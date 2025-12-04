/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import net.minecraftforge.client.event.GuiOpenEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResetGirlList
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void resetGirlList(GuiOpenEvent event) {
/* 14 */     if (event.getGui() instanceof net.minecraft.client.gui.GuiMainMenu || event.getGui() instanceof net.minecraft.client.gui.GuiMultiplayer)
/*    */     {
/* 16 */       GirlEntity.girlEntities.clear();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\ResetGirlList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */