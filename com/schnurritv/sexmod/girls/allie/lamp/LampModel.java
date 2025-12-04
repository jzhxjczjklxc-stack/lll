/*    */ package com.schnurritv.sexmod.girls.allie.lamp;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import software.bernie.geckolib3.core.IAnimatable;
/*    */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*    */ import software.bernie.geckolib3.core.processor.AnimationProcessor;
/*    */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LampModel
/*    */   extends AnimatedGeoModel<LampItem>
/*    */ {
/*    */   public ResourceLocation getModelLocation(LampItem object) {
/* 16 */     return new ResourceLocation("sexmod", "geo/allie/lamp.geo.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureLocation(LampItem object) {
/* 21 */     return new ResourceLocation("sexmod", "textures/entity/allie/lamp.png");
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getAnimationFileLocation(LampItem animatable) {
/* 26 */     return new ResourceLocation("sexmod", "animations/allie/lamp.animation.json");
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLivingAnimations(LampItem item, Integer uniqueID, AnimationEvent predicate) {
/* 31 */     super.setLivingAnimations(item, uniqueID, predicate);
/*    */     
/* 33 */     AnimationProcessor processor = getAnimationProcessor();
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\allie\lamp\LampModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */