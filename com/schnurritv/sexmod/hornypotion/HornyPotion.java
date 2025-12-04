/*    */ package com.schnurritv.sexmod.hornypotion;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityAnimal;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.PotionTypes;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.potion.PotionHelper;
/*    */ import net.minecraft.potion.PotionType;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.TickEvent;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class HornyPotion extends Potion {
/* 23 */   public static final Potion HORNY_EFFECT = new HornyPotion("horny potion", false, 16736968, 0, 0);
/* 24 */   public static final PotionType HORNY_POTION = (PotionType)(new PotionType("horny_potion", new PotionEffect[] { new PotionEffect(HORNY_EFFECT, 3600) })).setRegistryName("horny_potion");
/*    */   
/*    */   public HornyPotion() {
/* 27 */     super(false, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public HornyPotion(String name, boolean isBadPotion, int color, int iconIndexX, int iconIndexY) {
/* 32 */     super(isBadPotion, color);
/* 33 */     func_76390_b(name);
/* 34 */     func_76399_b(iconIndexX, iconIndexY);
/* 35 */     setRegistryName(new ResourceLocation("sexmod:" + name));
/*    */   }
/*    */   
/*    */   public static void registerHornyPotion() {
/* 39 */     ForgeRegistries.POTIONS.register((IForgeRegistryEntry)HORNY_EFFECT);
/* 40 */     ForgeRegistries.POTION_TYPES.register((IForgeRegistryEntry)HORNY_POTION);
/* 41 */     PotionHelper.func_193357_a(PotionTypes.field_185231_c, Item.func_150898_a((Block)Blocks.field_150328_O), HORNY_POTION);
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void removeHornyFromPlayer(TickEvent.PlayerTickEvent event) {
/* 47 */     event.player.func_184589_d(HORNY_EFFECT);
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void makeAnimalsHorny(LivingEvent.LivingUpdateEvent event) {
/* 53 */     if (event.getEntity() instanceof EntityVillager) {
/*    */       
/* 55 */       EntityVillager villager = (EntityVillager)event.getEntity();
/*    */       
/* 57 */       if (villager.func_70644_a(HORNY_EFFECT)) {
/*    */         
/* 59 */         villager.field_70714_bg.func_75776_a(2, new EntityAIVillagerJustBangHerWithoutThinking(villager));
/* 60 */         villager.func_184589_d(HORNY_EFFECT);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 66 */     if (!(event.getEntity() instanceof EntityAnimal)) {
/*    */       return;
/*    */     }
/*    */     
/* 70 */     EntityAnimal entity = (EntityAnimal)event.getEntity();
/*    */     
/* 72 */     if (entity.func_70644_a(HORNY_EFFECT)) {
/*    */       
/* 74 */       if (entity.func_70874_b() >= 0) {
/*    */         
/* 76 */         entity.func_70873_a(0);
/* 77 */         entity.func_70875_t();
/* 78 */         entity.func_146082_f(entity.field_70170_p.func_72890_a((Entity)entity, 30.0D));
/*    */       } 
/*    */ 
/*    */       
/* 82 */       entity.func_184589_d(HORNY_EFFECT);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\hornypotion\HornyPotion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */