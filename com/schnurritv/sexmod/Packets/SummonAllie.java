/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.allie.AllieEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SummonAllie
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid = false;
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 25 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SummonAllie, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SummonAllie message, MessageContext ctx) {
/* 39 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 41 */         EntityPlayerMP entityPlayerMP = (ctx.getServerHandler()).field_147369_b;
/* 42 */         Vec3d pos = entityPlayerMP.func_174791_d().func_72441_c(-Math.sin(((EntityPlayer)entityPlayerMP).field_70759_as * 0.017453292519943295D) * 2.0D, 0.0D, Math.cos(((EntityPlayer)entityPlayerMP).field_70759_as * 0.017453292519943295D) * 2.0D);
/*    */         
/* 44 */         AllieEntity allie = new AllieEntity(((EntityPlayer)entityPlayerMP).field_70170_p, entityPlayerMP.func_184614_ca());
/* 45 */         allie.setPlayer(entityPlayerMP.getPersistentID());
/* 46 */         allie.func_70080_a(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, ((EntityPlayer)entityPlayerMP).field_70759_as + 180.0F, ((EntityPlayer)entityPlayerMP).field_70125_A);
/* 47 */         allie.func_189654_d(true);
/* 48 */         allie.field_70145_X = true;
/* 49 */         ((EntityPlayer)entityPlayerMP).field_70170_p.func_72838_d((Entity)allie);
/*    */       }
/*    */       else {
/*    */         
/* 53 */         System.out.println("received an invalid message @SummonAllie :(");
/*    */       } 
/*    */       
/* 56 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SummonAllie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */