/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateEquipment
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girl;
/*    */   NBTTagCompound nbtStuff;
/*    */   
/*    */   public UpdateEquipment() {}
/*    */   
/*    */   public UpdateEquipment(UUID girl, NBTTagCompound nbtStuff) {
/* 25 */     this.girl = girl;
/* 26 */     this.nbtStuff = nbtStuff;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     this.girl = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 33 */     this.nbtStuff = ByteBufUtils.readTag(buf);
/* 34 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 40 */     ByteBufUtils.writeUTF8String(buf, this.girl.toString());
/* 41 */     ByteBufUtils.writeTag(buf, this.nbtStuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<UpdateEquipment, IMessage>
/*    */   {
/*    */     public IMessage onMessage(UpdateEquipment message, MessageContext ctx) {
/* 49 */       if (message.messageValid) {
/*    */         
/* 51 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girl);
/*    */         
/* 53 */         for (GirlEntity girl : girlList) {
/* 54 */           girl.inventory.deserializeNBT(message.nbtStuff);
/*    */         }
/*    */       } else {
/*    */         
/* 58 */         System.out.println("received an invalid message @UpdateEquipment :(");
/*    */       } 
/*    */       
/* 61 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\UpdateEquipment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */