/*     */ package com.schnurritv.sexmod.gui;
/*     */ 
/*     */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*     */ import com.schnurritv.sexmod.util.PenisMath;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class SexUI
/*     */   extends Gui
/*     */ {
/*  15 */   static ResourceLocation buttons = new ResourceLocation("sexmod", "textures/gui/buttons.png");
/*  16 */   static ResourceLocation hornyMeter = new ResourceLocation("sexmod", "textures/gui/hornymeter.png");
/*     */   
/*     */   public static boolean shouldBeRendered = false;
/*     */   
/*  20 */   public static double cumPercentage = 0.0D;
/*     */   
/*  22 */   static double drawnCumPercentage = cumPercentage;
/*  23 */   static float transitionStep = 0.0F;
/*  24 */   static float cumStep = 0.0F;
/*     */   
/*     */   static boolean keepSpacePressed = false;
/*  27 */   static float i = 0.0F;
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void renderUI(RenderGameOverlayEvent event) {
/*  32 */     if (shouldBeRendered && event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
/*     */       
/*  34 */       Minecraft minecraft = Minecraft.func_71410_x();
/*     */       
/*  36 */       if (transitionStep < 1.0F) {
/*  37 */         transitionStep += minecraft.func_193989_ak() / 25.0F;
/*     */       } else {
/*     */         
/*  40 */         transitionStep = 1.0F;
/*     */       } 
/*     */       
/*  43 */       GL11.glPushMatrix();
/*     */ 
/*     */       
/*  46 */       minecraft.field_71446_o.func_110577_a(buttons);
/*  47 */       GL11.glScalef(0.35F, 0.35F, 0.35F);
/*     */ 
/*     */       
/*  50 */       if (cumPercentage >= 1.0D) {
/*     */ 
/*     */         
/*  53 */         if (HandlePlayerMovement.isCumming) {
/*  54 */           keepSpacePressed = true;
/*     */         }
/*     */         
/*  57 */         int yOffsetSpaceButton = keepSpacePressed ? 54 : 0;
/*  58 */         func_73729_b(240, 160, 0, 108 + yOffsetSpaceButton, 256, 52);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  63 */       if (!keepSpacePressed) {
/*     */         
/*  65 */         int yOffsetShiftButton = HandlePlayerMovement.isThrusting ? 54 : 0;
/*  66 */         func_73729_b((int)PenisMath.Lerp(-200.0D, 98.0D, transitionStep), 405, 0, yOffsetShiftButton, 158, 54);
/*     */       } 
/*     */       
/*  69 */       GL11.glScalef(2.857143F, 2.857143F, 2.857143F);
/*     */       
/*  71 */       minecraft.field_71446_o.func_110577_a(hornyMeter);
/*  72 */       GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  73 */       func_73729_b(10, (int)PenisMath.Lerp(-200.0D, 10.0D, transitionStep), 0, 0, 146, 175);
/*     */       
/*  75 */       drawnCumPercentage = PenisMath.Lerp(drawnCumPercentage, cumPercentage, minecraft.func_193989_ak());
/*     */       
/*  77 */       int height = (int)PenisMath.Lerp(0.0D, 160.0D, drawnCumPercentage);
/*  78 */       int textureY = (int)PenisMath.Lerp(167.0D, 8.0D, drawnCumPercentage);
/*  79 */       double y = PenisMath.Lerp(178.0D, 18.0D, drawnCumPercentage);
/*     */ 
/*     */       
/*  82 */       if (!keepSpacePressed) {
/*     */ 
/*     */         
/*  85 */         func_73729_b(67, (int)PenisMath.Lerp(-45.0D, y, transitionStep), 159, textureY, 32, height);
/*     */ 
/*     */         
/*  88 */         func_73729_b(120, (int)PenisMath.Lerp(-58.0D, PenisMath.Lerp(178.0D, 149.0D, 1.0D - drawnCumPercentage), transitionStep), 212, (int)PenisMath.Lerp(169.0D, 141.0D, 1.0D - drawnCumPercentage), 28, (int)PenisMath.Lerp(1.0D, 29.0D, 1.0D - drawnCumPercentage));
/*  89 */         func_73729_b(18, (int)PenisMath.Lerp(-58.0D, PenisMath.Lerp(178.0D, 149.0D, 1.0D - drawnCumPercentage), transitionStep), 212, (int)PenisMath.Lerp(169.0D, 141.0D, 1.0D - drawnCumPercentage), 28, (int)PenisMath.Lerp(1.0D, 29.0D, 1.0D - drawnCumPercentage));
/*     */       }
/*     */       else {
/*     */         
/*  93 */         cumStep += minecraft.func_193989_ak() / 15.0F;
/*  94 */         func_73729_b(67, (int)PenisMath.Lerp(18.0D, -300.0D, cumStep), 159, 8, 32, 160);
/*     */       } 
/*  96 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addCumPercentage(double amount) {
/* 102 */     cumPercentage += amount;
/* 103 */     cumPercentage = (cumPercentage > 1.0D) ? 1.0D : cumPercentage;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void resetCumPercentage() {
/* 108 */     cumPercentage = 0.0D;
/* 109 */     keepSpacePressed = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\SexUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */