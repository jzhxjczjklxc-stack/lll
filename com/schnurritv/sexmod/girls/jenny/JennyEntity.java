/*      */ package com.schnurritv.sexmod.girls.jenny;
/*      */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*      */ import com.schnurritv.sexmod.Packets.JennyAwaitPlayerDoggy;
/*      */ import com.schnurritv.sexmod.Packets.SendCompanionHome;
/*      */ import com.schnurritv.sexmod.Packets.SendGirlToBed;
/*      */ import com.schnurritv.sexmod.Packets.SetPlayerMovement;
/*      */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*      */ import com.schnurritv.sexmod.girls.GirlEntity;
/*      */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*      */ import com.schnurritv.sexmod.gui.SexUI;
/*      */ import com.schnurritv.sexmod.hornypotion.HornyPotion;
/*      */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*      */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*      */ import com.schnurritv.sexmod.util.PenisMath;
/*      */ import com.schnurritv.sexmod.util.Reference;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.block.state.IBlockState;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.init.SoundEvents;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.network.datasync.DataParameter;
/*      */ import net.minecraft.network.datasync.EntityDataManager;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.EnumHand;
/*      */ import net.minecraft.util.SoundEvent;
/*      */ import net.minecraft.util.math.BlockPos;
/*      */ import net.minecraft.util.math.Vec3d;
/*      */ import net.minecraft.util.math.Vec3i;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*      */ import net.minecraftforge.fml.relauncher.SideOnly;
/*      */ import software.bernie.geckolib3.core.PlayState;
/*      */ import software.bernie.geckolib3.core.controller.AnimationController;
/*      */ import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
/*      */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*      */ import software.bernie.geckolib3.core.manager.AnimationData;
/*      */ 
/*      */ public class JennyEntity extends GirlEntity {
/*      */   public boolean lookingForBed = false;
/*   50 */   public static final DataParameter<Boolean> isHorny = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187198_h).func_187156_b().func_187161_a(73); public boolean isPreparingPayment = false; public boolean awaitPlayer = false; int preparingPaymentTick; int bedSearchTick; int flip; boolean paizuriCamSide;
/*      */   
/*      */   public JennyEntity(World worldIn) {
/*   53 */     super(worldIn);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   96 */     this.preparingPaymentTick = 0;
/*   97 */     this.bedSearchTick = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  707 */     this.flip = 0;
/*  708 */     this.paizuriCamSide = false; func_70105_a(0.49F, 1.95F);
/*      */     this.girlName = "Jenny";
/*      */     this.slashSwordRot = 140;
/*      */     this.stabSwordRot = 50;
/*      */     this.holdBowRot = 140;
/*  713 */     this.swordOffsetStab = new Vec3d(0.0D, -0.029999997854232782D, -0.2D); } @SideOnly(Side.CLIENT) public void registerControllers(AnimationData data) { super.registerControllers(data);
/*      */     
/*  715 */     AnimationController.ISoundListener actionSoundListener = event -> {
/*      */         String playerName;
/*      */         int rand;
/*      */         UUID player;
/*      */         IBlockState state;
/*      */         switch (event.sound) {
/*      */           case "attackSound":
/*      */             playSoundAroundHer(SoundEvents.field_187727_dV);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "attackDone":
/*      */             setCurrentAction(GirlEntity.Action.NULL);
/*      */             if (++this.nextAttack == 3) {
/*      */               this.nextAttack = 0;
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "becomeNude":
/*      */             changeDataParameterFromClient("currentModel", (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "0" : "1");
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "stripDone":
/*      */             if (!((String)this.field_70180_af.func_187225_a(ANIMATION_FOLLOW_UP)).equals("boobjob")) {
/*      */               resetGirl();
/*      */             }
/*      */             checkFollowUp();
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "stripMSG1":
/*      */             say("Hihi~");
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_GIGGLE));
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "paymentMSG1":
/*      */             say("Huh?");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HUH[1]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "paymentMSG2":
/*      */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0], 0.5F);
/*      */             playerName = "<" + (Minecraft.func_71410_x()).field_71439_g.func_70005_c_() + "> ";
/*      */             switch ((String)this.field_70180_af.func_187225_a(ANIMATION_FOLLOW_UP)) {
/*      */               case "strip":
/*      */                 say(playerName + "show Bobs and vegana pls", true);
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case "blowjob":
/*      */                 say(playerName + "Give me the sucky sucky and these are yours", true);
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case "doggy":
/*      */                 say(playerName + "Give me the sex pls :)", true);
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case "boobjob":
/*      */                 say(playerName + "gib boba OwO", true);
/*      */                 break;
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*      */             say(playerName + "sex pls", true);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "paymentMSG3":
/*      */             say("Hehe~");
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_GIGGLE));
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "sexUiOn":
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.shouldBeRendered = true;
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "paymentMSG4":
/*      */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0], 0.25F);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "paymentDone":
/*      */             checkFollowUp();
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG1":
/*      */             say("What are you...");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_MMM[8]);
/*      */             this.playerYaw = this.field_70177_z + 180.0F;
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG2":
/*      */             say("eh... boys...");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[8]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG3":
/*      */             say("OHOhh...!");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_AFTERSESSIONMOAN[0]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG4":
/*      */             playSoundAroundHer(SoundsHandler.MISC_BELLJINGLE[0]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG5":
/*      */             say("Was this really necessary?!");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HMPH[1], 0.5F);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG6":
/*      */             say("Oh~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[8]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG7":
/*      */             say("You like it?~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_GIGGLE[4]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG8":
/*      */             say("<" + (Minecraft.func_71410_x()).field_71439_g.func_70005_c_() + "> Yee", true);
/*      */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0], 0.5F);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG9":
/*      */             say("Hihihi~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_GIGGLE[2]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG10":
/*      */             if (belongsToPlayer()) {
/*      */               moveCamera(-0.4D, -0.8D, -0.2D, 60.0F, -3.0F);
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG11":
/*      */             this.playerIsThrusting = false;
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_LIPSOUND));
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiMSG12":
/*      */             if (Reference.RANDOM.nextInt(5) == 0) {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_BJMOAN));
/*      */             }
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_LIPSOUND));
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjtMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MMM));
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_LIPSOUND));
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.04D);
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjiDone":
/*      */             setCurrentAction(GirlEntity.Action.SUCKBLOWJOB);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.shouldBeRendered = true;
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjtDone":
/*      */             setCurrentAction(GirlEntity.Action.SUCKBLOWJOB);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjtReady":
/*      */           case "doggyfastReady":
/*      */           case "paizuriReady":
/*      */             if (belongsToPlayer()) {
/*      */               this.playerIsThrusting = false;
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG1":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_BJMOAN[1]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG2":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_BJMOAN[7]);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.shouldBeRendered = false;
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG3":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_AFTERSESSIONMOAN[1]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG4":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[0]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG5":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[1]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG6":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[2]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcMSG7":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[3]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcBlackScreen":
/*      */             if (belongsToPlayer()) {
/*      */               BlackScreenUI.activate();
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "bjcDone":
/*      */           case "paizuri_cumDone":
/*      */           case "doggyCumDone":
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */               resetGirl();
/*      */             } 
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "doggyGoOnBedMSG1":
/*      */             playSoundAroundHer(SoundsHandler.MISC_BEDRUSTLE[0]);
/*      */             this.playerYaw = this.field_70177_z;
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "doggyGoOnBedMSG2":
/*      */             sayAround("what are you waiting for?~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING[9]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "doggyGoOnBedMSG3":
/*      */             sayAround("this ass ain't gonna fuck itself...");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_GIGGLE[0]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "doggyGoOnBedMSG4":
/*      */             playSoundAroundHer(SoundsHandler.MISC_SLAP[0], 0.75F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggyGoOnBedDone":
/*      */             PacketHandler.INSTANCE.sendToServer((IMessage)new JennyAwaitPlayerDoggy(girlId(), (Minecraft.func_71410_x()).field_71439_g.getPersistentID()));
/*      */             setCurrentAction(GirlEntity.Action.WAITDOGGY);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartMSG1":
/*      */             playSoundAroundHer(SoundsHandler.MISC_TOUCH[0]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartMSG2":
/*      */             playSoundAroundHer(SoundsHandler.MISC_TOUCH[1]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartMSG3":
/*      */             playSoundAroundHer(SoundsHandler.MISC_BEDRUSTLE[1], 0.5F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartMSG4":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_SMALLINSERTS));
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_MMM[1]);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartMSG5":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.33F);
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MOAN));
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggystartDone":
/*      */             setCurrentAction(GirlEntity.Action.DOGGYSLOW);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.shouldBeRendered = true;
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggyslowMSG1":
/*      */             this.playerIsThrusting = false;
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.33F);
/*      */             rand = Reference.RANDOM.nextInt(4);
/*      */             if (rand == 0) {
/*      */               rand = Reference.RANDOM.nextInt(2);
/*      */               if (rand == 0) {
/*      */                 playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MMM));
/*      */               } else {
/*      */                 playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MOAN));
/*      */               } 
/*      */             } else {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING));
/*      */             } 
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.00666D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggyslowMSG2":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_LIGHTBREATHING), 0.5F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggyfastMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             this.flip++;
/*      */             if (this.flip % 2 == 0) {
/*      */               int random = Reference.RANDOM.nextInt(2);
/*      */               if (random == 0) {
/*      */                 playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MOAN));
/*      */                 break;
/*      */               } 
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING));
/*      */               break;
/*      */             } 
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_AHH));
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggyfastDone":
/*      */             setCurrentAction(GirlEntity.Action.DOGGYSLOW);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggycumMSG1":
/*      */             playSoundAroundHer(SoundsHandler.MISC_CUMINFLATION[0], 2.0F);
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 2.0F);
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MOAN));
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggycumMSG2":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING[4]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggycumMSG3":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING[5]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggycumMSG4":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING[6]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "doggycumMSG5":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HEAVYBREATHING[7]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "pearl":
/*      */             PacketHandler.INSTANCE.sendToServer((IMessage)new SendCompanionHome(girlId()));
/*      */             break;
/*      */ 
/*      */           
/*      */           case "boobjob_camera":
/*      */             player = (Minecraft.func_71410_x()).field_71439_g.getPersistentID();
/*      */             if (player.equals(this.field_70170_p.func_72890_a((Entity)getGirl(), 2.0D).getPersistentID())) {
/*      */               this.playerYaw = (this.field_70170_p.func_152378_a(player)).field_70177_z;
/*      */               setPlayer(player);
/*      */               if (!this.paizuriCamSide) {
/*      */                 this.paizuriCamSide = true;
/*      */                 moveCamera(-0.7D, -0.6D, -0.2D, 60.0F, -3.0F);
/*      */               } 
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuri_startDone":
/*      */             if (belongsToPlayer()) {
/*      */               setCurrentAction(GirlEntity.Action.PAIZURI_SLOW);
/*      */               SexUI.resetCumPercentage();
/*      */               SexUI.shouldBeRendered = true;
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuriFastMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*      */             if (func_70681_au().nextBoolean()) {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_MMM));
/*      */             } else {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_AHH));
/*      */             } 
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.04D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuriSlowMSG1":
/*      */           case "paizuriStartMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuri_fastDone":
/*      */             setCurrentAction(GirlEntity.Action.PAIZURI_SLOW);
/*      */             if (belongsToPlayer() && !this.paizuriCamSide) {
/*      */               this.paizuriCamSide = true;
/*      */               moveCamera(-0.7D, -0.6D, -0.2D, 60.0F, -3.0F);
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuri_startStep":
/*      */             state = this.field_70170_p.func_180495_p(func_180425_c().func_177973_b(new Vec3i(0, 1, 0)));
/*      */             playSoundAroundHer(state.func_177230_c().getSoundType(state, this.field_70170_p, func_180425_c(), (Entity)this).func_185844_d());
/*      */             break;
/*      */ 
/*      */           
/*      */           case "paizuri_cumStart":
/*      */             if (belongsToPlayer() && !this.paizuriCamSide) {
/*      */               moveCamera(-0.7D, -0.6D, -0.2D, 60.0F, -3.0F);
/*      */             }
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       };
/* 1243 */     this.actionController.registerSoundListener(actionSoundListener);
/* 1244 */     data.addAnimationController(this.actionController); }
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*      */     super.func_70088_a();
/*      */     if (!this.field_70170_p.field_72995_K || !(this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld))
/*      */       this.field_70180_af.func_187214_a(isHorny, Boolean.valueOf(false)); 
/*      */   }
/*      */   
/*      */   public float func_70047_e() {
/*      */     return 1.64F;
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184639_G() {
/*      */     return null;
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184615_bR() {
/*      */     return SoundsHandler.Random(SoundsHandler.GIRLS_JENNY_SIGH);
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184601_bQ(DamageSource source) {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public void func_70619_bc() {
/*      */     super.func_70619_bc();
/*      */     EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 15.0D);
/*      */     if (this.awaitPlayer && closestPlayer != null && closestPlayer.func_174791_d().func_72438_d(func_174791_d()) < 0.5D) {
/*      */       this.awaitPlayer = false;
/*      */       this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, this.field_70170_p.func_72890_a((Entity)this, 15.0D).getPersistentID().toString());
/*      */       EntityPlayerMP playerMP = func_184102_h().func_184103_al().func_177451_a(playerSheHasSexWith());
/*      */       this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, playerMP.getPersistentID().toString());
/*      */       playerMP.func_70634_a((func_174791_d()).field_72450_a, (func_174791_d()).field_72448_b, (func_174791_d()).field_72449_c);
/*      */       TurnPlayerIntoCamera(playerMP, false);
/*      */       playerMP.func_191958_b(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       moveCamera(0.0D, 0.0D, 0.4D, 0.0F, 60.0F);
/*      */       this.playerCamPos = null;
/*      */       setCurrentAction(GirlEntity.Action.DOGGYSTART);
/*      */       PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(false), playerMP);
/*      */     } 
/*      */     if (this.lookingForBed)
/*      */       if (func_174791_d().func_72438_d(targetPos()) < 0.6D || this.bedSearchTick > 200) {
/*      */         this.lookingForBed = false;
/*      */         this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*      */         this.bedSearchTick = 0;
/*      */         this.field_70145_X = true;
/*      */         func_189654_d(true);
/*      */         this.field_70159_w = 0.0D;
/*      */         this.field_70181_x = 0.0D;
/*      */         this.field_70179_y = 0.0D;
/*      */         setCurrentAction(GirlEntity.Action.STARTDOGGY);
/*      */       } else {
/*      */         this.bedSearchTick++;
/*      */         if (this.bedSearchTick == 60 || this.bedSearchTick == 120) {
/*      */           func_70661_as().func_75499_g();
/*      */           func_70661_as().func_75492_a((targetPos()).field_72450_a, (targetPos()).field_72448_b, (targetPos()).field_72449_c, 0.35D);
/*      */         } 
/*      */       }  
/*      */     if (this.isPreparingPayment) {
/*      */       this.preparingPaymentTick++;
/*      */       if (func_174791_d().equals(TARGET_POS) || this.preparingPaymentTick > 40) {
/*      */         this.isPreparingPayment = false;
/*      */         this.preparingPaymentTick = 0;
/*      */         setTargetYaw((this.field_70170_p.func_73046_m().func_184103_al().func_177451_a(playerSheHasSexWith())).field_70177_z + 180.0F);
/*      */         this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*      */         func_70661_as().func_75499_g();
/*      */         if (!((Boolean)this.field_70180_af.func_187225_a(isHorny)).booleanValue()) {
/*      */           setCurrentAction(GirlEntity.Action.PAYMENT);
/*      */         } else {
/*      */           checkFollowUp();
/*      */         } 
/*      */       } else {
/*      */         this.field_70177_z = targetYaw().floatValue();
/*      */         try {
/*      */           TARGET_POS.equals(null);
/*      */         } catch (NullPointerException e) {
/*      */           setTargetPos(getInFrontOfPlayer());
/*      */         } 
/*      */         func_189654_d(false);
/*      */         Vec3d nextPos = PenisMath.Lerp(func_174791_d(), targetPos(), 40 - this.preparingPaymentTick);
/*      */         func_70107_b(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_184645_a(EntityPlayer player, EnumHand hand) {
/*      */     if (super.func_184645_a(player, hand))
/*      */       return true; 
/*      */     ItemStack itemstack = player.func_184586_b(hand);
/*      */     boolean hasNameTag = (itemstack.func_77973_b() == Items.field_151057_cb);
/*      */     if (hasNameTag) {
/*      */       itemstack.func_111282_a(player, (EntityLivingBase)this, hand);
/*      */       return true;
/*      */     } 
/*      */     if (this.field_70170_p.field_72995_K && !openMenu(player))
/*      */       sayAround("I am busy at the moment~"); 
/*      */     return true;
/*      */   }
/*      */   
/*      */   public void func_70071_h_() {
/*      */     super.func_70071_h_();
/*      */     if (!this.field_70170_p.field_72995_K)
/*      */       this.field_70180_af.func_187227_b(isHorny, Boolean.valueOf(func_70644_a(HornyPotion.HORNY_EFFECT))); 
/*      */   }
/*      */   
/*      */   public boolean openMenu(EntityPlayer player) {
/*      */     if (playerSheHasSexWith() == null && (((String)this.field_70180_af.func_187225_a(MASTER)).equals("") || ((String)this.field_70180_af.func_187225_a(MASTER)).equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID().toString()))) {
/*      */       List<String> actions = new ArrayList<>(Arrays.asList(new String[] { "Blowjob", "Boobjob", "Doggy", (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "Strip" : "Dress up", "companion Set new home", "companion Go home", ((String)this.field_70180_af.func_187225_a(MASTER)).equals("") ? "companion Follow me" : "companion Stop following me", "companion Equipment" }));
/*      */       String[] actionsArray = new String[actions.size()];
/*      */       actions.toArray(actionsArray);
/*      */       int[] prices = new int[actions.size()];
/*      */       Item[] items = new Item[actions.size()];
/*      */       Arrays.fill(prices, 0);
/*      */       Arrays.fill((Object[])items, (Object)null);
/*      */       if (!((Boolean)this.field_70180_af.func_187225_a(isHorny)).booleanValue()) {
/*      */         items[0] = Items.field_151166_bC;
/*      */         prices[0] = 3;
/*      */         items[1] = Items.field_151079_bi;
/*      */         prices[1] = 2;
/*      */         items[2] = Items.field_151045_i;
/*      */         prices[2] = 2;
/*      */         if (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) {
/*      */           items[3] = Items.field_151043_k;
/*      */           prices[3] = 1;
/*      */         } 
/*      */       } 
/*      */       renderMenu(player, this, actionsArray, prices, items);
/*      */       return true;
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean canCloseUiWithoutHavingChosen() {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public void doAction(String animationName, UUID player) {
/*      */     super.doAction(animationName, player);
/*      */     switch (animationName) {
/*      */       case "companion Follow me":
/*      */         sayAround(String.format("Okay! I am right behind you %s~", new Object[] { ((EntityPlayer)Objects.<EntityPlayer>requireNonNull(this.field_70170_p.func_152378_a(player))).func_70005_c_() }));
/*      */         playSoundAroundHer(SoundsHandler.GIRLS_JENNY_GIGGLE[4]);
/*      */         break;
/*      */       case "companion Stop following me":
/*      */         sayAround("Oh.. well.. cya~");
/*      */         playSoundAroundHer(SoundsHandler.GIRLS_JENNY_SADOH[1]);
/*      */         break;
/*      */       case "companion Go home":
/*      */         say("Alright, I'm going home. Cya~");
/*      */         break;
/*      */       case "Blowjob":
/*      */         setPlayer(player);
/*      */         prepareBlowjob();
/*      */         break;
/*      */       case "Boobjob":
/*      */         setPlayer(player);
/*      */         prepareBoobjob();
/*      */         break;
/*      */       case "Doggy":
/*      */         setPlayer(player);
/*      */         prepareDoggy();
/*      */         break;
/*      */       case "Strip":
/*      */         setPlayer(player);
/*      */         prepareStrip();
/*      */         break;
/*      */       case "Dress up":
/*      */         setCurrentAction(GirlEntity.Action.STRIP);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void prepareAction(boolean shouldPreparePayment) {
/*      */     prepareAction(shouldPreparePayment, true);
/*      */     HandlePlayerMovement.setActive(false);
/*      */   }
/*      */   
/*      */   protected void prepareStrip() {
/*      */     prepareAction(true);
/*      */     changeDataParameterFromClient("animationFollowUp", "strip");
/*      */   }
/*      */   
/*      */   private void prepareBlowjob() {
/*      */     prepareAction(true);
/*      */     changeDataParameterFromClient("animationFollowUp", "blowjob");
/*      */   }
/*      */   
/*      */   private void prepareBoobjob() {
/*      */     prepareAction(true);
/*      */     changeDataParameterFromClient("animationFollowUp", "boobjob");
/*      */   }
/*      */   
/*      */   private void prepareDoggy() {
/*      */     prepareAction(true);
/*      */     changeDataParameterFromClient("animationFollowUp", "doggy");
/*      */   }
/*      */   
/*      */   public void goForDoggy() {
/*      */     BlockPos temp = findBed(func_180425_c());
/*      */     if (temp == null) {
/*      */       playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HMPH[2]);
/*      */       sayAround("no bed in sight...");
/*      */     } else {
/*      */       this.field_70714_bg.func_85156_a((EntityAIBase)this.aiWander);
/*      */       this.field_70714_bg.func_85156_a((EntityAIBase)this.aiLookAtPlayer);
/*      */       Vec3d bedPos = new Vec3d(temp.func_177958_n(), temp.func_177956_o(), temp.func_177952_p());
/*      */       int[] yaws = { 0, 180, -90, 90 };
/*      */       Vec3d[][] potentialSpaces = { { new Vec3d(0.5D, 0.0D, -0.5D), new Vec3d(0.0D, 0.0D, -1.0D) }, { new Vec3d(0.5D, 0.0D, 1.5D), new Vec3d(0.0D, 0.0D, 1.0D) }, { new Vec3d(-0.5D, 0.0D, 0.5D), new Vec3d(-1.0D, 0.0D, 0.0D) }, { new Vec3d(1.5D, 0.0D, 0.5D), new Vec3d(1.0D, 0.0D, 0.0D) } };
/*      */       int whichOne = -1;
/*      */       for (int i = 0; i < potentialSpaces.length; i++) {
/*      */         Vec3d searchPos = bedPos.func_178787_e(potentialSpaces[i][1]);
/*      */         if (this.field_70170_p.func_180495_p(new BlockPos(searchPos.field_72450_a, searchPos.field_72448_b, searchPos.field_72449_c)).func_177230_c() == Blocks.field_150350_a)
/*      */           if (whichOne == -1) {
/*      */             whichOne = i;
/*      */           } else {
/*      */             double oldDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72449_c);
/*      */             double newDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[i][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72449_c);
/*      */             if (newDistance < oldDistance)
/*      */               whichOne = i; 
/*      */           }  
/*      */       } 
/*      */       if (whichOne == -1) {
/*      */         playSoundAroundHer(SoundsHandler.GIRLS_JENNY_HMPH[2]);
/*      */         sayAround("bed is obscured...");
/*      */         return;
/*      */       } 
/*      */       Vec3d targetPos = bedPos.func_178787_e(potentialSpaces[whichOne][0]);
/*      */       setTargetYaw(yaws[whichOne]);
/*      */       setTargetPos(new Vec3d(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c));
/*      */       this.playerYaw = targetYaw().floatValue();
/*      */       func_70661_as().func_75499_g();
/*      */       func_70661_as().func_75492_a(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c, 0.35D);
/*      */       this.lookingForBed = true;
/*      */       this.bedSearchTick = 0;
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void cum() {
/*      */     if (currentAction() == GirlEntity.Action.SUCKBLOWJOB || currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*      */       this.playerIsCumming = true;
/*      */       this.actionController.transitionLengthTicks = 2.0D;
/*      */       setCurrentAction(GirlEntity.Action.CUMBLOWJOB);
/*      */       moveCamera(0.0D, 0.0D, 0.0D, 0.0F, 70.0F);
/*      */     } else if (currentAction() == GirlEntity.Action.DOGGYSLOW || currentAction() == GirlEntity.Action.DOGGYFAST) {
/*      */       this.playerIsCumming = true;
/*      */       this.actionController.transitionLengthTicks = 2.0D;
/*      */       setCurrentAction(GirlEntity.Action.DOGGYCUM);
/*      */     } else if (currentAction() == GirlEntity.Action.PAIZURI_FAST || currentAction() == GirlEntity.Action.PAIZURI_SLOW) {
/*      */       this.playerIsCumming = true;
/*      */       this.actionController.transitionLengthTicks = 2.0D;
/*      */       setCurrentAction(GirlEntity.Action.PAIZURI_CUM);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void thrust() {
/*      */     if (currentAction() == GirlEntity.Action.SUCKBLOWJOB || currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*      */       this.playerIsThrusting = true;
/*      */       if (currentAction() == GirlEntity.Action.THRUSTBLOWJOB) {
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*      */       } else {
/*      */         setCurrentAction(GirlEntity.Action.THRUSTBLOWJOB);
/*      */       } 
/*      */     } else if (currentAction() == GirlEntity.Action.DOGGYSLOW || currentAction() == GirlEntity.Action.DOGGYFAST) {
/*      */       this.playerIsThrusting = true;
/*      */       if (currentAction() == GirlEntity.Action.DOGGYFAST) {
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*      */       } else {
/*      */         setCurrentAction(GirlEntity.Action.DOGGYFAST);
/*      */       } 
/*      */     } else if (currentAction() == GirlEntity.Action.PAIZURI_SLOW || currentAction() == GirlEntity.Action.PAIZURI_FAST) {
/*      */       this.playerIsThrusting = true;
/*      */       if (this.paizuriCamSide) {
/*      */         this.paizuriCamSide = false;
/*      */         moveCamera(0.0D, 0.0D, 0.0D, 0.0F, 70.0F);
/*      */       } 
/*      */       if (currentAction() == GirlEntity.Action.PAIZURI_FAST) {
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*      */       } else {
/*      */         setCurrentAction(GirlEntity.Action.PAIZURI_FAST);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void checkFollowUp() {
/*      */     switch ((String)this.field_70180_af.func_187225_a(ANIMATION_FOLLOW_UP)) {
/*      */       case "strip":
/*      */         resetPlayer();
/*      */         setCurrentAction(GirlEntity.Action.STRIP);
/*      */         break;
/*      */       case "blowjob":
/*      */         setCurrentAction(GirlEntity.Action.STARTBLOWJOB);
/*      */         break;
/*      */       case "boobjob":
/*      */         if (((Integer)this.field_70180_af.func_187225_a(GirlEntity.CURRENT_MODEL)).intValue() != 0) {
/*      */           setCurrentAction(GirlEntity.Action.STRIP);
/*      */           return;
/*      */         } 
/*      */         setCurrentAction(GirlEntity.Action.PAIZURI_START);
/*      */         break;
/*      */       case "doggy":
/*      */         if (((Integer)this.field_70180_af.func_187225_a(GirlEntity.CURRENT_MODEL)).intValue() != 0) {
/*      */           setCurrentAction(GirlEntity.Action.STRIP);
/*      */           resetPlayer();
/*      */           return;
/*      */         } 
/*      */         resetGirl();
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new SendGirlToBed(girlId()));
/*      */         break;
/*      */     } 
/*      */     if (this.field_70170_p.field_72995_K) {
/*      */       changeDataParameterFromClient("animationFollowUp", "");
/*      */     } else {
/*      */       this.field_70180_af.func_187227_b(ANIMATION_FOLLOW_UP, "");
/*      */     } 
/*      */   }
/*      */   
/*      */   protected <E extends software.bernie.geckolib3.core.IAnimatable> PlayState predicate(AnimationEvent<E> event) {
/*      */     if (this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)
/*      */       return null; 
/*      */     switch (event.getController().getName()) {
/*      */       case "eyes":
/*      */         if (currentAction() != GirlEntity.Action.NULL || !(currentAction()).autoBlink) {
/*      */           createAnimation("animation.jenny.null", true, event);
/*      */           break;
/*      */         } 
/*      */         createAnimation("animation.jenny.fhappy", true, event);
/*      */         break;
/*      */       case "movement":
/*      */         if (currentAction() != GirlEntity.Action.NULL) {
/*      */           createAnimation("animation.jenny.null", true, event);
/*      */           break;
/*      */         } 
/*      */         if (func_184218_aH()) {
/*      */           createAnimation("animation.jenny.sit", true, event);
/*      */           break;
/*      */         } 
/*      */         if (Math.abs(this.field_70169_q - this.field_70165_t) + Math.abs(this.field_70166_s - this.field_70161_v) > 0.0D) {
/*      */           switch (getWalkSpeed()) {
/*      */             case NULL:
/*      */               createAnimation("animation.jenny.run", true, event);
/*      */               break;
/*      */             case STRIP:
/*      */               createAnimation("animation.jenny.fastwalk", true, event);
/*      */               break;
/*      */             case PAYMENT:
/*      */               createAnimation("animation.jenny.walk", true, event);
/*      */               break;
/*      */           } 
/*      */           this.field_70177_z = this.field_70759_as;
/*      */           break;
/*      */         } 
/*      */         createAnimation("animation.jenny.idle", true, event);
/*      */         break;
/*      */       case "action":
/*      */         switch (currentAction()) {
/*      */           case NULL:
/*      */             createAnimation("animation.jenny.null", true, event);
/*      */             break;
/*      */           case STRIP:
/*      */             createAnimation("animation.jenny.strip", false, event);
/*      */             break;
/*      */           case PAYMENT:
/*      */             createAnimation("animation.jenny.payment", false, event);
/*      */             break;
/*      */           case STARTBLOWJOB:
/*      */             createAnimation("animation.jenny.blowjobintro", false, event);
/*      */             break;
/*      */           case SUCKBLOWJOB:
/*      */             createAnimation("animation.jenny.blowjobsuck", true, event);
/*      */             break;
/*      */           case THRUSTBLOWJOB:
/*      */             createAnimation("animation.jenny.blowjobthrust", false, event);
/*      */             break;
/*      */           case CUMBLOWJOB:
/*      */             createAnimation("animation.jenny.blowjobcum", false, event);
/*      */             break;
/*      */           case STARTDOGGY:
/*      */             createAnimation("animation.jenny.doggygoonbed", false, event);
/*      */             break;
/*      */           case WAITDOGGY:
/*      */             createAnimation("animation.jenny.doggywait", true, event);
/*      */             break;
/*      */           case DOGGYSTART:
/*      */             createAnimation("animation.jenny.doggystart", false, event);
/*      */             break;
/*      */           case DOGGYSLOW:
/*      */             createAnimation("animation.jenny.doggyslow", true, event);
/*      */             break;
/*      */           case DOGGYFAST:
/*      */             createAnimation("animation.jenny.doggyfast", false, event);
/*      */             break;
/*      */           case DOGGYCUM:
/*      */             createAnimation("animation.jenny.doggycum", false, event);
/*      */             break;
/*      */           case ATTACK:
/*      */             createAnimation("animation.jenny.attack" + this.nextAttack, false, event);
/*      */             break;
/*      */           case BOW:
/*      */             createAnimation("animation.jenny.bowcharge", false, event);
/*      */             break;
/*      */           case RIDE:
/*      */             createAnimation("animation.jenny.ride", true, event);
/*      */             break;
/*      */           case SIT:
/*      */             createAnimation("animation.jenny.sit", true, event);
/*      */             break;
/*      */           case THROW_PEARL:
/*      */             createAnimation("animation.jenny.throwpearl", false, event);
/*      */             break;
/*      */           case DOWNED:
/*      */             createAnimation("animation.jenny.downed", true, event);
/*      */             break;
/*      */           case PAIZURI_START:
/*      */             createAnimation("animation.jenny.paizuri_start", false, event);
/*      */             break;
/*      */           case PAIZURI_SLOW:
/*      */             createAnimation("animation.jenny.paizuri_slow", true, event);
/*      */             break;
/*      */           case PAIZURI_FAST:
/*      */             createAnimation("animation.jenny.paizuri_fast", true, event);
/*      */             break;
/*      */           case PAIZURI_CUM:
/*      */             createAnimation("animation.jenny.paizuri_cum", false, event);
/*      */             break;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     return PlayState.CONTINUE;
/*      */   }
/*      */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\jenny\JennyEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */