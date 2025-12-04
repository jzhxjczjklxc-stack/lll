/*     */ package com.schnurritv.sexmod.hornypotion;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ 
/*     */ public class EntityAIVillagerJustBangHerWithoutThinking extends EntityAIBase {
/*     */   private final EntityVillager villager;
/*     */   private EntityVillager mate;
/*     */   private final World world;
/*     */   private int matingTimeout;
/*     */   
/*     */   public EntityAIVillagerJustBangHerWithoutThinking(EntityVillager villagerIn) {
/*  20 */     this.villager = villagerIn;
/*  21 */     this.world = villagerIn.field_70170_p;
/*  22 */     func_75248_a(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  30 */     if (this.matingTimeout != 0) {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     Entity entity = this.world.func_72857_a(EntityVillager.class, this.villager.func_174813_aQ().func_72314_b(8.0D, 3.0D, 8.0D), (Entity)this.villager);
/*     */     
/*  36 */     if (entity == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  42 */     this.mate = (EntityVillager)entity;
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  52 */     this.matingTimeout = 300;
/*  53 */     this.villager.func_70947_e(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  77 */     this.matingTimeout--;
/*  78 */     this.villager.func_70671_ap().func_75651_a((Entity)this.mate, 10.0F, 30.0F);
/*     */     
/*  80 */     if (this.villager.func_70068_e((Entity)this.mate) > 2.25D)
/*     */     {
/*  82 */       this.villager.func_70661_as().func_75497_a((Entity)this.mate, 0.25D);
/*     */     }
/*     */     
/*  85 */     if (this.matingTimeout <= 0) {
/*     */       
/*  87 */       giveBirth();
/*     */       
/*  89 */       this.villager.field_70714_bg.func_85156_a(this);
/*     */     } 
/*     */     
/*  92 */     if (this.villager.func_70681_au().nextInt(35) == 0)
/*     */     {
/*  94 */       this.world.func_72960_a((Entity)this.villager, (byte)12);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void giveBirth() {
/* 100 */     EntityVillager entityVillager = this.villager.func_90011_a((EntityAgeable)this.mate);
/* 101 */     this.mate.func_70873_a(6000);
/* 102 */     this.villager.func_70873_a(6000);
/* 103 */     this.mate.func_175549_o(false);
/* 104 */     this.villager.func_175549_o(false);
/*     */     
/* 106 */     BabyEntitySpawnEvent event = new BabyEntitySpawnEvent((EntityLiving)this.villager, (EntityLiving)this.mate, (EntityAgeable)entityVillager);
/* 107 */     if (MinecraftForge.EVENT_BUS.post((Event)event) || event.getChild() == null)
/* 108 */       return;  EntityAgeable entityAgeable = event.getChild();
/* 109 */     entityAgeable.func_70873_a(-24000);
/* 110 */     entityAgeable.func_70012_b(this.villager.field_70165_t, this.villager.field_70163_u, this.villager.field_70161_v, 0.0F, 0.0F);
/* 111 */     this.world.func_72838_d((Entity)entityAgeable);
/* 112 */     this.world.func_72960_a((Entity)entityAgeable, (byte)12);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\hornypotion\EntityAIVillagerJustBangHerWithoutThinking.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */