/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetNewHome
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girl;
/*    */   Vec3d pos;
/*    */   
/*    */   public SetNewHome() {}
/*    */   
/*    */   public SetNewHome(UUID girl, Vec3d pos) {
/* 25 */     this.girl = girl;
/* 26 */     this.pos = pos;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     this.girl = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 33 */     this.pos = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 34 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 40 */     ByteBufUtils.writeUTF8String(buf, this.girl.toString());
/* 41 */     buf.writeDouble(this.pos.field_72450_a);
/* 42 */     buf.writeDouble(this.pos.field_72448_b);
/* 43 */     buf.writeDouble(this.pos.field_72449_c);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SetNewHome, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SetNewHome message, MessageContext ctx) {
/* 52 */       if (message.messageValid) {
/*    */         
/* 54 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girl);
/*    */         
/* 56 */         ((GirlEntity)girlList.get(0)).say("Alright! this is my new Home~");
/*    */         
/* 58 */         for (GirlEntity girl : girlList) {
/* 59 */           girl.home = new Vec3d(message.pos.field_72450_a, Math.floor(message.pos.field_72448_b), message.pos.field_72449_c);
/*    */         }
/*    */       } else {
/*    */         
/* 63 */         System.out.println("received an invalid message @SetNewHome :(");
/*    */       } 
/*    */       
/* 66 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SetNewHome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */