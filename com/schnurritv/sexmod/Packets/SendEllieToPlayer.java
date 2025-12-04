/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ public class SendEllieToPlayer
/*    */   implements IMessage {
/*    */   boolean messageValid;
/*    */   UUID girlUUID;
/*    */   
/*    */   public SendEllieToPlayer() {
/* 21 */     this.messageValid = false;
/*    */   }
/*    */   
/*    */   public SendEllieToPlayer(UUID girlUUID) {
/* 25 */     this.girlUUID = girlUUID;
/* 26 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 33 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 39 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SendEllieToPlayer, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SendEllieToPlayer message, MessageContext ctx) {
/* 48 */       if (message.messageValid) {
/*    */         
/* 50 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 52 */         for (GirlEntity girl : girlList) {
/*    */           
/* 54 */           if (!girl.field_70170_p.field_72995_K)
/*    */           {
/* 56 */             if (girl instanceof EllieEntity) {
/*    */               
/* 58 */               EllieEntity ellie = (EllieEntity)girl;
/* 59 */               EntityPlayerMP entityPlayerMP = girl.func_184102_h().func_184103_al().func_177451_a(ellie.playerSheHasSexWith());
/*    */               
/* 61 */               ellie.setTargetPos(ellie.getBehindOfPlayer((EntityPlayer)girl.func_184102_h().func_184103_al().func_177451_a(entityPlayerMP.func_110124_au())));
/*    */               
/* 63 */               ellie.delayedRot = ((EntityPlayer)entityPlayerMP).field_70177_z;
/* 64 */               ellie.delayNewRot = true;
/* 65 */               ellie.func_184212_Q().func_187227_b(GirlEntity.SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } else {
/*    */         
/* 71 */         System.out.println("received an invalid message @SendEllieToPlayer :(");
/*    */       } 
/*    */       
/* 74 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SendEllieToPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */