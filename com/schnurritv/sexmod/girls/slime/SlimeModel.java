/*     */ package com.schnurritv.sexmod.girls.slime;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.GirlModel;
/*     */ import java.util.Arrays;
/*     */ import javax.vecmath.Tuple3f;
/*     */ import javax.vecmath.Vector3f;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.processor.AnimationProcessor;
/*     */ import software.bernie.geckolib3.core.processor.IBone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SlimeModel
/*     */   extends GirlModel
/*     */ {
/*     */   protected ResourceLocation[] getModels() {
/*  21 */     return new ResourceLocation[] { new ResourceLocation("sexmod", "geo/slime/nude.geo.json"), new ResourceLocation("sexmod", "geo/slime/dressed.geo.json") };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocation getSkin() {
/*  28 */     return new ResourceLocation("sexmod", "textures/entity/slime/slime.png");
/*     */   }
/*     */   public ResourceLocation getAnimationFile() {
/*  31 */     return new ResourceLocation("sexmod", "animations/slime/slime.animation.json");
/*     */   }
/*  33 */   GirlEntity.Action[] actionsWithSlime = new GirlEntity.Action[] { GirlEntity.Action.STARTDOGGY, GirlEntity.Action.DOGGYCUM, GirlEntity.Action.DOGGYSLOW, GirlEntity.Action.DOGGYFAST, GirlEntity.Action.DOGGYCUM, GirlEntity.Action.DOGGYSTART, GirlEntity.Action.WAITDOGGY };
/*     */ 
/*     */   
/*     */   public void setLivingAnimations(GirlEntity girl, Integer uniqueID, AnimationEvent customPredicate) {
/*  37 */     super.setLivingAnimations(girl, uniqueID, customPredicate);
/*     */ 
/*     */     
/*  40 */     AnimationProcessor processor = getAnimationProcessor();
/*     */     
/*  42 */     if (!(girl.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) && processor.getBone("bedSlime") != null && processor.getBone("bedSlimeLayer") != null) {
/*  43 */       processor.getBone("bedSlime").setHidden(!Arrays.<GirlEntity.Action>asList(this.actionsWithSlime).contains(girl.currentAction()));
/*  44 */       processor.getBone("bedSlimeLayer").setHidden(!Arrays.<GirlEntity.Action>asList(this.actionsWithSlime).contains(girl.currentAction()));
/*     */     } 
/*     */ 
/*     */     
/*  48 */     copyData(new String[] { "head" }, "hat");
/*     */     
/*  50 */     if (!(girl.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)) {
/*  51 */       if (((SlimeEntity)girl).isPregnant && girl.field_70173_aa % 10 == 0) {
/*     */         
/*  53 */         GirlEntity.spawnParticleOnGirl(EnumParticleTypes.SPELL_WITCH, girl);
/*     */       }
/*  55 */       else if (((SlimeEntity)girl).getHornyLevel() == 2 && girl.field_70173_aa % 20 == 0) {
/*     */         
/*  57 */         GirlEntity.spawnParticleOnGirl(EnumParticleTypes.HEART, girl);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void copyData(String[] froms, String to) {
/*  65 */     AnimationProcessor processor = getAnimationProcessor();
/*     */     
/*  67 */     IBone toBone = processor.getBone(to);
/*  68 */     IBone[] fromBones = new IBone[froms.length];
/*     */     
/*  70 */     for (int i = 0; i < fromBones.length; i++)
/*     */     {
/*  72 */       fromBones[i] = processor.getBone(froms[i]);
/*     */     }
/*     */     
/*  75 */     Vector3f totalRot = new Vector3f(0.0F, 0.0F, 0.0F);
/*  76 */     Vector3f totalPos = new Vector3f(0.0F, 0.0F, 0.0F);
/*     */     
/*  78 */     for (IBone bone : fromBones) {
/*     */       
/*  80 */       totalRot.add((Tuple3f)new Vector3f(bone.getRotationX(), bone.getRotationY(), bone.getRotationZ()));
/*  81 */       totalPos.add((Tuple3f)new Vector3f(bone.getPositionX(), bone.getPositionY(), bone.getPositionZ()));
/*     */     } 
/*     */     
/*  84 */     toBone.setRotationX(totalRot.x);
/*  85 */     toBone.setRotationY(totalRot.y);
/*  86 */     toBone.setRotationZ(totalRot.z);
/*  87 */     toBone.setPositionX(totalPos.x);
/*  88 */     toBone.setPositionY(totalPos.y);
/*  89 */     toBone.setPositionZ(totalPos.z);
/*  90 */     toBone.setPositionZ(totalPos.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getHelmetBones() {
/*  97 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getHeadBones() {
/* 102 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getChestPlateBones() {
/* 107 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getTorsoBones() {
/* 112 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getPantsBones() {
/* 117 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getLegsBones() {
/* 122 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getShoesBones() {
/* 127 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getFeetBones() {
/* 132 */     return new String[0];
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\SlimeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */