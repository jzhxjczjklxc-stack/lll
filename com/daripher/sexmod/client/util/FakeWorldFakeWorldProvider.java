/*     */ package com.daripher.sexmod.client.util;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.DimensionType;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.biome.BiomePlains;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ public class FakeWorldFakeWorldProvider
/*     */   extends WorldProvider
/*     */ {
/*     */   public DimensionType func_186058_p() {
/*  19 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_76572_b() {
/*  26 */     this.field_191067_f = true;
/*     */   }
/*     */   
/*     */   public DimensionType func_186058_p() {
/*  30 */     return DimensionType.OVERWORLD;
/*     */   }
/*     */   
/*     */   public boolean func_76569_d() {
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_76567_e() {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public int func_76557_i() {
/*  42 */     return 63;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76568_b(int par1, int par2) {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDimension(int dim) {}
/*     */   
/*     */   public String getSaveFolder() {
/*  54 */     return null;
/*     */   }
/*     */   
/*     */   public BlockPos getRandomizedSpawnPoint() {
/*  58 */     return new BlockPos(0, 64, 0);
/*     */   }
/*     */   
/*     */   public boolean shouldMapSpin(String entity, double x, double y, double z) {
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   public int getRespawnDimension(EntityPlayerMP player) {
/*  66 */     return 0;
/*     */   }
/*     */   
/*     */   public Biome getBiomeForCoords(BlockPos pos) {
/*  70 */     return (Biome)new BiomePlains(false, (new Biome.BiomeProperties("Plains")).func_185398_c(0.125F).func_185400_d(0.05F).func_185400_d(0.8F).func_185400_d(0.4F));
/*     */   }
/*     */   
/*     */   public boolean isDaytime() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {}
/*     */ 
/*     */   
/*     */   public void calculateInitialWeather() {}
/*     */ 
/*     */   
/*     */   public void updateWeather() {}
/*     */   
/*     */   public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canSnowAt(BlockPos pos, boolean checkLight) {
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public long getSeed() {
/*  95 */     return 1L;
/*     */   }
/*     */   
/*     */   public long getWorldTime() {
/*  99 */     return 1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorldTime(long time) {}
/*     */   
/*     */   public boolean canMineBlock(EntityPlayer player, BlockPos pos) {
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isBlockHighHumidity(BlockPos pos) {
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 114 */     return 256;
/*     */   }
/*     */   
/*     */   public int getActualHeight() {
/* 118 */     return 256;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetRainAndThunder() {}
/*     */   
/*     */   public boolean canDoLightning(Chunk chunk) {
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canDoRainSnowIce(Chunk chunk) {
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public BlockPos getSpawnPoint() {
/* 133 */     return new BlockPos(0, 64, 0);
/*     */   }
/*     */   
/*     */   public boolean func_76566_a(int par1, int par2) {
/* 137 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakeWorldFakeWorldProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */