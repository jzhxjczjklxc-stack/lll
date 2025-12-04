/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*    */ import com.schnurritv.sexmod.gui.SexUI;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ public class SetPlayerMovement
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   boolean setActive;
/*    */   
/*    */   public SetPlayerMovement(boolean setActive) {
/* 19 */     this.setActive = setActive;
/* 20 */     this.messageValid = true;
/*    */   }
/*    */   
/*    */   public SetPlayerMovement() {
/* 24 */     this.messageValid = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 30 */     this.setActive = buf.readBoolean();
/* 31 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 37 */     buf.writeBoolean(this.setActive);
/* 38 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SetPlayerMovement, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SetPlayerMovement message, MessageContext ctx) {
/* 47 */       if (message.messageValid && ctx.side == Side.CLIENT) {
/*    */         
/* 49 */         HandlePlayerMovement.setActive(message.setActive);
/*    */         
/*    */         try {
/* 52 */           (Minecraft.func_71410_x()).field_71439_g.func_70016_h(0.0D, 0.0D, 0.0D);
/*    */         }
/* 54 */         catch (Exception exception) {}
/*    */ 
/*    */ 
/*    */         
/* 58 */         if (message.setActive) {
/* 59 */           SexUI.shouldBeRendered = false;
/*    */         }
/*    */       } else {
/*    */         
/* 63 */         System.out.println("received an invalid message @SetPlayerMovement :(");
/*    */       } 
/*    */       
/* 66 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SetPlayerMovement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */