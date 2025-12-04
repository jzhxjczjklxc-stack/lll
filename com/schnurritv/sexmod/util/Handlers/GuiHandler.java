/*    */ package com.schnurritv.sexmod.util.Handlers;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.gui.GirlContainer;
/*    */ import com.schnurritv.sexmod.gui.GirlInventoryUI;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 28 */     if (ID == 0)
/*    */     {
/* 30 */       for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */         
/* 32 */         if (!girl.field_70170_p.field_72995_K && girl.func_180425_c().func_177958_n() == x && girl.func_180425_c().func_177956_o() == y && girl.func_180425_c().func_177952_p() == z)
/*    */         {
/* 34 */           return new GirlContainer(girl, player.field_71071_by, UUID.randomUUID());
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 45 */     if (ID == 0)
/*    */     {
/* 47 */       for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */         
/* 49 */         if (girl.field_70170_p.field_72995_K && girl.func_180425_c().func_177958_n() == x && girl.func_180425_c().func_177956_o() == y && girl.func_180425_c().func_177952_p() == z)
/*    */         {
/* 51 */           return new GirlInventoryUI(girl, player.field_71071_by, UUID.randomUUID());
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\GuiHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */