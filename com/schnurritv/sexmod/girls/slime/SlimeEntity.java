/*     */ package com.schnurritv.sexmod.girls.slime;
/*     */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*     */ import com.schnurritv.sexmod.Packets.JennyAwaitPlayerDoggy;
/*     */ import com.schnurritv.sexmod.Packets.SetPlayerMovement;
/*     */ import com.schnurritv.sexmod.Packets.SetSlimePregnant;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.girls.slime.friendlySlime.FriendlySlimeEntity;
/*     */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*     */ import com.schnurritv.sexmod.gui.SexUI;
/*     */ import com.schnurritv.sexmod.hornypotion.HornyPotion;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityMoveHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import software.bernie.geckolib3.core.PlayState;
/*     */ import software.bernie.geckolib3.core.controller.AnimationController;
/*     */ import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.manager.AnimationData;
/*     */ 
/*     */ public class SlimeEntity extends GirlEntity {
/*  40 */   public double prevRenderPos = -420.0D;
/*  41 */   public int playerChasingCounter = 0;
/*  42 */   public static double hornyLevelIncreasePercentage = 0.2D;
/*     */   public boolean awaitPlayer = false;
/*     */   public boolean isPregnant = false;
/*  45 */   public int ticksUntilBirth = -1;
/*     */   
/*     */   public AISlimeFloat floatTask;
/*     */   
/*     */   public AISlimeHop hopTask;
/*  50 */   public static DataParameter<String> currentJumpStage = EntityDataManager.func_187226_a(SlimeEntity.class, DataSerializers.field_187194_d).func_187156_b().func_187161_a(74);
/*  51 */   public static DataParameter<Integer> hornyLevel = EntityDataManager.func_187226_a(SlimeEntity.class, DataSerializers.field_187192_b).func_187156_b().func_187161_a(73); int ticksUntilJump; long antiSoundStackTick;
/*     */   int flip;
/*     */   
/*  54 */   public enum JumpStage { START,
/*  55 */     AIR,
/*  56 */     END,
/*  57 */     NONE; }
/*     */ 
/*     */   
/*     */   public JumpStage currentJumpStage() {
/*  61 */     return JumpStage.valueOf((String)this.field_70180_af.func_187225_a(currentJumpStage));
/*     */   }
/*     */   
/*     */   public void setCurrentJumpStage(JumpStage stage) {
/*  65 */     this.field_70180_af.func_187227_b(currentJumpStage, stage.toString());
/*     */   }
/*     */   public int getHornyLevel() {
/*  68 */     return ((Integer)this.field_70180_af.func_187225_a(hornyLevel)).intValue();
/*     */   } public void setHornyLevel(int level) {
/*  70 */     this.field_70180_af.func_187227_b(hornyLevel, Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public SlimeEntity(World worldIn)
/*     */   {
/*  75 */     super(worldIn);
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
/* 149 */     this.ticksUntilJump = -1;
/*     */     
/* 151 */     this.antiSoundStackTick = 0L;
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
/* 268 */     this.flip = 0; func_70105_a(0.6F, 1.85F); this.girlName = "Slime"; this.field_70765_h = new SlimeMoveHelper(this); } public void func_70014_b(NBTTagCompound compound) { super.func_70014_b(compound); compound.func_74768_a("hornyLevel", ((Integer)this.field_70180_af.func_187225_a(hornyLevel)).intValue()); }
/*     */   public void func_70037_a(NBTTagCompound compound) { super.func_70037_a(compound); this.field_70180_af.func_187227_b(hornyLevel, Integer.valueOf(compound.func_74762_e("hornyLevel"))); if (((Integer)this.field_70180_af.func_187225_a(hornyLevel)).intValue() > 0) this.field_70180_af.func_187227_b(CURRENT_MODEL, Integer.valueOf(0));  }
/*     */   protected void func_184651_r() { Reference.server = func_184102_h(); this.floatTask = new AISlimeFloat(this); this.hopTask = new AISlimeHop(this); this.field_70714_bg.func_75776_a(1, this.floatTask); this.field_70714_bg.func_75776_a(2, this.hopTask); }
/*     */   protected void func_70088_a() { super.func_70088_a(); if (!this.field_70170_p.field_72995_K || !(this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)) { func_184212_Q().func_187214_a(hornyLevel, Integer.valueOf(0)); func_184212_Q().func_187214_a(currentJumpStage, JumpStage.NONE.toString()); }  func_189654_d(false); this.field_70145_X = false; }
/*     */   public float func_70047_e() { return 1.54F; }
/* 273 */   protected ResourceLocation func_184647_J() { return LootTableHandler.SLIME; }
/*     */    public void doAction(String animationName, UUID player) {}
/*     */   public boolean openMenu(EntityPlayer player) {
/*     */     return false;
/*     */   }
/* 278 */   public static double distanceToGround(SlimeEntity slime) { if (slime.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) return 0.0D;
/*     */     
/* 280 */     float f = 1.0F;
/* 281 */     float f1 = 90.0F;
/* 282 */     float f2 = slime.field_70126_B + (slime.field_70177_z - slime.field_70126_B) * f;
/* 283 */     double d = slime.field_70169_q + (slime.field_70165_t - slime.field_70169_q) * f;
/* 284 */     double d1 = slime.field_70167_r + (slime.field_70163_u - slime.field_70167_r) * f + 1.62D;
/* 285 */     double d2 = slime.field_70166_s + (slime.field_70161_v - slime.field_70166_s) * f;
/* 286 */     Vec3d vec3d = new Vec3d(d, d1, d2);
/* 287 */     float f3 = MathHelper.func_76134_b(-f2 * 0.01745329F - 3.141593F);
/* 288 */     float f4 = MathHelper.func_76126_a(-f2 * 0.01745329F - 3.141593F);
/* 289 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.01745329F);
/* 290 */     float f6 = MathHelper.func_76126_a(-f1 * 0.01745329F);
/* 291 */     float f7 = f4 * f5;
/* 292 */     float f8 = f6;
/* 293 */     float f9 = f3 * f5;
/* 294 */     double d3 = 5000.0D;
/* 295 */     Vec3d vec3d1 = vec3d.func_72441_c(f7 * d3, f8 * d3, f9 * d3);
/* 296 */     RayTraceResult block = slime.field_70170_p.func_72901_a(vec3d, vec3d1, true);
/*     */     
/* 298 */     return slime.field_70163_u - block.field_72307_f.field_72448_b; }
/*     */   
/*     */   public boolean canCloseUiWithoutHavingChosen() {
/*     */     return true;
/*     */   }
/* 303 */   public void func_70071_h_() { super.func_70071_h_();
/*     */     
/* 305 */     if (!this.field_70170_p.field_72995_K) {
/*     */       return;
/*     */     }
/* 308 */     if (!(this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)) {
/* 309 */       if (currentJumpStage() == JumpStage.START && this.field_70163_u - this.prevRenderPos < 0.0D)
/*     */       {
/* 311 */         setCurrentJumpStage(JumpStage.AIR);
/*     */       }
/*     */       
/* 314 */       if (currentJumpStage() == JumpStage.AIR && distanceToGround(this) < 3.0D) {
/* 315 */         setCurrentJumpStage(JumpStage.END);
/*     */       }
/*     */     }  }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void registerControllers(AnimationData data) {
/* 325 */     data.addAnimationController(this.eyesController);
/*     */     
/* 327 */     AnimationController.ISoundListener movementSoundListener = event -> {
/*     */         String command = event.sound;
/*     */         switch (command) {
/*     */           case "jumpStart":
/*     */             playSoundAroundHer(SoundEvents.field_187882_fq);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "jumpStartDone":
/*     */             this.field_70180_af.func_187227_b(currentJumpStage, JumpStage.AIR.toString());
/*     */             break;
/*     */ 
/*     */           
/*     */           case "jumpEndSound":
/*     */             if (this.antiSoundStackTick < 0L) {
/*     */               this.antiSoundStackTick = 20L;
/*     */               playSoundAroundHer(SoundEvents.field_187886_fs);
/*     */             } 
/*     */             break;
/*     */ 
/*     */           
/*     */           case "jumpEndDone":
/*     */             this.field_70180_af.func_187227_b(currentJumpStage, JumpStage.NONE.toString());
/*     */             changeDataParameterFromClient("currentJumpStage", JumpStage.NONE.toString());
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       };
/* 357 */     this.movementController.registerSoundListener(movementSoundListener);
/* 358 */     data.addAnimationController(this.movementController);
/*     */     
/* 360 */     AnimationController.ISoundListener actionSoundListener = event -> {
/*     */         int rand;
/*     */         String command = event.sound;
/*     */         switch (command) {
/*     */           case "undress":
/*     */             if (isClosestPlayer()) {
/*     */               this.field_70180_af.func_187227_b(CURRENT_MODEL, Integer.valueOf(0));
/*     */               resetGirl();
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "dress":
/*     */             if (isClosestPlayer()) {
/*     */               this.field_70180_af.func_187227_b(CURRENT_MODEL, Integer.valueOf(1));
/*     */               setCurrentAction(null);
/*     */               resetGirl();
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "becomeNude":
/*     */             this.field_70180_af.func_187227_b(CURRENT_MODEL, Integer.valueOf(0));
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "sexUiOn":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjiMSG10":
/*     */             if (belongsToPlayer()) {
/*     */               moveCamera(-0.4D, -0.8D, -0.2D, 60.0F, -3.0F);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjiMSG11":
/*     */             this.playerIsThrusting = false;
/*     */             playSoundAroundHer(SoundEvents.field_187886_fs, 0.5F);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.02D);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjiMSG12":
/*     */             if (Reference.RANDOM.nextInt(5) == 0) {
/*     */               playSoundAroundHer(SoundEvents.field_187882_fq, 0.5F);
/*     */             }
/*     */             playSoundAroundHer(SoundEvents.field_187886_fs, 0.5F);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.02D);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjtMSG1":
/*     */             playSoundAroundHer(SoundEvents.field_187878_fo);
/*     */             playSoundAroundHer(SoundEvents.field_187874_fm);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.04D);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjiDone":
/*     */             setCurrentAction(GirlEntity.Action.SUCKBLOWJOB);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjtDone":
/*     */             setCurrentAction(GirlEntity.Action.SUCKBLOWJOB);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjtReady":
/*     */           case "doggyfastReady":
/*     */             this.playerIsThrusting = false;
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjcMSG1":
/*     */             playSoundAroundHer(SoundEvents.field_187882_fq);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjcMSG2":
/*     */             playSoundAroundHer(SoundEvents.field_187882_fq);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = false;
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyslowMSG2":
/*     */             playSoundAroundHer(SoundEvents.field_187878_fo);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjcBlackScreen":
/*     */             if (belongsToPlayer()) {
/*     */               BlackScreenUI.activate();
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "bjcDone":
/*     */           case "doggyCumDone":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.resetCumPercentage();
/*     */               resetGirl();
/*     */               PacketHandler.INSTANCE.sendToServer((IMessage)new SetSlimePregnant(girlId(), true));
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyGoOnBedMSG1":
/*     */             playSoundAroundHer(SoundEvents.field_187886_fs);
/*     */             this.playerYaw = this.field_70177_z;
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyGoOnBedDone":
/*     */             PacketHandler.INSTANCE.sendToServer((IMessage)new JennyAwaitPlayerDoggy(girlId(), (Minecraft.func_71410_x()).field_71439_g.getPersistentID()));
/*     */             setCurrentAction(GirlEntity.Action.WAITDOGGY);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartMSG1":
/*     */             playSoundAroundHer(SoundsHandler.MISC_TOUCH[0]);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartMSG2":
/*     */             playSoundAroundHer(SoundsHandler.MISC_TOUCH[1]);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartMSG3":
/*     */             playSoundAroundHer(SoundEvents.field_187886_fs, 0.25F);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartMSG4":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_SMALLINSERTS), 1.5F);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.resetCumPercentage();
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartMSG5":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.33F);
/*     */             playSoundAroundHer(SoundEvents.field_187878_fo);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggystartDone":
/*     */             setCurrentAction(GirlEntity.Action.DOGGYSLOW);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyslowMSG1":
/*     */             this.playerIsThrusting = false;
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.33F);
/*     */             rand = Reference.RANDOM.nextInt(4);
/*     */             if (rand == 0) {
/*     */               rand = Reference.RANDOM.nextInt(2);
/*     */               if (rand == 0) {
/*     */                 playSoundAroundHer(SoundEvents.field_187882_fq);
/*     */               } else {
/*     */                 playSoundAroundHer(SoundEvents.field_187886_fs);
/*     */               } 
/*     */             } else {
/*     */               playSoundAroundHer(SoundEvents.field_187878_fo);
/*     */             } 
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.00666D);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyfastMSG1":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.02D);
/*     */             }
/*     */             this.flip++;
/*     */             if (this.flip % 2 == 0) {
/*     */               int random = Reference.RANDOM.nextInt(2);
/*     */               if (random == 0) {
/*     */                 playSoundAroundHer(SoundEvents.field_187882_fq);
/*     */                 break;
/*     */               } 
/*     */               playSoundAroundHer(SoundEvents.field_187886_fs);
/*     */               break;
/*     */             } 
/*     */             playSoundAroundHer(SoundEvents.field_187878_fo);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggyfastDone":
/*     */             setCurrentAction(GirlEntity.Action.DOGGYSLOW);
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case "doggycumMSG1":
/*     */             playSoundAroundHer(SoundsHandler.MISC_CUMINFLATION[0], 4.0F);
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 2.0F);
/*     */             playSoundAroundHer(SoundEvents.field_187874_fm);
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       };
/* 621 */     this.actionController.registerSoundListener(actionSoundListener);
/* 622 */     data.addAnimationController(this.actionController); }
/*     */   public void func_70619_bc() { super.func_70619_bc(); if (((Boolean)this.field_70180_af.func_187225_a(SHOULD_BE_AT_TARGET)).booleanValue()) { func_70034_d(targetYaw().floatValue()); func_70080_a((targetPos()).field_72450_a, (targetPos()).field_72448_b, (targetPos()).field_72449_c, targetYaw().floatValue(), 0.0F); func_70101_b(targetYaw().floatValue(), this.field_70125_A); }  EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 5.0D); if (this.awaitPlayer && closestPlayer != null && func_174791_d().func_72438_d(closestPlayer.func_174791_d()) < 0.75D) { setCurrentJumpStage(JumpStage.NONE); this.field_70180_af.func_187227_b(hornyLevel, Integer.valueOf(0)); this.awaitPlayer = false; EntityPlayerMP playerMP = func_184102_h().func_184103_al().func_177451_a(closestPlayer.getPersistentID()); this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, playerMP.getPersistentID().toString()); playerMP.func_70634_a((func_174791_d()).field_72450_a, (func_174791_d()).field_72448_b, (func_174791_d()).field_72449_c); TurnPlayerIntoCamera(playerMP, false); playerMP.func_191958_b(0.0F, 0.0F, 0.0F, 0.0F); func_191958_b(0.0F, 0.0F, 0.0F, 5.0F); this.playerCamPos = null; setTargetPos(func_174791_d()); setTargetYaw(this.field_70177_z); this.playerYaw = targetYaw().floatValue(); this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true)); setCurrentAction(GirlEntity.Action.DOGGYSTART); PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(false), playerMP); moveCamera(0.0D, 0.0D, 0.4D, 0.0F, 60.0F); }  if (((Integer)this.field_70180_af.func_187225_a(hornyLevel)).intValue() == 2)
/*     */       if (closestPlayer != null && this.field_70122_E && func_174791_d().func_72438_d(closestPlayer.func_174791_d()) < 0.75D) { boolean playerIsHavinSexAlready = false; for (GirlEntity girl : girlEntities) { if (closestPlayer.getPersistentID().equals(girl.playerSheHasSexWith())) { playerIsHavinSexAlready = true; break; }  }  if (!playerIsHavinSexAlready) { setCurrentJumpStage(JumpStage.NONE); this.field_70180_af.func_187227_b(hornyLevel, Integer.valueOf(0)); this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, closestPlayer.getPersistentID().toString()); TurnPlayerIntoCamera((EntityPlayerMP)closestPlayer, false); closestPlayer.func_70634_a((func_174791_d()).field_72450_a, (func_174791_d()).field_72448_b, (func_174791_d()).field_72449_c); func_189654_d(true); this.field_70145_X = true; this.playerCamPos = null; setTargetPos(func_174791_d()); setTargetYaw(this.field_70177_z); this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true)); this.playerYaw = closestPlayer.field_70177_z; setCurrentAction(GirlEntity.Action.SUCKBLOWJOB); prepareAction(false, true); PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(false), (EntityPlayerMP)closestPlayer); }  }   this.ticksUntilJump--; if (this.ticksUntilJump <= -1) { this.ticksUntilJump = -1; } else if (this.ticksUntilJump == 0 && !this.isPregnant) { Vec3d forward = Vec3d.func_189986_a(this.field_70125_A, this.field_70177_z); this.field_70181_x = 0.75D; this.field_70159_w = 0.44999998807907104D * forward.field_72450_a; this.field_70179_y = 0.44999998807907104D * forward.field_72449_c; }  this.ticksUntilBirth--; if (this.ticksUntilBirth <= -1) { this.ticksUntilBirth = -1; } else if (this.ticksUntilBirth == 0) { this.isPregnant = false; PacketHandler.INSTANCE.sendToAllAround((IMessage)new SetSlimePregnant(girlId(), false), getTargetPoint()); FriendlySlimeEntity slime = new FriendlySlimeEntity(this.field_70170_p); slime.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); this.field_70170_p.func_72838_d((Entity)slime); playSoundAroundHer(SoundsHandler.MISC_PLOB[0]); }
/*     */      this.antiSoundStackTick--; if (func_70644_a(HornyPotion.HORNY_EFFECT)) { func_184589_d(HornyPotion.HORNY_EFFECT); if (getHornyLevel() == 0)
/*     */         setCurrentAction(GirlEntity.Action.UNDRESS);  setHornyLevel(2); }
/* 627 */      } protected <E extends software.bernie.geckolib3.core.IAnimatable> PlayState predicate(AnimationEvent<E> event) { if (this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) return null;
/*     */     
/* 629 */     switch (event.getController().getName()) {
/*     */ 
/*     */       
/*     */       case "eyes":
/* 633 */         if (currentAction() == GirlEntity.Action.NULL || !(currentAction()).autoBlink) {
/* 634 */           createAnimation("animation.slime.null", true, event);
/*     */           
/*     */           break;
/*     */         } 
/* 638 */         createAnimation("animation.slime.fhappy", true, event);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case "movement":
/* 644 */         if (currentAction() != GirlEntity.Action.NULL) {
/* 645 */           createAnimation("animation.slime.null", true, event);
/*     */         }
/*     */ 
/*     */         
/* 649 */         switch (JumpStage.valueOf((String)this.field_70180_af.func_187225_a(currentJumpStage))) {
/*     */           case UNDRESS:
/* 651 */             createAnimation("animation.slime.jumpstart", false, event);
/*     */             break;
/*     */           
/*     */           case DRESS:
/* 655 */             createAnimation("animation.slime.jumpair", true, event);
/*     */             break;
/*     */           
/*     */           case STRIP:
/* 659 */             createAnimation("animation.slime.jumpend", false, event);
/*     */             break;
/*     */           
/*     */           case STARTBLOWJOB:
/* 663 */             createAnimation("animation.slime.idle", true, event);
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/*     */         break;
/*     */ 
/*     */       
/*     */       case "action":
/* 672 */         if (currentAction() == GirlEntity.Action.NULL) {
/* 673 */           createAnimation("animation.slime.null", true, event);
/*     */           
/*     */           break;
/*     */         } 
/* 677 */         switch (currentAction()) {
/*     */           
/*     */           case UNDRESS:
/* 680 */             createAnimation("animation.slime.undress", false, event);
/*     */             break;
/*     */           
/*     */           case DRESS:
/* 684 */             createAnimation("animation.slime.dress", false, event);
/*     */             break;
/*     */           
/*     */           case STRIP:
/* 688 */             createAnimation("animation.slime.strip", false, event);
/*     */             break;
/*     */           
/*     */           case STARTBLOWJOB:
/* 692 */             createAnimation("animation.slime.blowjobintro", false, event);
/*     */             break;
/*     */           
/*     */           case SUCKBLOWJOB:
/* 696 */             createAnimation("animation.slime.blowjobsuck", true, event);
/*     */             break;
/*     */           
/*     */           case THRUSTBLOWJOB:
/* 700 */             createAnimation("animation.slime.blowjobthrust", false, event);
/*     */             break;
/*     */           
/*     */           case CUMBLOWJOB:
/* 704 */             createAnimation("animation.slime.blowjobcum", false, event);
/*     */             break;
/*     */           
/*     */           case STARTDOGGY:
/* 708 */             createAnimation("animation.slime.doggygoonbed", false, event);
/*     */             break;
/*     */           
/*     */           case WAITDOGGY:
/* 712 */             createAnimation("animation.slime.doggywait", true, event);
/*     */             break;
/*     */           
/*     */           case DOGGYSTART:
/* 716 */             createAnimation("animation.slime.doggystart", false, event);
/*     */             break;
/*     */           
/*     */           case DOGGYSLOW:
/* 720 */             createAnimation("animation.slime.doggyslow", true, event);
/*     */             break;
/*     */           
/*     */           case DOGGYFAST:
/* 724 */             createAnimation("animation.slime.doggyfast", false, event);
/*     */             break;
/*     */           
/*     */           case DOGGYCUM:
/* 728 */             createAnimation("animation.slime.doggycum", false, event);
/*     */             break;
/*     */         } 
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 735 */     return PlayState.CONTINUE; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cum() {
/* 741 */     if (currentAction() == GirlEntity.Action.SUCKBLOWJOB || currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*     */ 
/*     */       
/* 744 */       this.playerIsCumming = true;
/* 745 */       this.actionController.transitionLengthTicks = 2.0D;
/* 746 */       setCurrentAction(GirlEntity.Action.CUMBLOWJOB);
/*     */     
/*     */     }
/* 749 */     else if (currentAction() == GirlEntity.Action.DOGGYSLOW || currentAction() == GirlEntity.Action.DOGGYFAST) {
/*     */       
/* 751 */       this.playerIsCumming = true;
/* 752 */       this.actionController.transitionLengthTicks = 2.0D;
/* 753 */       setCurrentAction(GirlEntity.Action.DOGGYCUM);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void thrust() {
/* 761 */     if (currentAction() == GirlEntity.Action.SUCKBLOWJOB || currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*     */ 
/*     */       
/* 764 */       this.playerIsThrusting = true;
/*     */       
/* 766 */       if (currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*     */ 
/*     */         
/* 769 */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*     */       }
/*     */       else {
/*     */         
/* 773 */         setCurrentAction(GirlEntity.Action.THRUSTBLOWJOB);
/*     */       } 
/* 775 */     } else if (currentAction() == GirlEntity.Action.DOGGYSLOW || currentAction() == GirlEntity.Action.DOGGYFAST) {
/*     */       
/* 777 */       this.playerIsThrusting = true;
/*     */       
/* 779 */       if (currentAction() == GirlEntity.Action.DOGGYFAST) {
/*     */ 
/*     */ 
/*     */         
/* 783 */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*     */       }
/*     */       else {
/*     */         
/* 787 */         setCurrentAction(GirlEntity.Action.DOGGYFAST);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkFollowUp() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent func_184639_G() {
/* 799 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
/* 804 */     return SoundEvents.field_187880_fp;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent func_184615_bR() {
/* 809 */     return SoundEvents.field_187874_fm;
/*     */   }
/*     */   
/*     */   static class AISlimeFloat
/*     */     extends EntityAIBase
/*     */   {
/*     */     private final SlimeEntity slime;
/*     */     
/*     */     public AISlimeFloat(SlimeEntity slimeIn) {
/* 818 */       this.slime = slimeIn;
/* 819 */       func_75248_a(5);
/* 820 */       ((PathNavigateGround)slimeIn.func_70661_as()).func_179693_d(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_75250_a() {
/* 828 */       return (this.slime.func_70090_H() || this.slime.func_180799_ab());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75246_d() {
/* 836 */       if (this.slime.func_70681_au().nextFloat() < 0.8F)
/*     */       {
/* 838 */         this.slime.func_70683_ar().func_75660_a();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class AISlimeHop
/*     */     extends EntityAIBase
/*     */   {
/*     */     private final SlimeEntity slime;
/*     */     
/*     */     public AISlimeHop(SlimeEntity slimeIn) {
/* 850 */       this.slime = slimeIn;
/* 851 */       func_75248_a(5);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_75250_a() {
/* 859 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_75246_d() {
/* 867 */       ((SlimeEntity.SlimeMoveHelper)this.slime.func_70605_aq()).setSpeed(1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   class SlimeMoveHelper
/*     */     extends EntityMoveHelper
/*     */   {
/*     */     private float yRot;
/*     */     private int jumpDelay;
/*     */     private final SlimeEntity slime;
/*     */     
/*     */     public SlimeMoveHelper(SlimeEntity slimeIn) {
/* 879 */       super((EntityLiving)slimeIn);
/* 880 */       this.slime = slimeIn;
/* 881 */       this.yRot = 180.0F * slimeIn.field_70177_z / 3.1415927F;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setDirection(float p_179920_1_) {
/* 886 */       this.yRot = p_179920_1_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSpeed(double speedIn) {
/* 891 */       this.field_75645_e = speedIn;
/* 892 */       this.field_188491_h = EntityMoveHelper.Action.MOVE_TO;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_75641_c() {
/* 897 */       this.field_75648_a.field_70177_z = func_75639_a(this.field_75648_a.field_70177_z, this.yRot, 90.0F);
/* 898 */       this.field_75648_a.field_70759_as = this.field_75648_a.field_70177_z;
/* 899 */       this.field_75648_a.field_70761_aq = this.field_75648_a.field_70177_z;
/*     */       
/* 901 */       if (this.field_188491_h != EntityMoveHelper.Action.MOVE_TO) {
/*     */         
/* 903 */         this.field_75648_a.func_191989_p(0.0F);
/*     */       }
/*     */       else {
/*     */         
/* 907 */         this.field_188491_h = EntityMoveHelper.Action.WAIT;
/*     */         
/* 909 */         if (this.field_75648_a.field_70122_E) {
/*     */           
/* 911 */           if (this.jumpDelay-- <= 0) {
/*     */             float chosenDegrees;
/*     */             
/* 914 */             this.jumpDelay = (this.slime.getHornyLevel() == 2) ? 100 : (Reference.RANDOM.nextInt(100) + 100);
/*     */             
/* 916 */             double r = Math.random();
/*     */             
/* 918 */             if (r < SlimeEntity.hornyLevelIncreasePercentage && !this.slime.isPregnant) {
/*     */               
/* 920 */               this.slime.setHornyLevel(Math.min(this.slime.getHornyLevel() + 1, 2));
/* 921 */               if (this.slime.getHornyLevel() == 1) {
/*     */                 
/* 923 */                 this.slime.setCurrentAction(GirlEntity.Action.UNDRESS);
/*     */ 
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 931 */             if (this.slime.getHornyLevel() != 2) {
/* 932 */               chosenDegrees = this.slime.func_70681_au().nextInt(360);
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 937 */               EntityPlayer playerToChase = this.slime.field_70170_p.func_72890_a((Entity)this.slime, 10.0D);
/*     */               
/* 939 */               if (playerToChase == null) {
/* 940 */                 chosenDegrees = this.slime.func_70681_au().nextInt(360);
/*     */               }
/*     */               else {
/*     */                 
/* 944 */                 Vec3d distance = this.slime.func_174791_d().func_178788_d(playerToChase.func_174791_d());
/* 945 */                 chosenDegrees = (float)Math.atan2(distance.field_72449_c, distance.field_72450_a) * 57.29578F + 90.0F;
/*     */               } 
/*     */ 
/*     */               
/* 949 */               this.slime.playerChasingCounter++;
/*     */               
/* 951 */               if (this.slime.playerChasingCounter > 6) {
/* 952 */                 this.slime.playerChasingCounter = 0;
/* 953 */                 this.slime.setCurrentAction(GirlEntity.Action.STARTDOGGY);
/* 954 */                 this.slime.awaitPlayer = true;
/* 955 */                 this.slime.field_70714_bg.func_85156_a(this.slime.hopTask);
/* 956 */                 this.slime.field_70714_bg.func_85156_a(this.slime.floatTask);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/* 961 */             if (!this.slime.isPregnant)
/*     */             {
/* 963 */               ((SlimeMoveHelper)this.slime.func_70605_aq()).setDirection(chosenDegrees);
/* 964 */               this.slime.field_70180_af.func_187227_b(SlimeEntity.currentJumpStage, SlimeEntity.JumpStage.NONE.toString());
/* 965 */               this.slime.field_70180_af.func_187227_b(SlimeEntity.currentJumpStage, SlimeEntity.JumpStage.START.toString());
/* 966 */               this.slime.ticksUntilJump = 15;
/*     */             }
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 972 */             this.slime.field_70702_br = 0.0F;
/* 973 */             this.slime.field_191988_bg = 0.0F;
/* 974 */             this.field_75648_a.func_70659_e(0.0F);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 979 */           this.field_75648_a.func_70659_e((float)(this.field_75645_e * this.field_75648_a.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()));
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\slime\SlimeEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */