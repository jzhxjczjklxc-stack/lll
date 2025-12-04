/*    */ package com.schnurritv.sexmod.util.Handlers;
/*    */ import com.schnurritv.sexmod.Packets.ChangeDataParameter;
/*    */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*    */ import com.schnurritv.sexmod.Packets.PrepareAction;
/*    */ import com.schnurritv.sexmod.Packets.SendChatMessage;
/*    */ import com.schnurritv.sexmod.Packets.SendCompanionHome;
/*    */ import com.schnurritv.sexmod.Packets.SetNewHome;
/*    */ import com.schnurritv.sexmod.Packets.SetSlimePregnant;
/*    */ import com.schnurritv.sexmod.Packets.TeleportPlayer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ public class PacketHandler {
/* 13 */   private static int ID = 0; public static SimpleNetworkWrapper INSTANCE;
/*    */   private static int nextID() {
/* 15 */     return ID++;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerMessages() {
/* 21 */     INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("sexmodchannel");
/*    */     
/* 23 */     INSTANCE.registerMessage(SendChatMessage.Handler.class, SendChatMessage.class, nextID(), Side.CLIENT);
/* 24 */     INSTANCE.registerMessage(SendChatMessage.Handler.class, SendChatMessage.class, nextID(), Side.SERVER);
/* 25 */     INSTANCE.registerMessage(SetPlayerMovement.Handler.class, SetPlayerMovement.class, nextID(), Side.CLIENT);
/* 26 */     INSTANCE.registerMessage(TeleportPlayer.Handler.class, TeleportPlayer.class, nextID(), Side.SERVER);
/* 27 */     INSTANCE.registerMessage(SendGirlToBed.Handler.class, SendGirlToBed.class, nextID(), Side.SERVER);
/* 28 */     INSTANCE.registerMessage(JennyAwaitPlayerDoggy.Handler.class, JennyAwaitPlayerDoggy.class, nextID(), Side.SERVER);
/* 29 */     INSTANCE.registerMessage(SendEllieToPlayer.Handler.class, SendEllieToPlayer.class, nextID(), Side.SERVER);
/* 30 */     INSTANCE.registerMessage(PrepareAction.Handler.class, PrepareAction.class, nextID(), Side.SERVER);
/* 31 */     INSTANCE.registerMessage(ClearAnimationCache.Handler.class, ClearAnimationCache.class, nextID(), Side.CLIENT);
/* 32 */     INSTANCE.registerMessage(ClearAnimationCache.Handler.class, ClearAnimationCache.class, nextID(), Side.SERVER);
/* 33 */     INSTANCE.registerMessage(ResetGirl.Handler.class, ResetGirl.class, nextID(), Side.SERVER);
/* 34 */     INSTANCE.registerMessage(SetSlimePregnant.Handler.class, SetSlimePregnant.class, nextID(), Side.SERVER);
/* 35 */     INSTANCE.registerMessage(SetSlimePregnant.Handler.class, SetSlimePregnant.class, nextID(), Side.CLIENT);
/* 36 */     INSTANCE.registerMessage(ChangeDataParameter.Handler.class, ChangeDataParameter.class, nextID(), Side.SERVER);
/* 37 */     INSTANCE.registerMessage(OpenGirlInventory.Handler.class, OpenGirlInventory.class, nextID(), Side.SERVER);
/* 38 */     INSTANCE.registerMessage(SendCompanionHome.Handler.class, SendCompanionHome.class, nextID(), Side.SERVER);
/* 39 */     INSTANCE.registerMessage(SetNewHome.Handler.class, SetNewHome.class, nextID(), Side.SERVER);
/* 40 */     INSTANCE.registerMessage(UploadInventoryToServer.Handler.class, UploadInventoryToServer.class, nextID(), Side.SERVER);
/* 41 */     INSTANCE.registerMessage(RemoveItems.Handler.class, RemoveItems.class, nextID(), Side.SERVER);
/* 42 */     INSTANCE.registerMessage(SummonAllie.Handler.class, SummonAllie.class, nextID(), Side.SERVER);
/* 43 */     INSTANCE.registerMessage(WishDone.Handler.class, WishDone.class, nextID(), Side.SERVER);
/* 44 */     INSTANCE.registerMessage(MakeRichWish.Handler.class, MakeRichWish.class, nextID(), Side.SERVER);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\PacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */