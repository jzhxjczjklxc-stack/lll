/*     */ package com.schnurritv.sexmod.girls.slime;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.GirlRenderer;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.Collections;
/*     */ import java.util.Objects;
/*     */ import javax.vecmath.Tuple3f;
/*     */ import javax.vecmath.Tuple4f;
/*     */ import javax.vecmath.Vector3f;
/*     */ import javax.vecmath.Vector4f;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import software.bernie.geckolib3.core.IAnimatable;
/*     */ import software.bernie.geckolib3.core.IAnimatableModel;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoBone;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoCube;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoModel;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoQuad;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoVertex;
/*     */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*     */ import software.bernie.geckolib3.model.provider.GeoModelProvider;
/*     */ import software.bernie.geckolib3.model.provider.data.EntityModelData;
/*     */ import software.bernie.geckolib3.renderers.geo.RenderHurtColor;
/*     */ import software.bernie.shadowed.eliotlash.mclib.utils.Interpolations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SlimeRenderer
/*     */   extends GirlRenderer
/*     */ {
/*     */   public SlimeRenderer(RenderManager renderManager, AnimatedGeoModel model, double leashHeightOffset) {
/*  48 */     super(renderManager, model, leashHeightOffset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(GeoModel model, GirlEntity animatable, float partialTicks, float red, float green, float blue, float alpha) {
/*  56 */     GlStateManager.func_179129_p();
/*  57 */     GlStateManager.func_179091_B();
/*  58 */     renderEarly(animatable, partialTicks, red, green, blue, alpha);
/*     */     
/*  60 */     renderLate(animatable, partialTicks, red, green, blue, alpha);
/*     */     
/*  62 */     BufferBuilder builder = Tessellator.func_178181_a().func_178180_c();
/*     */ 
/*     */     
/*  65 */     for (GeoBone group : model.topLevelBones) {
/*     */       
/*  67 */       if (group.getName().equals("steve")) {
/*     */         
/*  69 */         builder.func_181668_a(7, DefaultVertexFormats.field_181712_l);
/*     */         try {
/*  71 */           (Minecraft.func_71410_x()).field_71446_o.func_110577_a(getPlayerSkin(this.girl));
/*  72 */         } catch (IOException e) {
/*  73 */           e.printStackTrace();
/*     */         } 
/*  75 */         renderRecursively(builder, group, red, green, blue, alpha);
/*  76 */         Tessellator.func_178181_a().func_78381_a();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  81 */     func_110776_a(Objects.<ResourceLocation>requireNonNull(getEntityTexture((EntityLivingBase)this.girl)));
/*  82 */     builder.func_181668_a(7, DefaultVertexFormats.field_181712_l);
/*     */     
/*  84 */     for (GeoBone group : model.topLevelBones) {
/*     */       
/*  86 */       if (group.getName().equals("steve")) {
/*     */         continue;
/*     */       }
/*     */       
/*  90 */       renderRecursively(builder, group, red, green, blue, alpha);
/*     */     } 
/*  92 */     Tessellator.func_178181_a().func_78381_a();
/*     */ 
/*     */     
/*  95 */     renderAfter(animatable, partialTicks, red, green, blue, alpha);
/*  96 */     GlStateManager.func_179101_C();
/*  97 */     GlStateManager.func_179089_o();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderRecursively(BufferBuilder builder, GeoBone bone, float red, float green, float blue, float alpha) {
/* 103 */     MATRIX_STACK.push();
/* 104 */     MATRIX_STACK.translate(bone);
/* 105 */     MATRIX_STACK.moveToPivot(bone);
/* 106 */     MATRIX_STACK.rotate(bone);
/* 107 */     MATRIX_STACK.scale(bone);
/* 108 */     MATRIX_STACK.moveBackFromPivot(bone);
/*     */     
/* 110 */     if (!bone.isHidden) {
/*     */       
/* 112 */       for (GeoCube cube : bone.childCubes) {
/*     */         
/* 114 */         MATRIX_STACK.push();
/* 115 */         GlStateManager.func_179094_E();
/* 116 */         renderCube(builder, cube, red, green, blue, alpha);
/* 117 */         GlStateManager.func_179121_F();
/* 118 */         MATRIX_STACK.pop();
/*     */       } 
/* 120 */       for (GeoBone childBone : bone.childBones) {
/* 121 */         renderRecursively(builder, childBone, red, green, blue, alpha);
/*     */       }
/*     */     } 
/* 124 */     MATRIX_STACK.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderCube(BufferBuilder builder, GeoCube cube, float red, float green, float blue, float alpha) {
/* 131 */     MATRIX_STACK.moveToPivot(cube);
/* 132 */     MATRIX_STACK.rotate(cube);
/* 133 */     MATRIX_STACK.moveBackFromPivot(cube);
/*     */     
/* 135 */     for (GeoQuad quad : cube.quads) {
/*     */       
/* 137 */       if (quad != null) {
/*     */ 
/*     */         
/* 140 */         Vector3f normal = new Vector3f(quad.normal.func_177958_n(), quad.normal.func_177956_o(), quad.normal.func_177952_p());
/*     */         
/* 142 */         MATRIX_STACK.getNormalMatrix().transform((Tuple3f)normal);
/*     */ 
/*     */         
/* 145 */         if ((cube.size.y == 0.0F || cube.size.z == 0.0F) && normal.getX() < 0.0F)
/*     */         {
/* 147 */           normal.x *= -1.0F;
/*     */         }
/* 149 */         if ((cube.size.x == 0.0F || cube.size.z == 0.0F) && normal.getY() < 0.0F)
/*     */         {
/* 151 */           normal.y *= -1.0F;
/*     */         }
/* 153 */         if ((cube.size.x == 0.0F || cube.size.y == 0.0F) && normal.getZ() < 0.0F)
/*     */         {
/* 155 */           normal.z *= -1.0F;
/*     */         }
/*     */         
/* 158 */         for (GeoVertex vertex : quad.vertices) {
/*     */           
/* 160 */           Vector4f vector4f = new Vector4f(vertex.position.getX(), vertex.position.getY(), vertex.position.getZ(), 1.0F);
/*     */           
/* 162 */           MATRIX_STACK.getModelMatrix().transform((Tuple4f)vector4f);
/*     */           
/* 164 */           builder.func_181662_b(vector4f.getX(), vector4f.getY(), vector4f.getZ()).func_187315_a(vertex.textureU, vertex.textureV).func_181666_a(red, green, blue, alpha).func_181663_c(normal.getX(), normal.getY(), normal.getZ()).func_181675_d();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doRender(GirlEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
/* 173 */     this.girl = entity;
/*     */     
/* 175 */     if (entity.func_110167_bD())
/*     */     {
/* 177 */       renderLeash(entity, x, y + this.leashHeightOffset, z, partialTicks);
/*     */     }
/*     */     
/* 180 */     GlStateManager.func_179094_E();
/* 181 */     GlStateManager.func_179137_b(x, y, z);
/* 182 */     GL11.glDisable(2896);
/* 183 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.5F);
/* 184 */     GlStateManager.func_179108_z();
/* 185 */     GlStateManager.func_179147_l();
/* 186 */     GlStateManager.func_179129_p();
/* 187 */     GlStateManager.func_187401_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
/*     */     
/* 189 */     SlimeEntity slime = (SlimeEntity)entity;
/*     */ 
/*     */ 
/*     */     
/* 193 */     slime.prevRenderPos = slime.field_70163_u;
/*     */ 
/*     */     
/* 196 */     boolean shouldSit = (entity.func_184187_bx() != null && entity.func_184187_bx().shouldRiderSit());
/* 197 */     EntityModelData entityModelData = new EntityModelData();
/* 198 */     entityModelData.isSitting = shouldSit;
/* 199 */     entityModelData.isChild = entity.func_70631_g_();
/*     */     
/* 201 */     float f = Interpolations.lerpYaw(entity.field_70760_ar, entity.field_70761_aq, partialTicks);
/* 202 */     float f1 = Interpolations.lerpYaw(entity.field_70758_at, entity.field_70759_as, partialTicks);
/* 203 */     float netHeadYaw = f1 - f;
/* 204 */     if (shouldSit && entity.func_184187_bx() instanceof EntityLivingBase) {
/*     */       
/* 206 */       EntityLivingBase livingentity = (EntityLivingBase)entity.func_184187_bx();
/* 207 */       f = Interpolations.lerpYaw(livingentity.field_70760_ar, livingentity.field_70761_aq, partialTicks);
/* 208 */       netHeadYaw = f1 - f;
/* 209 */       float f3 = MathHelper.func_76142_g(netHeadYaw);
/* 210 */       if (f3 < -85.0F)
/*     */       {
/* 212 */         f3 = -85.0F;
/*     */       }
/*     */       
/* 215 */       if (f3 >= 85.0F)
/*     */       {
/* 217 */         f3 = 85.0F;
/*     */       }
/*     */       
/* 220 */       f = f1 - f3;
/* 221 */       if (f3 * f3 > 2500.0F)
/*     */       {
/* 223 */         f += f3 * 0.2F;
/*     */       }
/*     */       
/* 226 */       netHeadYaw = f1 - f;
/*     */     } 
/*     */     
/* 229 */     float headPitch = Interpolations.lerp(entity.field_70127_C, entity.field_70125_A, partialTicks);
/* 230 */     float f7 = handleRotationFloat((EntityLivingBase)entity, partialTicks);
/* 231 */     applyRotations((EntityLivingBase)entity, f7, f, partialTicks);
/*     */     
/* 233 */     float limbSwingAmount = 0.0F;
/* 234 */     float limbSwing = 0.0F;
/* 235 */     if (!shouldSit && entity.func_70089_S()) {
/*     */       
/* 237 */       limbSwingAmount = Interpolations.lerp(entity.field_184618_aE, entity.field_70721_aZ, partialTicks);
/* 238 */       limbSwing = entity.field_184619_aG - entity.field_70721_aZ * (1.0F - partialTicks);
/* 239 */       if (entity.func_70631_g_())
/*     */       {
/* 241 */         limbSwing *= 3.0F;
/*     */       }
/*     */       
/* 244 */       if (limbSwingAmount > 1.0F)
/*     */       {
/* 246 */         limbSwingAmount = 1.0F;
/*     */       }
/*     */     } 
/* 249 */     entityModelData.headPitch = -headPitch;
/* 250 */     entityModelData.netHeadYaw = -netHeadYaw;
/*     */     
/* 252 */     AnimationEvent<GirlEntity> predicate = new AnimationEvent((IAnimatable)entity, limbSwing, limbSwingAmount, partialTicks, (limbSwingAmount <= -0.15F || limbSwingAmount >= 0.15F), Collections.singletonList(entityModelData));
/*     */     
/* 254 */     GeoModelProvider modelProvider = getGeoModelProvider();
/*     */     
/* 256 */     ResourceLocation location = modelProvider.getModelLocation(entity);
/*     */     
/* 258 */     GeoModel model = modelProvider.getModel(location);
/*     */     
/* 260 */     if (modelProvider instanceof IAnimatableModel)
/*     */     {
/* 262 */       ((IAnimatableModel)modelProvider).setLivingAnimations(entity, Integer.valueOf(entity.func_110124_au().hashCode()), predicate);
/*     */     }
/*     */     
/* 265 */     GlStateManager.func_179094_E();
/* 266 */     GlStateManager.func_179109_b(0.0F, 0.01F, 0.0F);
/* 267 */     (Minecraft.func_71410_x()).field_71446_o.func_110577_a(getEntityTexture((EntityLivingBase)entity));
/* 268 */     Color renderColor = getRenderColor(entity, partialTicks);
/*     */     
/* 270 */     boolean flag = setDoRenderBrightness((EntityLivingBase)entity, partialTicks);
/*     */     
/* 272 */     render(model, entity, partialTicks, renderColor.getRed() / 255.0F, renderColor.getBlue() / 255.0F, renderColor.getGreen() / 255.0F, renderColor.getAlpha() / 255.0F);
/*     */     
/* 274 */     if (flag)
/*     */     {
/* 276 */       RenderHurtColor.unset();
/*     */     }
/*     */     
/* 279 */     GL11.glScaled(1.0D, 1.0D, 1.0D);
/* 280 */     GL11.glEnable(2896);
/* 281 */     GlStateManager.func_179084_k();
/* 282 */     GlStateManager.func_179133_A();
/* 283 */     GlStateManager.func_179121_F();
/* 284 */     GlStateManager.func_179121_F();
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\SlimeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */