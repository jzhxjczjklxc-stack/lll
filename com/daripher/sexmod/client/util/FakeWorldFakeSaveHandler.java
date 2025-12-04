/*    */ package com.daripher.sexmod.client.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.MinecraftException;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.chunk.storage.IChunkLoader;
/*    */ import net.minecraft.world.gen.structure.template.TemplateManager;
/*    */ import net.minecraft.world.storage.IPlayerFileData;
/*    */ import net.minecraft.world.storage.ISaveHandler;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ 
/*    */ public class FakeWorldFakeSaveHandler
/*    */   implements ISaveHandler
/*    */ {
/*    */   @Nullable
/*    */   public WorldInfo func_75757_d() {
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75762_c() throws MinecraftException {}
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkLoader func_75763_a(WorldProvider provider) {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75755_a(WorldInfo worldInformation, NBTTagCompound tagCompound) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75761_a(WorldInfo worldInformation) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public IPlayerFileData func_75756_e() {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75759_a() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public File func_75765_b() {
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public File func_75758_b(String mapName) {
/* 61 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public TemplateManager func_186340_h() {
/* 66 */     return new TemplateManager("", Minecraft.func_71410_x().func_184126_aj());
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakeWorldFakeSaveHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */