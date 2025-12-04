/*      */ package com.schnurritv.sexmod.girls.ellie;
/*      */ import com.schnurritv.sexmod.Packets.ChangeDataParameter;
/*      */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*      */ import com.schnurritv.sexmod.Packets.SendCompanionHome;
/*      */ import com.schnurritv.sexmod.Packets.SendEllieToPlayer;
/*      */ import com.schnurritv.sexmod.Packets.SendGirlToBed;
/*      */ import com.schnurritv.sexmod.Packets.SetPlayerMovement;
/*      */ import com.schnurritv.sexmod.Packets.TeleportPlayer;
/*      */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*      */ import com.schnurritv.sexmod.girls.GirlEntity;
/*      */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*      */ import com.schnurritv.sexmod.gui.SexUI;
/*      */ import com.schnurritv.sexmod.hornypotion.HornyPotion;
/*      */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*      */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*      */ import com.schnurritv.sexmod.util.Reference;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityPlayerSP;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.SoundEvents;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.EnumHand;
/*      */ import net.minecraft.util.SoundEvent;
/*      */ import net.minecraft.util.math.BlockPos;
/*      */ import net.minecraft.util.math.Vec3d;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*      */ import net.minecraftforge.fml.relauncher.Side;
/*      */ import net.minecraftforge.fml.relauncher.SideOnly;
/*      */ import software.bernie.geckolib3.core.PlayState;
/*      */ import software.bernie.geckolib3.core.controller.AnimationController;
/*      */ import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
/*      */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*      */ import software.bernie.geckolib3.core.manager.AnimationData;
/*      */ 
/*      */ public class EllieEntity extends GirlEntity {
/*   46 */   public float delayedRot = 0.0F;
/*      */   public boolean delayNewRot = false;
/*      */   public boolean awaitPlayer = false;
/*      */   public boolean lookingForBed = false;
/*      */   public boolean isPreparingPayment = false;
/*      */   public boolean isBusy = false;
/*   52 */   public float hornyLevel = 3200.0F;
/*      */   
/*      */   static final float HORNY_SEX_LEVEL = 4800.0F;
/*      */   
/*      */   static final float HORNY_RANGE = 10.0F;
/*   57 */   public int delayedRotTick = 0;
/*   58 */   public int bedSearchTick = -1;
/*   59 */   public int sexDelayTick = -1;
/*      */   boolean moanBreak;
/*      */   
/*   62 */   public EllieEntity(World worldIn) { super(worldIn);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  713 */     this.moanBreak = false; func_70105_a(0.49F, 1.95F);
/*      */     this.girlName = "Ellie";
/*      */     this.slashSwordRot = -85;
/*      */     this.stabSwordRot = -175;
/*      */     this.holdBowRot = -85;
/*  718 */     this.swordOffsetStab = new Vec3d(-0.1D, 0.05D, 0.0D); } @SideOnly(Side.CLIENT) public void registerControllers(AnimationData data) { super.registerControllers(data);
/*      */     
/*  720 */     AnimationController.ISoundListener actionSoundListener = event -> {
/*      */         EntityPlayer player;
/*      */         EntityPlayerSP entityPlayerSP2;
/*      */         EntityPlayerSP entityPlayerSP1;
/*      */         switch (event.sound) {
/*      */           case "becomeNude":
/*      */             changeDataParameterFromClient("currentModel", (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "0" : "1");
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "stripDone":
/*      */             setCurrentAction(null);
/*      */             resetGirl();
/*      */             checkFollowUp();
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "dashMSG1":
/*      */             player = this.field_70170_p.func_72890_a((Entity)girl(), 15.0D);
/*      */             if (player != null) {
/*      */               Vec3d distance = func_174791_d().func_178788_d(player.func_174791_d());
/*      */               float chosenDegrees = (float)Math.atan2(distance.field_72449_c, distance.field_72450_a) * 57.29578F;
/*      */               this.field_70177_z = chosenDegrees;
/*      */               this.field_70759_as = chosenDegrees;
/*      */               this.field_70761_aq = chosenDegrees;
/*      */             } 
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "dashReady":
/*      */             if (isClosestPlayer()) {
/*      */               PacketHandler.INSTANCE.sendToServer((IMessage)new SendEllieToPlayer(girlId()));
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "dashDone":
/*      */             setCurrentAction(GirlEntity.Action.HUG);
/*      */             player = this.field_70170_p.func_72890_a((Entity)girl(), 15.0D);
/*      */             if (player != null) {
/*      */               float chosenDegrees = player.field_70177_z;
/*      */               this.field_70177_z = chosenDegrees;
/*      */               this.field_70759_as = chosenDegrees;
/*      */               this.field_70761_aq = chosenDegrees;
/*      */             } 
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugMSG1":
/*      */             entityPlayerSP2 = (Minecraft.func_71410_x()).field_71439_g;
/*      */             if (entityPlayerSP2.getPersistentID().equals(playerSheHasSexWith()) || entityPlayerSP2.func_110124_au().equals(playerSheHasSexWith())) {
/*      */               PacketHandler.INSTANCE.sendToServer((IMessage)new TeleportPlayer(entityPlayerSP2.func_110124_au().toString(), entityPlayerSP2.func_174791_d(), ((EntityPlayer)entityPlayerSP2).field_70177_z - 80.0F, ((EntityPlayer)entityPlayerSP2).field_70125_A));
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugMSG2":
/*      */             say("Hmm...");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[0]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugMSG3":
/*      */             say("Hey!");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[1]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugMSG4":
/*      */             say("Mommy is horny");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[2]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugMSG5":
/*      */             say("so... what am I gonna do with you now, darling~ ?");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[3]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugDone":
/*      */             entityPlayerSP1 = (Minecraft.func_71410_x()).field_71439_g;
/*      */             if (entityPlayerSP1.getPersistentID().equals(playerSheHasSexWith())) {
/*      */               setCurrentAction(GirlEntity.Action.HUGIDLE);
/*      */               openMenu((EntityPlayer)entityPlayerSP1);
/*      */             } 
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugselectedMSG1":
/*      */             say("Mhm.. I know~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[4]);
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case "hugselectedMSG2":
/*      */             say("follow me, darling~");
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[5]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "hugselectedDone":
/*      */             if (isClosestPlayer()) {
/*      */               setCurrentAction(GirlEntity.Action.NULL);
/*      */               Vec3d newPos = func_174791_d();
/*      */               newPos = newPos.func_72441_c(-Math.sin((this.field_70177_z + 90.0F) * 0.017453292519943295D) * -0.7803124785423279D, 0.0D, Math.cos((this.field_70177_z + 90.0F) * 0.017453292519943295D) * -0.7803124785423279D);
/*      */               newPos = newPos.func_72441_c(-Math.sin(this.field_70177_z * 0.017453292519943295D) * 0.5296875238418579D, 0.0D, Math.cos(this.field_70177_z * 0.017453292519943295D) * 0.5296875238418579D);
/*      */               String newPosString = newPos.field_72450_a + "f" + newPos.field_72448_b + "f" + newPos.field_72449_c + "f";
/*      */               PacketHandler.INSTANCE.sendToServer((IMessage)new ChangeDataParameter(girlId(), "targetPos", newPosString));
/*      */               resetGirl();
/*      */               PacketHandler.INSTANCE.sendToServer((IMessage)new SendGirlToBed(girlId()));
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "sitdownMSG1":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[6]);
/*      */             if (isClosestPlayer()) {
/*      */               sayAround("Come to mommy~");
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "sitdownDone":
/*      */             if (isClosestPlayer()) {
/*      */               setCurrentAction(GirlEntity.Action.SITDOWNIDLE);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlStartMSG0":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[7]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlStartMSG1":
/*      */             if (isClosestPlayer()) {
/*      */               sayAround("Do you like what you see honey?~");
/*      */             }
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlStartMSG2":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlStartDone":
/*      */             if (belongsToPlayer()) {
/*      */               setCurrentAction(GirlEntity.Action.COWGIRLSLOW);
/*      */               SexUI.shouldBeRendered = true;
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlfastMSG1":
/*      */             if (this.moanBreak) {
/*      */               this.moanBreak = false;
/*      */             } else {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             } 
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.04D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_fastReady":
/*      */             this.playerIsThrusting = false;
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlfastReady":
/*      */             this.playerIsThrusting = false;
/*      */             if (belongsToPlayer()) {
/*      */               if (!HandlePlayerMovement.isThrusting) {
/*      */                 setCurrentAction(GirlEntity.Action.COWGIRLSLOW);
/*      */                 break;
/*      */               } 
/*      */               if (Reference.RANDOM.nextInt(4) != 1) {
/*      */                 this.actionController.clearAnimationCache();
/*      */               }
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlfastdomMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             if (belongsToPlayer()) {
/*      */               String msg;
/*      */               SexUI.addCumPercentage(0.2D);
/*      */               switch (Reference.RANDOM.nextInt(5)) {
/*      */                 case 0:
/*      */                   msg = "ahh.. fuuck..";
/*      */                   playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_INSULT[0]);
/*      */                   break;
/*      */ 
/*      */                 
/*      */                 case 1:
/*      */                   msg = "...fucking slut..!";
/*      */                   this.moanBreak = true;
/*      */                   playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_INSULT[1]);
/*      */                   break;
/*      */ 
/*      */                 
/*      */                 case 2:
/*      */                   msg = "...slut";
/*      */                   playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_INSULT[2]);
/*      */                   break;
/*      */ 
/*      */                 
/*      */                 case 3:
/*      */                   msg = "you fucking whore...!";
/*      */                   this.moanBreak = true;
/*      */                   playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_INSULT[3]);
/*      */                   break;
/*      */ 
/*      */                 
/*      */                 default:
/*      */                   msg = "whore hmmh...!";
/*      */                   playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_INSULT[4]);
/*      */                   break;
/*      */               } 
/*      */ 
/*      */               
/*      */               sayAround(msg);
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG2":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_ORGASM[1]);
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG3":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING), 0.75F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG4":
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.shouldBeRendered = false;
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG5":
/*      */           case "missionary_cumMSG2":
/*      */             playSoundAroundHer(SoundsHandler.GIRLS_ELLIE_DIALOG[8]);
/*      */             if (belongsToPlayer()) {
/*      */               sayAround("goooood.. ehh.. boy... hehe~");
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "cowgirlcumMSG6":
/*      */             if (belongsToPlayer()) {
/*      */               BlackScreenUI.activate();
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_cumDone":
/*      */           case "cowgirlcumDone":
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.resetCumPercentage();
/*      */               resetGirl();
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case "attackSound":
/*      */             playSoundAroundHer(SoundEvents.field_187727_dV);
/*      */             break;
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
/*      */           case "pearl":
/*      */             PacketHandler.INSTANCE.sendToServer((IMessage)new SendCompanionHome(girlId()));
/*      */             break;
/*      */ 
/*      */           
/*      */           case "openSexUi":
/*      */             if (isClosestPlayer()) {
/*      */               SexUI.shouldBeRendered = true;
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_slowMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*      */             if (func_70681_au().nextBoolean() && func_70681_au().nextBoolean()) {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_MOAN));
/*      */             } else {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             } 
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.02D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_fastMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*      */             if (func_70681_au().nextBoolean() || func_70681_au().nextBoolean()) {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_MOAN));
/*      */             } else {
/*      */               playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             } 
/*      */             if (belongsToPlayer()) {
/*      */               SexUI.addCumPercentage(0.05D);
/*      */             }
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_fastDone":
/*      */             if (!this.playerIsThrusting) {
/*      */               setCurrentAction(GirlEntity.Action.MISSIONARY_SLOW);
/*      */               break;
/*      */             } 
/*      */             setCurrentAction(GirlEntity.Action.MISSIONARY_FAST);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "bedRustle":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*      */             playSoundAroundHer(SoundsHandler.MISC_BEDRUSTLE[0]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "bedRustle1":
/*      */             playSoundAroundHer(SoundsHandler.MISC_BEDRUSTLE[1]);
/*      */             break;
/*      */ 
/*      */           
/*      */           case "missionary_cumMSG1":
/*      */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.GIRLS_ELLIE_AHH));
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       };
/* 1097 */     this.actionController.registerSoundListener(actionSoundListener);
/* 1098 */     data.addAnimationController(this.actionController); }
/*      */ 
/*      */   
/*      */   protected void func_184651_r() {
/*      */     super.func_184651_r();
/*      */   }
/*      */   
/*      */   public void func_70619_bc() {
/*      */     super.func_70619_bc();
/*      */     if (this.delayNewRot) {
/*      */       this.delayedRotTick++;
/*      */       if (this.delayedRotTick > 1) {
/*      */         this.delayedRotTick = 0;
/*      */         this.delayNewRot = false;
/*      */         setTargetYaw(this.delayedRot);
/*      */       } 
/*      */     } 
/*      */     if (currentAction() == GirlEntity.Action.NULL) {
/*      */       this.field_70145_X = false;
/*      */       func_189654_d(false);
/*      */     } 
/*      */     if (this.lookingForBed) {
/*      */       this.bedSearchTick++;
/*      */       if ((func_174791_d().func_72438_d(targetPos()) < 1.0D && this.bedSearchTick < 140) || this.bedSearchTick == 140) {
/*      */         this.field_70180_af.func_187227_b(SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/*      */         this.field_70145_X = true;
/*      */         func_189654_d(true);
/*      */         this.field_70159_w = 0.0D;
/*      */         this.field_70181_x = 0.0D;
/*      */         this.field_70179_y = 0.0D;
/*      */         this.bedSearchTick = 141;
/*      */       } 
/*      */       if (this.bedSearchTick == 5 || this.bedSearchTick == 60 || this.bedSearchTick == 120) {
/*      */         func_70661_as().func_75499_g();
/*      */         func_70661_as().func_75492_a((targetPos()).field_72450_a, (targetPos()).field_72448_b, (targetPos()).field_72449_c, 0.35D);
/*      */       } else if (this.bedSearchTick == 160) {
/*      */         setCurrentAction(GirlEntity.Action.SITDOWN);
/*      */       } else if (this.bedSearchTick == 310) {
/*      */         this.awaitPlayer = true;
/*      */         this.lookingForBed = false;
/*      */         this.bedSearchTick = 0;
/*      */       } 
/*      */     } 
/*      */     EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 10.0D);
/*      */     if (!this.isBusy && !this.lookingForBed && !this.awaitPlayer && playerSheHasSexWith() == null && closestPlayer != null && closestPlayer.field_70122_E && ((String)this.field_70180_af.func_187225_a(MASTER)).equals(""))
/*      */       if (++this.hornyLevel > 4800.0F) {
/*      */         boolean playerIsHavinSexAlready = false;
/*      */         for (GirlEntity girl : girlEntities) {
/*      */           if (closestPlayer.getPersistentID().equals(girl.playerSheHasSexWith())) {
/*      */             playerIsHavinSexAlready = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */         if (!playerIsHavinSexAlready) {
/*      */           this.isBusy = true;
/*      */           approachPlayer(closestPlayer);
/*      */         } 
/*      */       }  
/*      */     if (this.awaitPlayer && closestPlayer != null && closestPlayer.func_174791_d().func_72438_d(func_174791_d()) < 1.0D) {
/*      */       this.awaitPlayer = false;
/*      */       this.sexDelayTick = 0;
/*      */     } 
/*      */     if (this.sexDelayTick >= 0) {
/*      */       this.sexDelayTick++;
/*      */       if (this.sexDelayTick == 3) {
/*      */         this.sexDelayTick = -1;
/*      */         this.field_70180_af.func_187227_b(CURRENT_MODEL, Integer.valueOf(0));
/*      */         checkFollowUp();
/*      */         setPlayer(closestPlayer.getPersistentID());
/*      */         closestPlayer.field_71075_bZ.field_75100_b = true;
/*      */         closestPlayer.field_70145_X = true;
/*      */         closestPlayer.func_191958_b(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_70071_h_() {
/*      */     super.func_70071_h_();
/*      */     EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 10.0D);
/*      */     if (this.field_70170_p.field_72995_K)
/*      */       setUpBlackScreen(closestPlayer); 
/*      */     if (!this.field_70170_p.field_72995_K && func_70644_a(HornyPotion.HORNY_EFFECT) && this.hornyLevel < 4800.0F && !this.lookingForBed && !this.awaitPlayer && playerSheHasSexWith() == null) {
/*      */       func_184589_d(HornyPotion.HORNY_EFFECT);
/*      */       this.hornyLevel = 999999.0F;
/*      */       this.field_70145_X = true;
/*      */       func_189654_d(true);
/*      */       this.field_70181_x = 0.0D;
/*      */     } 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   void setUpBlackScreen(EntityPlayer closestPlayer) {
/*      */     if (currentAction() == GirlEntity.Action.SITDOWNIDLE && closestPlayer != null && closestPlayer.func_174791_d().func_72438_d(func_174791_d()) < 1.0D && closestPlayer.getPersistentID().equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID())) {
/*      */       BlackScreenUI.activate();
/*      */       HandlePlayerMovement.setActive(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void cum() {
/*      */     if (currentAction() == GirlEntity.Action.COWGIRLFAST || currentAction() == GirlEntity.Action.COWGIRLSLOW) {
/*      */       this.playerIsCumming = true;
/*      */       this.actionController.transitionLengthTicks = 2.0D;
/*      */       setCurrentAction(GirlEntity.Action.COWGIRLCUM);
/*      */     } else if (currentAction() == GirlEntity.Action.MISSIONARY_FAST || currentAction() == GirlEntity.Action.MISSIONARY_SLOW) {
/*      */       this.playerIsCumming = true;
/*      */       this.actionController.transitionLengthTicks = 2.0D;
/*      */       setCurrentAction(GirlEntity.Action.MISSIONARY_CUM);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void thrust() {
/*      */     if (currentAction() == GirlEntity.Action.COWGIRLSLOW || currentAction() == GirlEntity.Action.COWGIRLFAST) {
/*      */       this.playerIsThrusting = true;
/*      */       if (currentAction() == GirlEntity.Action.COWGIRLFAST) {
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*      */       } else {
/*      */         setCurrentAction(GirlEntity.Action.COWGIRLFAST);
/*      */       } 
/*      */     } else if (currentAction() == GirlEntity.Action.MISSIONARY_FAST || currentAction() == GirlEntity.Action.MISSIONARY_SLOW) {
/*      */       this.playerIsThrusting = true;
/*      */       if (currentAction() == GirlEntity.Action.MISSIONARY_FAST) {
/*      */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*      */       } else {
/*      */         setCurrentAction(GirlEntity.Action.MISSIONARY_FAST);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184601_bQ(DamageSource edamageSourceIn) {
/*      */     return null;
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184639_G() {
/*      */     return null;
/*      */   }
/*      */   
/*      */   protected SoundEvent func_184615_bR() {
/*      */     return null;
/*      */   }
/*      */   
/*      */   protected void func_110147_ax() {
/*      */     super.func_110147_ax();
/*      */   }
/*      */   
/*      */   protected void prepareAction(EntityPlayerMP player) {
/*      */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiLookAtPlayer);
/*      */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiWander);
/*      */     func_70661_as().func_75499_g();
/*      */     this.field_70159_w = 0.0D;
/*      */     this.field_70181_x = 0.0D;
/*      */     this.field_70179_y = 0.0D;
/*      */   }
/*      */   
/*      */   public boolean openMenu(EntityPlayer player) {
/*      */     renderMenu(player, girl(), new String[] { "Cowgirl", "Missionary" }, new int[] { 0, 0 }, new Item[] { null, null });
/*      */     return true;
/*      */   }
/*      */   
/*      */   public void openCompanionMenu(EntityPlayer player) {
/*      */     List<String> actions = new ArrayList<>(Arrays.asList(new String[] { (((Integer)this.field_70180_af.func_187225_a(CURRENT_MODEL)).intValue() == 1) ? "Strip" : "Dress up", "companion Set new home", "companion Go home", ((String)this.field_70180_af.func_187225_a(MASTER)).equals("") ? "companion Follow me" : "companion Stop following me", "companion Equipment" }));
/*      */     String[] actionsArray = new String[actions.size()];
/*      */     actions.toArray(actionsArray);
/*      */     int[] prices = new int[actions.size()];
/*      */     Item[] items = new Item[actions.size()];
/*      */     Arrays.fill(prices, 0);
/*      */     Arrays.fill((Object[])items, (Object)null);
/*      */     renderMenu(player, this, actionsArray, prices, items);
/*      */   }
/*      */   
/*      */   protected boolean func_184645_a(EntityPlayer player, EnumHand hand) {
/*      */     if (super.func_184645_a(player, hand))
/*      */       return true; 
/*      */     ItemStack itemstack = player.func_184586_b(hand);
/*      */     boolean hasNameTag = (itemstack.func_77973_b() == Items.field_151057_cb);
/*      */     if (hasNameTag) {
/*      */       itemstack.func_111282_a(player, (EntityLivingBase)this, hand);
/*      */       return true;
/*      */     } 
/*      */     if (this.field_70170_p.field_72995_K && !openCompanionMenuOnClient(player))
/*      */       sayAround("I'm busy right now honey~"); 
/*      */     return true;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   boolean openCompanionMenuOnClient(EntityPlayer player) {
/*      */     if (playerSheHasSexWith() == null && (((String)this.field_70180_af.func_187225_a(MASTER)).equals("") || ((String)this.field_70180_af.func_187225_a(MASTER)).equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID().toString()))) {
/*      */       openCompanionMenu(player);
/*      */       return true;
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean canCloseUiWithoutHavingChosen() {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public void doAction(String actionName, UUID player) {
/*      */     super.doAction(actionName, player);
/*      */     switch (actionName) {
/*      */       case "companion Follow me":
/*      */         sayAround("I'll protect you darling~");
/*      */         break;
/*      */       case "companion Stop following me":
/*      */         sayAround("stay safe darling~");
/*      */         playSoundAroundHer(SoundsHandler.GIRLS_JENNY_SADOH[1]);
/*      */         stopCompanionShip();
/*      */         break;
/*      */       case "companion Go home":
/*      */         sayAround("Okay, mommy is going home... stay safe darling~");
/*      */         break;
/*      */       case "Dress up":
/*      */         setCurrentAction(GirlEntity.Action.STRIP);
/*      */         break;
/*      */       case "Strip":
/*      */         setCurrentAction(GirlEntity.Action.STRIP);
/*      */         resetPlayer();
/*      */         break;
/*      */       case "Cowgirl":
/*      */         setPlayer(player);
/*      */         setCurrentAction(GirlEntity.Action.HUGSELECTED);
/*      */         changeDataParameterFromClient("animationFollowUp", "cowgirl");
/*      */         break;
/*      */       case "Missionary":
/*      */         setPlayer(player);
/*      */         setCurrentAction(GirlEntity.Action.HUGSELECTED);
/*      */         changeDataParameterFromClient("animationFollowUp", "Missionary");
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void goForCowgirl() {
/*      */     Vec3d bedPos;
/*      */     int whichOne = -1;
/*      */     int bedsFound = 0;
/*      */     Vec3d[][] potentialSpaces = { { new Vec3d(0.5D, 0.0D, -0.18D), new Vec3d(0.0D, 0.0D, -1.0D), new Vec3d(0.0D, 0.0D, 1.0D) }, { new Vec3d(0.5D, 0.0D, 1.18D), new Vec3d(0.0D, 0.0D, 1.0D), new Vec3d(0.0D, 0.0D, -1.0D) }, { new Vec3d(-0.18D, 0.0D, 0.5D), new Vec3d(-1.0D, 0.0D, 0.0D), new Vec3d(1.0D, 0.0D, 0.0D) }, { new Vec3d(1.18D, 0.0D, 0.5D), new Vec3d(1.0D, 0.0D, 0.0D), new Vec3d(-1.0D, 0.0D, 0.0D) } };
/*      */     int[] yaws = { 0, 180, -90, 90 };
/*      */     do {
/*      */       BlockPos temp = findBed(func_180425_c(), ++bedsFound);
/*      */       if (temp == null) {
/*      */         say("no bed in sight...");
/*      */         return;
/*      */       } 
/*      */       bedPos = new Vec3d(temp.func_177958_n(), temp.func_177956_o(), temp.func_177952_p());
/*      */       for (int i = 0; i < potentialSpaces.length; i++) {
/*      */         Vec3d spaceFront = bedPos.func_178787_e(potentialSpaces[i][1]);
/*      */         Block blockFront = this.field_70170_p.func_180495_p(new BlockPos(spaceFront.field_72450_a, spaceFront.field_72448_b, spaceFront.field_72449_c)).func_177230_c();
/*      */         Vec3d spaceBack = bedPos.func_178787_e(potentialSpaces[i][2]);
/*      */         Block blockBack = this.field_70170_p.func_180495_p(new BlockPos(spaceBack.field_72450_a, spaceBack.field_72448_b, spaceBack.field_72449_c)).func_177230_c();
/*      */         if (blockFront == Blocks.field_150350_a && blockBack == Blocks.field_150324_C)
/*      */           if (whichOne == -1) {
/*      */             whichOne = i;
/*      */           } else {
/*      */             double oldDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[whichOne][0])).field_72449_c);
/*      */             double newDistance = func_180425_c().func_177954_c((bedPos.func_178787_e(potentialSpaces[i][0])).field_72450_a, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72448_b, (bedPos.func_178787_e(potentialSpaces[i][0])).field_72449_c);
/*      */             if (newDistance < oldDistance)
/*      */               whichOne = i; 
/*      */           }  
/*      */       } 
/*      */     } while (whichOne == -1);
/*      */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiWander);
/*      */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiLookAtPlayer);
/*      */     Vec3d targetPos = bedPos.func_178787_e(potentialSpaces[whichOne][0]);
/*      */     setTargetYaw(yaws[whichOne]);
/*      */     setTargetPos(new Vec3d(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c));
/*      */     this.playerYaw = targetYaw().floatValue();
/*      */     func_70661_as().func_75499_g();
/*      */     func_70661_as().func_75492_a(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c, 0.35D);
/*      */     this.lookingForBed = true;
/*      */     this.bedSearchTick = 0;
/*      */   }
/*      */   
/*      */   boolean shouldCrouch() {
/*      */     return (this.field_70170_p.func_180495_p(func_180425_c().func_177982_a(0, 2, 0)).func_177230_c() != Blocks.field_150350_a);
/*      */   }
/*      */   
/*      */   void approachPlayer(EntityPlayer player) {
/*      */     this.field_70180_af.func_187227_b(PLAYER_SHE_HAS_SEX_WITH, player.getPersistentID().toString());
/*      */     prepareAction((EntityPlayerMP)player);
/*      */     this.shouldBeAtTargetYaw = true;
/*      */     Vec3d distance = player.func_174791_d().func_178788_d(func_174791_d());
/*      */     setTargetYaw((float)Math.atan2(distance.field_72449_c, distance.field_72450_a) * 57.29578F + 90.0F);
/*      */     PacketHandler.INSTANCE.sendTo((IMessage)new SetPlayerMovement(false), (EntityPlayerMP)player);
/*      */     func_189654_d(true);
/*      */     this.field_70145_X = true;
/*      */     this.field_70159_w = 0.0D;
/*      */     this.field_70181_x = 0.0D;
/*      */     this.field_70179_y = 0.0D;
/*      */     setCurrentAction(GirlEntity.Action.DASH);
/*      */   }
/*      */   
/*      */   protected ResourceLocation func_184647_J() {
/*      */     return LootTableHandler.ELLIE;
/*      */   }
/*      */   
/*      */   public float func_70047_e() {
/*      */     return shouldCrouch() ? 1.53F : 1.9F;
/*      */   }
/*      */   
/*      */   protected void checkFollowUp() {
/*      */     EntityPlayer closestPlayer;
/*      */     Vec3d playerPos;
/*      */     switch ((String)this.field_70180_af.func_187225_a(ANIMATION_FOLLOW_UP)) {
/*      */       case "strip":
/*      */         resetPlayer();
/*      */         setCurrentAction(GirlEntity.Action.STRIP);
/*      */         break;
/*      */       case "Missionary":
/*      */         setCurrentAction(GirlEntity.Action.MISSIONARY_START);
/*      */         closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 10.0D);
/*      */         playerPos = func_174791_d().func_178786_a(0.0D, 0.1D, 0.0D);
/*      */         closestPlayer.func_70080_a(playerPos.field_72450_a, playerPos.field_72448_b, playerPos.field_72449_c, targetYaw().floatValue(), 60.0F);
/*      */         closestPlayer.func_70634_a(playerPos.field_72450_a, playerPos.field_72448_b, playerPos.field_72449_c);
/*      */         break;
/*      */       case "cowgirl":
/*      */         setCurrentAction(GirlEntity.Action.COWGIRLSTART);
/*      */         closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 10.0D);
/*      */         playerPos = func_174791_d().func_178787_e(new Vec3d(-Math.sin(targetYaw().floatValue() * 0.017453292519943295D) * 1.8D, -0.65D, Math.cos(targetYaw().floatValue() * 0.017453292519943295D) * 1.8D));
/*      */         closestPlayer.func_70080_a(playerPos.field_72450_a, playerPos.field_72448_b, playerPos.field_72449_c, 180.0F + targetYaw().floatValue(), -30.0F);
/*      */         closestPlayer.func_70634_a(playerPos.field_72450_a, playerPos.field_72448_b, playerPos.field_72449_c);
/*      */         break;
/*      */     } 
/*      */     this.field_70180_af.func_187227_b(ANIMATION_FOLLOW_UP, "");
/*      */   }
/*      */   
/*      */   public Vec3d getBehindOfPlayer(EntityPlayer player) {
/*      */     float playerYaw = player.field_70177_z;
/*      */     float distance = 0.5F;
/*      */     return player.func_174791_d().func_72441_c(-Math.sin(playerYaw * 0.017453292519943295D) * -distance, 0.0D, Math.cos(playerYaw * 0.017453292519943295D) * -distance);
/*      */   }
/*      */   
/*      */   protected <E extends software.bernie.geckolib3.core.IAnimatable> PlayState predicate(AnimationEvent<E> event) {
/*      */     double speed;
/*      */     if (this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)
/*      */       return null; 
/*      */     switch (event.getController().getName()) {
/*      */       case "eyes":
/*      */         if (currentAction() != GirlEntity.Action.NULL || !(currentAction()).autoBlink) {
/*      */           createAnimation("animation.ellie.null", true, event);
/*      */           break;
/*      */         } 
/*      */         createAnimation("animation.ellie.eyes", true, event);
/*      */         break;
/*      */       case "movement":
/*      */         if (currentAction() != GirlEntity.Action.NULL) {
/*      */           createAnimation("animation.ellie.null", true, event);
/*      */           break;
/*      */         } 
/*      */         speed = Math.abs(this.field_70169_q - this.field_70165_t) + Math.abs(this.field_70166_s - this.field_70161_v);
/*      */         if (speed == 0.0D) {
/*      */           createAnimation(shouldCrouch() ? "animation.ellie.crouchidle" : "animation.ellie.idle", true, event);
/*      */           break;
/*      */         } 
/*      */         if (shouldCrouch()) {
/*      */           createAnimation("animation.ellie.crouchwalk", true, event);
/*      */           break;
/*      */         } 
/*      */         switch (getWalkSpeed()) {
/*      */           case NULL:
/*      */             createAnimation("animation.ellie.run", true, event);
/*      */             break;
/*      */           case STRIP:
/*      */             createAnimation("animation.ellie.fastwalk", true, event);
/*      */             break;
/*      */           case DASH:
/*      */             createAnimation("animation.ellie.walk", true, event);
/*      */             break;
/*      */         } 
/*      */         break;
/*      */       case "action":
/*      */         switch (currentAction()) {
/*      */           case NULL:
/*      */             createAnimation("animation.ellie.null", true, event);
/*      */             break;
/*      */           case STRIP:
/*      */             createAnimation("animation.ellie.strip", false, event);
/*      */             break;
/*      */           case DASH:
/*      */             createAnimation("animation.ellie.dash", false, event);
/*      */             break;
/*      */           case HUG:
/*      */             createAnimation("animation.ellie.hug", false, event);
/*      */             break;
/*      */           case HUGIDLE:
/*      */             createAnimation("animation.ellie.hugidle", true, event);
/*      */             break;
/*      */           case HUGSELECTED:
/*      */             createAnimation("animation.ellie.hugselected", false, event);
/*      */             break;
/*      */           case SITDOWN:
/*      */             createAnimation("animation.ellie.sitdown", false, event);
/*      */             break;
/*      */           case SITDOWNIDLE:
/*      */             createAnimation("animation.ellie.sitdownidle", true, event);
/*      */             break;
/*      */           case COWGIRLSTART:
/*      */             createAnimation("animation.ellie.cowgirlstart", false, event);
/*      */             break;
/*      */           case COWGIRLSLOW:
/*      */             createAnimation("animation.ellie.cowgirlslow2", true, event);
/*      */             break;
/*      */           case COWGIRLFAST:
/*      */             createAnimation("animation.ellie.cowgirlfast", true, event);
/*      */             break;
/*      */           case COWGIRLCUM:
/*      */             createAnimation("animation.ellie.cowgirlcum", true, event);
/*      */             break;
/*      */           case ATTACK:
/*      */             createAnimation("animation.ellie.attack" + this.nextAttack, false, event);
/*      */             break;
/*      */           case BOW:
/*      */             createAnimation("animation.ellie.bowcharge", false, event);
/*      */             break;
/*      */           case RIDE:
/*      */             createAnimation("animation.ellie.ride", true, event);
/*      */             break;
/*      */           case SIT:
/*      */             createAnimation("animation.ellie.sit", true, event);
/*      */             break;
/*      */           case THROW_PEARL:
/*      */             createAnimation("animation.ellie.throwpearl", false, event);
/*      */             break;
/*      */           case DOWNED:
/*      */             createAnimation("animation.ellie.downed", true, event);
/*      */             break;
/*      */           case MISSIONARY_START:
/*      */             createAnimation("animation.ellie.missionary_start", false, event);
/*      */             break;
/*      */           case MISSIONARY_SLOW:
/*      */             createAnimation("animation.ellie.missionary_slow", true, event);
/*      */             break;
/*      */           case MISSIONARY_FAST:
/*      */             createAnimation("animation.ellie.missionary_fast", false, event);
/*      */             break;
/*      */           case MISSIONARY_CUM:
/*      */             createAnimation("animation.ellie.missionary_cum", false, event);
/*      */             break;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     return PlayState.CONTINUE;
/*      */   }
/*      */   
/*      */   protected EllieEntity girl() {
/*      */     return this;
/*      */   }
/*      */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\ellie\EllieEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */