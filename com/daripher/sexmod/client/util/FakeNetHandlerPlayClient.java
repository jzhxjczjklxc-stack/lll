/*    */ package com.daripher.sexmod.client.util;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import net.minecraft.network.EnumPacketDirection;
/*    */ 
/*    */ public class FakeNetHandlerPlayClient
/*    */   extends NetHandlerPlayClient {
/*    */   public FakeNetHandlerPlayClient(Minecraft mcIn) {
/* 13 */     super(mcIn, mcIn.field_71462_r, new FakeNetworkManager(EnumPacketDirection.CLIENTBOUND), mcIn.func_110432_I().func_148256_e());
/*    */   }
/*    */   private NetworkPlayerInfo playerInfo;
/*    */   
/*    */   public NetworkPlayerInfo func_175102_a(UUID uniqueId) {
/* 18 */     return this.playerInfo;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public NetworkPlayerInfo func_175104_a(String name) {
/* 23 */     return this.playerInfo;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakeNetHandlerPlayClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */