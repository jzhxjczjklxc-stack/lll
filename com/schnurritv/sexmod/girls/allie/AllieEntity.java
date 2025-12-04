/*     */ package com.schnurritv.sexmod.girls.allie;
/*     */ 
/*     */ import com.schnurritv.sexmod.Packets.ClearAnimationCache;
/*     */ import com.schnurritv.sexmod.Packets.PrepareAction;
/*     */ import com.schnurritv.sexmod.Packets.WishDone;
/*     */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.gui.BlackScreenUI;
/*     */ import com.schnurritv.sexmod.gui.SexUI;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import software.bernie.geckolib3.core.PlayState;
/*     */ import software.bernie.geckolib3.core.controller.AnimationController;
/*     */ import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.manager.AnimationData;
/*     */ 
/*     */ public class AllieEntity
/*     */   extends GirlEntity
/*     */ {
/*  33 */   float alpha = 1.0F;
/*     */   
/*  35 */   public static final DataParameter<ItemStack> LAMP = EntityDataManager.func_187226_a(GirlEntity.class, DataSerializers.field_187196_f).func_187156_b().func_187161_a(73);
/*     */   
/*     */   public AllieEntity(World worldIn) {
/*  38 */     super(worldIn);
/*  39 */     this.girlName = "Allie";
/*     */   }
/*     */   
/*     */   public AllieEntity(World worldIn, ItemStack lamp) {
/*  43 */     super(worldIn);
/*  44 */     this.girlName = "Allie";
/*  45 */     this; this.field_70180_af.func_187227_b(LAMP, lamp);
/*     */     
/*  47 */     if (firstWish()) {
/*  48 */       setCurrentAction(GirlEntity.Action.SUMMON);
/*     */     } else {
/*     */       
/*  51 */       setCurrentAction(GirlEntity.Action.SUMMON_NORMAL);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  57 */     super.func_70088_a();
/*     */     
/*  59 */     this.field_70180_af.func_187214_a(LAMP, ItemStack.field_190927_a);
/*     */   }
/*     */   
/*     */   boolean firstWish() {
/*  63 */     return (((ItemStack)this.field_70180_af.func_187225_a(LAMP)).func_77978_p().func_74762_e("uses") == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canCloseUiWithoutHavingChosen() {
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean openMenu(EntityPlayer player) {
/*  74 */     List<String> actions = new ArrayList<>(Arrays.asList(new String[] { "Deepthroat!" }));
/*     */     
/*  76 */     String[] actionsArray = new String[actions.size()];
/*  77 */     actions.toArray(actionsArray);
/*     */     
/*  79 */     int[] prices = new int[actions.size()];
/*  80 */     Item[] items = new Item[actions.size()];
/*     */     
/*  82 */     Arrays.fill(prices, 0);
/*  83 */     Arrays.fill((Object[])items, (Object)null);
/*  84 */     renderMenu(player, this, actionsArray, prices, items);
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected <E extends software.bernie.geckolib3.core.IAnimatable> PlayState predicate(AnimationEvent<E> event) {
/*  91 */     if (this.field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) {
/*  92 */       return PlayState.STOP;
/*     */     }
/*  94 */     switch (event.getController().getName()) {
/*     */ 
/*     */       
/*     */       case "eyes":
/*  98 */         if (currentAction() != GirlEntity.Action.NULL || !(currentAction()).autoBlink) {
/*  99 */           createAnimation("animation.allie.null", true, event);
/*     */         }
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "movement":
/* 108 */         createAnimation("animation.allie.tail", true, event);
/*     */         break;
/*     */ 
/*     */       
/*     */       case "action":
/* 113 */         switch (currentAction()) {
/*     */           
/*     */           case SUMMON:
/* 116 */             createAnimation("animation.allie.summon", false, event);
/*     */             break;
/*     */           
/*     */           case SUMMON_NORMAL:
/* 120 */             createAnimation("animation.allie.summon_normal", false, event);
/*     */             break;
/*     */           
/*     */           case SUMMON_NORMAL_WAIT:
/* 124 */             createAnimation("animation.allie.summon_normal_wait", true, event);
/*     */             break;
/*     */           
/*     */           case SUMMON_WAIT:
/* 128 */             createAnimation("animation.allie.summon_wait", true, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_PREPARE:
/* 132 */             createAnimation("animation.allie.deepthroat_prepare", false, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_NORMAL_PREPARE:
/* 136 */             createAnimation("animation.allie.deepthroat_normal_prepare", false, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_START:
/* 140 */             createAnimation("animation.allie.deepthroat_start", false, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_SLOW:
/* 144 */             createAnimation("animation.allie.deepthroat_slow", true, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_FAST:
/* 148 */             createAnimation("animation.allie.deepthroat_fast", true, event);
/*     */             break;
/*     */           
/*     */           case DEEPTHROAT_CUM:
/* 152 */             createAnimation("animation.allie.deepthroat_cum", false, event);
/*     */             break;
/*     */         } 
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 159 */     return PlayState.CONTINUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerControllers(AnimationData data) {
/* 164 */     super.registerControllers(data);
/*     */     
/* 166 */     AnimationController.ISoundListener soundListener = event -> {
/*     */         switch (event.sound) {
/*     */           case "summonMSG1":
/*     */             sayAround("HIIYAAYA!");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG2":
/*     */             sayAround("Congratulations mortal~");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG3":
/*     */             sayAround("By finding and rubbing my lamp...");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG4":
/*     */             sayAround("you got yourself...");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG5":
/*     */             sayAround("3 wishes!");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG6":
/*     */             sayAround("... get the reference? :D");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG7":
/*     */             sayAround("So..!");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonMSG8":
/*     */             sayAround("tell me your first wish, mortal~");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             openMenu(this.field_70170_p.func_152378_a(playerSheHasSexWith()));
/*     */             break;
/*     */ 
/*     */           
/*     */           case "summonDone":
/*     */             setCurrentAction(GirlEntity.Action.SUMMON_WAIT);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "deepthroat_prepareMSG1":
/*     */             sayAround("Hihihi");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "deepthroat_prepareMSG2":
/*     */             sayAround("Boys...");
/*     */             playSoundAroundHer(SoundsHandler.MISC_PLOB[0]);
/*     */             break;
/*     */ 
/*     */           
/*     */           case "blackscreen":
/*     */             if (belongsToPlayer()) {
/*     */               BlackScreenUI.activate();
/*     */             }
/*     */             break;
/*     */           
/*     */           case "deepthroat_prepareDone":
/*     */             setCurrentAction(GirlEntity.Action.DEEPTHROAT_START);
/*     */             if (belongsToPlayer()) {
/*     */               PacketHandler.INSTANCE.sendToServer((IMessage)new PrepareAction(girlId(), playerSheHasSexWith(), false, true));
/*     */               this.playerYaw = this.field_70177_z + 180.0F;
/*     */               moveCamera(0.0D, 0.0D, 1.350000023841858D, this.field_70177_z, 30.0F);
/*     */               SexUI.resetCumPercentage();
/*     */             } 
/*     */             break;
/*     */           
/*     */           case "deepthroat_fastDone":
/*     */             if (belongsToPlayer()) {
/*     */               this.playerIsThrusting = HandlePlayerMovement.isThrusting;
/*     */               SexUI.addCumPercentage(0.03999999910593033D);
/*     */             } 
/*     */             if (this.playerIsThrusting) {
/*     */               break;
/*     */             }
/*     */           
/*     */           case "deepthroat_startDone":
/*     */             setCurrentAction(GirlEntity.Action.DEEPTHROAT_SLOW);
/*     */             break;
/*     */           
/*     */           case "deepthroat_slowMSG1":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*     */             if (belongsToPlayer()) {
/*     */               SexUI.shouldBeRendered = true;
/*     */               SexUI.addCumPercentage(0.019999999552965164D);
/*     */             } 
/*     */             break;
/*     */           
/*     */           case "deepthroat_cumMSG1":
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_POUNDING));
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_CUMINFLATION), 1.5F);
/*     */             break;
/*     */           
/*     */           case "deepthroat_cumDone":
/*     */             if (belongsToPlayer()) {
/*     */               resetGirl();
/*     */               PacketHandler.INSTANCE.sendToServer((IMessage)new WishDone((ItemStack)this.field_70180_af.func_187225_a(LAMP), girlId()));
/*     */             } 
/*     */             break;
/*     */           
/*     */           case "summon_normalMSG1":
/*     */             sayAround("sup mortal?");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */           
/*     */           case "summon_normalMSG2":
/*     */             sayAround("you have...");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */           
/*     */           case "summon_normalMSG3":
/*     */             if (((ItemStack)this.field_70180_af.func_187225_a(LAMP)).func_77978_p().func_74762_e("uses") == 2) {
/*     */               sayAround("2 wishes left!");
/*     */             } else {
/*     */               sayAround("one last wish");
/*     */             } 
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */           
/*     */           case "summon_normalMSG4":
/*     */             sayAround("So...");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */           
/*     */           case "summon_normalMSG5":
/*     */             sayAround("Tell me your wish, mortal!");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */           
/*     */           case "summon_normalDone":
/*     */             setCurrentAction(GirlEntity.Action.SUMMON_NORMAL_WAIT);
/*     */             if (belongsToPlayer()) {
/*     */               openMenu(this.field_70170_p.func_152378_a(playerSheHasSexWith()));
/*     */             }
/*     */             break;
/*     */           
/*     */           case "deepthroat_normal_prepareMSG1":
/*     */             sayAround("alright!");
/*     */             playSoundAroundHer(SoundsHandler.Random(SoundsHandler.MISC_PLOB));
/*     */             break;
/*     */         } 
/*     */       
/*     */       };
/* 326 */     this.actionController.registerSoundListener(soundListener);
/* 327 */     data.addAnimationController(this.actionController);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doAction(String actionName, UUID player) {
/* 333 */     switch (actionName) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "Deepthroat!":
/* 341 */         if (firstWish()) {
/* 342 */           setCurrentAction(GirlEntity.Action.DEEPTHROAT_PREPARE);
/*     */           break;
/*     */         } 
/* 345 */         setCurrentAction(GirlEntity.Action.DEEPTHROAT_NORMAL_PREPARE);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void thrust() {
/* 354 */     if (currentAction() == GirlEntity.Action.DEEPTHROAT_FAST || currentAction() == GirlEntity.Action.DEEPTHROAT_SLOW) {
/*     */       
/* 356 */       this.playerIsThrusting = true;
/*     */       
/* 358 */       if (currentAction() == GirlEntity.Action.DEEPTHROAT_FAST) {
/*     */ 
/*     */         
/* 361 */         PacketHandler.INSTANCE.sendToServer((IMessage)new ClearAnimationCache(girlId()));
/*     */       }
/*     */       else {
/*     */         
/* 365 */         setCurrentAction(GirlEntity.Action.DEEPTHROAT_FAST);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cum() {
/* 372 */     if (currentAction() == GirlEntity.Action.DEEPTHROAT_FAST || currentAction() == GirlEntity.Action.DEEPTHROAT_SLOW) {
/*     */ 
/*     */       
/* 375 */       this.playerIsCumming = true;
/* 376 */       setCurrentAction(GirlEntity.Action.DEEPTHROAT_CUM);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void checkFollowUp() {}
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\allie\AllieEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */