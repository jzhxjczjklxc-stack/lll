/*    */ package com.schnurritv.sexmod.girls.jenny;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlModel;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JennyModel
/*    */   extends GirlModel
/*    */ {
/*    */   public static JennyModel INSTANCE;
/*    */   
/*    */   public JennyModel() {
/* 17 */     INSTANCE = this;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation[] getModels() {
/* 22 */     return new ResourceLocation[] { new ResourceLocation("sexmod", "geo/jenny/jennynude.geo.json"), new ResourceLocation("sexmod", "geo/jenny/jennydressed.geo.json") };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceLocation getSkin() {
/* 29 */     return new ResourceLocation("sexmod", "textures/entity/jenny/jenny.png");
/*    */   }
/*    */   public ResourceLocation getAnimationFile() {
/* 32 */     return new ResourceLocation("sexmod", "animations/jenny/jenny.animation.json");
/*    */   }
/*    */   
/*    */   public String[] getHelmetBones() {
/* 36 */     return new String[] { "armorHelmet" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getHeadBones() {
/* 41 */     return new String[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getChestPlateBones() {
/* 46 */     return new String[] { "armorShoulderR", "armorShoulderL", "armorChest", "armorBoobs" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getTorsoBones() {
/* 51 */     return new String[] { "boobsFlesh", "upperBodyL", "upperBodyR" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getPantsBones() {
/* 56 */     return new String[] { "armorBootyR", "armorBootyL", "armorPantsLowL", "armorPantsLowR", "armorPantsLowR", "armorPantsUpR", "armorPantsUpL", "armorHip" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getLegsBones() {
/* 61 */     return new String[] { "fleshL", "fleshR", "vagina", "curvesL", "curvesR", "kneeL", "kneeR" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getShoesBones() {
/* 66 */     return new String[] { "armorShoesL", "armorShoesR" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFeetBones() {
/* 71 */     return new String[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\jenny\JennyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */