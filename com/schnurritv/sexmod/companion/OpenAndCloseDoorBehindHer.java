/*     */ package com.schnurritv.sexmod.companion;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDoor;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.pathfinding.Path;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ 
/*     */ public class OpenAndCloseDoorBehindHer extends EntityAIBase {
/*     */   protected EntityLiving entity;
/*  17 */   protected BlockPos doorPosition = BlockPos.field_177992_a;
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockDoor doorBlock;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasStoppedDoorInteraction;
/*     */ 
/*     */ 
/*     */   
/*     */   float entityPositionX;
/*     */ 
/*     */   
/*     */   float entityPositionZ;
/*     */ 
/*     */   
/*     */   int closeDoorTick;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  40 */     boolean flag = true;
/*     */     
/*  42 */     for (int x = -3; x < 5; x++) {
/*  43 */       for (int z = -3; z < 5; z++) {
/*     */         
/*  45 */         IBlockState state = this.entity.field_70170_p.func_180495_p(this.entity.func_180425_c().func_177982_a(x, 0, z));
/*     */         
/*  47 */         if (state.func_177230_c() instanceof BlockDoor && state.func_185904_a() == Material.field_151575_d) {
/*     */           
/*  49 */           flag = false;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  54 */       if (!flag) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/*  59 */     if (flag)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  65 */     PathNavigateGround pathnavigateground = (PathNavigateGround)this.entity.func_70661_as();
/*  66 */     Path path = pathnavigateground.func_75505_d();
/*     */     
/*  68 */     if (path != null && !path.func_75879_b() && pathnavigateground.func_179686_g()) {
/*     */       
/*  70 */       for (int i = 0; i < Math.min(path.func_75873_e() + 2, path.func_75874_d()); i++) {
/*     */         
/*  72 */         PathPoint pathpoint = path.func_75877_a(i);
/*  73 */         this.doorPosition = new BlockPos(pathpoint.field_75839_a, pathpoint.field_75837_b + 1, pathpoint.field_75838_c);
/*     */         
/*  75 */         if (this.entity.func_70092_e(this.doorPosition.func_177958_n(), this.entity.field_70163_u, this.doorPosition.func_177952_p()) <= 2.25D) {
/*     */           
/*  77 */           this.doorBlock = getBlockDoor(this.doorPosition);
/*     */           
/*  79 */           if (this.doorBlock != null)
/*     */           {
/*  81 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  86 */       this.doorPosition = (new BlockPos((Entity)this.entity)).func_177984_a();
/*  87 */       this.doorBlock = getBlockDoor(this.doorPosition);
/*  88 */       return (this.doorBlock != null);
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/* 102 */     return (this.closeDoorTick >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/* 110 */     this.hasStoppedDoorInteraction = false;
/* 111 */     this.entityPositionX = (float)((this.doorPosition.func_177958_n() + 0.5F) - this.entity.field_70165_t);
/* 112 */     this.entityPositionZ = (float)((this.doorPosition.func_177952_p() + 0.5F) - this.entity.field_70161_v);
/* 113 */     this.doorBlock.func_176512_a(this.entity.field_70170_p, this.doorPosition, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenAndCloseDoorBehindHer(EntityLiving entityIn) {
/* 119 */     this.closeDoorTick = 10;
/*     */     this.entity = entityIn;
/*     */     if (!(entityIn.func_70661_as() instanceof PathNavigateGround))
/*     */       throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");  } public void func_75246_d() {
/* 123 */     float f = (float)((this.doorPosition.func_177958_n() + 0.5F) - this.entity.field_70165_t);
/* 124 */     float f1 = (float)((this.doorPosition.func_177952_p() + 0.5F) - this.entity.field_70161_v);
/* 125 */     float f2 = this.entityPositionX * f + this.entityPositionZ * f1;
/*     */     
/* 127 */     if (f2 < 0.0F)
/*     */     {
/* 129 */       if (--this.closeDoorTick <= 0) {
/*     */         
/* 131 */         this.doorBlock.func_176512_a(this.entity.field_70170_p, this.doorPosition, false);
/* 132 */         this.hasStoppedDoorInteraction = true;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/* 142 */     this.closeDoorTick = 10;
/*     */   }
/*     */ 
/*     */   
/*     */   private BlockDoor getBlockDoor(BlockPos pos) {
/* 147 */     IBlockState iblockstate = this.entity.field_70170_p.func_180495_p(pos);
/* 148 */     Block block = iblockstate.func_177230_c();
/* 149 */     return (block instanceof BlockDoor && iblockstate.func_185904_a() == Material.field_151575_d) ? (BlockDoor)block : null;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\OpenAndCloseDoorBehindHer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */