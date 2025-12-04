/*    */ package com.schnurritv.sexmod.proxy;
/*    */ import com.schnurritv.sexmod.Main;
/*    */ import com.schnurritv.sexmod.girls.allie.lamp.LampItem;
/*    */ import com.schnurritv.sexmod.hornypotion.HornyPotion;
/*    */ import com.schnurritv.sexmod.util.Handlers.EntityInnit;
/*    */ import com.schnurritv.sexmod.util.Handlers.EventHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.GuiHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import com.schnurritv.sexmod.world.WorldGenCustomStructures;
/*    */ import java.io.IOException;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ 
/*    */ public class CommonProxy {
/*    */   public void preInitRegistries(FMLPreInitializationEvent event) {
/* 21 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenCustomStructures(), 0);
/* 22 */     EntityInnit.registerEntities();
/* 23 */     HornyPotion.registerHornyPotion();
/* 24 */     LampItem.registerLamp();
/*    */   }
/*    */ 
/*    */   
/*    */   public void initRegistries(FMLInitializationEvent event) throws IOException {
/* 29 */     Main.setConfigs();
/* 30 */     SoundsHandler.registerSounds();
/* 31 */     NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, (IGuiHandler)new GuiHandler());
/* 32 */     EventHandler.registerEvents(false);
/* 33 */     PacketHandler.registerMessages();
/*    */   }
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) throws IOException {}
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\proxy\CommonProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */