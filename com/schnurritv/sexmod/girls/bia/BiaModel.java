/*    */ package com.schnurritv.sexmod.girls.bia;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlModel;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiaModel
/*    */   extends GirlModel
/*    */ {
/*    */   protected ResourceLocation[] getModels() {
/* 18 */     return new ResourceLocation[] { new ResourceLocation("sexmod", "geo/bia/bianude.geo.json"), new ResourceLocation("sexmod", "geo/bia/biadressed.geo.json") };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceLocation getSkin() {
/* 26 */     return new ResourceLocation("sexmod", "textures/entity/bia/bia.png");
/*    */   }
/*    */   
/*    */   public ResourceLocation getAnimationFile() {
/* 30 */     return new ResourceLocation("sexmod", "animations/bia/bia.animation.json");
/*    */   }
/*    */   
/*    */   public String[] getHelmetBones() {
/* 34 */     return new String[] { "armorHelmet" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getHeadBones() {
/* 39 */     return new String[] { "leaf7", "leaf8" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getChestPlateBones() {
/* 44 */     return new String[] { "armorChest", "armorBoobs", "armorShoulderR", "armorShoulderL" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getTorsoBones() {
/* 49 */     return new String[] { "bra", "upperBodyR", "upperBodyL" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getPantsBones() {
/* 54 */     return new String[] { "armorBootyR", "armorBootyL", "armorPantsLowL", "armorPantsLowR", "armorPantsLowR", "armorPantsUpR", "armorPantsUpL", "armorHip" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getLegsBones() {
/* 59 */     return new String[] { "slip", "fleshL", "fleshR", "vagina", "curvesL", "curvesR", "kneeL", "kneeR" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getShoesBones() {
/* 64 */     return new String[] { "armorShoesL", "armorShoesR" };
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFeetBones() {
/* 69 */     return new String[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\bia\BiaModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */