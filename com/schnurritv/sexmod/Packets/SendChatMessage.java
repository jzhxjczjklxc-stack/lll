/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.TextComponentString;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ 
/*    */ public class SendChatMessage
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   String chatMessage;
/*    */   int dimension;
/*    */   UUID girlUUID;
/*    */   
/*    */   public SendChatMessage(String chatMessage, int dimension, UUID girlUUID) {
/* 27 */     this.chatMessage = chatMessage;
/* 28 */     this.dimension = dimension;
/* 29 */     this.girlUUID = girlUUID;
/* 30 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public SendChatMessage() {
/* 35 */     this.messageValid = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/*    */     try {
/* 44 */       int stringLength = buf.readInt();
/* 45 */       byte[] bytes = new byte[stringLength];
/*    */       
/* 47 */       for (int i = 0; i < stringLength; i++)
/*    */       {
/* 49 */         bytes[i] = buf.readByte();
/*    */       }
/*    */       
/* 52 */       this.chatMessage = new String(bytes);
/*    */       
/* 54 */       this.dimension = buf.readInt();
/* 55 */       this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/*    */       
/* 57 */       this.messageValid = true;
/*    */     }
/* 59 */     catch (IndexOutOfBoundsException ioe) {
/*    */       
/* 61 */       this.messageValid = false;
/* 62 */       System.out.println("couldn't read bytes @SendChatMessage :(");
/*    */       return;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 71 */     buf.writeInt((this.chatMessage.getBytes()).length);
/* 72 */     buf.writeBytes(this.chatMessage.getBytes());
/* 73 */     buf.writeInt(this.dimension);
/* 74 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SendChatMessage, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SendChatMessage message, MessageContext ctx) {
/* 83 */       if (message.messageValid) {
/*    */         
/* 85 */         if (ctx.side.isClient()) {
/*    */           
/* 87 */           (Minecraft.func_71410_x()).field_71439_g.func_145747_a((ITextComponent)new TextComponentString(message.chatMessage));
/*    */         } else {
/*    */           
/* 90 */           Vec3d girlPos = ((GirlEntity)GirlEntity.getGirlsByUUID(message.girlUUID).get(0)).prevPos();
/* 91 */           PacketHandler.INSTANCE.sendToAllAround(new SendChatMessage(message.chatMessage, message.dimension, message.girlUUID), new NetworkRegistry.TargetPoint(message.dimension, girlPos.field_72450_a, girlPos.field_72448_b, girlPos.field_72449_c, 40.0D));
/*    */         } 
/*    */       } else {
/*    */         
/* 95 */         System.out.println("recieved an unvalid message @SendChatMessage :(");
/*    */       } 
/*    */ 
/*    */       
/* 99 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SendChatMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */