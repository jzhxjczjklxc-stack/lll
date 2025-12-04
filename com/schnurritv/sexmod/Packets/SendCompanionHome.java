/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.companion.CompanionPearl;
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.util.Reference;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityEnderPearl;
/*    */ import net.minecraft.util.EnumParticleTypes;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ public class SendCompanionHome
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girl;
/*    */   
/*    */   public SendCompanionHome() {}
/*    */   
/*    */   public SendCompanionHome(UUID girl) {
/* 29 */     this.girl = girl;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 35 */     this.girl = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 36 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 42 */     ByteBufUtils.writeUTF8String(buf, this.girl.toString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SendCompanionHome, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SendCompanionHome message, MessageContext ctx) {
/* 50 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 52 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girl);
/*    */         
/* 54 */         for (GirlEntity girl : girlList) {
/*    */           
/* 56 */           if (!girl.field_70170_p.field_72995_K) {
/*    */             
/* 58 */             if (girl.currentAction() != GirlEntity.Action.THROW_PEARL) {
/*    */               
/* 60 */               girl.setCurrentAction(GirlEntity.Action.THROW_PEARL);
/* 61 */               girl.setTargetYaw((float)Math.atan2(girl.field_70161_v - girl.home.field_72449_c, girl.field_70165_t - girl.home.field_72450_a) * 57.29578F + 90.0F);
/* 62 */               girl.setTargetPos(girl.func_174791_d());
/* 63 */               girl.func_184212_Q().func_187227_b(GirlEntity.SHOULD_BE_AT_TARGET, Boolean.valueOf(true));
/* 64 */               girl.pearl = null;
/* 65 */               System.out.println("animation set"); continue;
/*    */             } 
/* 67 */             if (girl.pearl == null) {
/*    */               
/* 69 */               float distance = (float)girl.func_174791_d().func_72438_d(girl.home);
/*    */               
/* 71 */               girl.pearl = (EntityEnderPearl)new CompanionPearl(girl.field_70170_p, (EntityLivingBase)girl);
/*    */               
/* 73 */               girl.pearl.func_70186_c(girl.home.field_72450_a - girl.field_70165_t, girl.home.field_72448_b - girl.field_70163_u, girl.home.field_72449_c - girl.field_70161_v, Math.min(4.0F, distance * 0.1F), 0.0F);
/* 74 */               girl.field_70170_p.func_72838_d((Entity)girl.pearl);
/*    */               
/*    */               continue;
/*    */             } 
/*    */             
/* 79 */             WorldServer server = (WorldServer)girl.field_70170_p;
/*    */             
/* 81 */             for (int i = 0; i < 32; i++)
/*    */             {
/* 83 */               server.func_180505_a(EnumParticleTypes.PORTAL, false, girl.field_70165_t, girl.field_70163_u + Reference.RANDOM.nextDouble() * 2.0D, girl.field_70161_v, 32, 0.2D, 0.2D, 0.2D, Reference.RANDOM.nextGaussian(), new int[0]);
/*    */             }
/*    */             
/* 86 */             girl.func_70107_b(girl.home.field_72450_a, girl.home.field_72448_b, girl.home.field_72449_c);
/* 87 */             girl.pearl = null;
/* 88 */             girl.setCurrentAction(GirlEntity.Action.NULL);
/* 89 */             girl.func_184212_Q().func_187227_b(GirlEntity.SHOULD_BE_AT_TARGET, Boolean.valueOf(false));
/* 90 */             girl.stopCompanionShip();
/*    */           } 
/*    */         } 
/*    */       } else {
/*    */         
/* 95 */         System.out.println("received an invalid message @SendCompanionHome :(");
/*    */       } 
/*    */       
/* 98 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SendCompanionHome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */