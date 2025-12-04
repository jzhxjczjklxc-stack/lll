/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.gui.SexUI;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.MovementInput;
/*    */ import net.minecraftforge.client.event.InputUpdateEvent;
/*    */ import net.minecraftforge.client.event.MouseEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HandlePlayerMovement
/*    */ {
/*    */   private static boolean active = true;
/*    */   public static boolean isThrusting = false;
/*    */   public static boolean isCumming = false;
/*    */   public static boolean r = false;
/*    */   public static boolean g = false;
/*    */   public static boolean b = false;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void PreventPlayerFromMoving(InputUpdateEvent event) {
/* 26 */     MovementInput movement = event.getMovementInput();
/* 27 */     isThrusting = movement.field_78899_d;
/*    */ 
/*    */     
/* 30 */     r = movement.field_187255_c;
/* 31 */     g = movement.field_187257_e;
/* 32 */     b = movement.field_187258_f;
/*    */ 
/*    */     
/* 35 */     if (!active) {
/*    */ 
/*    */       
/* 38 */       if (movement.field_78899_d)
/*    */       {
/* 40 */         GirlEntity.sendThrust((Minecraft.func_71410_x()).field_71439_g.getPersistentID());
/*    */       }
/*    */ 
/*    */       
/* 44 */       if (movement.field_78901_c && SexUI.cumPercentage >= 1.0D)
/*    */       {
/* 46 */         GirlEntity.sendCum((Minecraft.func_71410_x()).field_71439_g.getPersistentID());
/*    */       }
/*    */       
/* 49 */       isThrusting = movement.field_78899_d;
/* 50 */       isCumming = movement.field_78901_c;
/*    */       
/* 52 */       movement.field_187256_d = false;
/* 53 */       movement.field_187255_c = false;
/* 54 */       movement.field_187257_e = false;
/* 55 */       movement.field_187258_f = false;
/* 56 */       movement.field_78899_d = false;
/* 57 */       movement.field_78901_c = false;
/* 58 */       movement.field_192832_b = 0.0F;
/* 59 */       movement.field_78902_a = 0.0F;
/* 60 */       (Minecraft.func_71410_x()).field_71439_g.func_70016_h(0.0D, 0.0D, 0.0D);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setActive(boolean active) {
/* 67 */     HandlePlayerMovement.active = active;
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void PreventPlayerFromTakingAction(MouseEvent event) {
/* 73 */     event.setCanceled(!active);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\HandlePlayerMovement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */