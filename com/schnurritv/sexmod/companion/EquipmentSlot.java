/*    */ package com.schnurritv.sexmod.companion;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.items.IItemHandler;
/*    */ import net.minecraftforge.items.SlotItemHandler;
/*    */ 
/*    */ public class EquipmentSlot extends SlotItemHandler {
/*    */   Slot slot;
/*    */   
/*    */   public enum Slot {
/* 13 */     WEAPON(0),
/* 14 */     BOW(1),
/* 15 */     HELMET(2),
/* 16 */     CHEST_PLATE(3),
/* 17 */     PANTS(4),
/* 18 */     SHOES(5);
/*    */     
/*    */     public int id;
/*    */     
/*    */     public static Slot getSlotById(int id) {
/* 23 */       switch (id) {
/*    */         case 0:
/* 25 */           return WEAPON;
/*    */         
/*    */         case 1:
/* 28 */           return BOW;
/*    */         
/*    */         case 2:
/* 31 */           return HELMET;
/*    */         
/*    */         case 3:
/* 34 */           return CHEST_PLATE;
/*    */         
/*    */         case 4:
/* 37 */           return PANTS;
/*    */         
/*    */         case 5:
/* 40 */           return SHOES;
/*    */       } 
/*    */       
/* 43 */       throw new NullPointerException("Girls don't have a slot nr. " + id);
/*    */     }
/*    */     
/*    */     Slot(int id) {
/* 47 */       this.id = id;
/*    */     }
/*    */   }
/*    */   
/*    */   public EquipmentSlot(Slot slot, IItemHandler inventoryIn, int index, int xPosition, int yPosition) {
/* 52 */     super(inventoryIn, index, xPosition, yPosition);
/* 53 */     this.slot = slot;
/*    */   }
/*    */   
/*    */   public static boolean isItemValidForSlot(ItemStack stack, int id) {
/* 57 */     return isIemValidForSlot(stack, Slot.getSlotById(id));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack stack) {
/* 63 */     return isIemValidForSlot(stack, this.slot);
/*    */   }
/*    */ 
/*    */   
/*    */   static boolean isIemValidForSlot(ItemStack stack, Slot slot) {
/* 68 */     Item item = stack.func_77973_b();
/*    */     
/* 70 */     switch (slot) {
/*    */       
/*    */       case WEAPON:
/* 73 */         return (item instanceof net.minecraft.item.ItemSword || item instanceof net.minecraft.item.ItemTool);
/*    */       
/*    */       case BOW:
/* 76 */         return item instanceof net.minecraft.item.ItemBow;
/*    */       
/*    */       case HELMET:
/* 79 */         return (item instanceof ItemArmor && ((ItemArmor)item).field_77881_a == EntityEquipmentSlot.HEAD);
/*    */       
/*    */       case CHEST_PLATE:
/* 82 */         return (item instanceof ItemArmor && ((ItemArmor)item).field_77881_a == EntityEquipmentSlot.CHEST);
/*    */       
/*    */       case PANTS:
/* 85 */         return (item instanceof ItemArmor && ((ItemArmor)item).field_77881_a == EntityEquipmentSlot.LEGS);
/*    */       
/*    */       case SHOES:
/* 88 */         return (item instanceof ItemArmor && ((ItemArmor)item).field_77881_a == EntityEquipmentSlot.FEET);
/*    */     } 
/*    */     
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\EquipmentSlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */