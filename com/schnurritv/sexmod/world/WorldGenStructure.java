/*    */ package com.schnurritv.sexmod.world;
/*    */ 
/*    */ import com.schnurritv.sexmod.util.interfaces.IStructure;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraft.world.gen.structure.template.Template;
/*    */ import net.minecraft.world.gen.structure.template.TemplateManager;
/*    */ 
/*    */ 
/*    */ public class WorldGenStructure
/*    */   extends WorldGenerator
/*    */   implements IStructure
/*    */ {
/*    */   public static String structureName;
/*    */   
/*    */   public WorldGenStructure(String name) {
/* 22 */     this; structureName = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void generateStructure(World world, BlockPos pos) {
/* 27 */     MinecraftServer mcServer = world.func_73046_m();
/* 28 */     TemplateManager manager = worldServer.func_184163_y();
/* 29 */     ResourceLocation location = new ResourceLocation("sexmod", structureName);
/* 30 */     Template template = manager.func_189942_b(mcServer, location);
/*    */     
/* 32 */     if (template != null) {
/* 33 */       IBlockState state = world.func_180495_p(pos);
/* 34 */       world.func_184138_a(pos, state, state, 3);
/* 35 */       template.func_186253_b(world, pos, settings);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_180709_b(World worldIn, Random rand, BlockPos position) {
/* 42 */     this; generateStructure(worldIn, position);
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\world\WorldGenStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */