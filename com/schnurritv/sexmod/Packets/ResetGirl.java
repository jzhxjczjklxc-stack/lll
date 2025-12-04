/*     */ package com.schnurritv.sexmod.Packets;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*     */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResetGirl
/*     */   implements IMessage
/*     */ {
/*     */   boolean messageValid;
/*     */   UUID girlUUID;
/*     */   boolean onlyDoPlayerPart;
/*     */   
/*     */   public ResetGirl() {
/*  32 */     this.messageValid = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResetGirl(UUID girlUUID) {
/*  37 */     this.girlUUID = girlUUID;
/*  38 */     this.onlyDoPlayerPart = false;
/*  39 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResetGirl(UUID girlUUID, boolean onlyDoPlayerPart) {
/*  44 */     this.girlUUID = girlUUID;
/*  45 */     this.onlyDoPlayerPart = onlyDoPlayerPart;
/*  46 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buf) {
/*  52 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/*  53 */     this.onlyDoPlayerPart = buf.readBoolean();
/*  54 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buf) {
/*  60 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*  61 */     buf.writeBoolean(this.onlyDoPlayerPart);
/*  62 */     this.messageValid = true;
/*     */   }
/*     */   
/*     */   public static class Handler
/*     */     implements IMessageHandler<ResetGirl, IMessage>
/*     */   {
/*     */     public static void resetGirl(GirlEntity girl) {
/*  69 */       if (girl instanceof EllieEntity) {
/*     */         
/*  71 */         EllieEntity ellie = (EllieEntity)girl;
/*  72 */         ellie.hornyLevel = 0.0F;
/*  73 */         ellie.isBusy = false;
/*  74 */         ellie.delayNewRot = false;
/*  75 */         ellie.delayedRot = 0.0F;
/*  76 */         ellie.awaitPlayer = false;
/*  77 */         ellie.lookingForBed = false;
/*  78 */         ellie.isPreparingPayment = false;
/*  79 */         ellie.delayedRotTick = 0;
/*  80 */         ellie.bedSearchTick = -1;
/*  81 */         ellie.sexDelayTick = -1;
/*  82 */         ellie.shouldBeAtTargetYaw = false;
/*     */       }
/*  84 */       else if (girl instanceof SlimeEntity) {
/*     */         
/*  86 */         SlimeEntity slime = (SlimeEntity)girl;
/*     */         
/*  88 */         if (!girl.field_70714_bg.field_75782_a.contains(slime.floatTask)) {
/*  89 */           slime.field_70714_bg.func_75776_a(1, (EntityAIBase)slime.floatTask);
/*     */         }
/*  91 */         if (!girl.field_70714_bg.field_75782_a.contains(slime.hopTask)) {
/*  92 */           slime.field_70714_bg.func_75776_a(2, (EntityAIBase)slime.hopTask);
/*     */         }
/*  94 */         slime.setCurrentAction(GirlEntity.Action.DRESS);
/*  95 */         slime.setHornyLevel(0);
/*  96 */         slime.func_184212_Q().func_187227_b(GirlEntity.CURRENT_MODEL, Integer.valueOf(1));
/*     */       } 
/*     */       
/*  99 */       girl.func_184212_Q().func_187227_b(GirlEntity.SHOULD_BE_AT_TARGET, Boolean.valueOf(false));
/* 100 */       girl.setPlayer(null);
/* 101 */       girl.playerIsCumming = false;
/* 102 */       girl.playerIsThrusting = false;
/* 103 */       girl.playerCamPos = null;
/* 104 */       girl.func_189654_d(false);
/* 105 */       girl.field_70145_X = false;
/*     */       
/* 107 */       girl.func_70634_a((girl.func_174791_d()).field_72450_a, girl.func_180425_c().func_177956_o(), (girl.func_174791_d()).field_72449_c);
/*     */     }
/*     */ 
/*     */     
/*     */     public static void resetPlayer(EntityPlayerMP player) {
/* 112 */       player.func_70634_a(player.field_70165_t, Math.ceil(player.field_70163_u), player.field_70161_v);
/* 113 */       player.func_82142_c(false);
/* 114 */       player.field_70145_X = false;
/* 115 */       player.func_189654_d(false);
/* 116 */       PacketHandler.INSTANCE.sendTo(new SetPlayerMovement(true), player);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IMessage onMessage(ResetGirl message, MessageContext ctx) {
/* 123 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*     */         
/* 125 */         ArrayList<GirlEntity> girls = GirlEntity.getGirlsByUUID(message.girlUUID);
/*     */         
/* 127 */         for (GirlEntity girl : girls) {
/*     */           
/* 129 */           if (girl.field_70170_p.field_72995_K) {
/*     */             continue;
/*     */           }
/*     */           
/* 133 */           if (girl.playerSheHasSexWith() != null) {
/* 134 */             resetPlayer(Reference.server.func_184103_al().func_177451_a(girl.playerSheHasSexWith()));
/*     */           }
/* 136 */           if (message.onlyDoPlayerPart) {
/*     */             continue;
/*     */           }
/*     */           
/* 140 */           resetGirl(girl);
/*     */         } 
/*     */       } else {
/* 143 */         System.out.println("recieved an unvalid message @SendChatMessage :(");
/*     */       } 
/*     */ 
/*     */       
/* 147 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\ResetGirl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */