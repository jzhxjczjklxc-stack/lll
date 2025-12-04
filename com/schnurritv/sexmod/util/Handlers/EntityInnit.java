/*    */ package com.schnurritv.sexmod.util.Handlers;
/*    */ 
/*    */ import com.schnurritv.sexmod.Main;
/*    */ import com.schnurritv.sexmod.girls.allie.AllieEntity;
/*    */ import com.schnurritv.sexmod.girls.bia.BiaEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*    */ import com.schnurritv.sexmod.girls.slime.friendlySlime.FriendlySlimeEntity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EnumCreatureType;
/*    */ import net.minecraft.init.Biomes;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ 
/*    */ 
/*    */ public class EntityInnit
/*    */ {
/*    */   public static void registerEntities() {
/* 21 */     registerEntity("jenny", (Class)JennyEntity.class, 177013, 3286592, 12655237);
/* 22 */     registerEntity("ellie", (Class)EllieEntity.class, 228922, 1447446, 9961472);
/* 23 */     registerEntity("slime", (Class)SlimeEntity.class, 168597, 13167780, 8244330);
/* 24 */     registerEntity("bia", (Class)BiaEntity.class, 230053, 7488816, 7254603);
/*    */ 
/*    */     
/* 27 */     EntityRegistry.registerModEntity(new ResourceLocation("sexmod:allie"), AllieEntity.class, "allie", 5614613, Main.instance, 50, 1, true);
/*    */ 
/*    */     
/* 30 */     EntityRegistry.registerModEntity(new ResourceLocation("sexmod:friendly_slime"), FriendlySlimeEntity.class, "friendly_slime", 5548484, Main.instance, 50, 1, true);
/*    */     
/* 32 */     EntityRegistry.addSpawn(SlimeEntity.class, 10, 1, 1, EnumCreatureType.CREATURE, new Biome[] { Biomes.field_76780_h, Biomes.field_150599_m });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void registerEntity(String name, Class<? extends Entity> entity, int id, int color1, int color2) {
/* 40 */     EntityRegistry.registerModEntity(new ResourceLocation("sexmod:" + name), entity, name, id, Main.instance, 50, 1, true, color1, color2);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmo\\util\Handlers\EntityInnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */