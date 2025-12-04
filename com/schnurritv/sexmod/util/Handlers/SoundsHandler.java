/*     */ package com.schnurritv.sexmod.util.Handlers;
/*     */ 
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.HashMap;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoundsHandler
/*     */ {
/*  42 */   public static final SoundEvent[] GIRLS_JENNY_AFTERSESSIONMOAN = new SoundEvent[5];
/*  43 */   public static final SoundEvent[] GIRLS_JENNY_AHH = new SoundEvent[10];
/*  44 */   public static final SoundEvent[] GIRLS_JENNY_BJMOAN = new SoundEvent[13];
/*  45 */   public static final SoundEvent[] GIRLS_JENNY_GIGGLE = new SoundEvent[5];
/*  46 */   public static final SoundEvent[] GIRLS_JENNY_HAPPYOH = new SoundEvent[3];
/*  47 */   public static final SoundEvent[] GIRLS_JENNY_HEAVYBREATHING = new SoundEvent[8];
/*  48 */   public static final SoundEvent[] GIRLS_JENNY_HMPH = new SoundEvent[5];
/*  49 */   public static final SoundEvent[] GIRLS_JENNY_HUH = new SoundEvent[2];
/*  50 */   public static final SoundEvent[] GIRLS_JENNY_LIGHTBREATHING = new SoundEvent[12];
/*  51 */   public static final SoundEvent[] GIRLS_JENNY_LIPSOUND = new SoundEvent[10];
/*  52 */   public static final SoundEvent[] GIRLS_JENNY_MMM = new SoundEvent[9];
/*  53 */   public static final SoundEvent[] GIRLS_JENNY_MOAN = new SoundEvent[8];
/*  54 */   public static final SoundEvent[] GIRLS_JENNY_SADOH = new SoundEvent[2];
/*  55 */   public static final SoundEvent[] GIRLS_JENNY_SIGH = new SoundEvent[2];
/*  56 */   public static final SoundEvent[] MISC_PLOB = new SoundEvent[1];
/*  57 */   public static final SoundEvent[] MISC_BELLJINGLE = new SoundEvent[1];
/*  58 */   public static final SoundEvent[] MISC_BEDRUSTLE = new SoundEvent[2];
/*  59 */   public static final SoundEvent[] MISC_SLAP = new SoundEvent[2];
/*  60 */   public static final SoundEvent[] MISC_TOUCH = new SoundEvent[2];
/*  61 */   public static final SoundEvent[] MISC_POUNDING = new SoundEvent[35];
/*  62 */   public static final SoundEvent[] MISC_SMALLINSERTS = new SoundEvent[5];
/*  63 */   public static final SoundEvent[] MISC_CUMINFLATION = new SoundEvent[1];
/*  64 */   public static final SoundEvent[] GIRLS_ELLIE_AHH = new SoundEvent[10];
/*  65 */   public static final SoundEvent[] GIRLS_ELLIE_GIGGLE = new SoundEvent[1];
/*  66 */   public static final SoundEvent[] GIRLS_ELLIE_HEAVYBREATHING = new SoundEvent[2];
/*  67 */   public static final SoundEvent[] GIRLS_ELLIE_MMM = new SoundEvent[6];
/*  68 */   public static final SoundEvent[] GIRLS_ELLIE_MOAN = new SoundEvent[4];
/*  69 */   public static final SoundEvent[] GIRLS_ELLIE_ORGASM = new SoundEvent[2];
/*  70 */   public static final SoundEvent[] GIRLS_ELLIE_INSULT = new SoundEvent[5];
/*  71 */   public static final SoundEvent[] GIRLS_ELLIE_DIALOG = new SoundEvent[9];
/*  72 */   public static final SoundEvent[] MISC_SCREAM = new SoundEvent[2];
/*  73 */   public static final SoundEvent[] GIRLS_BIA_AHH = new SoundEvent[8];
/*  74 */   public static final SoundEvent[] GIRLS_BIA_BJMOAN = new SoundEvent[5];
/*  75 */   public static final SoundEvent[] GIRLS_BIA_BREATH = new SoundEvent[4];
/*  76 */   public static final SoundEvent[] GIRLS_BIA_GIGGLE = new SoundEvent[3];
/*  77 */   public static final SoundEvent[] GIRLS_BIA_HEY = new SoundEvent[4];
/*  78 */   public static final SoundEvent[] GIRLS_BIA_HUH = new SoundEvent[3];
/*  79 */   public static final SoundEvent[] GIRLS_BIA_MMM = new SoundEvent[8];
/*     */ 
/*     */   
/*  82 */   private static final SoundEvent[][] soundCategorys = new SoundEvent[][] { GIRLS_JENNY_AFTERSESSIONMOAN, GIRLS_JENNY_AHH, GIRLS_JENNY_BJMOAN, GIRLS_JENNY_GIGGLE, GIRLS_JENNY_HAPPYOH, GIRLS_JENNY_HEAVYBREATHING, GIRLS_JENNY_HMPH, GIRLS_JENNY_HUH, GIRLS_JENNY_LIGHTBREATHING, GIRLS_JENNY_LIPSOUND, GIRLS_JENNY_MMM, GIRLS_JENNY_MOAN, GIRLS_JENNY_SADOH, GIRLS_JENNY_SIGH, MISC_PLOB, MISC_BELLJINGLE, MISC_BEDRUSTLE, MISC_SLAP, MISC_TOUCH, MISC_POUNDING, MISC_SMALLINSERTS, MISC_CUMINFLATION, GIRLS_ELLIE_AHH, GIRLS_ELLIE_GIGGLE, GIRLS_ELLIE_HEAVYBREATHING, GIRLS_ELLIE_MMM, GIRLS_ELLIE_MOAN, GIRLS_ELLIE_ORGASM, GIRLS_ELLIE_INSULT, GIRLS_ELLIE_DIALOG, MISC_SCREAM, GIRLS_BIA_AHH, GIRLS_BIA_BJMOAN, GIRLS_BIA_BREATH, GIRLS_BIA_GIGGLE, GIRLS_BIA_HEY, GIRLS_BIA_HUH, GIRLS_BIA_MMM };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public static final SoundsHandler INSTANCE = new SoundsHandler();
/*     */ 
/*     */   
/*     */   public static void registerSounds() {
/* 127 */     for (int soundCategoryIndex = 0; soundCategoryIndex < soundCategorys.length; soundCategoryIndex++) {
/*     */ 
/*     */       
/* 130 */       SoundEvent[] soundCategory = soundCategorys[soundCategoryIndex];
/*     */ 
/*     */       
/* 133 */       for (int soundIndex = 0; soundIndex < soundCategory.length; soundIndex++) {
/*     */ 
/*     */         
/* 136 */         String categoryName, path = INSTANCE.getClass().getDeclaredFields()[soundCategoryIndex].getName().toLowerCase().replace("_", ".");
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 141 */           categoryName = path.split("\\.")[2];
/* 142 */         } catch (ArrayIndexOutOfBoundsException e) {
/*     */           
/* 144 */           categoryName = path.split("\\.")[1];
/*     */         } 
/*     */ 
/*     */         
/* 148 */         soundCategory[soundIndex] = registerSound(path + "." + categoryName + soundIndex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SoundEvent registerSound(String path) {
/* 157 */     ResourceLocation location = new ResourceLocation("sexmod", path);
/* 158 */     SoundEvent event = new SoundEvent(location);
/* 159 */     event.setRegistryName(path);
/* 160 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/*     */     
/* 162 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   static HashMap<SoundEvent, Integer> lastRandomSound = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static SoundEvent Random(SoundEvent[] soundArray) {
/*     */     int random;
/* 176 */     lastRandomSound.putIfAbsent(soundArray[0], Integer.valueOf(-69));
/*     */ 
/*     */ 
/*     */     
/* 180 */     int trys = 0;
/*     */     do {
/* 182 */       random = Reference.RANDOM.nextInt(soundArray.length);
/*     */     }
/* 184 */     while (++trys < 10 && random == ((Integer)lastRandomSound.get(soundArray[0])).intValue());
/*     */     
/* 186 */     lastRandomSound.replace(soundArray[0], Integer.valueOf(random));
/*     */     
/* 188 */     return soundArray[random];
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */