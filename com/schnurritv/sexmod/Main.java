/*    */ package com.schnurritv.sexmod;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.schnurritv.sexmod.girls.GirlModel;
/*    */ import com.schnurritv.sexmod.proxy.CommonProxy;
/*    */ import com.schnurritv.sexmod.util.Configs;
/*    */ import com.schnurritv.sexmod.world.WorldGenCustomStructures;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.SidedProxy;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import software.bernie.geckolib3.GeckoLib;
/*    */ 
/*    */ 
/*    */ @Mod(modid = "sexmod", name = "SchnurriTV's Sex Mod", version = "1.3 beta", acceptedMinecraftVersions = "[1.12.2]")
/*    */ public class Main
/*    */ {
/*    */   @Instance
/*    */   public static Main instance;
/*    */   @SidedProxy(clientSide = "com.schnurritv.sexmod.proxy.ClientProxy", serverSide = "com.schnurritv.sexmod.proxy.CommonProxy")
/*    */   public static CommonProxy proxy;
/* 31 */   public static final Logger LOGGER = LogManager.getLogger("sexmod");
/*    */ 
/*    */ 
/*    */   
/*    */   public Main() {
/* 36 */     GeckoLib.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event) {
/* 43 */     proxy.preInitRegistries(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void init(FMLInitializationEvent event) throws IOException {
/* 49 */     proxy.initRegistries(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void postInit(FMLPostInitializationEvent event) throws IOException {
/* 55 */     proxy.postInit(event);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setConfigs() throws IOException {
/* 69 */     Gson gson = new Gson();
/* 70 */     File dir = new File("sexmod");
/* 71 */     dir.mkdir();
/* 72 */     File configFile = new File("sexmod/config.json");
/*    */     
/* 74 */     if (!configFile.exists()) {
/*    */       
/* 76 */       configFile.createNewFile();
/* 77 */       FileWriter fw = new FileWriter(configFile);
/* 78 */       fw.write(gson.toJson(new Configs(1000, true, true)));
/* 79 */       fw.close();
/*    */     } 
/*    */     
/* 82 */     Configs.INSTANCE = (Configs)gson.fromJson(new FileReader(configFile), Configs.class);
/*    */     
/* 84 */     WorldGenCustomStructures.shouldGenerateBuildings = Configs.INSTANCE.shouldGenBuildings;
/* 85 */     GirlModel.shouldUseOtherSkins = Configs.INSTANCE.shouldLoadOtherSkins;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */