/*     */ package com.schnurritv.sexmod.companion;
/*     */ import com.schnurritv.sexmod.girls.GirlEntity;
/*     */ import net.minecraft.advancements.CriteriaTriggers;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityEnderPearl;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityEndGateway;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.living.EnderTeleportEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class CompanionPearl extends EntityEnderPearl {
/*     */   public CompanionPearl(World worldIn) {
/*  22 */     super(worldIn);
/*     */   }
/*     */   
/*     */   public CompanionPearl(World worldIn, EntityLivingBase throwerIn) {
/*  26 */     super(worldIn, throwerIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70184_a(RayTraceResult result) {
/*  32 */     EntityLivingBase entitylivingbase = func_85052_h();
/*     */     
/*  34 */     if (result.field_72313_a == RayTraceResult.Type.BLOCK) {
/*     */       
/*  36 */       BlockPos blockpos = result.func_178782_a();
/*  37 */       TileEntity tileentity = this.field_70170_p.func_175625_s(blockpos);
/*     */       
/*  39 */       if (tileentity instanceof TileEntityEndGateway) {
/*     */         
/*  41 */         TileEntityEndGateway tileentityendgateway = (TileEntityEndGateway)tileentity;
/*     */         
/*  43 */         if (entitylivingbase != null) {
/*     */           
/*  45 */           if (entitylivingbase instanceof EntityPlayerMP)
/*     */           {
/*  47 */             CriteriaTriggers.field_192124_d.func_192193_a((EntityPlayerMP)entitylivingbase, this.field_70170_p.func_180495_p(blockpos));
/*     */           }
/*     */           
/*  50 */           tileentityendgateway.func_184306_a((Entity)entitylivingbase);
/*  51 */           func_70106_y();
/*     */           
/*     */           return;
/*     */         } 
/*  55 */         tileentityendgateway.func_184306_a((Entity)this);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  60 */     for (int i = 0; i < 32; i++)
/*     */     {
/*  62 */       this.field_70170_p.func_175688_a(EnumParticleTypes.PORTAL, this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0D, this.field_70146_Z.nextGaussian(), new int[0]);
/*     */     }
/*     */     
/*  65 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/*  67 */       if (entitylivingbase != null) {
/*     */         
/*  69 */         GirlEntity girl = (GirlEntity)entitylivingbase;
/*     */         
/*  71 */         if (girl.home.func_72438_d(func_174791_d()) < 5.0D) {
/*  72 */           EnderTeleportEvent event = new EnderTeleportEvent(entitylivingbase, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5.0F);
/*  73 */           if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
/*     */             
/*  75 */             if (entitylivingbase.func_184218_aH())
/*     */             {
/*  77 */               entitylivingbase.func_184210_p();
/*     */             }
/*     */             
/*  80 */             entitylivingbase.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  81 */             entitylivingbase.field_70143_R = 0.0F;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  86 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class EventHandler
/*     */   {
/*     */     @SubscribeEvent
/*     */     public void arrive(EnderTeleportEvent event) {
/*  95 */       if (event.getEntityLiving() instanceof GirlEntity) {
/*     */         
/*  97 */         GirlEntity girl = (GirlEntity)event.getEntityLiving();
/*     */         
/*  99 */         girl.pearl = null;
/* 100 */         girl.setCurrentAction(GirlEntity.Action.NULL);
/* 101 */         girl.func_184212_Q().func_187227_b(GirlEntity.SHOULD_BE_AT_TARGET, Boolean.valueOf(false));
/* 102 */         girl.stopCompanionShip();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\companion\CompanionPearl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */