/*     */ package com.schnurritv.sexmod.companion;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.entity.projectile.EntityTippedArrow;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHealEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class Companion
/*     */   extends EntityAIBase
/*     */ {
/*     */   GirlEntity girl;
/*     */   EntityPlayer master;
/*     */   EntityLivingBase target;
/*     */   Entity ridingEntity;
/*  51 */   Mode currentMode = Mode.IDLE;
/*  52 */   GirlEntity.WalkSpeed currentWalkSpeed = GirlEntity.WalkSpeed.WALK; PathNavigate navigator; EntityDataManager dataManager; static final double WALK_SPEED = 0.5D; static final double RUN_SPEED = 0.7D;
/*     */   static final int MODE_SWITCH_COOLDOWN = 60;
/*     */   double lastDistance;
/*     */   Vec3d lastMasterPos;
/*     */   int idlePosChangeTick;
/*     */   int attackModeCoolDown;
/*     */   int attackCoolDown;
/*     */   int chargingTicks;
/*     */   int shouldntFollowAnymoreTick;
/*     */   
/*  62 */   enum Mode { ATTACK,
/*  63 */     FOLLOW,
/*  64 */     IDLE,
/*  65 */     RIDE,
/*  66 */     DOWNED; }
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
/*     */   public boolean func_75250_a() {
/*  79 */     return !((String)this.girl.func_184212_Q().func_187225_a(GirlEntity.MASTER)).equals("");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  85 */     String uuidString = (String)this.dataManager.func_187225_a(GirlEntity.MASTER);
/*  86 */     return (!uuidString.equals("") && this.girl.field_70170_p.func_152378_a(UUID.fromString(uuidString)) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  92 */     this.navigator.func_75499_g();
/*  93 */     this.currentMode = Mode.IDLE;
/*  94 */     this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(0));
/*  95 */     this.girl.setCurrentAction(GirlEntity.Action.NULL);
/*  96 */     this.dataManager.func_187227_b(GirlEntity.MASTER, "");
/*     */     
/*  98 */     this.navigator = null;
/*  99 */     this.dataManager = null;
/* 100 */     this.master = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/* 106 */     this.navigator = this.girl.func_70661_as();
/* 107 */     this.dataManager = this.girl.func_184212_Q();
/* 108 */     this.master = this.girl.field_70170_p.func_152378_a(UUID.fromString((String)this.dataManager.func_187225_a(GirlEntity.MASTER)));
/*     */   }
/*     */   
/* 111 */   public Companion() { this.lastDistance = 3.4028234663852886E38D;
/* 112 */     this.lastMasterPos = Vec3d.field_186680_a;
/* 113 */     this.idlePosChangeTick = 0;
/* 114 */     this.attackModeCoolDown = 0;
/* 115 */     this.attackCoolDown = 0;
/* 116 */     this.chargingTicks = 0;
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
/*     */ 
/*     */ 
/*     */     
/* 252 */     this.shouldntFollowAnymoreTick = 0; } public Companion(GirlEntity girl) { this.lastDistance = 3.4028234663852886E38D; this.lastMasterPos = Vec3d.field_186680_a; this.idlePosChangeTick = 0; this.attackModeCoolDown = 0; this.attackCoolDown = 0; this.chargingTicks = 0; this.shouldntFollowAnymoreTick = 0;
/*     */     this.girl = girl; }
/*     */ 
/*     */   
/* 256 */   Mode updateMode() { this.attackModeCoolDown--;
/*     */     
/* 258 */     if (this.girl.downed || this.girl.playerSheHasSexWith() != null) {
/* 259 */       return Mode.DOWNED;
/*     */     }
/* 261 */     if (this.master.func_184218_aH()) {
/*     */       
/* 263 */       Entity ridingEntity = this.master.func_184187_bx();
/*     */       
/* 265 */       if (this.girl.func_184218_aH() || this.girl.func_184220_m(ridingEntity) || (ridingEntity instanceof EntityHorse && ((EntityHorse)ridingEntity).func_110257_ck())) {
/* 266 */         this.ridingEntity = ridingEntity;
/* 267 */         return Mode.RIDE;
/*     */       }
/*     */     
/* 270 */     } else if ((!this.master.func_184218_aH() && this.girl.func_184218_aH()) || (this.currentMode == Mode.RIDE && !this.master.func_184218_aH())) {
/* 271 */       this.girl.setCurrentAction(GirlEntity.Action.NULL);
/* 272 */       this.girl.func_184210_p();
/* 273 */       this.girl.field_70145_X = false;
/* 274 */       this.girl.func_189654_d(false);
/*     */     } 
/*     */ 
/*     */     
/* 278 */     if (shouldAttackTarget(this.target))
/*     */     {
/* 280 */       return Mode.ATTACK;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     DamageSource source = this.girl.func_189748_bU();
/*     */     
/* 288 */     if (source != null) {
/*     */       
/* 290 */       EntityLivingBase entityLivingBase = (EntityLivingBase)source.func_76346_g();
/*     */       
/* 292 */       if (shouldAttackTarget(entityLivingBase)) {
/* 293 */         this.target = entityLivingBase;
/* 294 */         return Mode.ATTACK;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 299 */     EntityLivingBase newTarget = this.master.func_110144_aD();
/* 300 */     if (this.master.field_70173_aa - this.master.func_142013_aG() < 140 && shouldAttackTarget(newTarget)) {
/*     */       
/* 302 */       this.target = newTarget;
/* 303 */       return Mode.ATTACK;
/*     */     } 
/*     */ 
/*     */     
/* 307 */     if (this.currentMode != Mode.FOLLOW) {
/*     */ 
/*     */       
/* 310 */       source = this.master.func_189748_bU();
/*     */       
/* 312 */       if (source != null) {
/*     */         
/* 314 */         newTarget = (EntityLivingBase)source.func_76346_g();
/*     */         
/* 316 */         if (shouldAttackTarget(newTarget)) {
/* 317 */           this.target = newTarget;
/* 318 */           return Mode.ATTACK;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 323 */       Vec3d pos = this.girl.func_174791_d();
/* 324 */       AxisAlignedBB area = new AxisAlignedBB(pos.field_72450_a - 5.0D, pos.field_72448_b - 2.0D, pos.field_72449_c - 5.0D, pos.field_72450_a + 5.0D, pos.field_72448_b + 2.0D, pos.field_72449_c + 5.0D);
/* 325 */       List<EntityMob> mobs = this.girl.field_70170_p.func_72872_a(EntityMob.class, area);
/*     */       
/* 327 */       mobs.sort((o1, o2) -> {
/*     */             double o1Distance = o1.func_70032_d((Entity)this.girl);
/*     */ 
/*     */             
/*     */             double o2Distance = o2.func_70032_d((Entity)this.girl);
/*     */ 
/*     */             
/*     */             return (o1Distance == o2Distance) ? 0 : ((o1Distance < o2Distance) ? -1 : 1);
/*     */           });
/*     */       
/* 337 */       for (EntityMob mob : mobs) {
/* 338 */         if (shouldAttackTarget((EntityLivingBase)mob) && !(mob instanceof net.minecraft.entity.monster.EntityCreeper)) {
/* 339 */           this.target = (EntityLivingBase)mob;
/* 340 */           return Mode.ATTACK;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 346 */     float distance = this.girl.func_70032_d((Entity)this.master);
/* 347 */     boolean shouldFollow = (distance > 5.0F);
/*     */     
/* 349 */     if (!shouldFollow && this.currentMode == Mode.FOLLOW)
/*     */     {
/* 351 */       if (++this.shouldntFollowAnymoreTick > 60) {
/* 352 */         shouldFollow = false;
/* 353 */         this.shouldntFollowAnymoreTick = 0;
/*     */       } else {
/*     */         
/* 356 */         shouldFollow = true;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 361 */     if (shouldFollow && this.currentMode == Mode.ATTACK) {
/* 362 */       this.attackModeCoolDown = 60;
/*     */     }
/* 364 */     if (shouldFollow) {
/* 365 */       return Mode.FOLLOW;
/*     */     }
/* 367 */     return Mode.IDLE; }
/*     */   public void func_75246_d() { double distance; Vec3d girlPos; this.currentMode = updateMode(); this.girl.aiLookAtPlayer.shouldLook = (this.currentMode == Mode.IDLE); switch (this.currentMode) { case ATTACK: this.girl.func_70671_ap().func_75651_a((Entity)this.target, 30.0F, 30.0F); distance = this.girl.func_70032_d((Entity)this.target); this.navigator.func_75499_g(); if (distance < 1.9D && --this.attackCoolDown <= 0) { attack(); break; }  if (this.girl.inventory.getStackInSlot(1).func_77973_b() instanceof net.minecraft.item.ItemBow && this.girl.func_70635_at().func_75522_a((Entity)this.target) && ++this.chargingTicks > 0 && distance > 6.0D) { this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(2)); this.girl.setCurrentAction(GirlEntity.Action.BOW); if (this.chargingTicks >= 32) { this.chargingTicks = -20; attackTargetWithRangedAttack(); this.girl.setCurrentAction(GirlEntity.Action.NULL); }  this.lastDistance = this.girl.func_70032_d((Entity)this.master); this.lastMasterPos = this.master.func_174791_d(); return; }  if (distance < 2.0D) { this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(1)); this.navigator.func_75497_a((Entity)this.target, 0.5D); this.girl.setWalkSpeed(GirlEntity.WalkSpeed.WALK); break; }  this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(1)); this.navigator.func_75497_a((Entity)this.target, 0.7D); this.girl.setWalkSpeed(GirlEntity.WalkSpeed.RUN); break;
/*     */       case FOLLOW: this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(0)); distance = this.girl.func_70032_d((Entity)this.master); if (this.navigator.func_111269_d() > distance) { this.navigator.func_75499_g(); if (!this.girl.downed)
/*     */             this.navigator.func_75497_a((Entity)this.master, 0.5D);  } else { tpToPlayer(); }  this.idlePosChangeTick = 300; setMovementSpeed(); break;
/*     */       case IDLE: this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(0)); if (!this.girl.downed) { if (++this.idlePosChangeTick > 200 + Reference.RANDOM.nextInt(100)) { this.idlePosChangeTick = 0; Vec3d masterPos = this.master.func_174791_d(); Vec3d idlePos = new Vec3d(masterPos.field_72450_a + 1.0D + (Reference.RANDOM.nextFloat() * 3.0F), masterPos.field_72448_b, masterPos.field_72449_c + 1.0D + (Reference.RANDOM.nextFloat() * 3.0F)); this.navigator.func_75499_g(); this.navigator.func_75492_a(idlePos.field_72450_a, idlePos.field_72448_b, idlePos.field_72449_c, 0.5D); }  setMovementSpeed(); break; }  if (this.girl.func_70032_d((Entity)this.master) > 10.0F)
/*     */           tpToPlayer();  break;
/*     */       case RIDE: if (this.girl.func_184218_aH()) { this.girl.setCurrentAction(GirlEntity.Action.SIT); break; }  this.girl.func_189654_d(true); this.girl.field_70145_X = true; girlPos = this.master.func_174791_d().func_178786_a((this.ridingEntity.func_70040_Z()).field_72450_a * 0.5D, 0.0D, (this.ridingEntity.func_70040_Z()).field_72449_c * 0.5D); this.girl.func_70080_a(girlPos.field_72450_a, girlPos.field_72448_b, girlPos.field_72449_c, 0.0F, 0.0F); this.girl.field_70159_w = 0.0D; this.girl.field_70181_x = 0.0D; this.girl.field_70179_y = 0.0D; this.girl.setCurrentAction(GirlEntity.Action.RIDE); break;
/*     */       case DOWNED: this.navigator.func_75499_g(); break; }  this.lastDistance = this.girl.func_70032_d((Entity)this.master); this.lastMasterPos = this.master.func_174791_d(); if (this.girl.currentAction() == GirlEntity.Action.BOW)
/*     */       this.girl.setCurrentAction(GirlEntity.Action.NULL);  this.chargingTicks = Math.min(this.chargingTicks, 0); }
/* 376 */   boolean shouldAttackTarget(EntityLivingBase target) { Vec3d girlPos = this.girl.func_174791_d(); return (this.attackModeCoolDown <= 0 && target != null && target.field_70170_p != null && !this.girl.equals(target) && target.func_70089_S() && girlPos.func_72438_d(this.master.func_174791_d()) < 15.0D && girlPos.func_72438_d(target.func_174791_d()) < 20.0D && !target.equals(this.master)); } void tpToPlayer() { BlockPos tpTo; do { tpTo = this.master.func_180425_c().func_177982_a(Reference.RANDOM.nextInt(10), 0, Reference.RANDOM.nextInt(10)); }
/* 377 */     while (!this.girl.func_184595_k(tpTo.func_177958_n(), tpTo.func_177956_o(), tpTo.func_177952_p()));
/*     */     
/* 379 */     this.girl.field_70159_w = 0.0D;
/* 380 */     this.girl.field_70181_x = 0.0D;
/* 381 */     this.girl.field_70179_y = 0.0D; }
/*     */   
/*     */   void setMovementSpeed() {
/*     */     double speed;
/*     */     GirlEntity.WalkSpeed walkSpeed;
/* 386 */     float distance = this.girl.func_70032_d((Entity)this.master);
/* 387 */     boolean masterIsMoving = (this.master.func_70011_f(this.lastMasterPos.field_72450_a, this.lastMasterPos.field_72448_b, this.lastMasterPos.field_72449_c) != 0.0D);
/*     */ 
/*     */ 
/*     */     
/* 391 */     if (this.master.func_70051_ag()) {
/* 392 */       speed = 0.7D;
/* 393 */       walkSpeed = GirlEntity.WalkSpeed.RUN;
/*     */     } else {
/*     */       
/* 396 */       speed = 0.5D;
/* 397 */       walkSpeed = GirlEntity.WalkSpeed.WALK;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 402 */     double extraSpeed = Math.floor((distance / 5.0F)) * 0.2D;
/* 403 */     speed += extraSpeed;
/*     */     
/* 405 */     if (this.girl.func_70090_H()) {
/*     */       
/* 407 */       speed *= 60.0D;
/* 408 */       walkSpeed = GirlEntity.WalkSpeed.WALK;
/*     */     } 
/*     */     
/* 411 */     if (this.girl.downed) {
/* 412 */       speed = 0.0D;
/*     */     }
/* 414 */     this.navigator.func_75489_a(speed);
/* 415 */     this.girl.setWalkSpeed(walkSpeed);
/*     */   }
/*     */   
/*     */   public void attackTargetWithRangedAttack() {
/* 419 */     EntityArrow entityarrow = getArrow();
/* 420 */     double d0 = this.target.field_70165_t - this.girl.field_70165_t;
/* 421 */     double d1 = (this.target.func_174813_aQ()).field_72338_b + (this.target.field_70131_O / 3.0F) - entityarrow.field_70163_u;
/* 422 */     double d2 = this.target.field_70161_v - this.girl.field_70161_v;
/* 423 */     double d3 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
/* 424 */     entityarrow.func_70186_c(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 2.0F);
/* 425 */     this.girl.func_184185_a(SoundEvents.field_187866_fi, 1.0F, 1.0F / (this.girl.func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 426 */     this.girl.field_70170_p.func_72838_d((Entity)entityarrow);
/* 427 */     entityarrow.func_70239_b(4.5D);
/*     */   }
/*     */   
/*     */   protected EntityArrow getArrow() {
/* 431 */     EntityTippedArrow entityTippedArrow = new EntityTippedArrow(this.girl.field_70170_p, (EntityLivingBase)this.girl);
/*     */     
/* 433 */     ItemStack bow = this.girl.inventory.getStackInSlot(1);
/*     */     
/* 435 */     double power = EnchantmentHelper.func_77506_a(Enchantments.field_185309_u, bow);
/* 436 */     int punch = EnchantmentHelper.func_77506_a(Enchantments.field_185310_v, bow);
/* 437 */     int fire = EnchantmentHelper.func_77506_a(Enchantments.field_185311_w, bow);
/*     */     
/* 439 */     if (power != 0.0D) {
/* 440 */       entityTippedArrow.func_70239_b(entityTippedArrow.func_70242_d() + power * 0.5D + 0.5D);
/*     */     }
/* 442 */     if (punch != 0) {
/* 443 */       entityTippedArrow.func_70240_a(punch);
/*     */     }
/* 445 */     if (fire != 0) {
/* 446 */       entityTippedArrow.func_70015_d(100);
/*     */     }
/* 448 */     return (EntityArrow)entityTippedArrow;
/*     */   }
/*     */   
/*     */   void attack() {
/* 452 */     this.girl.setCurrentAction(GirlEntity.Action.ATTACK);
/* 453 */     this.dataManager.func_187227_b(GirlEntity.ATTACK_MODE, Integer.valueOf(1));
/*     */     
/* 455 */     ItemStack weapon = this.girl.inventory.getStackInSlot(0);
/*     */     
/* 457 */     Multimap<String, AttributeModifier> modifiers = weapon.func_111283_C(EntityEquipmentSlot.MAINHAND);
/*     */     
/* 459 */     float damage = 0.0F;
/* 460 */     float attackSpeed = 0.0F;
/*     */     
/* 462 */     for (AttributeModifier modifier : modifiers.get(SharedMonsterAttributes.field_111264_e.func_111108_a())) {
/* 463 */       damage = (float)modifier.func_111164_d();
/*     */     }
/* 465 */     for (AttributeModifier modifier : modifiers.get(SharedMonsterAttributes.field_188790_f.func_111108_a())) {
/* 466 */       attackSpeed = (float)modifier.func_111164_d();
/*     */     }
/* 468 */     attackSpeed = Math.max(attackSpeed, 0.5F);
/*     */ 
/*     */     
/* 471 */     float extraDamage = EnchantmentHelper.func_152377_a(weapon, this.target.func_70668_bt());
/* 472 */     int knockBack = EnchantmentHelper.func_77506_a(Enchantments.field_180313_o, weapon);
/* 473 */     int fireAspect = EnchantmentHelper.func_77506_a(Enchantments.field_77334_n, weapon);
/* 474 */     int sweeping = EnchantmentHelper.func_77506_a(Enchantments.field_191530_r, weapon);
/*     */     
/* 476 */     this.target.func_70653_a((Entity)this.girl, knockBack * 0.5F, MathHelper.func_76126_a(this.girl.field_70177_z * 0.017453292F), -MathHelper.func_76134_b(this.girl.field_70177_z * 0.017453292F));
/* 477 */     this.target.func_70015_d(fireAspect * 4);
/*     */     
/* 479 */     if (sweeping != 0) {
/*     */       
/* 481 */       float percentage = 0.5F;
/*     */       
/* 483 */       if (sweeping == 2) {
/* 484 */         percentage = 0.67F;
/* 485 */       } else if (sweeping == 3) {
/* 486 */         percentage = 0.75F;
/*     */       } 
/*     */       
/* 489 */       for (EntityLivingBase entitylivingbase : this.girl.field_70170_p.func_72872_a(EntityLivingBase.class, this.target.func_174813_aQ().func_72314_b(1.0D, 0.25D, 1.0D))) {
/* 490 */         if (entitylivingbase != this.girl && entitylivingbase != this.master && entitylivingbase != this.target && !this.girl.func_184191_r((Entity)entitylivingbase) && this.girl.func_70068_e((Entity)entitylivingbase) < 9.0D) {
/* 491 */           entitylivingbase.func_70653_a((Entity)this.girl, 0.4F, MathHelper.func_76126_a(this.girl.field_70177_z * 0.017453292F), -MathHelper.func_76134_b(this.girl.field_70177_z * 0.017453292F));
/* 492 */           entitylivingbase.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.girl), (damage + extraDamage) * percentage);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 497 */     this.target.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.girl), damage + extraDamage);
/* 498 */     this.attackCoolDown = Math.round(Math.abs(attackSpeed) / 3.373494F * 20.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void noDeath(LivingDeathEvent event) {
/* 504 */     if (event.getEntityLiving() instanceof GirlEntity) {
/*     */       
/* 506 */       GirlEntity girl = (GirlEntity)event.getEntityLiving();
/*     */       
/* 508 */       if (!((String)girl.func_184212_Q().func_187225_a(GirlEntity.MASTER)).equals(""))
/*     */       {
/* 510 */         event.setCanceled(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void downed(LivingHurtEvent event) {
/* 518 */     if (event.getEntityLiving() instanceof GirlEntity) {
/*     */       
/* 520 */       GirlEntity girl = (GirlEntity)event.getEntityLiving();
/*     */       
/* 522 */       if (girl.downed) {
/*     */         
/* 524 */         event.setCanceled(true);
/*     */       }
/* 526 */       else if (girl.func_110143_aJ() - event.getAmount() < 0.0F && !((String)girl.func_184212_Q().func_187225_a(GirlEntity.MASTER)).equals("")) {
/*     */         
/* 528 */         girl.downed = true;
/* 529 */         girl.setCurrentAction(GirlEntity.Action.DOWNED);
/* 530 */         event.setAmount(girl.func_110143_aJ() - 1.0F);
/* 531 */         girl.func_70661_as().func_75499_g();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void healDowned(LivingHealEvent event) {
/* 539 */     if (event.getEntityLiving() instanceof GirlEntity) {
/*     */       
/* 541 */       GirlEntity girl = (GirlEntity)event.getEntityLiving();
/*     */       
/* 543 */       if (girl.downed && girl.func_110143_aJ() + event.getAmount() >= girl.func_110138_aP()) {
/*     */         
/* 545 */         girl.downed = false;
/* 546 */         girl.setCurrentAction(GirlEntity.Action.NULL);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void dropItems(LivingDeathEvent event) {
/* 554 */     if (event.getEntityLiving() instanceof GirlEntity) {
/*     */       
/* 556 */       GirlEntity girl = (GirlEntity)event.getEntityLiving();
/*     */       
/* 558 */       if (girl.field_70170_p.field_72995_K || girl instanceof com.schnurritv.sexmod.girls.slime.SlimeEntity) {
/*     */         return;
/*     */       }
/* 561 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 563 */         Item item = girl.inventory.getStackInSlot(i).func_77973_b();
/* 564 */         if (item != Items.field_190931_a)
/* 565 */           girl.func_145779_a(item, 1); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\Companion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */