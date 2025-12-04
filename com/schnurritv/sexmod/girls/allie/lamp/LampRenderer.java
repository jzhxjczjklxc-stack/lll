/*    */ package com.schnurritv.sexmod.girls.allie.lamp;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.BufferBuilder;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import software.bernie.geckolib3.geo.render.built.GeoBone;
/*    */ import software.bernie.geckolib3.geo.render.built.GeoCube;
/*    */ import software.bernie.geckolib3.geo.render.built.GeoModel;
/*    */ import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
/*    */ 
/*    */ 
/*    */ public class LampRenderer
/*    */   extends GeoItemRenderer<LampItem>
/*    */ {
/*    */   Minecraft mc;
/*    */   
/*    */   public LampRenderer() {
/* 22 */     super(new LampModel());
/* 23 */     this.mc = Minecraft.func_71410_x();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(GeoModel model, LampItem animatable, float partialTicks, float red, float green, float blue, float alpha) {
/* 29 */     GlStateManager.func_179129_p();
/* 30 */     GlStateManager.func_179091_B();
/* 31 */     renderEarly(animatable, partialTicks, red, green, blue, alpha);
/*    */     
/* 33 */     renderLate(animatable, partialTicks, red, green, blue, alpha);
/*    */     
/* 35 */     BufferBuilder builder = Tessellator.func_178181_a().func_178180_c();
/*    */     
/* 37 */     builder.func_181668_a(7, DefaultVertexFormats.field_181712_l);
/*    */ 
/*    */     
/* 40 */     for (GeoBone group : model.topLevelBones)
/*    */     {
/* 42 */       renderRecursively(builder, animatable, group, red, green, blue, alpha);
/*    */     }
/*    */     
/* 45 */     Tessellator.func_178181_a().func_78381_a();
/*    */     
/* 47 */     renderAfter(animatable, partialTicks, red, green, blue, alpha);
/* 48 */     GlStateManager.func_179101_C();
/* 49 */     GlStateManager.func_179089_o();
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderRecursively(BufferBuilder builder, LampItem animatable, GeoBone bone, float red, float green, float blue, float alpha) {
/* 54 */     MATRIX_STACK.push();
/*    */     
/* 56 */     MATRIX_STACK.translate(bone);
/* 57 */     MATRIX_STACK.moveToPivot(bone);
/* 58 */     MATRIX_STACK.rotate(bone);
/* 59 */     MATRIX_STACK.scale(bone);
/* 60 */     MATRIX_STACK.moveBackFromPivot(bone);
/*    */     
/* 62 */     String name = bone.getName();
/*    */     
/* 64 */     if (name.equals("leftArm") || name.equals("rightArm")) {
/*    */       
/* 66 */       ItemStack stack = this.mc.field_71439_g.func_184614_ca();
/*    */       
/* 68 */       if (stack.func_77942_o()) {
/* 69 */         NBTTagCompound nbt = stack.func_77978_p();
/*    */         
/* 71 */         if (nbt.func_186857_a("user").equals(this.mc.field_71439_g.getPersistentID()) && this.mc.field_71474_y.field_74320_O == 0) {
/* 72 */           renderBoneNormally(builder, animatable, bone, red, green, blue, alpha);
/*    */         }
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 78 */       renderBoneNormally(builder, animatable, bone, red, green, blue, alpha);
/*    */     } 
/*    */     
/* 81 */     MATRIX_STACK.pop();
/*    */   }
/*    */   
/*    */   void renderBoneNormally(BufferBuilder builder, LampItem animatable, GeoBone bone, float red, float green, float blue, float alpha) {
/* 85 */     if (!bone.isHidden) {
/*    */       
/* 87 */       for (GeoCube cube : bone.childCubes) {
/*    */         
/* 89 */         MATRIX_STACK.push();
/* 90 */         GlStateManager.func_179094_E();
/* 91 */         renderCube(builder, cube, red, green, blue, alpha);
/* 92 */         GlStateManager.func_179121_F();
/* 93 */         MATRIX_STACK.pop();
/*    */       } 
/* 95 */       for (GeoBone childBone : bone.childBones)
/*    */       {
/* 97 */         renderRecursively(builder, animatable, childBone, red, green, blue, alpha);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\allie\lamp\LampRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */