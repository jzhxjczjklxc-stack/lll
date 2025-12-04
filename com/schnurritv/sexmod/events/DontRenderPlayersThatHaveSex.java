/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.client.event.RenderHandEvent;
/*    */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DontRenderPlayersThatHaveSex
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void RenderPlayer(RenderPlayerEvent.Pre event) {
/* 17 */     for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */       
/* 19 */       if (girl.playerSheHasSexWith() == null || girl.currentAction() == null)
/*    */         continue; 
/* 21 */       EntityPlayer player = event.getEntityPlayer();
/*    */       
/* 23 */       if ((girl.playerSheHasSexWith().equals(player.getPersistentID()) || girl.playerSheHasSexWith().equals(player.func_110124_au())) && (girl.currentAction()).hasPlayer) {
/* 24 */         event.setCanceled(true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void RenderHand(RenderHandEvent event) {
/* 34 */     for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */       
/* 36 */       if (girl.playerSheHasSexWith() == null || girl.currentAction() == null)
/*    */         continue; 
/* 38 */       EntityPlayerSP entityPlayerSP = (Minecraft.func_71410_x()).field_71439_g;
/*    */       
/* 40 */       if ((girl.playerSheHasSexWith().equals(entityPlayerSP.func_110124_au()) || girl.playerSheHasSexWith().equals(entityPlayerSP.getPersistentID())) && (girl.currentAction()).hasPlayer) {
/* 41 */         event.setCanceled(true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\DontRenderPlayersThatHaveSex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */