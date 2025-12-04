/*     */ package com.schnurritv.sexmod.girls.bia;
/*     */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*     */ import com.schnurritv.sexmod.Packets.SendCompanionHome;
/*     */ import com.schnurritv.sexmod.Packets.SendGirlToBed;
/*     */ import com.schnurritv.sexmod.Packets.SetPlayerMovement;
/*     */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*     */ import com.schnurritv.sexmod.gui.SexUI;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*     */ import com.schnurritv.sexmod.util.PenisMath;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import software.bernie.geckolib3.core.PlayState;
/*     */ import software.bernie.geckolib3.core.controller.AnimationController;
/*     */ import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.manager.AnimationData;
/*     */ 
/*     */ public class BiaEntity extends GirlEntity {
/*     */   public boolean isPreparingTalk = false;
/*     */   boolean lookingForBed = false;
/*  41 */   int bedSearchTick = 0;
/*     */   int preparingTalkTick;
/*     */   
/*  44 */   public BiaEntity(World worldIn) { super(worldIn);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.preparingTalkTick = 0; func_70105_a(0.49F, 1.65F); this.girlName = "Bia";
/*     */     this.slashSwordRot = 140;
/*     */     this.stabSwordRot = 50;
/*     */     this.holdBowRot = 140;
/*  57 */     this.swordOffsetStab = new Vec3d(0.0D, -0.029999997854232782D, -0.2D); } public void func_70619_bc() { super.func_70619_bc();
/*  58 */     if (this.isPreparingTalk) {
/*     */       
/*  60 */       this.preparingTalkTick++;
/*     */       
/*  62 */       if (func_174791_d().equals(TARGET_POS) || this.preparingTalkTick > 40) {
/*     */         
/*  64 */         this.isPreparingTalk = false;
/*  65 */         this.preparingTalkTick = 0;
/*  66 */         setTargetYaw((this.field_70170_p.func_73046_m().func_184103_al().func_177451_a(playerSheHasSexWith())).field_70177_z + 180.0F);
/*  67 */         this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*  68 */         func_70661_as().func_75499_g();
/*     */         
/*  70 */         checkFollowUp();
/*     */       }
/*     */       else {
/*     */         
/*  74 */         this.field_70177_z = targetYaw().floatValue();
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/*  79 */           TARGET_POS.equals(null);
/*     */         }
/*  81 */         catch (NullPointerException e) {
/*  82 */           setTargetPos(getInFrontOfPlayer());
/*     */         } 
/*     */         
/*  85 */         func_189654_d(false);
/*  86 */         Vec3d nextPos = PenisMath.Lerp(func_174791_d(), targetPos(), 40 - this.preparingTalkTick);
/*     */         
/*  88 */         func_70107_b(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  93 */     if (this.lookingForBed)
/*     */     {
/*  95 */       if (func_174791_d().func_72438_d(targetPos()) < 0.6D || this.bedSearchTick > 200) {
/*     */         
/*  97 */         this.lookingForBed = false;
/*  98 */         this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*  99 */         this.bedSearchTick = 0;
/* 100 */         this.field_70145_X = true;
/* 101 */         func_189654_d(true);
/* 102 */         this.field_70159_w = 0.0D;
/* 103 */         this.field_70181_x = 0.0D;
/* 104 */         this.field_70179_y = 0.0D;
/*     */         
/* 106 */         setCurrentAction(GirlEntity.Action.ANAL_PREPARE);
/*     */       }
/*     */       else {
/*     */         
/* 110 */         this.bedSearchTick++;
/*     */         
/* 112 */         if (this.bedSearchTick == 60 || this.bedSearchTick == 120) {
/*     */           
/* 114 */           func_70661_as().func_75499_g();
/* 115 */           func_70661_as().func_75492_a((targetPos()).field_72450_a, (targetPos()).field_72448_b, (targetPos()).field_72449_c, 0.35D);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 120 */     if (currentAction() == GirlEntity.Action.ANAL_WAIT) {
/*     */       
/* 122 */       EntityPlayer player = this.field_70170_p.func_72890_a((Entity)this, 15.0D);
/*     */       
/* 124 */       if (player != null && player.func_70032_d((Entity)this) < 1.0D) {
/*     */         
/* 126 */         player.field_70145_X = true;
/* 127 */         player.func_189654_d(true);
/* 128 */         PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(false), (EntityPlayerMP)player);
/* 129 */         player.func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 130 */         setPlayer(player.getPersistentID());
/* 131 */         moveCamera(-0.3D, -1.0D, -0.5D, player.field_70759_as, this.field_70125_A);
/* 132 */         setCurrentAction(GirlEntity.Action.ANAL_START);
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCloseUiWithoutHavingChosen() {
/* 140 */     return (playerSheHasSexWith() == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_184645_a(EntityPlayer player, EnumHand hand) {
/* 146 */     if (super.func_184645_a(player, hand)) {
/* 147 */       return true;
/*     */     }
/* 149 */     ItemStack itemstack = player.func_184586_b(hand);
/* 150 */     boolean hasNameTag = (itemstack.func_77973_b() == Items.field_151057_cb);
/*     */     
/* 152 */     if (hasNameTag) {
/* 153 */       itemstack.func_111282_a(player, (EntityLivingBase)this, hand);
/* 154 */       return true;
/*     */     } 
/*     */     
/* 157 */     if (this.field_70170_p.field_72995_K && !openMenu(player)) {
/* 158 */       sayAround("I am busy at the moment~");
/*     */     }
/*     */ 
/*     */     
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean openMenu(EntityPlayer player) {
/* 168 */     if (playerSheHasSexWith() == null && (((String)this.field_70180_af.func_187225_a(MASTER)).equals("") || ((String)this.field_70180_af.func_187225_a(MASTER)).equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID().toString()))) {
/*     */       
/* 170 */       List<String> actions = new ArrayList<>(Arrays.asList(new String[] { "companion Set new home", "companion Go home", (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "Strip" : "Dress up", "Talk", "Head pat", ((String)this.field_70180_af.func_187225_a(MASTER)).equals("") ? "companion Follow me" : "companion Stop following me", "companion Equipment" }));
/*     */       
/* 172 */       String[] actionsArray = new String[actions.size()];
/* 173 */       actions.toArray(actionsArray);
/*     */       
/* 175 */       int[] prices = new int[actions.size()];
/* 176 */       Item[] items = new Item[actions.size()];
/*     */       
/* 178 */       Arrays.fill(prices, 0);
/* 179 */       Arrays.fill((Object[])items, (Object)null);
/* 180 */       renderMenu(player, this, actionsArray, prices, items);
/* 181 */       return true;
/*     */     } 
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void openSexMenu(EntityPlayer player) {
/* 189 */     List<String> actions = new ArrayList<>(Arrays.asList(new String[] { "Anal" }));
/*     */     
/* 191 */     String[] actionsArray = new String[actions.size()];
/* 192 */     actions.toArray(actionsArray);
/*     */     
/* 194 */     int[] prices = new int[actions.size()];
/* 195 */     Item[] items = new Item[actions.size()];
/*     */     
/* 197 */     Arrays.fill(prices, 0);
/* 198 */     Arrays.fill((Object[])items, (Object)null);
/* 199 */     renderMenu(player, this, actionsArray, prices, items);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doAction(String animationName, UUID player) {
/* 204 */     super.doAction(animationName, player);
/*     */     
/* 206 */     switch (animationName) {
/*     */       
/*     */       case "companion Follow me":
/* 209 */         sayAround("Heya lets Go!");
/* 210 */         playSoundAroundHer(SoundsHandler.GIRLS_BIA_HEY[3]);
/*     */         break;
/*     */       
/*     */       case "companion Stop following me":
/* 214 */         sayAround("Hey, don't just leave me like that hehe~");
/* 215 */         playSoundAroundHer(SoundsHandler.GIRLS_BIA_HEY[0]);
/*     */         break;
/*     */ 
/*     */       
/*     */       case "companion Go home":
/* 220 */         say("Me is going home nya~");
/*     */         break;
/*     */       
/*     */       case "Talk":
/* 224 */         setPlayer((Minecraft.func_71410_x()).field_71439_g.getPersistentID());
/* 225 */         changeDataParameterFromClient("playerSheHasSexWith", (Minecraft.func_71410_x()).field_71439_g.getPersistentID().toString());
/* 226 */         changeDataParameterFromClient("animationFollowUp", "talkHorny");
/* 227 */         prepareAction();
/*     */         break;
/*     */       
/*     */       case "Head pat":
/* 231 */         setPlayer((Minecraft.func_71410_x()).field_71439_g.getPersistentID());
/* 232 */         changeDataParameterFromClient("playerSheHasSexWith", (Minecraft.func_71410_x()).field_71439_g.getPersistentID().toString());
/* 233 */         changeDataParameterFromClient("animationFollowUp", "Headpat");
/* 234 */         prepareAction();
/*     */         break;
/*     */       
/*     */       case "Anal":
/* 238 */         changeDataParameterFromClient("animationFollowUp", "anal");
/* 239 */         setCurrentAction(GirlEntity.Action.TALK_RESPONSE);
/*     */         break;
/*     */       
/*     */       case "Dress up":
/*     */       case "Strip":
/* 244 */         setCurrentAction(GirlEntity.Action.STRIP);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   void prepareAction() {
/* 250 */     prepareAction(true, true);
/* 251 */     HandlePlayerMovement.setActive(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected <E extends software.bernie.geckolib3.core.IAnimatable> PlayState predicate(AnimationEvent<E> event) {
/* 256 */     if (this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) return null;
/*     */     
/* 258 */     switch (event.getController().getName()) {
/*     */ 
/*     */       
/*     */       case "eyes":
/* 262 */         if (currentAction() != GirlEntity.Action.NULL || !(currentAction()).autoBlink) {
/* 263 */           createAnimation("animation.bia.null", true, event);
/*     */           
/*     */           break;
/*     */         } 
/* 267 */         createAnimation("animation.bia.fhappy", true, event);
/*     */         break;
/*     */ 
/*     */       
/*     */       case "movement":
/* 272 */         if (currentAction() != GirlEntity.Action.NULL) {
/* 273 */           createAnimation("animation.bia.null", true, event);
/*     */           
/*     */           break;
/*     */         } 
/* 277 */         if (func_184218_aH()) {
/* 278 */           createAnimation("animation.bia.sit", true, event);
/*     */           
/*     */           break;
/*     */         } 
/* 282 */         if (Math.abs(this.field_70169_q - this.field_70165_t) + Math.abs(this.field_70166_s - this.field_70161_v) > 0.0D) {
/*     */           
/* 284 */           switch (getWalkSpeed()) {
/*     */             
/*     */             case NULL:
/* 287 */               createAnimation("animation.bia.run", true, event);
/*     */               break;
/*     */             
/*     */             case STRIP:
/* 291 */               createAnimation("animation.bia.fastwalk", true, event);
/*     */               break;
/*     */             
/*     */             case ATTACK:
/* 295 */               createAnimation("animation.bia.walk", true, event);
/*     */               break;
/*     */           } 
/*     */           
/* 299 */           this.field_70177_z = this.field_70759_as;
/*     */           break;
/*     */         } 
/* 302 */         createAnimation("animation.bia.idle", true, event);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "action":
/* 309 */         switch (currentAction()) {
/*     */           
/*     */           case NULL:
/* 312 */             createAnimation("animation.bia.null", true, event);
/*     */             break;
/*     */           
/*     */           case STRIP:
/* 316 */             createAnimation("animation.bia.strip", false, event);
/*     */             break;
/*     */           
/*     */           case ATTACK:
/* 320 */             createAnimation("animation.bia.attack" + this.nextAttack, false, event);
/*     */             break;
/*     */           
/*     */           case BOW:
/* 324 */             createAnimation("animation.bia.bowcharge", false, event);
/*     */             break;
/*     */           
/*     */           case RIDE:
/* 328 */             createAnimation("animation.bia.ride", true, event);
/*     */             break;
/*     */           
/*     */           case SIT:
/* 332 */             createAnimation("animation.bia.sit", true, event);
/*     */             break;
/*     */           
/*     */           case THROW_PEARL:
/* 336 */             createAnimation("animation.bia.throwpearl", false, event);
/*     */             break;
/*     */           
/*     */           case DOWNED:
/* 340 */             createAnimation("animation.bia.downed", true, event);
/*     */             break;
/*     */           
/*     */           case TALK_HORNY:
/* 344 */             createAnimation("animation.bia.talk_horny", false, event);
/*     */             break;
/*     */           
/*     */           case TALK_IDLE:
/* 348 */             createAnimation("animation.bia.talk_idle", true, event);
/*     */             break;
/*     */           
/*     */           case TALK_RESPONSE:
/* 352 */             createAnimation("animation.bia.talk_response", true, event);
/*     */             break;
/*     */           
/*     */           case ANAL_PREPARE:
/* 356 */             createAnimation("animation.bia.anal_prepare", false, event);
/*     */             break;
/*     */           
/*     */           case ANAL_WAIT:
/* 360 */             createAnimation("animation.bia.anal_wait", false, event);
/*     */             break;
/*     */           
/*     */           case ANAL_START:
/* 364 */             createAnimation("animation.bia.anal_start", true, event);
/*     */             break;
/*     */           
/*     */           case ANAL_SLOW:
/* 368 */             createAnimation("animation.bia.anal_slow", true, event);
/*     */             break;
/*     */           
/*     */           case ANAL_FAST:
/* 372 */             createAnimation("animation.bia.anal_fast", true, event);
/*     */             break;
/*     */           
/*     */           case ANAL_CUM:
/* 376 */             createAnimation("animation.bia.anal_cum", false, event);
/*     */             break;
/*     */           
/*     */           case HEAD_PAT:
/* 380 */             createAnimation("animation.bia.headpat", false, event);
/*     */             break;
/*     */         } 
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 387 */     return PlayState.CONTINUE;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerControllers(AnimationData data) {
/* 393 */     super.registerControllers(data);
/*     */     
/* 395 */     AnimationController.ISoundListener actionSoundListener = event -> {
/*     */         switch (event.sound) {
/*     */           case "attackSound":
/*     */             playSoundAroundHer(SoundEvents.field_187727_dV);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "attackDone":
/*     */             setCurrentAction(GirlEntity.Action.NULL);
/*     */             if (++this.nextAttack == 3) {
/*     */               this.nextAttack = 0;
/*     */             }
/*     */             break;
/*     */ 
/*     */           
/*     */           case "becomeNude":
/*     */             changeDataParameterFromClient("currentModel", (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "0" : "1");
/*     */             break;
/*     */ 
/*     */           
/*     */           case "stripDone":
/*     */             resetGirl();
/*     */             checkFollowUp();
/*     */             break;
/*     */ 
/*     */           
/*     */           case "stripMSG1":
/*     */             say("Hihi~");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_BIA_GIGGLE));
/*     */             break;
/*     */ 
/*     */           
/*     */           case "sexUiOn":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */             }
/*     */             break;
/*     */ 
/*     */           
/*     */           case "pearl":
/*     */             PacketHandler.INSTANCE.sendToServer((IMessage)new SendCompanionHome(girlId()));
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_hornyMSG1":
/*     */             sayAround("Heyaaa~");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_HEY[3]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_hornyMSG2":
/*     */             sayAround("I am Hornyyyyy~");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_GIGGLE[2]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_hornyMSG3":
/*     */             sayAround("So...");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_BREATH[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_hornyMSG4":
/*     */             sayAround("Are we gonna have some fun nyaa?");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_HUH[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_hornyDone":
/*     */             setCurrentAction(GirlEntity.Action.TALK_IDLE);
/*     */             if (belongsToPlayer()) {
/*     */               openSexMenu((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g);
/*     */             }
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_responseMSG1":
/*     */             sayAround("Huh?!...");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_HUH[2]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_responseMSG2":
/*     */             sayAround("I... uhm...");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_BREATH[1]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_responseMSG3":
/*     */             sayAround("yes~");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_GIGGLE[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "talk_responseDone":
/*     */             resetPlayer();
/*     */             if (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() != 0) {
/*     */               setCurrentAction(GirlEntity.Action.STRIP);
/*     */               break;
/*     */             } 
/*     */             checkFollowUp();
/*     */             break;
/*     */ 
/*     */           
/*     */           case "anal_prepareMSG1":
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */           
/*     */           case "anal_prepareMSG2":
/*     */             playSoundAroundHer(SoundsHandler.MISC_BEDRUSTLE[0]);
/*     */             break;
/*     */           
/*     */           case "anal_prepareDone":
/*     */             setCurrentAction(GirlEntity.Action.ANAL_WAIT);
/*     */             break;
/*     */           
/*     */           case "anal_startMSG1":
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_MMM[3]);
/*     */             playSoundAroundHer(SoundsHandler.MISC_POUNDING[34]);
/*     */             break;
/*     */           
/*     */           case "anal_fastMSG1":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.02D);
/*     */             }
/*     */           
/*     */           case "anal_slowMSG1":
/*     */           case "anal_startMSG2":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.addCumPercentage(0.02D);
/*     */             }
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.5F);
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_BIA_AHH));
/*     */             break;
/*     */           
/*     */           case "anal_fastDone":
/*     */             this.playerIsThrusting = HandlePlayerMovement.isThrusting;
/*     */             if (this.playerIsThrusting) {
/*     */               break;
/*     */             }
/*     */           
/*     */           case "anal_startDone":
/*     */             setCurrentAction(GirlEntity.Action.ANAL_SLOW);
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */             }
/*     */             break;
/*     */           
/*     */           case "anal_cumMSG2":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_BIA_AHH));
/*     */             break;
/*     */           
/*     */           case "anal_cumBlackScreen":
/*     */             if (belongsToPlayer()) {
/*     */               BlackScreenUI.activate();
/*     */             }
/*     */             break;
/*     */           
/*     */           case "anal_cumDone":
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.resetCumPercentage();
/*     */               resetGirl();
/*     */             } 
/*     */             break;
/*     */           
/*     */           case "headpatMSG1":
/*     */             sayAround("Ooh headpats!");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_BREATH[0]);
/*     */             break;
/*     */           
/*     */           case "headpatMSG2":
/*     */             sayAround("Hmmm.... :D");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_MMM[0]);
/*     */             break;
/*     */           
/*     */           case "headpatMSG3":
/*     */             sayAround("huh...?");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_HUH[0]);
/*     */             break;
/*     */           
/*     */           case "headpatMSG4":
/*     */             sayAround("Tanku hehe");
/*     */             playSoundAroundHer(SoundsHandler.GIRLS_BIA_GIGGLE[1]);
/*     */             break;
/*     */           
/*     */           case "headpatDone":
/*     */             resetGirl();
/*     */             break;
/*     */         } 
/*     */       
/*     */       };
/* 586 */     this.actionController.registerSoundListener(actionSoundListener);
/* 587 */     data.addAnimationController(this.actionController);
/*     */   }
/*     */   
/*     */   public void goForAnal() {
/* 591 */     BlockPos temp = findBed(func_180425_c());
/*     */ 
/*     */     
/* 594 */     if (temp == null) {
/*     */       
/* 596 */       playSoundAroundHer(SoundsHandler.GIRLS_BIA_BREATH[2]);
/* 597 */       sayAround("no bed in sight...");
/*     */     }
/*     */     else {
/*     */       
/* 601 */       this.field_70714_bg.func_85156_a((EntityAIBase)this.aiWander);
/* 602 */       this.field_70714_bg.func_85156_a((EntityAIBase)this.aiLookAtPlayer);
/*     */       
/* 604 */       Vec3d bedPos = new Vec3d(temp.func_177958_n(), temp.func_177956_o(), temp.func_177952_p());
/*     */ 
/*     */ 
/*     */       
/* 608 */       int[] yaws = { 0, 180, -90, 90 };
/*     */ 
/*     */       
/* 611 */       Vec3d[][] potentialSpaces = { { new Vec3d(0.5D, 0.0D, -0.5D), new Vec3d(0.0D, 0.0D, -1.0D) }, { new Vec3d(0.5D, 0.0D, 1.5D), new Vec3d(0.0D, 0.0D, 1.0D) }, { new Vec3d(-0.5D, 0.0D, 0.5D), new Vec3d(-1.0D, 0.0D, 0.0D) }, { new Vec3d(1.5D, 0.0D, 0.5D), new Vec3d(1.0D, 0.0D, 0.0D) } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 618 */       int whichOne = -1;
/*     */       
/* 620 */       for (int i = 0; i < potentialSpaces.length; i++) {
/*     */         
/* 622 */         Vec3d searchPos = bedPos.func_178787_e(potentialSpaces[i][1]);
/*     */         
/* 624 */         if (this.field_70170_p.func_180495_p(new BlockPos(searchPos.field_72450_a, searchPos.field_72448_b, searchPos.field_72449_c)).func_177230_c() == Blocks.field_150350_a)
/*     */         {
/* 626 */           if (whichOne == -1) {
/*     */             
/* 628 */             whichOne = i;
/*     */           }
/*     */           else {
/*     */             
/* 632 */             double oldDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72449_c);
/* 633 */             double newDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[i][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72449_c);
/*     */             
/* 635 */             if (newDistance < oldDistance)
/*     */             {
/* 637 */               whichOne = i;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/* 642 */       if (whichOne == -1) {
/*     */         
/* 644 */         playSoundAroundHer(SoundsHandler.GIRLS_BIA_BREATH[2]);
/* 645 */         sayAround("bed is obscured...");
/*     */         
/*     */         return;
/*     */       } 
/* 649 */       Vec3d targetPos = bedPos.func_178787_e(potentialSpaces[whichOne][0]);
/*     */       
/* 651 */       setTargetYaw(yaws[whichOne]);
/* 652 */       setTargetPos(targetPos);
/* 653 */       this.playerYaw = targetYaw().floatValue();
/*     */       
/* 655 */       func_70661_as().func_75499_g();
/* 656 */       func_70661_as().func_75492_a(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c, 0.35D);
/* 657 */       this.lookingForBed = true;
/* 658 */       this.bedSearchTick = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void thrust() {
/* 665 */     if (currentAction() == GirlEntity.Action.ANAL_FAST || currentAction() == GirlEntity.Action.ANAL_SLOW) {
/*     */       
/* 667 */       this.playerIsThrusting = true;
/*     */       
/* 669 */       if (currentAction() == GirlEntity.Action.ANAL_FAST) {
/*     */ 
/*     */         
/* 672 */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*     */       }
/*     */       else {
/*     */         
/* 676 */         setCurrentAction(GirlEntity.Action.ANAL_FAST);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cum() {
/* 684 */     if (currentAction() == GirlEntity.Action.ANAL_SLOW || currentAction() == GirlEntity.Action.ANAL_FAST) {
/*     */ 
/*     */       
/* 687 */       this.playerIsCumming = true;
/* 688 */       setCurrentAction(GirlEntity.Action.ANAL_CUM);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkFollowUp() {
/* 695 */     switch ((String)this.field_70180_af.func_187225_a(ANIMATION_FOLLOW_UP)) {
/*     */       
/*     */       case "talkHorny":
/* 698 */         setCurrentAction(GirlEntity.Action.TALK_HORNY);
/*     */         break;
/*     */       
/*     */       case "Headpat":
/* 702 */         setCurrentAction(GirlEntity.Action.HEAD_PAT);
/*     */         break;
/*     */       
/*     */       case "anal":
/* 706 */         resetGirl();
/* 707 */         PacketHandler.INSTANCE.sendToServer((IMessage)new SendGirlToBed(girlId()));
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 712 */     if (this.field_70170_p.field_72995_K) {
/* 713 */       changeDataParameterFromClient("animationFollowUp", "");
/*     */     } else {
/*     */       
/* 716 */       this.field_70180_af.func_187227_b(ANIMATION_FOLLOW_UP, "");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\bia\BiaEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */