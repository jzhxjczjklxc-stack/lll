/*     */ package com.schnurritv.sexmod.gui;
/*     */ 
/*     */ import com.schnurritv.sexmod.companion.EquipmentSlot;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.IItemHandler;
/*     */ 
/*     */ public class GirlContainer
/*     */   extends Container
/*     */ {
/*     */   GirlEntity girl;
/*     */   public Slot[] equipmentSlots;
/*     */   public UUID containerId;
/*  24 */   public static List<GirlContainer> list = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public GirlContainer(GirlEntity girl, InventoryPlayer inventoryPlayer, UUID containerId) {
/*  28 */     this.containerId = containerId;
/*  29 */     list.add(this);
/*  30 */     if (girl.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
/*  31 */       IItemHandler inventory = (IItemHandler)girl.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
/*     */       
/*  33 */       this.girl = girl;
/*  34 */       this.equipmentSlots = new Slot[] { (Slot)new EquipmentSlot(EquipmentSlot.Slot.WEAPON, inventory, EquipmentSlot.Slot.WEAPON.id, 31, 60), (Slot)new EquipmentSlot(EquipmentSlot.Slot.BOW, inventory, EquipmentSlot.Slot.BOW.id, 50, 60), (Slot)new EquipmentSlot(EquipmentSlot.Slot.HELMET, inventory, EquipmentSlot.Slot.HELMET.id, 72, 60), (Slot)new EquipmentSlot(EquipmentSlot.Slot.CHEST_PLATE, inventory, EquipmentSlot.Slot.CHEST_PLATE.id, 91, 60), (Slot)new EquipmentSlot(EquipmentSlot.Slot.PANTS, inventory, EquipmentSlot.Slot.PANTS.id, 110, 60), (Slot)new EquipmentSlot(EquipmentSlot.Slot.SHOES, inventory, EquipmentSlot.Slot.SHOES.id, 129, 60) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  43 */       List<Slot> playerSlots = new ArrayList<>();
/*     */       
/*  45 */       for (int y = 0; y < 3; y++) {
/*  46 */         for (int i = 0; i < 9; i++) {
/*  47 */           playerSlots.add(new Slot((IInventory)inventoryPlayer, i + y * 9 + 9, 8 + i * 18, 84 + y * 18));
/*     */         }
/*     */       } 
/*     */       
/*  51 */       for (int x = 0; x < 9; x++) {
/*  52 */         playerSlots.add(new Slot((IInventory)inventoryPlayer, x, 8 + x * 18, 142));
/*     */       }
/*     */       
/*  55 */       for (Slot slot : this.equipmentSlots) {
/*  56 */         func_75146_a(slot);
/*     */       }
/*     */       
/*  59 */       for (Slot slot : playerSlots) {
/*  60 */         func_75146_a(slot);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int index) {
/*  71 */     ItemStack stack = ItemStack.field_190927_a;
/*  72 */     Slot slot = this.field_75151_b.get(index);
/*     */     
/*  74 */     if (slot != null && slot.func_75216_d()) {
/*  75 */       ItemStack stackInSlot = slot.func_75211_c();
/*  76 */       stack = stackInSlot.func_77946_l();
/*     */       
/*  78 */       int containerSlots = this.field_75151_b.size() - player.field_71071_by.field_70462_a.size();
/*     */       
/*  80 */       if (index < containerSlots) {
/*     */         
/*  82 */         if (!func_75135_a(stackInSlot, containerSlots, this.field_75151_b.size(), true)) {
/*  83 */           return ItemStack.field_190927_a;
/*     */         }
/*  85 */       } else if (!func_75135_a(stackInSlot, 0, containerSlots, false)) {
/*  86 */         return ItemStack.field_190927_a;
/*     */       } 
/*     */       
/*  89 */       if (stackInSlot.func_190916_E() == 0) {
/*  90 */         slot.func_75215_d(ItemStack.field_190927_a);
/*     */       } else {
/*  92 */         slot.func_75218_e();
/*     */       } 
/*     */       
/*  95 */       slot.func_190901_a(player, stackInSlot);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 100 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75141_a(int slotID, ItemStack stack) {
/* 105 */     super.func_75141_a(slotID, stack);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer playerIn) {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer playerIn) {
/* 115 */     super.func_75134_a(playerIn);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\GirlContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */