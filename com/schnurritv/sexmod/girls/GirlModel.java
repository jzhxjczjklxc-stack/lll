/*     */ package com.schnurritv.sexmod.girls;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import software.bernie.geckolib3.core.IAnimatable;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.processor.AnimationProcessor;
/*     */ import software.bernie.geckolib3.core.processor.IBone;
/*     */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*     */ import software.bernie.geckolib3.model.provider.data.EntityModelData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GirlModel<T extends GirlEntity>
/*     */   extends AnimatedGeoModel<T>
/*     */   implements ModelBones
/*     */ {
/*     */   public static boolean shouldUseOtherSkins = true;
/*  35 */   protected ResourceLocation[] models = getModels();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocation getAnimationFileLocation(GirlEntity animatable) {
/*  46 */     return getAnimationFile();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocation getModelLocation(GirlEntity girl) {
/*  52 */     if (girl.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) {
/*  53 */       return this.models[0];
/*     */     }
/*  55 */     if (((Integer)girl.func_184212_Q().func_187225_a(GirlEntity.CURRENT_MODEL)).intValue() > this.models.length) {
/*  56 */       System.out.println("Girl doesn't have an outfit Nr." + girl.func_184212_Q().func_187225_a(GirlEntity.CURRENT_MODEL) + " so im just making her nude lol");
/*  57 */       return this.models[0];
/*     */     } 
/*     */     
/*  60 */     return this.models[((Integer)girl.func_184212_Q().func_187225_a(GirlEntity.CURRENT_MODEL)).intValue()];
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceLocation getTextureLocation(GirlEntity girl) {
/*  65 */     return getSkin();
/*     */   }
/*     */   
/*     */   public void setMolangQueries(IAnimatable animatable, double currentTick) {
/*  69 */     if ((Minecraft.func_71410_x()).field_71441_e != null) {
/*  70 */       super.setMolangQueries(animatable, currentTick);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLivingAnimations(T girl, Integer uniqueID, AnimationEvent customPredicate) {
/*  77 */     super.setLivingAnimations((IAnimatable)girl, uniqueID, customPredicate);
/*     */     
/*  79 */     AnimationProcessor<T> processor = getAnimationProcessor();
/*     */     try {
/*  81 */       renderPlayer(girl, processor);
/*  82 */     } catch (IOException e) {
/*  83 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  86 */     if (((GirlEntity)girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) {
/*     */       return;
/*     */     }
/*  89 */     if (((Boolean)girl.func_184212_Q().func_187225_a(GirlEntity.SHOULD_BE_AT_TARGET)).booleanValue())
/*     */     {
/*  91 */       girl.func_180426_a((girl.targetPos()).field_72450_a, (girl.targetPos()).field_72448_b, (girl.targetPos()).field_72449_c, girl.targetYaw().floatValue(), 0.0F, 3, true);
/*     */     }
/*     */     
/*  94 */     ((GirlEntity)girl).actionController.transitionLengthTicks = (((GirlEntity)girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld || girl.currentAction() == null) ? 5.0D : (girl.currentAction()).transitionTick;
/*     */     
/*  96 */     setUpHead(girl, processor, customPredicate);
/*     */     
/*  98 */     if (((Integer)((GirlEntity)girl).field_70180_af.func_187225_a(GirlEntity.CURRENT_MODEL)).intValue() == 0) {
/*  99 */       disableArmor(processor);
/*     */     } else {
/* 101 */       manageArmor(girl, processor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void manageArmor(T girl, AnimationProcessor<T> processor) {
/* 107 */     renderHelmetOrHead(processor, !((ItemStack)((GirlEntity)girl).field_70180_af.func_187225_a(GirlEntity.HELMET)).func_77973_b().equals(ItemStack.field_190927_a.func_77973_b()));
/* 108 */     renderChestPlateOrTorso(processor, !((ItemStack)((GirlEntity)girl).field_70180_af.func_187225_a(GirlEntity.CHEST_PLATE)).func_77973_b().equals(ItemStack.field_190927_a.func_77973_b()));
/* 109 */     renderPantsOrLegs(processor, !((ItemStack)((GirlEntity)girl).field_70180_af.func_187225_a(GirlEntity.PANTS)).func_77973_b().equals(ItemStack.field_190927_a.func_77973_b()));
/* 110 */     renderShoesOrFeet(processor, !((ItemStack)((GirlEntity)girl).field_70180_af.func_187225_a(GirlEntity.SHOES)).func_77973_b().equals(ItemStack.field_190927_a.func_77973_b()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void disableArmor(AnimationProcessor<T> processor) {
/* 115 */     renderHelmetOrHead(processor, false);
/* 116 */     renderChestPlateOrTorso(processor, false);
/* 117 */     renderPantsOrLegs(processor, false);
/* 118 */     renderShoesOrFeet(processor, false);
/*     */   }
/*     */ 
/*     */   
/*     */   void renderHelmetOrHead(AnimationProcessor<T> processor, boolean renderHelmet) {
/* 123 */     render(getHelmetBones(), renderHelmet, processor);
/* 124 */     render(getHeadBones(), !renderHelmet, processor);
/*     */   }
/*     */ 
/*     */   
/*     */   void renderChestPlateOrTorso(AnimationProcessor<T> processor, boolean renderBreastplate) {
/* 129 */     render(getChestPlateBones(), renderBreastplate, processor);
/* 130 */     render(getTorsoBones(), !renderBreastplate, processor);
/*     */   }
/*     */ 
/*     */   
/*     */   void renderPantsOrLegs(AnimationProcessor<T> processor, boolean renderPants) {
/* 135 */     render(getPantsBones(), renderPants, processor);
/* 136 */     render(getLegsBones(), !renderPants, processor);
/*     */   }
/*     */ 
/*     */   
/*     */   void renderShoesOrFeet(AnimationProcessor<T> processor, boolean renderShoes) {
/* 141 */     render(getShoesBones(), renderShoes, processor);
/* 142 */     render(getFeetBones(), !renderShoes, processor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(String[] boneNames, boolean render, AnimationProcessor<T> processor) {
/* 148 */     for (String boneName : boneNames)
/*     */     {
/* 150 */       render(boneName, render, processor);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void render(String boneName, boolean render, AnimationProcessor<T> processor) {
/* 156 */     if (processor.getBone(boneName) == null) {
/*     */       return;
/*     */     }
/* 159 */     processor.getBone(boneName).setHidden(!render);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void renderPlayer(T girl, AnimationProcessor<T> processor) throws IOException {
/*     */     try {
/* 173 */       processor.getBone("steve").setHidden(!(girl.currentAction()).hasPlayer);
/* 174 */     } catch (NullPointerException nullPointerException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUpHead(T girl, AnimationProcessor<T> processor, AnimationEvent predicate) {
/* 181 */     if (!(((GirlEntity)girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) && (girl.currentAction() == GirlEntity.Action.NULL || ((Integer)girl.func_184212_Q().func_187225_a(GirlEntity.ATTACK_MODE)).intValue() != 0)) {
/*     */       
/* 183 */       EntityModelData extraData = predicate.getExtraDataOfType(EntityModelData.class).get(0);
/*     */ 
/*     */ 
/*     */       
/* 187 */       IBone neck = processor.getBone("neck");
/* 188 */       neck.setRotationY(extraData.netHeadYaw * 0.5F * 0.017453292F);
/*     */       
/* 190 */       IBone head = processor.getBone("head");
/* 191 */       head.setRotationY(extraData.netHeadYaw * 0.017453292F);
/* 192 */       head.setRotationX(extraData.headPitch * 0.017453292F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       IBone body = (processor.getBone("body") == null) ? processor.getBone("dd") : processor.getBone("body");
/* 198 */       body.setRotationY(0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract ResourceLocation[] getModels();
/*     */   
/*     */   public abstract ResourceLocation getSkin();
/*     */   
/*     */   public abstract ResourceLocation getAnimationFile();
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\GirlModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */