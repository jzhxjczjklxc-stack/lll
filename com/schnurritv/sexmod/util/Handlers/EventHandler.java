/*    */ package com.schnurritv.sexmod.util.Handlers;
/*    */ import com.schnurritv.sexmod.companion.Companion;
/*    */ import com.schnurritv.sexmod.companion.CompanionPearl;
/*    */ import com.schnurritv.sexmod.companion.DamageCalculation;
/*    */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*    */ import com.schnurritv.sexmod.events.NoDamageForGirlsWhileHavingTheSex;
/*    */ import com.schnurritv.sexmod.events.PornWarning;
/*    */ import com.schnurritv.sexmod.events.RemoveEntityFromList;
/*    */ import com.schnurritv.sexmod.events.ResetGirlList;
/*    */ import com.schnurritv.sexmod.events.SetFOVForSex;
/*    */ import com.schnurritv.sexmod.events.SlimeJumpDetector;
/*    */ import com.schnurritv.sexmod.girls.allie.lamp.LampItem;
/*    */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*    */ import com.schnurritv.sexmod.gui.PornWarningWindow;
/*    */ import com.schnurritv.sexmod.gui.SexUI;
/*    */ import com.schnurritv.sexmod.hornypotion.HornyPotion;
/*    */ import java.io.File;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ public class EventHandler {
/*    */   public static void registerEvents(boolean clientSide) {
/* 22 */     MinecraftForge.EVENT_BUS.register(new NoDamageForGirlsWhileHavingTheSex());
/* 23 */     MinecraftForge.EVENT_BUS.register(new RemoveEntityFromList());
/* 24 */     MinecraftForge.EVENT_BUS.register(new ResetJoiningPlayer());
/* 25 */     MinecraftForge.EVENT_BUS.register(new SlimeJumpDetector());
/* 26 */     MinecraftForge.EVENT_BUS.register(new HornyPotion());
/* 27 */     MinecraftForge.EVENT_BUS.register(new DamageCalculation());
/* 28 */     MinecraftForge.EVENT_BUS.register(new CompanionPearl.EventHandler());
/* 29 */     MinecraftForge.EVENT_BUS.register(new Companion());
/* 30 */     MinecraftForge.EVENT_BUS.register(new LampItem());
/*    */     
/* 32 */     if (clientSide) {
/*    */       
/* 34 */       if (needsPornWarning()) {
/* 35 */         MinecraftForge.EVENT_BUS.register(new PornWarning());
/*    */       } else {
/*    */         
/* 38 */         PornWarningWindow.wait = false;
/*    */       } 
/*    */       
/* 41 */       MinecraftForge.EVENT_BUS.register(new SetFOVForSex());
/* 42 */       MinecraftForge.EVENT_BUS.register(new SexUI());
/* 43 */       MinecraftForge.EVENT_BUS.register(new BlackScreenUI());
/* 44 */       MinecraftForge.EVENT_BUS.register(new HandlePlayerMovement());
/* 45 */       MinecraftForge.EVENT_BUS.register(new DontRenderPlayersThatHaveSex());
/* 46 */       MinecraftForge.EVENT_BUS.register(new ResetGirlList());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static boolean needsPornWarning() {
/* 54 */     File save = new File("sexmod/dontAskAgain");
/* 55 */     save.getParentFile().mkdirs();
/* 56 */     return !save.exists();
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\EventHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */