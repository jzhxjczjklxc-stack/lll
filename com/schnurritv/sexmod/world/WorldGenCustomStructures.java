/*     */ package com.schnurritv.sexmod.world;
/*     */ 
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import javax.vecmath.Vector2f;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Biomes;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.IChunkGenerator;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.fml.common.IWorldGenerator;
/*     */ 
/*     */ public class WorldGenCustomStructures implements IWorldGenerator {
/*     */   public static boolean shouldGenerateBuildings = true;
/*  26 */   static int minimumDistance = 50;
/*  27 */   public static HashMap<String, List<Vector2f>> buildings = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/*  32 */     if (shouldGenerateBuildings) {
/*  33 */       switch (world.field_73011_w.getDimension()) {
/*     */ 
/*     */         
/*     */         case 0:
/*  37 */           generateStructure(new WorldGenStructure("jenny"), world, random, chunkX, chunkZ, Arrays.asList(new Biome[] { Biomes.field_76772_c, Biomes.field_76767_f }, ), new Vec3i(9, 4, 9), 0, "jenny");
/*  38 */           generateStructure(new WorldGenStructure("ellie"), world, random, chunkX, chunkZ, Arrays.asList(new Biome[] { Biomes.field_150578_U, Biomes.field_150584_S, Biomes.field_76768_g, Biomes.field_150585_R }, ), new Vec3i(30, 27, 26), 0, "ellie");
/*  39 */           generateStructure(new WorldGenStructure("bia"), world, random, chunkX, chunkZ, Arrays.asList(new Biome[] { Biomes.field_150583_P, Biomes.field_185448_Z }, ), new Vec3i(11, 9, 15), 0, "bia");
/*     */           break;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean didIt = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, List<Biome> biomes, Vec3i bounds, int yOffset, String name) {
/*  57 */     if (!this.didIt) {
/*  58 */       buildings.put("jenny", new ArrayList<>());
/*  59 */       buildings.put("ellie", new ArrayList<>());
/*  60 */       buildings.put("bia", new ArrayList<>());
/*  61 */       this.didIt = true;
/*     */     } 
/*     */     
/*  64 */     int x = chunkX * 16 + random.nextInt(15);
/*  65 */     int z = chunkZ * 16 + random.nextInt(15);
/*  66 */     int y = calculateGenerationHeight(world, x, z);
/*     */     
/*  68 */     BlockPos pos = new BlockPos(x, y - yOffset, z);
/*     */     
/*  70 */     Biome currentBiome = world.field_73011_w.getBiomeForCoords(pos);
/*     */     
/*  72 */     if (world.func_175624_G() != WorldType.field_77138_c && 
/*  73 */       biomes.contains(currentBiome)) {
/*     */ 
/*     */       
/*  76 */       for (Vector2f chunk : buildings.get(name)) {
/*     */         
/*  78 */         if (Math.abs(chunk.x - chunkX) + Math.abs(chunk.y - chunkZ) < minimumDistance) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/*  83 */       for (x = 0; x < bounds.func_177952_p(); x++) {
/*     */         
/*  85 */         for (z = 0; z < bounds.func_177958_n(); z++) {
/*     */           
/*  87 */           Block underground = world.func_180495_p(new BlockPos(pos.func_177958_n() + x, pos.func_177956_o() - 1, pos.func_177952_p() + z)).func_177230_c();
/*  88 */           Block floor = world.func_180495_p(new BlockPos(pos.func_177958_n() + x, pos.func_177956_o(), pos.func_177952_p() + z)).func_177230_c();
/*  89 */           Block surface = world.func_180495_p(new BlockPos(pos.func_177958_n() + x, pos.func_177956_o() + 1, pos.func_177952_p() + z)).func_177230_c();
/*     */ 
/*     */           
/*  92 */           if (underground != Blocks.field_150348_b && underground != Blocks.field_150346_d) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/*  97 */           if (floor != Blocks.field_150349_c && floor != Blocks.field_150346_d && floor != Blocks.field_150348_b) {
/*     */             return;
/*     */           }
/*     */           
/* 101 */           if (name.equals("jenny"))
/*     */           {
/* 103 */             if (surface != Blocks.field_150350_a && !(surface instanceof net.minecraft.block.BlockBush) && surface != Blocks.field_150431_aC && surface != Blocks.field_150433_aE && surface != Blocks.field_150364_r && surface != Blocks.field_150363_s) {
/*     */               return;
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       ((List<Vector2f>)buildings.get(name)).add(new Vector2f(chunkX, chunkZ));
/* 114 */       generator.func_180709_b(world, random, pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int calculateGenerationHeight(World world, int x, int z) {
/* 123 */     Set<Block> topBlocks = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.field_150349_c, (Block)Blocks.field_150354_m, Blocks.field_180395_cM });
/*     */     
/* 125 */     int y = world.func_72800_K();
/* 126 */     boolean foundGround = false;
/*     */     
/* 128 */     while (!foundGround && y-- >= 0) {
/*     */       
/* 130 */       Block block = world.func_180495_p(new BlockPos(x, y, z)).func_177230_c();
/* 131 */       foundGround = topBlocks.contains(block);
/*     */     } 
/*     */     
/* 134 */     return y;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\world\WorldGenCustomStructures.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */