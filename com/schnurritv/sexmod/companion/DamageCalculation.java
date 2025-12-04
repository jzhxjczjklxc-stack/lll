/*     */ package com.schnurritv.sexmod.companion;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSource;
/*     */ import net.minecraftforge.event.entity.living.LivingDamageEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class DamageCalculation
/*     */ {
/*     */   public DamageCalculation() {
/*  27 */     Armor.addArmor(EntityEquipmentSlot.HEAD, ItemArmor.ArmorMaterial.LEATHER, 1, 0);
/*  28 */     Armor.addArmor(EntityEquipmentSlot.HEAD, ItemArmor.ArmorMaterial.GOLD, 2, 0);
/*  29 */     Armor.addArmor(EntityEquipmentSlot.HEAD, ItemArmor.ArmorMaterial.CHAIN, 2, 0);
/*  30 */     Armor.addArmor(EntityEquipmentSlot.HEAD, ItemArmor.ArmorMaterial.IRON, 2, 0);
/*  31 */     Armor.addArmor(EntityEquipmentSlot.HEAD, ItemArmor.ArmorMaterial.DIAMOND, 3, 3);
/*     */     
/*  33 */     Armor.addArmor(EntityEquipmentSlot.CHEST, ItemArmor.ArmorMaterial.LEATHER, 3, 0);
/*  34 */     Armor.addArmor(EntityEquipmentSlot.CHEST, ItemArmor.ArmorMaterial.GOLD, 5, 0);
/*  35 */     Armor.addArmor(EntityEquipmentSlot.CHEST, ItemArmor.ArmorMaterial.CHAIN, 5, 0);
/*  36 */     Armor.addArmor(EntityEquipmentSlot.CHEST, ItemArmor.ArmorMaterial.IRON, 6, 0);
/*  37 */     Armor.addArmor(EntityEquipmentSlot.CHEST, ItemArmor.ArmorMaterial.DIAMOND, 8, 3);
/*     */     
/*  39 */     Armor.addArmor(EntityEquipmentSlot.LEGS, ItemArmor.ArmorMaterial.LEATHER, 2, 0);
/*  40 */     Armor.addArmor(EntityEquipmentSlot.LEGS, ItemArmor.ArmorMaterial.GOLD, 3, 0);
/*  41 */     Armor.addArmor(EntityEquipmentSlot.LEGS, ItemArmor.ArmorMaterial.CHAIN, 4, 0);
/*  42 */     Armor.addArmor(EntityEquipmentSlot.LEGS, ItemArmor.ArmorMaterial.IRON, 5, 0);
/*  43 */     Armor.addArmor(EntityEquipmentSlot.LEGS, ItemArmor.ArmorMaterial.DIAMOND, 6, 3);
/*     */     
/*  45 */     Armor.addArmor(EntityEquipmentSlot.FEET, ItemArmor.ArmorMaterial.LEATHER, 1, 0);
/*  46 */     Armor.addArmor(EntityEquipmentSlot.FEET, ItemArmor.ArmorMaterial.GOLD, 1, 0);
/*  47 */     Armor.addArmor(EntityEquipmentSlot.FEET, ItemArmor.ArmorMaterial.CHAIN, 1, 0);
/*  48 */     Armor.addArmor(EntityEquipmentSlot.FEET, ItemArmor.ArmorMaterial.IRON, 2, 0);
/*  49 */     Armor.addArmor(EntityEquipmentSlot.FEET, ItemArmor.ArmorMaterial.DIAMOND, 3, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void calculateDamage(LivingDamageEvent event) {
/*  55 */     if (event.getEntity() instanceof GirlEntity) {
/*     */       
/*  57 */       GirlEntity girl = (GirlEntity)event.getEntity();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  63 */       ItemStack[] potentialArmors = { girl.inventory.getStackInSlot(2), girl.inventory.getStackInSlot(3), girl.inventory.getStackInSlot(4), girl.inventory.getStackInSlot(5) };
/*     */       
/*  65 */       List<ItemArmor> armorItems = new ArrayList<>();
/*  66 */       List<ItemStack> armorStacks = new ArrayList<>();
/*     */       
/*  68 */       for (ItemStack potentialArmor : potentialArmors) {
/*     */         
/*  70 */         if (potentialArmor.func_77973_b() instanceof ItemArmor) {
/*     */           
/*  72 */           armorItems.add((ItemArmor)potentialArmor.func_77973_b());
/*  73 */           armorStacks.add(potentialArmor);
/*     */         } 
/*     */       } 
/*     */       
/*  77 */       if (armorItems.size() == 0) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*  82 */       DamageSource source = event.getSource();
/*  83 */       int defencePoints = 0;
/*  84 */       int toughness = 0;
/*     */       
/*  86 */       if (!source.func_76363_c())
/*     */       {
/*  88 */         for (ItemArmor armor : armorItems) {
/*     */           
/*  90 */           defencePoints += Armor.getDefensePoints(armor.field_77881_a, armor.func_82812_d());
/*  91 */           toughness += Armor.getToughness(armor.field_77881_a, armor.func_82812_d());
/*     */         } 
/*     */       }
/*     */       
/*  95 */       float damage = event.getAmount();
/*     */ 
/*     */       
/*  98 */       damage *= 1.0F - Math.min(20.0F, Math.max(defencePoints / 5.0F, defencePoints - 4.0F * damage / (toughness + 8.0F))) / 25.0F;
/*     */       
/* 100 */       float thornDamage = 0.0F;
/*     */       
/* 102 */       float temp = damage;
/*     */ 
/*     */       
/* 105 */       for (ItemStack stack : armorStacks) {
/*     */         
/* 107 */         int protection = EnchantmentHelper.func_77506_a(Enchantments.field_180310_c, stack);
/* 108 */         damage -= protection * 0.04F * damage;
/*     */         
/* 110 */         int thorns = EnchantmentHelper.func_77506_a(Enchantments.field_92091_k, stack);
/* 111 */         thornDamage += (Reference.RANDOM.nextFloat() < 0.15F * thorns) ? (Reference.RANDOM.nextFloat() * 4.0F + 1.0F) : 0.0F;
/* 112 */         thornDamage = Math.min(4.0F, thornDamage);
/*     */         
/* 114 */         if (source.func_76347_k()) {
/* 115 */           int fireProtection = EnchantmentHelper.func_77506_a(Enchantments.field_77329_d, stack);
/* 116 */           damage -= fireProtection * 0.08F * damage;
/*     */         } 
/*     */         
/* 119 */         if (source.func_94541_c()) {
/* 120 */           int blastProtection = EnchantmentHelper.func_77506_a(Enchantments.field_185297_d, stack);
/* 121 */           damage -= blastProtection * 0.08F * damage;
/*     */         } 
/*     */         
/* 124 */         if (source.field_76373_n.equals("fall")) {
/* 125 */           int featherFalling = EnchantmentHelper.func_77506_a(Enchantments.field_180309_e, stack);
/* 126 */           damage -= featherFalling * 0.12F * damage;
/*     */         } 
/*     */         
/* 129 */         if (source.func_76352_a()) {
/* 130 */           int projectileProtection = EnchantmentHelper.func_77506_a(Enchantments.field_180308_g, stack);
/* 131 */           damage -= projectileProtection * 0.08F * damage;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 136 */       if (thornDamage > 0.0F && source instanceof EntityDamageSource) {
/*     */         
/* 138 */         EntityDamageSource entityDamageSource = (EntityDamageSource)source;
/*     */         
/* 140 */         if (entityDamageSource.func_76346_g() != null) {
/* 141 */           entityDamageSource.func_76346_g().func_70097_a(DamageSource.func_92087_a((Entity)girl), thornDamage);
/*     */         }
/* 143 */         System.out.println(thornDamage);
/*     */       } 
/*     */       
/* 146 */       event.setAmount(damage);
/*     */     } 
/*     */   }
/*     */   
/*     */   static class Armor
/*     */   {
/* 152 */     public static HashMap<String, Integer[]> stats = (HashMap)new HashMap<>();
/*     */ 
/*     */     
/*     */     public static int getDefensePoints(EntityEquipmentSlot slot, ItemArmor.ArmorMaterial material) {
/*     */       try {
/* 157 */         return ((Integer[])stats.get(slot.toString() + material.toString()))[0].intValue();
/*     */       }
/* 159 */       catch (NullPointerException e) {
/*     */         
/* 161 */         return 3;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public static int getToughness(EntityEquipmentSlot slot, ItemArmor.ArmorMaterial material) {
/*     */       try {
/* 168 */         return ((Integer[])stats.get(slot.toString() + material.toString()))[1].intValue();
/*     */       }
/* 170 */       catch (NullPointerException e) {
/*     */         
/* 172 */         return 0;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public static void addArmor(EntityEquipmentSlot slot, ItemArmor.ArmorMaterial material, int defensePoints, int toughness) {
/* 178 */       stats.put(slot.toString() + material.toString(), new Integer[] { Integer.valueOf(defensePoints), Integer.valueOf(toughness) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\DamageCalculation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */