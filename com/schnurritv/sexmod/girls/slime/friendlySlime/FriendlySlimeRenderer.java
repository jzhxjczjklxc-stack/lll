/*    */ package com.schnurritv.sexmod.girls.slime.friendlySlime;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class FriendlySlimeRenderer extends RenderLiving<FriendlySlimeEntity> {
/* 10 */   private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation("textures/entity/slime/slime.png");
/*    */ 
/*    */   
/*    */   public FriendlySlimeRenderer(RenderManager p_i47193_1_) {
/* 14 */     super(p_i47193_1_, new FriendlySlimeModel(), 0.25F);
/* 15 */     func_177094_a(new FriendlySlimeGelLayer(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(FriendlySlimeEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
/* 23 */     this.field_76989_e = 0.25F * entity.getSlimeSize();
/* 24 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(FriendlySlimeEntity entitylivingbaseIn, float partialTickTime) {
/* 32 */     float f = 0.999F;
/* 33 */     GlStateManager.func_179152_a(0.999F, 0.999F, 0.999F);
/* 34 */     float f1 = entitylivingbaseIn.getSlimeSize();
/* 35 */     float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
/* 36 */     float f3 = 1.0F / (f2 + 1.0F);
/* 37 */     GlStateManager.func_179152_a(f3 * f1, 1.0F / f3 * f1, f3 * f1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(FriendlySlimeEntity entity) {
/* 45 */     return SLIME_TEXTURES;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\friendlySlime\FriendlySlimeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */