/*    */ package com.schnurritv.sexmod.gui;
/*    */ 
/*    */ import com.schnurritv.sexmod.Packets.UploadInventoryToServer;
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GirlInventoryUI
/*    */   extends GuiContainer
/*    */ {
/* 20 */   static final ResourceLocation ITEMS_BACKGROUND = new ResourceLocation("sexmod", "textures/gui/girlinventory.png");
/*    */   UUID containerUUID;
/*    */   GirlEntity girl;
/*    */   UUID playerUUID;
/*    */   
/*    */   public GirlInventoryUI(GirlEntity girl, InventoryPlayer inventoryPlayer, UUID containerUUID) {
/* 26 */     super(new GirlContainer(girl, inventoryPlayer, containerUUID));
/* 27 */     this.containerUUID = containerUUID;
/* 28 */     this.girl = girl;
/* 29 */     this.playerUUID = inventoryPlayer.field_70458_d.getPersistentID();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 34 */     func_146276_q_();
/* 35 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/* 36 */     func_191948_b(mouseX, mouseY);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146281_b() {
/* 41 */     super.func_146281_b();
/*    */     
/* 43 */     GirlContainer rightContainer = null;
/*    */     
/* 45 */     for (GirlContainer container : GirlContainer.list) {
/*    */       
/* 47 */       if (container.containerId.equals(this.containerUUID)) {
/*    */         
/* 49 */         ItemStack[] stacks = new ItemStack[42];
/* 50 */         (Minecraft.func_71410_x()).field_71439_g.field_71071_by.field_70462_a.toArray((Object[])stacks);
/* 51 */         stacks[36] = container.func_75139_a(0).func_75211_c();
/* 52 */         stacks[37] = container.func_75139_a(1).func_75211_c();
/* 53 */         stacks[38] = container.func_75139_a(2).func_75211_c();
/* 54 */         stacks[39] = container.func_75139_a(3).func_75211_c();
/* 55 */         stacks[40] = container.func_75139_a(4).func_75211_c();
/* 56 */         stacks[41] = container.func_75139_a(5).func_75211_c();
/*    */         
/* 58 */         PacketHandler.INSTANCE.sendToServer((IMessage)new UploadInventoryToServer(this.girl.girlId(), this.playerUUID, stacks));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
/* 67 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 69 */     this.field_146297_k.field_71446_o.func_110577_a(ITEMS_BACKGROUND);
/* 70 */     func_73729_b(this.field_146294_l / 2 - 88, this.field_146295_m / 2 - 7 - 24, 33, 16, 176, 114);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\GirlInventoryUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */