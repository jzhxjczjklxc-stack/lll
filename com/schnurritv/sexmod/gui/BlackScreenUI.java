/*    */ package com.schnurritv.sexmod.gui;
/*    */ 
/*    */ import com.schnurritv.sexmod.util.PenisMath;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ public class BlackScreenUI
/*    */   extends Gui
/*    */ {
/*    */   private static boolean shouldBeRendered = false;
/* 15 */   private static double step = 0.0D;
/*    */   
/* 17 */   static ResourceLocation transitionScreen = new ResourceLocation("sexmod", "textures/gui/transitionscreen.png");
/* 18 */   static ResourceLocation mirroredTransitionScreen = new ResourceLocation("sexmod", "textures/gui/mirroredtransitionscreen.png");
/* 19 */   static ResourceLocation blackScreen = new ResourceLocation("sexmod", "textures/gui/blackscreen.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public static void activate() {
/* 24 */     shouldBeRendered = true;
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void renderUI(RenderGameOverlayEvent event) {
/* 30 */     if (shouldBeRendered && event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
/*    */       
/* 32 */       Minecraft mc = Minecraft.func_71410_x();
/*    */       
/* 34 */       step += (mc.func_193989_ak() * 0.75F);
/* 35 */       float xOffset = (float)PenisMath.Lerp(-900.0D, 450.0D, 0.5D * Math.cos(step / 25.0D) + 0.5D);
/*    */       
/* 37 */       mc.field_71446_o.func_110577_a(transitionScreen);
/* 38 */       func_175174_a(xOffset, 0.0F, 0, (int)(step * 1.5D), 256, 256);
/*    */       
/* 40 */       mc.field_71446_o.func_110577_a(mirroredTransitionScreen);
/* 41 */       func_175174_a(xOffset + 600.0F, 0.0F, 0, (int)(step * 1.5D), 256, 256);
/*    */       
/* 43 */       mc.field_71446_o.func_110577_a(blackScreen);
/* 44 */       func_175174_a(xOffset + 200.0F, 0.0F, 0, 0, 400, 256);
/*    */       
/* 46 */       if (step > 30.0D) {
/* 47 */         SexUI.shouldBeRendered = false;
/*    */       }
/*    */       
/* 50 */       if (step > 69.0D) {
/*    */         
/* 52 */         step = 0.0D;
/* 53 */         shouldBeRendered = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\BlackScreenUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */