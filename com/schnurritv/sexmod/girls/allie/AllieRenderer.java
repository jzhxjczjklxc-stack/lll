/*    */ package com.schnurritv.sexmod.girls.allie;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.GirlRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import software.bernie.geckolib3.geo.render.built.GeoModel;
/*    */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*    */ 
/*    */ public class AllieRenderer
/*    */   extends GirlRenderer {
/*    */   public AllieRenderer(RenderManager renderManager, AnimatedGeoModel model, double leashHeightOffset) {
/* 13 */     super(renderManager, model, leashHeightOffset);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(GeoModel model, GirlEntity animatable, float partialTicks, float red, float green, float blue, float alpha) {
/* 19 */     alpha = ((AllieEntity)animatable).alpha;
/* 20 */     GlStateManager.func_179152_a(alpha, alpha, alpha);
/* 21 */     super.render(model, animatable, partialTicks, red, green, blue, alpha);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\allie\AllieRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */