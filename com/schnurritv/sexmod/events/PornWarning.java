/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.gui.PornWarningWindow;
/*    */ import javax.swing.JFrame;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.TickEvent;
/*    */ 
/*    */ 
/*    */ public class PornWarning
/*    */   extends JFrame
/*    */ {
/*    */   public boolean didIt = false;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void PornWarning(TickEvent.ClientTickEvent event) {
/* 16 */     if (!this.didIt) {
/*    */       
/* 18 */       this.didIt = true;
/* 19 */       PornWarningWindow.launch();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\PornWarning.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */