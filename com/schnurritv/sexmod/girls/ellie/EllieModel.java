/*     */ package com.schnurritv.sexmod.girls.ellie;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.GirlModel;
/*     */ import com.schnurritv.sexmod.util.PenisMath;
/*     */ import java.util.HashMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.processor.IBone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EllieModel
/*     */   extends GirlModel
/*     */ {
/*     */   protected ResourceLocation[] getModels() {
/*  26 */     return new ResourceLocation[] { new ResourceLocation("sexmod", "geo/ellie/nude.geo.json"), new ResourceLocation("sexmod", "geo/ellie/dressed.geo.json") };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocation getSkin() {
/*  34 */     return new ResourceLocation("sexmod", "textures/entity/ellie/ellie.png");
/*     */   }
/*     */   
/*     */   public ResourceLocation getAnimationFile() {
/*  38 */     return new ResourceLocation("sexmod", "animations/ellie/ellie.animation.json");
/*     */   }
/*  40 */   HashMap<Integer, float[]> valuesForYaw = new HashMap<Integer, float[]>()
/*     */     {
/*     */     
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLivingAnimations(GirlEntity girl, Integer uniqueID, AnimationEvent customPredicate) {
/*  48 */     super.setLivingAnimations(girl, uniqueID, customPredicate);
/*     */     
/*  50 */     if (!(girl.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) && girl.currentAction() == GirlEntity.Action.SITDOWNIDLE) {
/*     */       
/*  52 */       EntityPlayer player = girl.field_70170_p.func_72890_a((Entity)girl, 15.0D);
/*     */       
/*  54 */       if (player != null) {
/*  55 */         float yaw; IBone head = getAnimationProcessor().getBone("head");
/*  56 */         Vec3d distance = girl.func_174791_d().func_178788_d(player.func_174791_d());
/*  57 */         int correspondingYaw = Math.round(girl.targetYaw().floatValue());
/*     */ 
/*     */         
/*  60 */         if (correspondingYaw == 180) {
/*     */           
/*  62 */           yaw = (float)Math.atan2(distance.field_72450_a, distance.field_72449_c) * 1.2F;
/*     */ 
/*     */           
/*  65 */           if (yaw > 0.0F) {
/*  66 */             yaw = Math.max(1.5F, Math.min(3.14F, yaw));
/*     */           } else {
/*     */             
/*  69 */             yaw = Math.max(-3.14F, Math.min(-1.5F, yaw));
/*     */           } 
/*     */ 
/*     */           
/*  73 */           if (yaw == 1.5F || yaw == 3.14F || yaw == -3.14F || yaw == -1.5F) {
/*  74 */             yaw = 0.0F;
/*     */           } else {
/*     */             
/*  77 */             yaw += 3.0F;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/*  82 */           float minYaw = ((float[])this.valuesForYaw.get(Integer.valueOf(correspondingYaw)))[1];
/*  83 */           float maxYaw = ((float[])this.valuesForYaw.get(Integer.valueOf(correspondingYaw)))[2];
/*     */           
/*  85 */           yaw = ((float)(Math.atan2(distance.field_72450_a, distance.field_72449_c) + ((float[])this.valuesForYaw.get(Integer.valueOf(correspondingYaw)))[0]) + girl.targetYaw().floatValue()) * 0.8F;
/*  86 */           yaw = PenisMath.clamp(yaw, minYaw, maxYaw);
/*     */ 
/*     */           
/*  89 */           if (yaw == minYaw || yaw == maxYaw) {
/*  90 */             yaw = 0.0F;
/*     */           }
/*     */         } 
/*     */         
/*  94 */         float pitch = (yaw == 0.0F) ? 0.0F : PenisMath.clamp((float)((player.field_70163_u - girl.field_70163_u) * 0.5D), -0.75F, 0.75F);
/*  95 */         head.setRotationY(yaw);
/*  96 */         head.setRotationX(pitch);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getHelmetBones() {
/* 106 */     return new String[] { "armorHelmet" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getHeadBones() {
/* 111 */     return new String[] { "headband" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getChestPlateBones() {
/* 116 */     return new String[] { "armorShoulderR", "armorShoulderL", "armorChest", "armorBoobs" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getTorsoBones() {
/* 121 */     return new String[] { "boobsFlesh", "upperBodyL", "upperBodyR" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getPantsBones() {
/* 126 */     return new String[] { "armorBootyR", "armorBootyL", "armorPantsLowL", "armorPantsLowR", "armorPantsLowR", "armorPantsUpR", "armorPantsUpL", "armorHip" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getLegsBones() {
/* 131 */     return new String[] { "fleshL", "fleshR", "vagina", "hotpants", "slip", "curvesL", "curvesR", "kneeL", "kneeR" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getShoesBones() {
/* 136 */     return new String[] { "armorShoesL", "armorShoesR" };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getFeetBones() {
/* 142 */     return new String[0];
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\ellie\EllieModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */