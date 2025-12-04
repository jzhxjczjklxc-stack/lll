/*     */ package com.schnurritv.sexmod.gui;
/*     */ 
/*     */ import com.schnurritv.sexmod.Packets.RemoveItems;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Handlers.SoundsHandler;
/*     */ import com.schnurritv.sexmod.util.PenisMath;
/*     */ import java.util.Arrays;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.TextComponentString;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuUI
/*     */   extends GuiScreen
/*     */ {
/*     */   GirlEntity girl;
/*     */   EntityPlayer player;
/*     */   String[] actions;
/*     */   int[] cost;
/*     */   Item[] item;
/*  33 */   static final ResourceLocation ITEMS_BACKGROUND = new ResourceLocation("sexmod", "textures/gui/girlinventory.png");
/*     */   
/*     */   EntityDataManager dataManager;
/*     */   
/*     */   boolean hasChosen = false;
/*     */   boolean drawEquipment = false;
/*     */   
/*     */   public MenuUI(EntityPlayer player, GirlEntity girl, String[] actions, int[] cost, Item[] item) {
/*  41 */     this.girl = girl;
/*  42 */     this.player = player;
/*  43 */     this.actions = actions;
/*  44 */     this.cost = cost;
/*  45 */     this.item = item;
/*  46 */     this.dataManager = girl.func_184212_Q();
/*  47 */     this.extraButtonWidth = new int[actions.length];
/*  48 */     Arrays.fill(this.extraButtonWidth, 0);
/*     */     
/*  50 */     for (String action : actions) {
/*     */       
/*  52 */       if (action.contains("companion")) {
/*  53 */         this.drawEquipment = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  62 */     buttonTransitionStep = 0.0F;
/*  63 */     priceTransitionStep = 0.0F;
/*     */     
/*  65 */     if (!this.girl.canCloseUiWithoutHavingChosen() && !this.hasChosen)
/*     */     {
/*  67 */       this.girl.resetGirl();
/*     */     }
/*  69 */     super.func_146281_b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/*  75 */     this.hasChosen = true;
/*     */     
/*  77 */     if (this.cost[button.field_146127_k] != 0 && !this.player.field_71075_bZ.field_75098_d) {
/*     */       
/*  79 */       for (ItemStack item : this.player.field_71071_by.field_70462_a) {
/*     */         
/*  81 */         if (item.func_77973_b().equals(this.item[button.field_146127_k]) && item.func_190916_E() >= this.cost[button.field_146127_k]) {
/*     */           
/*  83 */           PacketHandler.INSTANCE.sendToServer((IMessage)new RemoveItems(this.player.getPersistentID(), new ItemStack(item.func_77973_b(), this.cost[button.field_146127_k])));
/*  84 */           applyAction(button.field_146127_k);
/*  85 */           this.player.func_71053_j();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*  90 */       this.player.func_145747_a((ITextComponent)new TextComponentString("<" + this.girl.func_70005_c_() + "> you cannot afford that..."));
/*  91 */       this.girl.playSoundAroundHer(SoundsHandler.GIRLS_JENNY_SADOH[1]);
/*     */     } else {
/*     */       
/*  94 */       this.player.func_71053_j();
/*  95 */       applyAction(button.field_146127_k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void applyAction(int id) {
/* 102 */     this.girl.doAction(this.actions[id], this.player.getPersistentID());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 109 */     return false;
/*     */   }
/*     */   
/* 112 */   static float priceTransitionStep = 0.0F;
/* 113 */   static float buttonTransitionStep = 0.0F;
/*     */ 
/*     */   
/*     */   int[] extraButtonWidth;
/*     */ 
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 120 */     ScaledResolution resolution = new ScaledResolution(this.field_146297_k);
/* 121 */     int screenWidth = resolution.func_78326_a();
/* 122 */     int screenHeight = resolution.func_78328_b();
/*     */     
/* 124 */     priceTransitionStep = Math.min(2.0F, priceTransitionStep + this.field_146297_k.func_193989_ak() / 5.0F);
/*     */     
/* 126 */     int xText = (int)PenisMath.Lerp(120.0D, 161.0D, (priceTransitionStep - 1.0F));
/* 127 */     int xItem = (int)PenisMath.Lerp(96.0D, 137.0D, (priceTransitionStep - 1.0F));
/*     */ 
/*     */     
/* 130 */     if (priceTransitionStep > 1.0F) {
/*     */       
/* 132 */       int yText = 132;
/* 133 */       int yItem = 148;
/*     */       
/* 135 */       this.field_146296_j.field_77023_b = -300.0F;
/*     */       
/* 137 */       for (int j = 0; j < this.actions.length; j++) {
/*     */         
/* 139 */         if (this.cost[j] != 0) {
/*     */           
/* 141 */           func_146279_a(this.cost[j] + "x    ", screenWidth - xText, screenHeight - yText);
/* 142 */           this.field_146296_j.func_175042_a(new ItemStack(this.item[j], this.cost[j]), screenWidth - xItem, screenHeight - yItem);
/* 143 */           yText -= 30;
/* 144 */           yItem -= 30;
/*     */         } 
/*     */       } 
/*     */       
/* 148 */       this.field_146296_j.field_77023_b = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 152 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*     */     
/* 154 */     this.field_146292_n.clear();
/*     */     
/* 156 */     if (buttonTransitionStep < 1.0F) {
/*     */       
/* 158 */       buttonTransitionStep += this.field_146297_k.func_193989_ak() / 5.0F;
/*     */     } else {
/*     */       
/* 161 */       buttonTransitionStep = 1.0F;
/*     */     } 
/*     */     
/* 164 */     int x = (int)PenisMath.Lerp(-30.0D, 120.0D, buttonTransitionStep);
/* 165 */     int yRightSide = 150;
/* 166 */     int yLeftSide = 185;
/*     */     
/* 168 */     for (int i = 0; i < this.actions.length; i++) {
/*     */       
/* 170 */       if (this.actions[i].startsWith("companion")) {
/* 171 */         if (priceTransitionStep > 1.4F)
/*     */         {
/* 173 */           int textureXoffest = 0;
/* 174 */           int spaces = 0;
/* 175 */           int maxSize = 0;
/*     */           
/* 177 */           switch (this.actions[i]) {
/*     */             
/*     */             case "companion Set new home":
/* 180 */               spaces = 5;
/* 181 */               maxSize = 80;
/*     */               break;
/*     */ 
/*     */             
/*     */             case "companion Go home":
/* 186 */               textureXoffest = 16;
/* 187 */               spaces = 5;
/* 188 */               maxSize = 50;
/*     */               break;
/*     */ 
/*     */             
/*     */             case "companion Follow me":
/* 193 */               textureXoffest = 32;
/* 194 */               spaces = 4;
/* 195 */               maxSize = 50;
/*     */               break;
/*     */ 
/*     */             
/*     */             case "companion Stop following me":
/* 200 */               textureXoffest = 48;
/* 201 */               spaces = 4;
/* 202 */               maxSize = 90;
/*     */               break;
/*     */ 
/*     */             
/*     */             case "companion Equipment":
/* 207 */               textureXoffest = 64;
/* 208 */               spaces = 4;
/* 209 */               maxSize = 60;
/*     */               break;
/*     */           } 
/*     */           
/* 213 */           int buttonX = xItem - 100;
/* 214 */           float buttonXEnd = (buttonX + 100);
/* 215 */           int buttonY = 255 - yLeftSide;
/* 216 */           float buttonYEnd = (buttonY + 22);
/*     */           
/* 218 */           if (mouseX >= buttonX && mouseX <= buttonXEnd && mouseY >= buttonY && mouseY <= buttonYEnd) {
/* 219 */             this.extraButtonWidth[i] = this.extraButtonWidth[i] + 7;
/*     */           } else {
/*     */             
/* 222 */             this.extraButtonWidth[i] = 0;
/*     */           } 
/*     */           
/* 225 */           this.extraButtonWidth[i] = Math.min(maxSize, this.extraButtonWidth[i]);
/*     */           
/* 227 */           StringBuilder buttonText = new StringBuilder(this.actions[i].substring(9));
/*     */           
/* 229 */           for (int i2 = 0; i2 < spaces; i2++) {
/* 230 */             buttonText.append(" ");
/*     */           }
/*     */           
/* 233 */           this.field_146297_k.field_71446_o.func_110577_a(ITEMS_BACKGROUND);
/*     */           
/* 235 */           func_73729_b(this.extraButtonWidth[i] + buttonX + 4, buttonY + 2, textureXoffest + 32, 0, 16, 16);
/* 236 */           this.field_146292_n.add(new GuiButton(i, buttonX, buttonY, 23 + this.extraButtonWidth[i], 20, (this.extraButtonWidth[i] == 0) ? "" : buttonText.toString()));
/*     */           
/* 238 */           yLeftSide -= 30;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 243 */         this.field_146292_n.add(new GuiButton(i, screenWidth - x, screenHeight - yRightSide, 100, 20, this.actions[i]));
/* 244 */         yRightSide -= 30;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 249 */     if (this.drawEquipment) {
/* 250 */       this.field_146297_k.field_71446_o.func_110577_a(ITEMS_BACKGROUND);
/* 251 */       func_73729_b(x - 113, 60, 0, 0, 32, 130);
/*     */ 
/*     */       
/* 254 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.WEAPON), x - 105, 68);
/* 255 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.BOW), x - 105, 87);
/* 256 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.HELMET), x - 105, 109);
/* 257 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.CHEST_PLATE), x - 105, 127);
/* 258 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.PANTS), x - 105, 146);
/* 259 */       this.field_146296_j.func_175042_a((ItemStack)this.dataManager.func_187225_a(GirlEntity.SHOES), x - 105, 166);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\MenuUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */