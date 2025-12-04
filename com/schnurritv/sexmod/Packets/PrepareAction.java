/*     */ package com.schnurritv.sexmod.Packets;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.bia.BiaEntity;
/*     */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*     */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*     */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ public class PrepareAction
/*     */   implements IMessage {
/*     */   boolean messageValid;
/*     */   UUID girlUUID;
/*     */   boolean preparePayment;
/*     */   boolean setTargetPos;
/*  24 */   UUID playerUUID = null;
/*     */   public PrepareAction() {
/*  26 */     this.messageValid = false;
/*     */   }
/*     */   
/*     */   public PrepareAction(UUID girlUUID, UUID playerUUID, boolean preparePayment, boolean setTargetPos) {
/*  30 */     this.girlUUID = girlUUID;
/*  31 */     this.preparePayment = preparePayment;
/*  32 */     this.playerUUID = playerUUID;
/*  33 */     this.setTargetPos = setTargetPos;
/*  34 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buf) {
/*  40 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/*  41 */     this.preparePayment = buf.readBoolean();
/*  42 */     this.setTargetPos = buf.readBoolean();
/*  43 */     String temp = ByteBufUtils.readUTF8String(buf);
/*  44 */     this.playerUUID = temp.equals("null") ? null : UUID.fromString(temp);
/*  45 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buf) {
/*  51 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*  52 */     buf.writeBoolean(this.preparePayment);
/*  53 */     buf.writeBoolean(this.setTargetPos);
/*  54 */     ByteBufUtils.writeUTF8String(buf, (this.playerUUID == null) ? "null" : this.playerUUID.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Handler
/*     */     implements IMessageHandler<PrepareAction, IMessage>
/*     */   {
/*     */     public static void prepareAction(UUID girlUUID, UUID playerUUID, boolean preparePayment, boolean setTargetPos) {
/*  62 */       List<GirlEntity> girls = GirlEntity.getGirlsByUUID(girlUUID);
/*     */       
/*  64 */       for (GirlEntity girl : girls) {
/*     */         
/*  66 */         girl.setPlayer(playerUUID);
/*  67 */         if (girl instanceof JennyEntity || girl instanceof EllieEntity) {
/*  68 */           girl.field_70714_bg.func_85156_a((EntityAIBase)girl.aiLookAtPlayer);
/*  69 */           girl.field_70714_bg.func_85156_a((EntityAIBase)girl.aiWander);
/*     */         }
/*  71 */         else if (girl instanceof SlimeEntity) {
/*     */           
/*  73 */           SlimeEntity slime = (SlimeEntity)girl;
/*     */           
/*  75 */           slime.field_70714_bg.func_85156_a((EntityAIBase)slime.floatTask);
/*  76 */           slime.field_70714_bg.func_85156_a((EntityAIBase)slime.hopTask);
/*     */         } 
/*     */         
/*  79 */         girl.func_70661_as().func_75499_g();
/*  80 */         girl.field_70159_w = 0.0D;
/*  81 */         girl.field_70181_x = 0.0D;
/*  82 */         girl.field_70179_y = 0.0D;
/*     */         
/*  84 */         if (girl.playerSheHasSexWith() == null) {
/*  85 */           girl.setPlayer(playerUUID);
/*     */         }
/*     */         
/*  88 */         if (setTargetPos) {
/*  89 */           girl.setTargetPos(girl.getInFrontOfPlayer());
/*     */         }
/*     */         
/*  92 */         girl.TurnPlayerIntoCamera(girl.playerSheHasSexWith());
/*     */         
/*  94 */         if (preparePayment) {
/*     */           
/*  96 */           if (girl instanceof JennyEntity) {
/*     */             
/*  98 */             ((JennyEntity)girl).isPreparingPayment = true; continue;
/*     */           } 
/* 100 */           if (girl instanceof EllieEntity) {
/*     */             
/* 102 */             ((EllieEntity)girl).isPreparingPayment = true; continue;
/*     */           } 
/* 104 */           if (girl instanceof BiaEntity) {
/* 105 */             ((BiaEntity)girl).isPreparingTalk = true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IMessage onMessage(PrepareAction message, MessageContext ctx) {
/* 115 */       if (message.messageValid && ctx.side == Side.SERVER) {
/* 116 */         prepareAction(message.girlUUID, message.playerUUID, message.preparePayment, message.setTargetPos);
/*     */       }
/*     */       
/* 119 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\PrepareAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */