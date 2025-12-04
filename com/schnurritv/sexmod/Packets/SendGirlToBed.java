/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.bia.BiaEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ public class SendGirlToBed
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girlUUID;
/*    */   
/*    */   public SendGirlToBed() {
/* 22 */     this.messageValid = false;
/*    */   }
/*    */   
/*    */   public SendGirlToBed(UUID girlUUID) {
/* 26 */     this.girlUUID = girlUUID;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 33 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 39 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SendGirlToBed, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SendGirlToBed message, MessageContext ctx) {
/* 48 */       if (message.messageValid) {
/*    */ 
/*    */         
/* 51 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 53 */         for (GirlEntity girl : girlList) {
/*    */           
/* 55 */           if (!girl.field_70170_p.field_72995_K) {
/*    */             
/* 57 */             if (girl instanceof JennyEntity) {
/* 58 */               ((JennyEntity)girl).goForDoggy(); continue;
/*    */             } 
/* 60 */             if (girl instanceof EllieEntity) {
/*    */               
/* 62 */               ((EllieEntity)girl).goForCowgirl(); continue;
/*    */             } 
/* 64 */             if (girl instanceof BiaEntity)
/*    */             {
/* 66 */               ((BiaEntity)girl).goForAnal();
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } else {
/*    */         
/* 72 */         System.out.println("received an invalid message @SendGirlToSex :(");
/*    */       } 
/*    */       
/* 75 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SendGirlToBed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */