/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoDamageForGirlsWhileHavingTheSex
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void NoDamageForGirlsWhileHavingTheSex(LivingAttackEvent event) {
/* 14 */     if (event.getEntity() instanceof GirlEntity && event.getSource() != DamageSource.field_76380_i) {
/*    */       
/* 16 */       GirlEntity girl = (GirlEntity)event.getEntity();
/* 17 */       event.setCanceled((girl.playerSheHasSexWith() != null));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\NoDamageForGirlsWhileHavingTheSex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */