/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import net.minecraftforge.event.entity.living.LivingFallEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlimeJumpDetector
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void landing(LivingFallEvent event) {
/* 14 */     if (event.getEntity() instanceof com.schnurritv.sexmod.girls.slime.SlimeEntity)
/*    */     {
/* 16 */       event.setDamageMultiplier(0.0F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\SlimeJumpDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */