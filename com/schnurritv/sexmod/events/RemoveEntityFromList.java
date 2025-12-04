/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ public class RemoveEntityFromList
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void RemoveSophiFromList(LivingDeathEvent event) {
/* 12 */     if (event.getEntity() instanceof GirlEntity) {
/*    */       
/* 14 */       GirlEntity girl = (GirlEntity)event.getEntity();
/* 15 */       GirlEntity.girlEntities.remove(girl);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\RemoveEntityFromList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */