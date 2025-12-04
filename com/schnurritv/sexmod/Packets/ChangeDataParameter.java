/*     */ package com.schnurritv.sexmod.Packets;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ 
/*     */ public class ChangeDataParameter
/*     */   implements IMessage
/*     */ {
/*     */   boolean messageValid;
/*     */   UUID girl;
/*     */   String parameter;
/*     */   String value;
/*     */   
/*     */   public ChangeDataParameter() {
/*  22 */     this.messageValid = false;
/*     */   }
/*     */   
/*     */   public ChangeDataParameter(UUID girl, String parameter, String value) {
/*  26 */     this.girl = girl;
/*  27 */     this.parameter = parameter;
/*  28 */     this.value = value;
/*  29 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buf) {
/*  35 */     this.girl = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/*  36 */     this.parameter = ByteBufUtils.readUTF8String(buf);
/*  37 */     this.value = ByteBufUtils.readUTF8String(buf);
/*  38 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buf) {
/*  45 */     ByteBufUtils.writeUTF8String(buf, this.girl.toString());
/*  46 */     ByteBufUtils.writeUTF8String(buf, this.parameter);
/*  47 */     ByteBufUtils.writeUTF8String(buf, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Handler
/*     */     implements IMessageHandler<ChangeDataParameter, IMessage>
/*     */   {
/*     */     public IMessage onMessage(ChangeDataParameter message, MessageContext ctx) {
/*  56 */       if (message.messageValid) {
/*     */         
/*  58 */         for (GirlEntity girl : GirlEntity.getGirlsByUUID(message.girl)) {
/*  59 */           if (!girl.field_70170_p.field_72995_K && girl.girlId().equals(message.girl)) {
/*     */             String[] pos; Vec3d target;
/*  61 */             switch (message.parameter) {
/*     */               
/*     */               case "currentModel":
/*  64 */                 girl.func_184212_Q().func_187227_b(GirlEntity.CURRENT_MODEL, Integer.valueOf(message.value));
/*     */ 
/*     */               
/*     */               case "currentAction":
/*  68 */                 girl.setCurrentAction(GirlEntity.Action.valueOf(message.value));
/*     */ 
/*     */               
/*     */               case "animationFollowUp":
/*  72 */                 girl.func_184212_Q().func_187227_b(GirlEntity.ANIMATION_FOLLOW_UP, message.value);
/*     */ 
/*     */               
/*     */               case "playerSheHasSexWith":
/*  76 */                 girl.setPlayer(UUID.fromString(message.value));
/*     */ 
/*     */               
/*     */               case "currentJumpStage":
/*  80 */                 ((SlimeEntity)girl).setCurrentJumpStage(SlimeEntity.JumpStage.valueOf(message.value));
/*     */ 
/*     */ 
/*     */               
/*     */               case "targetPos":
/*  85 */                 pos = message.value.split("f");
/*  86 */                 target = new Vec3d(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
/*     */                 
/*  88 */                 girl.setTargetPos(target);
/*     */ 
/*     */               
/*     */               case "master":
/*  92 */                 girl.func_184212_Q().func_187227_b(GirlEntity.MASTER, message.value);
/*     */ 
/*     */               
/*     */               case "walk speed":
/*  96 */                 girl.func_184212_Q().func_187227_b(GirlEntity.WALK_SPEED, message.value);
/*     */             } 
/*     */ 
/*     */           
/*     */           } 
/*     */         } 
/*     */       } else {
/* 103 */         System.out.println("received an invalid message @ChangeDataParameter :(");
/*     */       } 
/*     */       
/* 106 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\ChangeDataParameter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */