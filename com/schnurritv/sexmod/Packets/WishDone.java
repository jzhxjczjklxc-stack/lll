/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WishDone
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   ItemStack lamp;
/*    */   UUID girlUUID;
/*    */   
/*    */   public WishDone() {}
/*    */   
/*    */   public WishDone(ItemStack lamp, UUID girlUUID) {
/* 28 */     this.lamp = lamp;
/* 29 */     this.girlUUID = girlUUID;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 35 */     this.lamp = ByteBufUtils.readItemStack(buf);
/* 36 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 37 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 43 */     ByteBufUtils.writeItemStack(buf, this.lamp);
/* 44 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<WishDone, IMessage>
/*    */   {
/*    */     public IMessage onMessage(WishDone message, MessageContext ctx) {
/* 52 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 54 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 56 */         for (GirlEntity girl : girlList) {
/* 57 */           if (girl.field_70170_p.field_72995_K) {
/*    */             continue;
/*    */           }
/* 60 */           girl.field_70170_p.func_72900_e((Entity)girl);
/*    */         } 
/*    */       } else {
/*    */         
/* 64 */         System.out.println("received an invalid message @UploadInventoryToServer :(");
/*    */       } 
/*    */       
/* 67 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\WishDone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */