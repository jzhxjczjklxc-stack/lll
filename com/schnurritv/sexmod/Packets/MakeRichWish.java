/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.util.Reference;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MakeRichWish
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   Vec3d pos;
/*    */   
/*    */   public MakeRichWish() {}
/*    */   
/*    */   public MakeRichWish(Vec3d pos) {
/* 29 */     this.pos = pos;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 35 */     this.pos = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 36 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 42 */     buf.writeDouble(this.pos.field_72450_a);
/* 43 */     buf.writeDouble(this.pos.field_72448_b);
/* 44 */     buf.writeDouble(this.pos.field_72449_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<MakeRichWish, IMessage>
/*    */   {
/*    */     public IMessage onMessage(MakeRichWish message, MessageContext ctx) {
/* 52 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 54 */         World world = (ctx.getServerHandler()).field_147369_b.field_70170_p;
/*    */         
/* 56 */         EntityItem diamonds = new EntityItem(world, message.pos.field_72450_a, message.pos.field_72448_b, message.pos.field_72449_c, new ItemStack(Items.field_151045_i, Reference.RANDOM.nextInt(2) + 1));
/* 57 */         EntityItem emeralds = new EntityItem(world, message.pos.field_72450_a, message.pos.field_72448_b, message.pos.field_72449_c, new ItemStack(Items.field_151166_bC, Reference.RANDOM.nextInt(2) + 1));
/* 58 */         EntityItem gold = new EntityItem(world, message.pos.field_72450_a, message.pos.field_72448_b, message.pos.field_72449_c, new ItemStack(Items.field_151043_k, Reference.RANDOM.nextInt(2) + 1));
/*    */         
/* 60 */         world.func_72838_d((Entity)diamonds);
/* 61 */         world.func_72838_d((Entity)emeralds);
/* 62 */         world.func_72838_d((Entity)gold);
/*    */       } else {
/*    */         
/* 65 */         System.out.println("received an invalid message @MakeRichWish :(");
/*    */       } 
/*    */       
/* 68 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\MakeRichWish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */