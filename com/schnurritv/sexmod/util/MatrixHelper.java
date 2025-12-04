/*    */ package com.schnurritv.sexmod.util;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import javax.vecmath.Matrix4f;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import software.bernie.geckolib3.geo.render.built.GeoBone;
/*    */ import software.bernie.geckolib3.util.MatrixStack;
/*    */ 
/*    */ 
/*    */ public class MatrixHelper
/*    */ {
/* 13 */   public static final float[] floats = new float[16];
/* 14 */   public static final FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
/* 15 */   private static final Matrix4f matrix = new Matrix4f();
/*    */ 
/*    */   
/*    */   public static void multiplyMatrix(MatrixStack stack, GeoBone bone) {
/* 19 */     matrix.set(stack.getModelMatrix());
/* 20 */     matrix.transpose();
/*    */     
/* 22 */     matrixToFloat(floats, matrix);
/* 23 */     buffer.clear();
/* 24 */     buffer.put(floats);
/* 25 */     buffer.flip();
/*    */     
/* 27 */     GlStateManager.func_179110_a(buffer);
/* 28 */     GlStateManager.func_179109_b(bone.rotationPointX / 16.0F, bone.rotationPointY / 16.0F, bone.rotationPointZ / 16.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void matrixToFloat(float[] floats, Matrix4f matrix4f) {
/* 33 */     floats[0] = matrix4f.m00;
/* 34 */     floats[1] = matrix4f.m01;
/* 35 */     floats[2] = matrix4f.m02;
/* 36 */     floats[3] = matrix4f.m03;
/* 37 */     floats[4] = matrix4f.m10;
/* 38 */     floats[5] = matrix4f.m11;
/* 39 */     floats[6] = matrix4f.m12;
/* 40 */     floats[7] = matrix4f.m13;
/* 41 */     floats[8] = matrix4f.m20;
/* 42 */     floats[9] = matrix4f.m21;
/* 43 */     floats[10] = matrix4f.m22;
/* 44 */     floats[11] = matrix4f.m23;
/* 45 */     floats[12] = matrix4f.m30;
/* 46 */     floats[13] = matrix4f.m31;
/* 47 */     floats[14] = matrix4f.m32;
/* 48 */     floats[15] = matrix4f.m33;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\MatrixHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */