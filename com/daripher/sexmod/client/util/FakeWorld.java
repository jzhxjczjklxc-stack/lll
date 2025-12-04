/*     */ package com.daripher.sexmod.client.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.profiler.Profiler;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.DimensionType;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.GameType;
/*     */ import net.minecraft.world.MinecraftException;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.biome.BiomePlains;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.chunk.storage.IChunkLoader;
/*     */ import net.minecraft.world.gen.structure.template.TemplateManager;
/*     */ import net.minecraft.world.storage.IPlayerFileData;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import net.minecraft.world.storage.WorldSavedData;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FakeWorld
/*     */   extends WorldClient
/*     */ {
/*     */   public FakeWorld() {
/*  58 */     super(new FakeNetHandlerPlayClient(Minecraft.func_71410_x()), new WorldSettings(0L, GameType.SURVIVAL, false, false, WorldType.field_77138_c), 0, EnumDifficulty.HARD, new Profiler());
/*  59 */     this.field_73011_w.func_76558_a((World)this);
/*     */   }
/*     */   
/*     */   public Biome func_180494_b(BlockPos pos) {
/*  63 */     return (Biome)new BiomePlains(false, (new Biome.BiomeProperties("Plains")).func_185398_c(0.125F).func_185400_d(0.05F).func_185400_d(0.8F).func_185395_b(0.4F));
/*     */   }
/*     */   
/*     */   public Biome getBiomeForCoordsBody(BlockPos pos) {
/*  67 */     return (Biome)new BiomePlains(false, (new Biome.BiomeProperties("Plains")).func_185398_c(0.125F).func_185400_d(0.05F).func_185400_d(0.8F).func_185395_b(0.4F));
/*     */   }
/*     */   
/*     */   protected boolean func_175680_a(int i, int i1, boolean b) {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public BlockPos func_175672_r(BlockPos pos) {
/*  75 */     return new BlockPos(pos.func_177958_n(), 63, pos.func_177952_p());
/*     */   }
/*     */   
/*     */   public boolean func_175623_d(BlockPos pos) {
/*  79 */     return (pos.func_177956_o() > 63);
/*     */   }
/*     */   
/*     */   public IBlockState func_180495_p(BlockPos pos) {
/*  83 */     return (pos.func_177956_o() > 63) ? Blocks.field_150350_a.func_176223_P() : Blocks.field_150349_c.func_176223_P();
/*     */   }
/*     */   
/*     */   public boolean func_175656_a(BlockPos pos, IBlockState state) {
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_175698_g(BlockPos pos) {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175646_b(BlockPos pos, TileEntity unusedTileEntity) {}
/*     */ 
/*     */   
/*     */   public void func_184138_a(BlockPos pos, IBlockState oldState, IBlockState newState, int flags) {}
/*     */   
/*     */   public boolean func_175655_b(BlockPos pos, boolean dropBlock) {
/* 101 */     return func_175623_d(pos);
/*     */   }
/*     */   
/*     */   public void func_175685_c(BlockPos pos, Block blockType, boolean p_175685_3_) {
/* 105 */     super.func_175685_c(pos, blockType, p_175685_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175695_a(BlockPos pos, Block blockType, EnumFacing skipSide) {}
/*     */ 
/*     */   
/*     */   public void func_175722_b(BlockPos pos, Block blockType, boolean p_175722_3_) {}
/*     */ 
/*     */   
/*     */   public void markAndNotifyBlock(BlockPos pos, Chunk chunk, IBlockState iblockstate, IBlockState newState, int flags) {}
/*     */ 
/*     */   
/*     */   public void func_72975_g(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */   
/*     */   public void func_147458_c(int p_147458_1_, int p_147458_2_, int p_147458_3_, int p_147458_4_, int p_147458_5_, int p_147458_6_) {}
/*     */   
/*     */   public boolean func_175691_a(BlockPos pos, Block blockType) {
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public int func_175671_l(BlockPos pos) {
/* 128 */     return 14;
/*     */   }
/*     */   
/*     */   public int func_175721_c(BlockPos pos, boolean checkNeighbors) {
/* 132 */     return 14;
/*     */   }
/*     */   
/*     */   public int func_175699_k(BlockPos pos) {
/* 136 */     return 14;
/*     */   }
/*     */   
/*     */   public int func_175642_b(EnumSkyBlock type, BlockPos pos) {
/* 140 */     return 14;
/*     */   }
/*     */   
/*     */   public int func_175705_a(EnumSkyBlock type, BlockPos pos) {
/* 144 */     return 14;
/*     */   }
/*     */   
/*     */   public boolean func_175710_j(BlockPos pos) {
/* 148 */     return (pos.func_177956_o() > 62);
/*     */   }
/*     */   
/*     */   public BlockPos func_175645_m(BlockPos pos) {
/* 152 */     return new BlockPos(pos.func_177958_n(), 63, pos.func_177952_p());
/*     */   }
/*     */   
/*     */   public int func_82734_g(int x, int z) {
/* 156 */     return 63;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_147456_g() {}
/*     */ 
/*     */   
/*     */   public void func_175704_b(BlockPos rangeMin, BlockPos rangeMax) {}
/*     */ 
/*     */   
/*     */   public void func_175653_a(EnumSkyBlock type, BlockPos pos, int lightValue) {}
/*     */   
/*     */   public float func_175724_o(BlockPos pos) {
/* 169 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float getSunBrightnessFactor(float p_72967_1_) {
/* 173 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_72971_b(float p_72971_1_) {
/* 178 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getSunBrightnessBody(float p_72971_1_) {
/* 183 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public boolean func_72935_r() {
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_184148_a(EntityPlayer player, double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch) {}
/*     */ 
/*     */   
/*     */   public void func_184156_a(BlockPos pos, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {}
/*     */ 
/*     */   
/*     */   public void func_184134_a(double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {}
/*     */ 
/*     */   
/*     */   public void func_175682_a(EnumParticleTypes particleType, boolean p_175682_2_, double xCoord, double yCoord, double zCoord, double xOffset, double yOffset, double zOffset, int... p_175682_15_) {}
/*     */ 
/*     */   
/*     */   public void func_175688_a(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xOffset, double yOffset, double zOffset, int... p_175688_14_) {}
/*     */ 
/*     */   
/*     */   public void func_184149_a(BlockPos blockPositionIn, SoundEvent soundEventIn) {}
/*     */   
/*     */   public RayTraceResult func_72901_a(Vec3d start, Vec3d end, boolean stopOnLiquid) {
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   public RayTraceResult func_72933_a(Vec3d start, Vec3d end) {
/* 213 */     return null;
/*     */   }
/*     */   
/*     */   public RayTraceResult func_147447_a(Vec3d vec31, Vec3d vec32, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) {
/* 217 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_72942_c(Entity par1Entity) {
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72838_d(Entity par1Entity) {
/* 225 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72923_a(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public void func_72847_b(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public void func_72900_e(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public void func_72973_f(Entity entityIn) {}
/*     */   
/*     */   public int func_72967_a(float par1) {
/* 241 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_180497_b(BlockPos pos, Block blockIn, int delay, int priority) {}
/*     */ 
/*     */   
/*     */   public void func_72939_s() {}
/*     */   
/*     */   public void func_72866_a(Entity entityIn, boolean forceUpdate) {
/* 251 */     if (forceUpdate) {
/* 252 */       entityIn.field_70173_aa++;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_72855_b(AxisAlignedBB bb) {
/* 258 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_72917_a(AxisAlignedBB bb, Entity entityIn) {
/* 262 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_72829_c(AxisAlignedBB bb) {
/* 266 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72953_d(AxisAlignedBB bb) {
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72918_a(AxisAlignedBB par1AxisAlignedBB, Material par2Material, Entity par3Entity) {
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72875_a(AxisAlignedBB par1AxisAlignedBB, Material par2Material) {
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_175625_s(BlockPos pos) {
/* 282 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_175719_a(EntityPlayer player, BlockPos pos, EnumFacing side) {
/* 286 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_72981_t() {
/* 291 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_72827_u() {
/* 296 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175690_a(BlockPos pos, TileEntity tileEntityIn) {}
/*     */ 
/*     */   
/*     */   public void func_175713_t(BlockPos pos) {}
/*     */ 
/*     */   
/*     */   public void func_147457_a(TileEntity p_147457_1_) {}
/*     */   
/*     */   public boolean func_175677_d(BlockPos pos, boolean _default) {
/* 309 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72835_b() {}
/*     */ 
/*     */   
/*     */   protected void func_72979_l() {}
/*     */ 
/*     */   
/*     */   public void updateWeatherBody() {}
/*     */   
/*     */   public boolean func_175675_v(BlockPos pos) {
/* 322 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_175662_w(BlockPos pos) {
/* 326 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_175670_e(BlockPos pos, boolean noWaterAdj) {
/* 330 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canBlockFreezeBody(BlockPos pos, boolean noWaterAdj) {
/* 334 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_175708_f(BlockPos pos, boolean checkLight) {
/* 338 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canSnowAtBody(BlockPos pos, boolean checkLight) {
/* 342 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72955_a(boolean par1) {
/* 346 */     return false;
/*     */   }
/*     */   
/*     */   public List func_72920_a(Chunk par1Chunk, boolean par2) {
/* 350 */     return null;
/*     */   }
/*     */   
/*     */   public Entity func_72857_a(Class par1Class, AxisAlignedBB par2AxisAlignedBB, Entity par3Entity) {
/* 354 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175650_b(Collection<Entity> entityCollection) {}
/*     */ 
/*     */   
/*     */   public void func_175681_c(Collection<Entity> entityCollection) {}
/*     */   
/*     */   public int func_72907_a(Class par1Class) {
/* 364 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_175676_y(BlockPos pos) {
/* 368 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_175627_a(BlockPos pos, EnumFacing direction) {
/* 372 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_175709_b(BlockPos pos, EnumFacing side) {
/* 376 */     return false;
/*     */   }
/*     */   
/*     */   public int func_175651_c(BlockPos pos, EnumFacing facing) {
/* 380 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_175640_z(BlockPos pos) {
/* 384 */     return false;
/*     */   }
/*     */   
/*     */   public int func_175687_A(BlockPos pos) {
/* 388 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72906_B() throws MinecraftException {}
/*     */   
/*     */   public long func_72905_C() {
/* 395 */     return 1L;
/*     */   }
/*     */   
/*     */   public long func_82737_E() {
/* 399 */     return 1L;
/*     */   }
/*     */   
/*     */   public long func_72820_D() {
/* 403 */     return 1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72877_b(long par1) {}
/*     */   
/*     */   public BlockPos func_175694_M() {
/* 410 */     return new BlockPos(0, 64, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_72897_h(Entity par1Entity) {}
/*     */   
/*     */   public boolean func_175678_i(BlockPos pos) {
/* 418 */     return (pos.func_177956_o() > 62);
/*     */   }
/*     */   
/*     */   public boolean canMineBlockBody(EntityPlayer player, BlockPos pos) {
/* 422 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72960_a(Entity par1Entity, byte par2) {}
/*     */   
/*     */   public float func_72819_i(float delta) {
/* 429 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175641_c(BlockPos pos, Block blockIn, int eventID, int eventParam) {}
/*     */ 
/*     */   
/*     */   public void func_72854_c() {}
/*     */   
/*     */   public boolean func_175727_C(BlockPos strikePosition) {
/* 439 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_147442_i(float p_147442_1_) {}
/*     */   
/*     */   public float func_72867_j(float par1) {
/* 447 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_72894_k(float par1) {}
/*     */   
/*     */   public boolean func_72911_I() {
/* 455 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_72896_J() {
/* 459 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_180502_D(BlockPos pos) {
/* 463 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72823_a(String dataID, WorldSavedData worldSavedDataIn) {}
/*     */ 
/*     */   
/*     */   public void func_175669_a(int p_175669_1_, BlockPos pos, int p_175669_3_) {}
/*     */ 
/*     */   
/*     */   public void func_180498_a(@Nullable EntityPlayer player, int type, BlockPos pos, int data) {}
/*     */ 
/*     */   
/*     */   public void func_175718_b(int type, BlockPos pos, int data) {}
/*     */   
/*     */   public int func_72800_K() {
/* 479 */     return 256;
/*     */   }
/*     */   
/*     */   public int func_72940_L() {
/* 483 */     return 256;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_92088_a(double par1, double par3, double par5, double par7, double par9, double par11, NBTTagCompound par13nbtTagCompound) {}
/*     */   
/*     */   public boolean func_175700_a(TileEntity tile) {
/* 491 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147448_a(Collection<TileEntity> tileEntityCollection) {}
/*     */   
/*     */   public boolean isSideSolid(BlockPos pos, EnumFacing side) {
/* 498 */     return (pos.func_177956_o() <= 63);
/*     */   }
/*     */   
/*     */   public boolean isSideSolid(BlockPos pos, EnumFacing side, boolean _default) {
/* 502 */     return (pos.func_177956_o() <= 63);
/*     */   }
/*     */   
/*     */   public int countEntities(EnumCreatureType type, boolean forSpawnCount) {
/* 506 */     return 0;
/*     */   }
/*     */   
/*     */   protected IChunkProvider func_72970_h() {
/* 510 */     return new FakeChunkProvider();
/*     */   }
/*     */   
/*     */   public Chunk func_72964_e(int par1, int par2) {
/* 514 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class FakeChunkProvider
/*     */     implements IChunkProvider
/*     */   {
/*     */     @Nullable
/*     */     public Chunk func_186026_b(int x, int z) {
/* 524 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Chunk func_186025_d(int x, int z) {
/* 529 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_73156_b() {
/* 534 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String func_73148_d() {
/* 539 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_191062_e(int x, int z) {
/* 544 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class FakeSaveHandler
/*     */     implements ISaveHandler
/*     */   {
/*     */     @Nullable
/*     */     public WorldInfo func_75757_d() {
/* 555 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75762_c() throws MinecraftException {}
/*     */ 
/*     */ 
/*     */     
/*     */     public IChunkLoader func_75763_a(WorldProvider provider) {
/* 565 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75755_a(WorldInfo worldInformation, NBTTagCompound tagCompound) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75761_a(WorldInfo worldInformation) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public IPlayerFileData func_75756_e() {
/* 580 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75759_a() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public File func_75765_b() {
/* 590 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public File func_75758_b(String mapName) {
/* 595 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public TemplateManager func_186340_h() {
/* 600 */       return new TemplateManager("", Minecraft.func_71410_x().func_184126_aj());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected static class FakeWorldProvider
/*     */     extends WorldProvider
/*     */   {
/*     */     protected void func_76572_b() {
/* 609 */       this.field_191067_f = true;
/*     */     }
/*     */     
/*     */     public DimensionType func_186058_p() {
/* 613 */       return DimensionType.OVERWORLD;
/*     */     }
/*     */     
/*     */     public boolean func_76569_d() {
/* 617 */       return true;
/*     */     }
/*     */     
/*     */     public boolean func_76567_e() {
/* 621 */       return true;
/*     */     }
/*     */     
/*     */     public int func_76557_i() {
/* 625 */       return 63;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public boolean func_76568_b(int par1, int par2) {
/* 630 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setDimension(int dim) {}
/*     */     
/*     */     public String getSaveFolder() {
/* 637 */       return null;
/*     */     }
/*     */     
/*     */     public BlockPos getRandomizedSpawnPoint() {
/* 641 */       return new BlockPos(0, 64, 0);
/*     */     }
/*     */     
/*     */     public boolean shouldMapSpin(String entity, double x, double y, double z) {
/* 645 */       return false;
/*     */     }
/*     */     
/*     */     public int getRespawnDimension(EntityPlayerMP player) {
/* 649 */       return 0;
/*     */     }
/*     */     
/*     */     public Biome getBiomeForCoords(BlockPos pos) {
/* 653 */       return (Biome)new BiomePlains(false, (new Biome.BiomeProperties("Plains")).func_185398_c(0.125F).func_185400_d(0.05F).func_185400_d(0.8F).func_185395_b(0.4F));
/*     */     }
/*     */     
/*     */     public boolean isDaytime() {
/* 657 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {}
/*     */ 
/*     */     
/*     */     public void calculateInitialWeather() {}
/*     */ 
/*     */     
/*     */     public void updateWeather() {}
/*     */     
/*     */     public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
/* 670 */       return false;
/*     */     }
/*     */     
/*     */     public boolean canSnowAt(BlockPos pos, boolean checkLight) {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public long getSeed() {
/* 678 */       return 1L;
/*     */     }
/*     */     
/*     */     public long getWorldTime() {
/* 682 */       return 1L;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setWorldTime(long time) {}
/*     */     
/*     */     public boolean canMineBlock(EntityPlayer player, BlockPos pos) {
/* 689 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isBlockHighHumidity(BlockPos pos) {
/* 693 */       return false;
/*     */     }
/*     */     
/*     */     public int getHeight() {
/* 697 */       return 256;
/*     */     }
/*     */     
/*     */     public int getActualHeight() {
/* 701 */       return 256;
/*     */     }
/*     */ 
/*     */     
/*     */     public void resetRainAndThunder() {}
/*     */     
/*     */     public boolean canDoLightning(Chunk chunk) {
/* 708 */       return false;
/*     */     }
/*     */     
/*     */     public boolean canDoRainSnowIce(Chunk chunk) {
/* 712 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public DimensionType func_186058_p() {
/* 717 */       return null;
/*     */     }
/*     */     
/*     */     public BlockPos getSpawnPoint() {
/* 721 */       return new BlockPos(0, 64, 0);
/*     */     }
/*     */     
/*     */     public boolean func_76566_a(int par1, int par2) {
/* 725 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakeWorld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */