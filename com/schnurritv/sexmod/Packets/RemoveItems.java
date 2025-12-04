/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.util.Reference;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
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
/*    */ public class RemoveItems
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid = false;
/*    */   UUID playerId;
/*    */   ItemStack stack;
/*    */   
/*    */   public RemoveItems() {}
/*    */   
/*    */   public RemoveItems(UUID playerId, ItemStack stack) {
/* 27 */     this.playerId = playerId;
/* 28 */     this.stack = stack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 34 */     this.playerId = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 35 */     this.stack = ByteBufUtils.readItemStack(buf);
/* 36 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 42 */     ByteBufUtils.writeUTF8String(buf, this.playerId.toString());
/* 43 */     ByteBufUtils.writeItemStack(buf, this.stack);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<RemoveItems, IMessage>
/*    */   {
/*    */     public IMessage onMessage(RemoveItems message, MessageContext ctx) {
/* 51 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 53 */         InventoryPlayer inventoryPlayer = (Reference.server.func_184103_al().func_177451_a(message.playerId)).field_71071_by;
/*    */         
/* 55 */         for (int i = 0; i < inventoryPlayer.func_70302_i_(); i++) {
/*    */           
/* 57 */           ItemStack stack = inventoryPlayer.func_70301_a(i);
/*    */           
/* 59 */           if (stack.func_77973_b().equals(message.stack.func_77973_b())) {
/*    */             
/* 61 */             stack.func_190918_g(message.stack.func_190916_E());
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } else {
/* 67 */         System.out.println("recieved an unvalid message @RemoveItems :(");
/*    */       } 
/*    */ 
/*    */       
/* 71 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\RemoveItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */