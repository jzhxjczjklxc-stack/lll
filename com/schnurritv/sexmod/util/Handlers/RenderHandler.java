/*    */ package com.schnurritv.sexmod.util.Handlers;
/*    */ import com.schnurritv.sexmod.girls.GirlRenderer;
/*    */ import com.schnurritv.sexmod.girls.allie.AllieEntity;
/*    */ import com.schnurritv.sexmod.girls.allie.AllieModel;
/*    */ import com.schnurritv.sexmod.girls.allie.AllieRenderer;
/*    */ import com.schnurritv.sexmod.girls.bia.BiaEntity;
/*    */ import com.schnurritv.sexmod.girls.bia.BiaModel;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieModel;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyModel;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeModel;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeRenderer;
/*    */ import com.schnurritv.sexmod.girls.slime.friendlySlime.FriendlySlimeEntity;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*    */ 
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(JennyEntity.class, manager -> new GirlRenderer(manager, (AnimatedGeoModel)new JennyModel(), -0.15D));
/* 25 */     RenderingRegistry.registerEntityRenderingHandler(EllieEntity.class, manager -> new GirlRenderer(manager, (AnimatedGeoModel)new EllieModel(), 0.05D));
/* 26 */     RenderingRegistry.registerEntityRenderingHandler(SlimeEntity.class, manager -> new SlimeRenderer(manager, (AnimatedGeoModel)new SlimeModel(), -0.2D));
/* 27 */     RenderingRegistry.registerEntityRenderingHandler(BiaEntity.class, manager -> new GirlRenderer(manager, (AnimatedGeoModel)new BiaModel(), -0.4D));
/* 28 */     RenderingRegistry.registerEntityRenderingHandler(AllieEntity.class, manager -> new AllieRenderer(manager, (AnimatedGeoModel)new AllieModel(), -0.4D));
/* 29 */     RenderingRegistry.registerEntityRenderingHandler(FriendlySlimeEntity.class, com.schnurritv.sexmod.girls.slime.friendlySlime.FriendlySlimeRenderer::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */