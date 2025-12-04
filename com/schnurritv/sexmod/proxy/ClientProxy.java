/*    */ package com.schnurritv.sexmod.proxy;
/*    */ 
/*    */ import com.daripher.sexmod.client.util.FakeWorld;
/*    */ import com.schnurritv.sexmod.Main;
/*    */ import com.schnurritv.sexmod.girls.allie.AllieEntity;
/*    */ import com.schnurritv.sexmod.girls.bia.BiaEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*    */ import com.schnurritv.sexmod.util.Handlers.EventHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.GuiHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.RenderHandler;
/*    */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ 
/*    */ public class ClientProxy
/*    */   extends CommonProxy
/*    */ {
/*    */   public void preInitRegistries(FMLPreInitializationEvent event) {
/* 29 */     super.preInitRegistries(event);
/* 30 */     RenderHandler.registerEntityRenders();
/*    */   }
/*    */ 
/*    */   
/*    */   public void initRegistries(FMLInitializationEvent event) throws IOException {
/* 35 */     Main.setConfigs();
/* 36 */     SoundsHandler.registerSounds();
/* 37 */     NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, (IGuiHandler)new GuiHandler());
/* 38 */     EventHandler.registerEvents(true);
/* 39 */     PacketHandler.registerMessages();
/*    */     
/* 41 */     Minecraft client = Minecraft.func_71410_x();
/* 42 */     RenderManager rendermanager = client.func_175598_ae();
/* 43 */     FakeWorld fakeWorld = new FakeWorld();
/*    */     
/* 45 */     rendermanager.func_188391_a((Entity)new JennyEntity((World)fakeWorld), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
/* 46 */     rendermanager.func_188391_a((Entity)new EllieEntity((World)fakeWorld), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
/* 47 */     rendermanager.func_188391_a((Entity)new SlimeEntity((World)fakeWorld), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
/* 48 */     rendermanager.func_188391_a((Entity)new BiaEntity((World)fakeWorld), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
/* 49 */     rendermanager.func_188391_a((Entity)new AllieEntity((World)fakeWorld), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */