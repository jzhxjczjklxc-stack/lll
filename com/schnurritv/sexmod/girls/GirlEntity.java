/*     */ package com.schnurritv.sexmod.girls;
/*     */ import com.schnurritv.sexmod.Packets.OpenGirlInventory;
/*     */ import com.schnurritv.sexmod.Packets.PrepareAction;
/*     */ import com.schnurritv.sexmod.Packets.ResetGirl;
/*     */ import com.schnurritv.sexmod.Packets.SendChatMessage;
/*     */ import com.schnurritv.sexmod.Packets.SendCompanionHome;
/*     */ import com.schnurritv.sexmod.Packets.SetNewHome;
/*     */ import com.schnurritv.sexmod.Packets.TeleportPlayer;
/*     */ import com.schnurritv.sexmod.companion.Companion;
/*     */ import com.schnurritv.sexmod.companion.LookAtNearbyEntity;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.ItemStackHandler;
/*     */ import software.bernie.geckolib3.core.IAnimatable;
/*     */ import software.bernie.geckolib3.core.controller.AnimationController;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.manager.AnimationData;
/*     */ import software.bernie.geckolib3.core.manager.AnimationFactory;
/*     */ 
/*     */ public abstract class GirlEntity extends EntityCreature implements IAnimatable {
/*  60 */   private final AnimationFactory factory = new AnimationFactory(this);
/*     */   public EntityAIWanderAvoidWater aiWander;
/*     */   public LookAtNearbyEntity aiLookAtPlayer;
/*  63 */   public static ArrayList<GirlEntity> girlEntities = new ArrayList<>();
/*  64 */   protected String girlName = "girl";
/*     */   
/*     */   public boolean shouldBeAtTargetYaw = false;
/*     */   public Vec3d playerCamPos;
/*     */   protected float playerYaw;
/*     */   protected EntityDataManager field_70180_af;
/*     */   protected PathNavigate field_70699_by;
/*  71 */   public int nextAttack = 1;
/*     */   
/*     */   public int slashSwordRot;
/*     */   public int stabSwordRot;
/*     */   public int holdBowRot;
/*     */   public Vec3d swordOffsetStab;
/*     */   public boolean downed;
/*  78 */   public Vec3d home = Vec3d.field_186680_a;
/*     */   
/*     */   public EntityEnderPearl pearl;
/*     */   
/*     */   public boolean playerIsThrusting = false;
/*     */   public boolean playerIsCumming = false;
/*  84 */   public ItemStackHandler inventory = new ItemStackHandler(6);
/*     */   
/*  86 */   public static final DataParameter<Boolean> SHOULD_BE_AT_TARGET = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187198_h).func_187156_b().func_187161_a(72);
/*  87 */   public static final DataParameter<String> TARGET_POS = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(71);
/*  88 */   public static final DataParameter<Float> TARGET_YAW = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187193_c).func_187156_b().func_187161_a(70);
/*  89 */   public static final DataParameter<String> GIRL_ID = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(69);
/*  90 */   public static final DataParameter<Integer> CURRENT_MODEL = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187192_b).func_187156_b().func_187161_a(68);
/*  91 */   public static final DataParameter<String> CURRENT_ACTION = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(67);
/*  92 */   public static final DataParameter<String> ANIMATION_FOLLOW_UP = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(66);
/*  93 */   public static final DataParameter<String> PLAYER_SHE_HAS_SEX_WITH = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(65);
/*  94 */   public static final DataParameter<String> WALK_SPEED = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(64);
/*  95 */   public static final DataParameter<Integer> ATTACK_MODE = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187192_b).func_187156_b().func_187161_a(63);
/*  96 */   public static final DataParameter<String> MASTER = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(62);
/*     */ 
/*     */   
/*  99 */   public static final DataParameter<ItemStack> WEAPON = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(61);
/* 100 */   public static final DataParameter<ItemStack> BOW = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(60);
/* 101 */   public static final DataParameter<ItemStack> HELMET = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(59);
/* 102 */   public static final DataParameter<ItemStack> CHEST_PLATE = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(58);
/* 103 */   public static final DataParameter<ItemStack> PANTS = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(57);
/* 104 */   public static final DataParameter<ItemStack> SHOES = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(56);
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void changeDataParameterFromClient(String parameter, String value) {
/* 109 */     PacketHandler.INSTANCE.sendToServer((IMessage)new ChangeDataParameter(girlId(), parameter, value));
/*     */   }
/*     */   
/* 112 */   public UUID girlId() { return UUID.fromString((String)this.field_70180_af.func_187225_a(GIRL_ID)); } public Action currentAction() {
/* 113 */     return Action.valueOf((String)this.field_70180_af.func_187225_a(CURRENT_ACTION));
/*     */   }
/*     */   public void setCurrentAction(Action newAction) {
/* 116 */     newAction = (newAction == null) ? Action.NULL : newAction;
/*     */     
/* 118 */     if (this.field_70170_p.field_72995_K) {
/* 119 */       changeDataParameterFromClient("currentAction", newAction.toString());
/*     */     }
/* 121 */     this.field_70180_af.func_187227_b(CURRENT_ACTION, newAction.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public UUID playerSheHasSexWith() {
/* 126 */     String uuidString = (String)this.field_70180_af.func_187225_a(PLAYER_SHE_HAS_SEX_WITH);
/*     */     
/* 128 */     if (uuidString.equals("null")) {
/* 129 */       return null;
/*     */     }
/* 131 */     return UUID.fromString(uuidString);
/*     */   }
/*     */   public void setPlayer(UUID player) {
/* 134 */     if (player == null) {
/* 135 */       this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, "null");
/*     */     } else {
/*     */       
/* 138 */       this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, player.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public Vec3d targetPos() {
/* 143 */     String[] pos = ((String)this.field_70180_af.func_187225_a(TARGET_POS)).split("\\|");
/*     */     
/* 145 */     return new Vec3d(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
/*     */   }
/*     */   
/*     */   public void setTargetPos(Vec3d pos) {
/* 149 */     this.field_70180_af.func_187227_b(TARGET_POS, pos.field_72450_a + "|" + pos.field_72448_b + "|" + pos.field_72449_c);
/*     */   }
/*     */   
/*     */   public Float targetYaw() {
/* 153 */     return (Float)this.field_70180_af.func_187225_a(TARGET_YAW);
/*     */   }
/*     */   public void setTargetYaw(float yaw) {
/* 156 */     this.field_70180_af.func_187227_b(TARGET_YAW, Float.valueOf(yaw));
/*     */   }
/* 158 */   public void setWalkSpeed(WalkSpeed walkSpeed) { this.field_70180_af.func_187227_b(WALK_SPEED, walkSpeed.toString()); } public WalkSpeed getWalkSpeed() {
/* 159 */     return WalkSpeed.valueOf((String)this.field_70180_af.func_187225_a(WALK_SPEED));
/*     */   }
/*     */   
/*     */   public enum PaymentItems {
/* 163 */     DIAMOND,
/* 164 */     GOLD,
/* 165 */     EMERALD;
/*     */   }
/*     */   
/* 168 */   private static final List<Item> TEMPTATION_ITEMS = Arrays.asList(new Item[] { Items.field_151166_bC, Items.field_151045_i, Items.field_151043_k, Items.field_151079_bi });
/*     */   
/*     */   public AnimationController actionController;
/*     */   
/*     */   public AnimationController movementController;
/*     */   
/*     */   public AnimationController eyesController;
/*     */   
/*     */   public String currentAnimationPath;
/*     */   
/*     */   public boolean currentAnimationLoop;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   void setUpControllers() {
/* 182 */     this.actionController = new AnimationController(this, "action", 0.0F, this::predicate);
/* 183 */     this.movementController = new AnimationController(this, "movement", 5.0F, this::predicate);
/* 184 */     this.eyesController = new AnimationController(this, "eyes", 10.0F, this::predicate);
/*     */   }
/*     */   
/*     */   public enum Action
/*     */   {
/* 189 */     NULL(0, false, true),
/* 190 */     STARTBLOWJOB(2, true, false),
/* 191 */     SUCKBLOWJOB(2, true, false),
/* 192 */     CUMBLOWJOB(0, true, false),
/* 193 */     THRUSTBLOWJOB(2, true, false),
/* 194 */     PAYMENT(5, true, false),
/* 195 */     STARTDOGGY(2, false, false),
/* 196 */     WAITDOGGY(0, false, true),
/* 197 */     DOGGYSTART(0, true, false),
/* 198 */     DOGGYSLOW(2, true, false),
/* 199 */     DOGGYFAST(2, true, false),
/* 200 */     DOGGYCUM(2, true, false),
/* 201 */     STRIP(5, false, false),
/* 202 */     DASH(2, false, false),
/* 203 */     HUG(2, true, false),
/* 204 */     HUGIDLE(0, true, true),
/* 205 */     HUGSELECTED(0, true, false),
/* 206 */     UNDRESS(2, false, true),
/* 207 */     DRESS(2, false, true),
/* 208 */     SITDOWN(2, false, false),
/* 209 */     SITDOWNIDLE(0, false, true),
/* 210 */     COWGIRLSTART(0, true, false),
/* 211 */     COWGIRLSLOW(10, true, false),
/* 212 */     COWGIRLFAST(10, true, false),
/* 213 */     COWGIRLCUM(2, true, false),
/* 214 */     ATTACK(0, false, true),
/* 215 */     BOW(2, false, true),
/* 216 */     RIDE(0, false, true),
/* 217 */     SIT(0, false, true),
/* 218 */     THROW_PEARL(0, false, false),
/* 219 */     DOWNED(7, false, true),
/* 220 */     PAIZURI_START(0, true, false),
/* 221 */     PAIZURI_SLOW(0, true, true),
/* 222 */     PAIZURI_FAST(0, true, false),
/* 223 */     PAIZURI_CUM(0, true, false),
/* 224 */     MISSIONARY_START(0, true, false),
/* 225 */     MISSIONARY_SLOW(2, true, false),
/* 226 */     MISSIONARY_FAST(2, true, false),
/* 227 */     MISSIONARY_CUM(2, true, false),
/* 228 */     TALK_HORNY(5, true, false),
/* 229 */     TALK_IDLE(0, true, true),
/* 230 */     TALK_RESPONSE(2, true, false),
/* 231 */     ANAL_PREPARE(5, false, false),
/* 232 */     ANAL_WAIT(0, false, true),
/* 233 */     ANAL_START(2, true, false),
/* 234 */     ANAL_SLOW(2, true, true),
/* 235 */     ANAL_FAST(2, true, false),
/* 236 */     ANAL_CUM(2, true, false),
/* 237 */     SUMMON(0, false, false),
/* 238 */     SUMMON_WAIT(0, false, true),
/* 239 */     HEAD_PAT(0, true, false),
/* 240 */     DEEPTHROAT_PREPARE(0, false, false),
/* 241 */     DEEPTHROAT_START(0, true, false),
/* 242 */     DEEPTHROAT_SLOW(2, true, false),
/* 243 */     DEEPTHROAT_FAST(2, true, false),
/* 244 */     DEEPTHROAT_CUM(2, true, false),
/* 245 */     SUMMON_NORMAL(0, false, false),
/* 246 */     SUMMON_NORMAL_WAIT(2, false, true),
/* 247 */     DEEPTHROAT_NORMAL_PREPARE(2, false, false);
/*     */     
/*     */     public int transitionTick;
/*     */     public boolean hasPlayer;
/*     */     public boolean autoBlink;
/*     */     
/*     */     Action(int transitionTick, boolean hasPlayer, boolean autoBlink) {
/* 254 */       this.transitionTick = transitionTick;
/* 255 */       this.hasPlayer = hasPlayer;
/* 256 */       this.autoBlink = autoBlink;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum WalkSpeed
/*     */   {
/* 262 */     WALK,
/* 263 */     FAST_WALK,
/* 264 */     RUN;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 269 */     return false;
/*     */   }
/*     */   
/*     */   public abstract boolean canCloseUiWithoutHavingChosen();
/*     */   
/*     */   protected GirlEntity(World worldIn) {
/* 275 */     super(worldIn);
/*     */     
/* 277 */     if (!worldIn.field_72995_K || !(worldIn instanceof com.daripher.sexmod.client.util.FakeWorld)) {
/* 278 */       girlEntities.add(this);
/* 279 */       ((PathNavigateGround)func_70661_as()).func_179688_b(true);
/* 280 */       this.inventory.setStackInSlot(0, new ItemStack(Items.field_151040_l));
/* 281 */       this.inventory.setStackInSlot(1, new ItemStack((Item)Items.field_151031_f));
/*     */     } 
/*     */ 
/*     */     
/* 285 */     if (worldIn.field_72995_K) {
/* 286 */       setUpControllers();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 292 */     super.func_70088_a();
/*     */     
/* 294 */     this.field_70699_by = func_70661_as();
/* 295 */     this.field_70180_af = func_184212_Q();
/*     */     
/* 297 */     if (!this.field_70170_p.field_72995_K || !(this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)) {
/*     */       
/* 299 */       this.field_70180_af.func_187214_a(GIRL_ID, UUID.randomUUID().toString());
/* 300 */       this.field_70180_af.func_187214_a(CURRENT_MODEL, Integer.valueOf(1));
/* 301 */       this.field_70180_af.func_187214_a(CURRENT_ACTION, Action.NULL.toString());
/* 302 */       this.field_70180_af.func_187214_a(ANIMATION_FOLLOW_UP, "");
/* 303 */       this.field_70180_af.func_187214_a(PLAYER_SHE_HAS_SEX_WITH, "null");
/* 304 */       this.field_70180_af.func_187214_a(SHOULD_BE_AT_TARGET, Boolean.valueOf(false));
/* 305 */       this.field_70180_af.func_187214_a(TARGET_YAW, Float.valueOf(0.0F));
/* 306 */       this.field_70180_af.func_187214_a(TARGET_POS, "0|0|0");
/* 307 */       this.field_70180_af.func_187214_a(WALK_SPEED, WalkSpeed.WALK.toString());
/* 308 */       this.field_70180_af.func_187214_a(ATTACK_MODE, Integer.valueOf(0));
/* 309 */       this.field_70180_af.func_187214_a(MASTER, "");
/* 310 */       this.field_70180_af.func_187214_a(WEAPON, ItemStack.field_190927_a);
/* 311 */       this.field_70180_af.func_187214_a(BOW, ItemStack.field_190927_a);
/* 312 */       this.field_70180_af.func_187214_a(HELMET, ItemStack.field_190927_a);
/* 313 */       this.field_70180_af.func_187214_a(CHEST_PLATE, ItemStack.field_190927_a);
/* 314 */       this.field_70180_af.func_187214_a(PANTS, ItemStack.field_190927_a);
/* 315 */       this.field_70180_af.func_187214_a(SHOES, ItemStack.field_190927_a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 323 */     super.func_110147_ax();
/* 324 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/* 325 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/* 326 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(30.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_184651_r() {
/* 332 */     Reference.server = func_184102_h();
/*     */     
/* 334 */     this.aiWander = new EntityAIWanderAvoidWater(this, 0.35D);
/* 335 */     this.aiLookAtPlayer = new LookAtNearbyEntity((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F);
/*     */     
/* 337 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/* 338 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new Companion(this));
/* 339 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt(this, 0.4D, false, new HashSet<>(TEMPTATION_ITEMS)));
/* 340 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new OpenAndCloseDoorBehindHer((EntityLiving)this));
/* 341 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)this.aiLookAtPlayer);
/* 342 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)this.aiWander);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70619_bc() {
/* 348 */     if (((Boolean)this.field_70180_af.func_187225_a(SHOULD_BE_AT_TARGET)).booleanValue()) {
/*     */       
/* 350 */       func_70034_d(targetYaw().floatValue());
/* 351 */       func_70080_a((targetPos()).field_72450_a, (targetPos()).field_72448_b, (targetPos()).field_72449_c, targetYaw().floatValue(), 0.0F);
/* 352 */       func_70101_b(targetYaw().floatValue(), this.field_70125_A);
/*     */     }
/* 354 */     else if (this.shouldBeAtTargetYaw) {
/* 355 */       func_70034_d(targetYaw().floatValue());
/* 356 */       func_70101_b(targetYaw().floatValue(), this.field_70125_A);
/*     */     } 
/*     */     
/* 359 */     if (this.home.equals(Vec3d.field_186680_a)) {
/* 360 */       this.home = new Vec3d((Vec3i)func_180425_c());
/*     */     }
/* 362 */     if (this.field_70173_aa % 80 == 0 && func_110143_aJ() != func_110138_aP())
/*     */     {
/* 364 */       if (((String)this.field_70180_af.func_187225_a(MASTER)).equals("")) {
/* 365 */         func_70691_i(1.0F);
/*     */       }
/*     */       else {
/*     */         
/* 369 */         List<EntityMob> mobs = this.field_70170_p.func_72872_a(EntityMob.class, new AxisAlignedBB(new BlockPos(this.field_70165_t - 7.0D, this.field_70163_u - 1.0D, this.field_70161_v - 7.0D), new BlockPos(this.field_70165_t + 7.0D, this.field_70163_u + 1.0D, this.field_70161_v + 7.0D)));
/*     */         
/* 371 */         int healAmount = mobs.isEmpty() ? 4 : 1;
/*     */         
/* 373 */         func_70691_i(healAmount);
/* 374 */         ((WorldServer)this.field_70170_p).func_180505_a(EnumParticleTypes.HEART, false, this.field_70165_t, this.field_70163_u + 1.0D + Reference.RANDOM.nextDouble(), this.field_70161_v, healAmount, 1.0D, 1.0D, 1.0D, Reference.RANDOM.nextGaussian(), new int[0]);
/*     */       } 
/*     */     }
/*     */     
/* 378 */     if (this.downed && ((String)this.field_70180_af.func_187225_a(MASTER)).equals("")) {
/* 379 */       this.downed = false;
/*     */     }
/* 381 */     this.field_70180_af.func_187227_b(field_184621_as, Byte.valueOf("1"));
/*     */     
/* 383 */     this.field_70180_af.func_187227_b(WEAPON, this.inventory.getStackInSlot(0));
/* 384 */     this.field_70180_af.func_187227_b(BOW, this.inventory.getStackInSlot(1));
/* 385 */     this.field_70180_af.func_187227_b(HELMET, this.inventory.getStackInSlot(2));
/* 386 */     this.field_70180_af.func_187227_b(CHEST_PLATE, this.inventory.getStackInSlot(3));
/* 387 */     this.field_70180_af.func_187227_b(PANTS, this.inventory.getStackInSlot(4));
/* 388 */     this.field_70180_af.func_187227_b(SHOES, this.inventory.getStackInSlot(5));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public abstract boolean openMenu(EntityPlayer paramEntityPlayer);
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected static void renderMenu(EntityPlayer player, GirlEntity girl, String[] animation, int[] cost, Item[] item) {
/* 397 */     Minecraft.func_71410_x().func_147108_a((GuiScreen)new MenuUI(player, girl, animation, cost, item));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setActiveItemStack(ItemStack stack) {
/* 402 */     this.field_184627_bm = stack;
/*     */   }
/*     */   
/*     */   public void setActiveStackUse(int use) {
/* 406 */     this.field_184628_bn = use;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3d prevPos() {
/* 411 */     return new Vec3d(this.field_70169_q, this.field_70167_r, this.field_70166_s);
/*     */   }
/*     */   
/*     */   protected static Vec3d prevPos(GirlEntity entity) {
/* 415 */     return new Vec3d(entity.field_70169_q, entity.field_70167_r, entity.field_70166_s);
/*     */   }
/*     */   
/*     */   public GirlEntity getGirl() {
/* 419 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void TurnPlayerIntoCamera(EntityPlayerMP player, boolean autoMoveCamera) {
/* 433 */     player.field_70159_w = 0.0D;
/* 434 */     player.field_70181_x = 0.0D;
/* 435 */     player.field_70179_y = 0.0D;
/*     */     
/* 437 */     if (autoMoveCamera) {
/* 438 */       Vec3d forward = getInFrontOfPlayer(0.35D);
/* 439 */       player.func_70634_a(forward.field_72450_a, forward.field_72448_b, forward.field_72449_c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void TurnPlayerIntoCamera(UUID playerID) {
/* 445 */     EntityPlayer player = this.field_70170_p.func_152378_a(playerID);
/*     */     
/* 447 */     player.field_70159_w = 0.0D;
/* 448 */     player.field_70181_x = 0.0D;
/* 449 */     player.field_70179_y = 0.0D;
/*     */     
/* 451 */     Vec3d forward = getInFrontOfPlayer(0.35D);
/* 452 */     player.func_70634_a(forward.field_72450_a, forward.field_72448_b, forward.field_72449_c);
/* 453 */     setTargetYaw(player.field_70759_as + 180.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void prepareAction(boolean shouldPreparePayment, boolean shoudSetTargetPos) {
/* 459 */     if (this.field_70170_p.field_72995_K) {
/* 460 */       PacketHandler.INSTANCE.sendToServer((IMessage)new PrepareAction(girlId(), playerSheHasSexWith(), shouldPreparePayment, shoudSetTargetPos));
/*     */     } else {
/*     */       
/* 463 */       PrepareAction.Handler.prepareAction(girlId(), playerSheHasSexWith(), shouldPreparePayment, shoudSetTargetPos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<GirlEntity> getGirlsByUUID(UUID uuid) {
/* 470 */     ArrayList<GirlEntity> girls = new ArrayList<>();
/*     */     
/* 472 */     for (GirlEntity girl : girlEntities) {
/*     */       
/* 474 */       if (girl.girlId().equals(uuid)) {
/* 475 */         girls.add(girl);
/*     */       }
/*     */     } 
/*     */     
/* 479 */     return girls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockPos findBed(BlockPos pos) {
/* 490 */     return findBed(pos, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockPos findBed(BlockPos pos, int whichBed) {
/* 495 */     int step = 1;
/* 496 */     int dir = -1;
/* 497 */     BlockPos searchPos = pos;
/* 498 */     int bedsFound = 0;
/*     */ 
/*     */     
/* 501 */     while (step < 22) {
/*     */       
/* 503 */       for (int move = 0; move < 2; move++) {
/*     */         
/* 505 */         dir *= -1;
/*     */         int stepTaken;
/* 507 */         for (stepTaken = 0; stepTaken < step; stepTaken++) {
/* 508 */           searchPos = searchPos.func_177982_a(0, 0, dir);
/*     */           
/* 510 */           for (int y = -3; y < 4; y++) {
/*     */             
/* 512 */             if (this.field_70170_p.func_180495_p(searchPos.func_177982_a(0, y, dir)).func_177230_c() == Blocks.field_150324_C)
/*     */             {
/* 514 */               if (++bedsFound == whichBed) {
/* 515 */                 return searchPos.func_177982_a(0, y, dir);
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 521 */         for (stepTaken = 0; stepTaken < step; stepTaken++) {
/* 522 */           searchPos = searchPos.func_177982_a(dir, 0, 0);
/*     */           
/* 524 */           for (int y = -3; y < 4; y++) {
/*     */             
/* 526 */             if (this.field_70170_p.func_180495_p(searchPos.func_177982_a(dir, y, 0)).func_177230_c() == Blocks.field_150324_C)
/*     */             {
/* 528 */               if (++bedsFound == whichBed) {
/* 529 */                 return searchPos.func_177982_a(dir, y, 0);
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 535 */         step++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 540 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_184647_J() {
/* 546 */     return LootTableHandler.JENNY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopCompanionShip() {
/* 551 */     if (this.field_70170_p.field_72995_K) {
/* 552 */       changeDataParameterFromClient("master", "");
/* 553 */       changeDataParameterFromClient("walk speed", WalkSpeed.WALK.toString());
/*     */     } else {
/*     */       
/* 556 */       this.field_70180_af.func_187227_b(MASTER, "");
/* 557 */       this.field_70180_af.func_187227_b(WALK_SPEED, WalkSpeed.WALK.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void doAction(String actionName, UUID player) {
/*     */     EntityPlayerSP entityPlayerSP;
/* 564 */     switch (actionName) {
/*     */       
/*     */       case "companion Follow me":
/* 567 */         changeDataParameterFromClient("master", player.toString());
/*     */         break;
/*     */       
/*     */       case "companion Stop following me":
/* 571 */         stopCompanionShip();
/*     */         break;
/*     */ 
/*     */       
/*     */       case "companion Equipment":
/* 576 */         entityPlayerSP = (Minecraft.func_71410_x()).field_71439_g;
/* 577 */         PacketHandler.INSTANCE.sendToServer((IMessage)new OpenGirlInventory(girlId(), entityPlayerSP.getPersistentID()));
/*     */         break;
/*     */ 
/*     */       
/*     */       case "companion Go home":
/* 582 */         PacketHandler.INSTANCE.sendToServer((IMessage)new SendCompanionHome(girlId()));
/*     */         break;
/*     */ 
/*     */       
/*     */       case "companion Set new home":
/* 587 */         PacketHandler.INSTANCE.sendToServer((IMessage)new SetNewHome(girlId(), new Vec3d((Vec3i)func_180425_c())));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected abstract <E extends IAnimatable> PlayState predicate(AnimationEvent<E> paramAnimationEvent);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void createAnimation(String path, boolean looped, AnimationEvent event) {
/* 605 */     event.getController().setAnimation((new AnimationBuilder()).addAnimation(path, Boolean.valueOf(looped)));
/* 606 */     this.currentAnimationLoop = looped;
/* 607 */     this.currentAnimationPath = path;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerControllers(AnimationData data) {
/* 614 */     data.addAnimationController(this.movementController);
/* 615 */     data.addAnimationController(this.eyesController);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void resetPlayer() {
/* 620 */     if (this.field_70170_p.field_72995_K && belongsToPlayer()) {
/*     */       
/* 622 */       this.playerCamPos = null;
/* 623 */       PacketHandler.INSTANCE.sendToServer((IMessage)new ResetGirl(girlId(), true));
/*     */     }
/* 625 */     else if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 627 */       ResetGirl.Handler.resetPlayer((EntityPlayerMP)this.field_70170_p.func_152378_a(playerSheHasSexWith()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetGirl() {
/* 634 */     this.playerCamPos = null;
/* 635 */     this.playerIsThrusting = false;
/* 636 */     this.playerIsCumming = false;
/* 637 */     func_189654_d(false);
/* 638 */     setCurrentAction((Action)null);
/*     */     
/* 640 */     if (this.field_70170_p.field_72995_K) {
/* 641 */       clientReset();
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetNavigator() {
/* 646 */     this.field_70699_by = func_175447_b(this.field_70170_p);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   void clientReset() {
/* 651 */     if (belongsToPlayer()) {
/*     */       
/* 653 */       HandlePlayerMovement.setActive(true);
/* 654 */       (Minecraft.func_71410_x()).field_71439_g.func_82142_c(false);
/*     */       
/* 656 */       PacketHandler.INSTANCE.sendToServer((IMessage)new ResetGirl(girlId()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void sendThrust(UUID playerUUID) {
/* 664 */     for (GirlEntity girl : girlEntities) {
/* 665 */       if (girl.belongsToPlayer() && 
/* 666 */         girl.playerSheHasSexWith().equals(playerUUID))
/*     */       {
/* 668 */         if (!girl.playerIsThrusting) {
/* 669 */           girl.thrust();
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void sendCum(UUID playerUUID) {
/* 680 */     for (GirlEntity girl : girlEntities) {
/* 681 */       if (girl.belongsToPlayer() && 
/* 682 */         girl.playerSheHasSexWith().equals(playerUUID))
/*     */       {
/* 684 */         if (!girl.playerIsCumming) {
/* 685 */           girl.cum();
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected abstract void thrust();
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected abstract void cum();
/*     */   
/*     */   public NetworkRegistry.TargetPoint getTargetPoint() {
/* 700 */     return new NetworkRegistry.TargetPoint(this.field_71093_bK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void moveCamera(double x, double y, double z, float yaw, float pitch) {
/* 715 */     if (playerSheHasSexWith() == null) {
/* 716 */       System.out.println("couldnt move camera because the player isn't set");
/*     */       
/*     */       return;
/*     */     } 
/* 720 */     EntityPlayer player = this.field_70170_p.func_152378_a(playerSheHasSexWith());
/*     */ 
/*     */     
/* 723 */     if (this.playerCamPos == null)
/*     */     {
/* 725 */       this.playerCamPos = player.func_174791_d();
/*     */     }
/*     */     
/* 728 */     Vec3d newPos = this.playerCamPos;
/*     */ 
/*     */     
/* 731 */     newPos = newPos.func_72441_c(-Math.sin((this.playerYaw + 90.0F) * 0.017453292519943295D) * x, 0.0D, Math.cos((this.playerYaw + 90.0F) * 0.017453292519943295D) * x);
/*     */ 
/*     */     
/* 734 */     newPos = newPos.func_72441_c(0.0D, y, 0.0D);
/*     */ 
/*     */     
/* 737 */     newPos = newPos.func_72441_c(-Math.sin(this.playerYaw * 0.017453292519943295D) * z, 0.0D, Math.cos(this.playerYaw * 0.017453292519943295D) * z);
/*     */     
/* 739 */     if (this.field_70170_p.field_72995_K) {
/* 740 */       PacketHandler.INSTANCE.sendToServer((IMessage)new TeleportPlayer(player.getPersistentID().toString(), newPos, this.playerYaw + yaw, pitch));
/*     */     }
/*     */     else {
/*     */       
/* 744 */       player.func_70080_a(newPos.field_72450_a, newPos.field_72448_b, newPos.field_72449_c, this.playerYaw + yaw, pitch);
/* 745 */       player.func_70634_a(newPos.field_72450_a, newPos.field_72448_b, newPos.field_72449_c);
/* 746 */       this.field_70159_w = 0.0D;
/* 747 */       this.field_70181_x = 0.0D;
/* 748 */       this.field_70179_y = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected boolean belongsToPlayer() {
/* 756 */     if (this.field_70170_p.field_72995_K) {
/*     */       
/* 758 */       EntityPlayerSP entityPlayerSP = (Minecraft.func_71410_x()).field_71439_g;
/* 759 */       return (entityPlayerSP.getPersistentID().equals(playerSheHasSexWith()) || entityPlayerSP.func_110124_au().equals(playerSheHasSexWith()));
/*     */     } 
/*     */     
/* 762 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void checkFollowUp();
/*     */ 
/*     */ 
/*     */   
/*     */   public void say(String msg) {
/* 773 */     if (!this.field_70170_p.field_72995_K) {
/* 774 */       PacketHandler.INSTANCE.sendToAllAround((IMessage)new SendChatMessage("<" + this.girlName + "> " + msg, this.field_71093_bK, girlId()), new NetworkRegistry.TargetPoint(this.field_71093_bK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 40.0D));
/*     */     }
/* 776 */     else if (belongsToPlayer()) {
/* 777 */       PacketHandler.INSTANCE.sendToServer((IMessage)new SendChatMessage("<" + this.girlName + "> " + msg, this.field_71093_bK, girlId()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void say(String msg, boolean noPrefix) {
/* 787 */     if (noPrefix) {
/*     */       
/* 789 */       if (belongsToPlayer()) {
/* 790 */         PacketHandler.INSTANCE.sendToServer((IMessage)new SendChatMessage(msg, this.field_71093_bK, girlId()));
/*     */       }
/*     */     } else {
/*     */       
/* 794 */       say(msg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void sayAround(String msg) {
/* 802 */     (Minecraft.func_71410_x()).field_71439_g.func_145747_a((ITextComponent)new TextComponentString("<" + this.girlName + "> " + msg));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playSoundAroundHer(SoundEvent sound) {
/* 812 */     if (this.field_70170_p.field_72995_K) {
/* 813 */       this.field_70170_p.func_184134_a(func_180425_c().func_177958_n(), func_180425_c().func_177956_o(), func_180425_c().func_177952_p(), sound, SoundCategory.NEUTRAL, 1.0F, 1.0F, false);
/*     */     }
/*     */     
/* 816 */     this.field_70170_p.func_184133_a(null, func_180425_c(), sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playSoundAroundHer(SoundEvent sound, float volume) {
/* 828 */     if (this.field_70170_p.field_72995_K) {
/* 829 */       this.field_70170_p.func_184134_a(func_180425_c().func_177958_n(), func_180425_c().func_177956_o(), func_180425_c().func_177952_p(), sound, SoundCategory.NEUTRAL, volume, 1.0F, false);
/*     */       
/*     */       return;
/*     */     } 
/* 833 */     this.field_70170_p.func_184133_a(null, func_180425_c(), sound, SoundCategory.PLAYERS, volume, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isClosestPlayer() {
/* 840 */     EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 50.0D);
/*     */     
/* 842 */     if (closestPlayer == null) {
/* 843 */       return false;
/*     */     }
/*     */     
/* 846 */     return closestPlayer.getPersistentID().equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID());
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3d getInFrontOfPlayer() {
/* 851 */     EntityPlayer playerSheHasSexWith = this.field_70170_p.func_152378_a(playerSheHasSexWith());
/*     */     
/* 853 */     float playerYaw = playerSheHasSexWith.field_70177_z;
/* 854 */     return playerSheHasSexWith.func_174791_d().func_72441_c(-Math.sin(playerYaw * 0.017453292519943295D), 0.0D, Math.cos(playerYaw * 0.017453292519943295D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3d getInFrontOfPlayer(double distance) {
/* 860 */     EntityPlayer playerSheHasSexWith = this.field_70170_p.func_152378_a(playerSheHasSexWith());
/*     */     
/* 862 */     float playerYaw = playerSheHasSexWith.field_70177_z;
/* 863 */     return playerSheHasSexWith.func_174791_d().func_72441_c(-Math.sin(playerYaw * 0.017453292519943295D) * distance, 0.0D, Math.cos(playerYaw * 0.017453292519943295D) * distance);
/*     */   }
/*     */   
/*     */   public static void spawnParticleOnGirl(EnumParticleTypes particle, GirlEntity girl) {
/* 867 */     double motionX = Reference.RANDOM.nextGaussian() * 0.02D;
/* 868 */     double motionY = Reference.RANDOM.nextGaussian() * 0.02D;
/* 869 */     double motionZ = Reference.RANDOM.nextGaussian() * 0.02D;
/* 870 */     girl.field_70170_p.func_175688_a(particle, girl.field_70165_t + (Reference.RANDOM
/*     */         
/* 872 */         .nextFloat() * girl.field_70130_N * 2.0F) - girl.field_70130_N, girl.field_70163_u + 0.5D + (Reference.RANDOM
/* 873 */         .nextFloat() * girl.field_70131_O), girl.field_70161_v + (Reference.RANDOM
/* 874 */         .nextFloat() * girl.field_70130_N * 2.0F) - girl.field_70130_N, motionX, motionY, motionZ, new int[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationFactory getFactory() {
/* 882 */     return this.factory;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/* 887 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
/* 892 */     return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
/* 897 */     return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) ? (T)this.inventory : (T)super.getCapability(capability, facing);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound) {
/* 903 */     compound.func_74782_a("inventory", (NBTBase)this.inventory.serializeNBT());
/* 904 */     compound.func_74780_a("homeX", this.home.field_72450_a);
/* 905 */     compound.func_74780_a("homeY", this.home.field_72448_b);
/* 906 */     compound.func_74780_a("homeZ", this.home.field_72449_c);
/* 907 */     super.func_70014_b(compound);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound) {
/* 912 */     super.func_70037_a(compound);
/* 913 */     this.inventory.deserializeNBT(compound.func_74775_l("inventory"));
/* 914 */     this.home = new Vec3d(compound.func_74769_h("homeX"), compound.func_74769_h("homeY"), compound.func_74769_h("homeZ"));
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\GirlEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */