/*    */ package com.schnurritv.sexmod.util;
/*    */ 
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PenisMath
/*    */ {
/*    */   public static Vec3d Lerp(Vec3d start, Vec3d end, int step) {
/* 17 */     if (step == 0)
/*    */     {
/* 19 */       return end;
/*    */     }
/*    */     
/*    */     try {
/* 23 */       Vec3d distance = end.func_178788_d(start);
/* 24 */       return start.func_72441_c(distance.field_72450_a / step, distance.field_72448_b / step, distance.field_72449_c / step);
/*    */     
/*    */     }
/* 27 */     catch (NullPointerException e) {
/*    */       
/* 29 */       System.out.println("couldn't calculate distance @EpicMathHelper.Lerp");
/* 30 */       System.out.println(start);
/* 31 */       System.out.println(end);
/* 32 */       System.out.println(step);
/* 33 */       return end;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double Lerp(double start, double end, double percentage) {
/* 49 */     return start + (end - start) * percentage;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Vec3d Lerp(Vec3d start, Vec3d end, double percentage) {
/* 54 */     Vec3d distance = end.func_178788_d(start);
/* 55 */     return start.func_178787_e(new Vec3d(distance.field_72450_a * percentage, distance.field_72448_b * percentage, distance.field_72449_c * percentage));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double cosEaseOut(double y1, double y2, double percentage) {
/* 62 */     double mu2 = (1.0D - Math.cos(percentage * Math.PI)) / 2.0D;
/* 63 */     return y1 * (1.0D - mu2) + y2 * mu2;
/*    */   }
/*    */ 
/*    */   
/*    */   public static float clamp(float value, float min, float max) {
/* 68 */     return Math.max(min, Math.min(max, value));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\PenisMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */