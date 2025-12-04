/*    */ package com.schnurritv.sexmod.events;
/*    */ 
/*    */ import com.schnurritv.sexmod.Packets.ResetGirl;
/*    */ import com.schnurritv.sexmod.Packets.SetPlayerMovement;
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.allie.lamp.LampItem;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ 
/*    */ 
/*    */ public class ResetJoiningPlayer
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void resetJoiningPlayer(PlayerEvent.PlayerLoggedInEvent event) throws IOException {
/* 22 */     EntityPlayerMP player = event.player.field_70170_p.func_73046_m().func_184103_al().func_177451_a(event.player.getPersistentID());
/* 23 */     player.func_82142_c(false);
/* 24 */     PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(true), player);
/*    */ 
/*    */     
/* 27 */     for (GirlEntity girl : GirlEntity.girlEntities) {
/* 28 */       if (girl instanceof com.schnurritv.sexmod.girls.allie.AllieEntity) {
/* 29 */         event.player.field_70170_p.func_72900_e((Entity)girl);
/*    */       }
/*    */     } 
/*    */     
/* 33 */     for (ItemStack stack : player.field_71071_by.field_70462_a) {
/*    */       
/* 35 */       if (stack.func_77973_b() == LampItem.LAMP_ITEM)
/*    */       {
/* 37 */         if (stack.func_77942_o())
/*    */         {
/* 39 */           stack.func_77978_p().func_186854_a("user", UUID.randomUUID());
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void resetGirls(PlayerEvent.PlayerLoggedOutEvent event) {
/* 48 */     for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */       
/* 50 */       if (girl instanceof com.schnurritv.sexmod.girls.allie.AllieEntity)
/*    */       {
/* 52 */         if (girl.playerSheHasSexWith() == null || girl.playerSheHasSexWith().equals(event.player.getPersistentID())) {
/* 53 */           event.player.field_70170_p.func_72900_e((Entity)girl);
/*    */           
/*    */           continue;
/*    */         } 
/*    */       }
/* 58 */       if (girl.playerSheHasSexWith() == null)
/*    */         continue; 
/* 60 */       if (girl.playerSheHasSexWith().equals(event.player.getPersistentID()) || girl.playerSheHasSexWith().equals(event.player.func_110124_au())) {
/*    */         
/* 62 */         ResetGirl.Handler.resetGirl(girl);
/* 63 */         girl.setCurrentAction(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\events\ResetJoiningPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */