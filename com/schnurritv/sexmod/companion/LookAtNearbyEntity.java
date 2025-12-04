/*    */ package com.schnurritv.sexmod.companion;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.ai.EntityAIWatchClosest2;
/*    */ 
/*    */ public class LookAtNearbyEntity
/*    */   extends EntityAIWatchClosest2 {
/*    */   public boolean shouldLook = true;
/*    */   
/*    */   public LookAtNearbyEntity(EntityLiving entitylivingIn, Class<? extends Entity> watchTargetClass, float maxDistance, float chanceIn) {
/* 12 */     super(entitylivingIn, watchTargetClass, maxDistance, chanceIn);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 18 */     if (this.shouldLook)
/* 19 */       super.func_75246_d(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\LookAtNearbyEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */