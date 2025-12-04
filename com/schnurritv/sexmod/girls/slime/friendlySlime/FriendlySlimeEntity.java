/*     */ package com.schnurritv.sexmod.girls.slime.friendlySlime;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityMoveHelper;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.datafix.DataFixer;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.loot.LootTableList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FriendlySlimeEntity
/*     */   extends EntityLiving
/*     */ {
/*  40 */   public static int ticksUntilGrowth = 8400;
/*     */   
/*  42 */   public static List<FriendlySlimeEntity> slimeEntities = new ArrayList<>();
/*     */   
/*  44 */   private static final DataParameter<Integer> ageInTicks = EntityDataManager.func_187226_a(FriendlySlimeEntity.class, DataSerializers.field_187192_b);
/*  45 */   private static final DataParameter<Integer> SLIME_SIZE = EntityDataManager.func_187226_a(FriendlySlimeEntity.class, DataSerializers.field_187192_b);
/*     */   public float squishAmount;
/*     */   public float squishFactor;
/*     */   public float prevSquishFactor;
/*     */   private boolean wasOnGround;
/*     */   
/*     */   public FriendlySlimeEntity(World worldIn) {
/*  52 */     super(worldIn);
/*  53 */     this.field_70765_h = new SlimeMoveHelper(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_184651_r() {
/*  58 */     this.field_70714_bg.func_75776_a(1, new AISlimeFloat(this));
/*  59 */     this.field_70714_bg.func_75776_a(5, new AISlimeHop(this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  64 */     super.func_70088_a();
/*  65 */     this.field_70180_af.func_187214_a(SLIME_SIZE, Integer.valueOf(1));
/*  66 */     this.field_70180_af.func_187214_a(ageInTicks, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setSlimeSize(int size, boolean resetHealth) {
/*  76 */     this.field_70180_af.func_187227_b(SLIME_SIZE, Integer.valueOf(size));
/*  77 */     func_70105_a(0.51000005F * size, 0.51000005F * size);
/*  78 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  79 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((size * size));
/*  80 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((0.2F + 0.1F * size));
/*     */     
/*  82 */     if (resetHealth)
/*     */     {
/*  84 */       func_70606_j(func_110138_aP());
/*     */     }
/*     */     
/*  87 */     this.field_70728_aV = size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlimeSize() {
/*  95 */     return ((Integer)this.field_70180_af.func_187225_a(SLIME_SIZE)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerFixesSlime(DataFixer fixer) {
/* 100 */     EntityLiving.func_189752_a(fixer, FriendlySlimeEntity.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound) {
/* 108 */     super.func_70014_b(compound);
/* 109 */     compound.func_74768_a("Size", getSlimeSize() - 1);
/* 110 */     compound.func_74757_a("wasOnGround", this.wasOnGround);
/* 111 */     compound.func_74768_a("ageInTicks", ((Integer)this.field_70180_af.func_187225_a(ageInTicks)).intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound) {
/* 119 */     super.func_70037_a(compound);
/* 120 */     int i = compound.func_74762_e("Size");
/*     */     
/* 122 */     if (i < 0)
/*     */     {
/* 124 */       i = 0;
/*     */     }
/*     */     
/* 127 */     setSlimeSize(i + 1, false);
/* 128 */     this.wasOnGround = compound.func_74767_n("wasOnGround");
/* 129 */     this.field_70180_af.func_187227_b(ageInTicks, Integer.valueOf(compound.func_74762_e("ageInTicks")));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSmallSlime() {
/* 134 */     return (getSlimeSize() <= 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EnumParticleTypes getParticleType() {
/* 139 */     return EnumParticleTypes.SLIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<FriendlySlimeEntity> getSlimeByPos(Vec3d pos) {
/* 144 */     ArrayList<FriendlySlimeEntity> slimes = getByDistance(pos, 0.1D);
/*     */     
/* 146 */     if (slimes.isEmpty()) {
/* 147 */       slimes = getByDistance(pos, 0.5D);
/*     */     }
/*     */     
/* 150 */     return slimes;
/*     */   }
/*     */ 
/*     */   
/*     */   private static ArrayList<FriendlySlimeEntity> getByDistance(Vec3d pos, double distance) {
/* 155 */     ArrayList<FriendlySlimeEntity> slimes = new ArrayList<>();
/*     */     
/*     */     try {
/* 158 */       for (FriendlySlimeEntity girl : slimeEntities)
/*     */       {
/* 160 */         if (girl == null) {
/*     */           continue;
/*     */         }
/*     */         
/* 164 */         double dist = Math.abs(girl.field_70169_q - pos.field_72450_a) + Math.abs(girl.field_70167_r - pos.field_72448_b) + Math.abs(girl.field_70166_s - pos.field_72449_c);
/*     */         
/* 166 */         if (girl.field_70170_p != null && dist < distance) {
/* 167 */           slimes.add(girl);
/*     */         }
/*     */       }
/*     */     
/* 171 */     } catch (Exception e) {
/*     */       
/* 173 */       System.out.println("couldnt find slimes at distance " + distance);
/*     */     } 
/*     */     
/* 176 */     return slimes;
/*     */   }
/*     */   
/*     */   public Vec3d prevPos() {
/* 180 */     return new Vec3d(this.field_70169_q, this.field_70167_r, this.field_70166_s);
/*     */   }
/*     */   
/*     */   void spawnParticle(EnumParticleTypes particle) {
/* 184 */     double motionX = Reference.RANDOM.nextGaussian() * 0.02D;
/* 185 */     double motionY = Reference.RANDOM.nextGaussian() * 0.02D;
/* 186 */     double motionZ = Reference.RANDOM.nextGaussian() * 0.02D;
/* 187 */     this.field_70170_p.func_175688_a(particle, this.field_70165_t + (Reference.RANDOM
/*     */         
/* 189 */         .nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.15D + (Reference.RANDOM
/* 190 */         .nextFloat() * this.field_70131_O), this.field_70161_v + (Reference.RANDOM
/* 191 */         .nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, motionX, motionY, motionZ, new int[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 202 */     this.field_70180_af.func_187227_b(ageInTicks, Integer.valueOf(((Integer)this.field_70180_af.func_187225_a(ageInTicks)).intValue() + 1));
/*     */     
/* 204 */     if (this.field_70170_p.field_72995_K) {
/*     */       
/* 206 */       if (((Integer)this.field_70180_af.func_187225_a(ageInTicks)).intValue() > ticksUntilGrowth * 0.95D)
/*     */       {
/* 208 */         spawnParticle(EnumParticleTypes.CLOUD);
/*     */       }
/* 210 */       else if (((Integer)this.field_70180_af.func_187225_a(ageInTicks)).intValue() > ticksUntilGrowth * 0.7D && this.field_70173_aa % 10 == 0)
/*     */       {
/* 212 */         spawnParticle(EnumParticleTypes.VILLAGER_HAPPY);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 217 */     else if (((Integer)this.field_70180_af.func_187225_a(ageInTicks)).intValue() > ticksUntilGrowth) {
/*     */       
/* 219 */       SlimeEntity adult = new SlimeEntity(this.field_70170_p);
/* 220 */       adult.func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 221 */       this.field_70170_p.func_72838_d((Entity)adult);
/* 222 */       adult.playSoundAroundHer(SoundEvents.field_187604_bf);
/* 223 */       this.field_70170_p.func_72900_e((Entity)this);
/*     */     } 
/*     */ 
/*     */     
/* 227 */     this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
/* 228 */     this.prevSquishFactor = this.squishFactor;
/* 229 */     super.func_70071_h_();
/*     */     
/* 231 */     if (this.field_70122_E && !this.wasOnGround) {
/*     */       
/* 233 */       int i = getSlimeSize();
/* 234 */       if (spawnCustomParticles()) i = 0; 
/* 235 */       for (int j = 0; j < i * 8; j++) {
/*     */         
/* 237 */         float f = this.field_70146_Z.nextFloat() * 6.2831855F;
/* 238 */         float f1 = this.field_70146_Z.nextFloat() * 0.5F + 0.5F;
/* 239 */         float f2 = MathHelper.func_76126_a(f) * i * 0.5F * f1;
/* 240 */         float f3 = MathHelper.func_76134_b(f) * i * 0.5F * f1;
/* 241 */         World world = this.field_70170_p;
/* 242 */         EnumParticleTypes enumparticletypes = getParticleType();
/* 243 */         double d0 = this.field_70165_t + f2;
/* 244 */         double d1 = this.field_70161_v + f3;
/* 245 */         world.func_175688_a(enumparticletypes, d0, (func_174813_aQ()).field_72338_b, d1, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */       } 
/*     */       
/* 248 */       func_184185_a(getSquishSound(), func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) / 0.8F);
/* 249 */       this.squishAmount = -0.5F;
/*     */     }
/* 251 */     else if (!this.field_70122_E && this.wasOnGround) {
/*     */       
/* 253 */       this.squishAmount = 1.0F;
/*     */     } 
/*     */     
/* 256 */     this.wasOnGround = this.field_70122_E;
/* 257 */     alterSquishAmount();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void alterSquishAmount() {
/* 262 */     this.squishAmount *= 0.6F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getJumpDelay() {
/* 270 */     return this.field_70146_Z.nextInt(100) + 50;
/*     */   }
/*     */ 
/*     */   
/*     */   protected FriendlySlimeEntity createInstance() {
/* 275 */     return new FriendlySlimeEntity(this.field_70170_p);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_184206_a(DataParameter<?> key) {
/* 280 */     if (SLIME_SIZE.equals(key)) {
/*     */       
/* 282 */       int i = getSlimeSize();
/* 283 */       func_70105_a(0.51000005F * i, 0.51000005F * i);
/* 284 */       this.field_70177_z = this.field_70759_as;
/* 285 */       this.field_70761_aq = this.field_70759_as;
/*     */       
/* 287 */       if (func_70090_H() && this.field_70146_Z.nextInt(20) == 0)
/*     */       {
/* 289 */         func_71061_d_();
/*     */       }
/*     */     } 
/*     */     
/* 293 */     super.func_184206_a(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 301 */     int i = getSlimeSize();
/*     */     
/* 303 */     if (!this.field_70170_p.field_72995_K && i > 1 && func_110143_aJ() <= 0.0F) {
/*     */       
/* 305 */       int j = 2 + this.field_70146_Z.nextInt(3);
/*     */       
/* 307 */       for (int k = 0; k < j; k++) {
/*     */         
/* 309 */         float f = ((k % 2) - 0.5F) * i / 4.0F;
/* 310 */         float f1 = ((k / 2) - 0.5F) * i / 4.0F;
/* 311 */         FriendlySlimeEntity friendlySlimeEntity = createInstance();
/*     */         
/* 313 */         if (func_145818_k_())
/*     */         {
/* 315 */           friendlySlimeEntity.func_96094_a(func_95999_t());
/*     */         }
/*     */         
/* 318 */         if (func_104002_bU())
/*     */         {
/* 320 */           friendlySlimeEntity.func_110163_bv();
/*     */         }
/*     */         
/* 323 */         friendlySlimeEntity.setSlimeSize(i / 2, true);
/* 324 */         friendlySlimeEntity.func_70012_b(this.field_70165_t + f, this.field_70163_u + 0.5D, this.field_70161_v + f1, this.field_70146_Z.nextFloat() * 360.0F, 0.0F);
/* 325 */         this.field_70170_p.func_72838_d((Entity)friendlySlimeEntity);
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     super.func_70106_y();
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 334 */     return 0.625F * this.field_70131_O;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
/* 339 */     return isSmallSlime() ? SoundEvents.field_187898_fy : SoundEvents.field_187880_fp;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent func_184615_bR() {
/* 344 */     return isSmallSlime() ? SoundEvents.field_187896_fx : SoundEvents.field_187874_fm;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getSquishSound() {
/* 349 */     return isSmallSlime() ? SoundEvents.field_187900_fz : SoundEvents.field_187886_fs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 354 */     return (getSlimeSize() == 1) ? Items.field_151123_aH : null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected ResourceLocation func_184647_J() {
/* 360 */     return (getSlimeSize() == 1) ? LootTableList.field_186378_ac : LootTableList.field_186419_a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 368 */     return 0.4F * getSlimeSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70646_bf() {
/* 377 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean makesSoundOnJump() {
/* 385 */     return (getSlimeSize() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70664_aZ() {
/* 394 */     this.field_70181_x = 0.41999998688697815D;
/* 395 */     this.field_70160_al = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public IEntityLivingData func_180482_a(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
/* 405 */     setSlimeSize(1, true);
/* 406 */     return super.func_180482_a(difficulty, livingdata);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getJumpSound() {
/* 411 */     return isSmallSlime() ? SoundEvents.field_189110_fE : SoundEvents.field_187882_fq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean spawnCustomParticles() {
/* 419 */     return false;
/*     */   }
/*     */   
/*     */   static class AISlimeFaceRandom
/*     */     extends EntityAIBase
/*     */   {
/*     */     private final FriendlySlimeEntity slime;
/*     */     private float chosenDegrees;
/*     */     private int nextRandomizeTime;
/*     */     
/*     */     public AISlimeFaceRandom(FriendlySlimeEntity slimeIn) {
/* 430 */       this.slime = slimeIn;
/* 431 */       func_75248_a(2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_75250_a() {
/* 439 */       return (this.slime.func_70638_az() == null && (this.slime.field_70122_E || this.slime.func_70090_H() || this.slime.func_180799_ab() || this.slime.func_70644_a(MobEffects.field_188424_y)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75246_d() {
/* 447 */       if (--this.nextRandomizeTime <= 0) {
/*     */         
/* 449 */         this.nextRandomizeTime = 40 + this.slime.func_70681_au().nextInt(60);
/* 450 */         this.chosenDegrees = this.slime.func_70681_au().nextInt(360);
/*     */       } 
/*     */       
/* 453 */       ((FriendlySlimeEntity.SlimeMoveHelper)this.slime.func_70605_aq()).setDirection(this.chosenDegrees, false);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AISlimeFloat
/*     */     extends EntityAIBase
/*     */   {
/*     */     private final FriendlySlimeEntity slime;
/*     */     
/*     */     public AISlimeFloat(FriendlySlimeEntity slimeIn) {
/* 463 */       this.slime = slimeIn;
/* 464 */       func_75248_a(5);
/* 465 */       ((PathNavigateGround)slimeIn.func_70661_as()).func_179693_d(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_75250_a() {
/* 473 */       return (this.slime.func_70090_H() || this.slime.func_180799_ab());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75246_d() {
/* 481 */       if (this.slime.func_70681_au().nextFloat() < 0.8F)
/*     */       {
/* 483 */         this.slime.func_70683_ar().func_75660_a();
/*     */       }
/*     */       
/* 486 */       ((FriendlySlimeEntity.SlimeMoveHelper)this.slime.func_70605_aq()).setSpeed(1.2D);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AISlimeHop
/*     */     extends EntityAIBase
/*     */   {
/*     */     private final FriendlySlimeEntity slime;
/*     */     
/*     */     public AISlimeHop(FriendlySlimeEntity slimeIn) {
/* 496 */       this.slime = slimeIn;
/* 497 */       func_75248_a(5);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_75250_a() {
/* 505 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75246_d() {
/* 513 */       ((FriendlySlimeEntity.SlimeMoveHelper)this.slime.func_70605_aq()).setSpeed(1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   static class SlimeMoveHelper
/*     */     extends EntityMoveHelper
/*     */   {
/*     */     private float yRot;
/*     */     private int jumpDelay;
/*     */     private final FriendlySlimeEntity slime;
/*     */     private boolean isAggressive;
/*     */     
/*     */     public SlimeMoveHelper(FriendlySlimeEntity slimeIn) {
/* 526 */       super(slimeIn);
/* 527 */       this.slime = slimeIn;
/* 528 */       this.yRot = 180.0F * slimeIn.field_70177_z / 3.1415927F;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setDirection(float p_179920_1_, boolean p_179920_2_) {
/* 533 */       this.yRot = p_179920_1_;
/* 534 */       this.isAggressive = p_179920_2_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSpeed(double speedIn) {
/* 539 */       this.field_75645_e = speedIn;
/* 540 */       this.field_188491_h = EntityMoveHelper.Action.MOVE_TO;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_75641_c() {
/* 545 */       this.field_75648_a.field_70177_z = func_75639_a(this.field_75648_a.field_70177_z, this.yRot, 90.0F);
/* 546 */       this.field_75648_a.field_70759_as = this.field_75648_a.field_70177_z;
/* 547 */       this.field_75648_a.field_70761_aq = this.field_75648_a.field_70177_z;
/*     */       
/* 549 */       if (this.field_188491_h != EntityMoveHelper.Action.MOVE_TO) {
/*     */         
/* 551 */         this.field_75648_a.func_191989_p(0.0F);
/*     */       }
/*     */       else {
/*     */         
/* 555 */         this.field_188491_h = EntityMoveHelper.Action.WAIT;
/*     */         
/* 557 */         if (this.field_75648_a.field_70122_E) {
/*     */           
/* 559 */           this.field_75648_a.func_70659_e((float)(this.field_75645_e * this.field_75648_a.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()));
/*     */           
/* 561 */           if (this.jumpDelay-- <= 0)
/*     */           {
/* 563 */             this.jumpDelay = this.slime.getJumpDelay();
/*     */             
/* 565 */             if (this.isAggressive)
/*     */             {
/* 567 */               this.jumpDelay /= 3;
/*     */             }
/*     */             
/* 570 */             float chosenDegrees = Reference.RANDOM.nextInt(360);
/*     */             
/* 572 */             ((SlimeMoveHelper)this.slime.func_70605_aq()).setDirection(chosenDegrees, false);
/* 573 */             this.slime.func_70683_ar().func_75660_a();
/*     */             
/* 575 */             if (this.slime.makesSoundOnJump())
/*     */             {
/* 577 */               this.slime.func_184185_a(this.slime.getJumpSound(), this.slime.func_70599_aP(), ((this.slime.func_70681_au().nextFloat() - this.slime.func_70681_au().nextFloat()) * 0.2F + 1.0F) * 0.8F);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 582 */             this.slime.field_70702_br = 0.0F;
/* 583 */             this.slime.field_191988_bg = 0.0F;
/* 584 */             this.field_75648_a.func_70659_e(0.0F);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 589 */           this.field_75648_a.func_70659_e((float)(this.field_75645_e * this.field_75648_a.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()));
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\friendlySlime\FriendlySlimeEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */