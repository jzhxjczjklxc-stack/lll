/*    */ package com.schnurritv.sexmod.girls.slime.friendlySlime;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelSlime;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class FriendlySlimeGelLayer
/*    */   implements LayerRenderer<FriendlySlimeEntity>
/*    */ {
/*    */   private final FriendlySlimeRenderer slimeRenderer;
/* 14 */   private final ModelBase slimeModel = (ModelBase)new ModelSlime(0);
/*    */ 
/*    */   
/*    */   public FriendlySlimeGelLayer(FriendlySlimeRenderer slimeRendererIn) {
/* 18 */     this.slimeRenderer = slimeRendererIn;
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRenderLayer(FriendlySlimeEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 23 */     if (!entitylivingbaseIn.func_82150_aj()) {
/*    */       
/* 25 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 26 */       GlStateManager.func_179108_z();
/* 27 */       GlStateManager.func_179147_l();
/* 28 */       GlStateManager.func_187401_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
/* 29 */       this.slimeModel.func_178686_a(this.slimeRenderer.func_177087_b());
/* 30 */       this.slimeModel.func_78088_a((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/* 31 */       GlStateManager.func_179084_k();
/* 32 */       GlStateManager.func_179133_A();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_177142_b() {
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\friendlySlime\FriendlySlimeGelLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */