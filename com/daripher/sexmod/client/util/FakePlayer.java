/*    */ package com.daripher.sexmod.client.util;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.util.RecipeBookClient;
/*    */ import net.minecraft.stats.RecipeBook;
/*    */ import net.minecraft.stats.StatisticsManager;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class FakePlayer
/*    */   extends EntityPlayerSP
/*    */ {
/*    */   public FakePlayer(World world) {
/* 14 */     super(Minecraft.func_71410_x(), (World)new FakeWorld(), new FakeNetHandlerPlayClient(Minecraft.func_71410_x()), new StatisticsManager(), (RecipeBook)new RecipeBookClient());
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakePlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */