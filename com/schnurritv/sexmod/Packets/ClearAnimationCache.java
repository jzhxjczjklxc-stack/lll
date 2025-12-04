/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ public class ClearAnimationCache
/*    */   implements IMessage {
/*    */   boolean messageValid;
/*    */   UUID girlUUID;
/*    */   
/*    */   public ClearAnimationCache() {
/* 20 */     this.messageValid = false;
/*    */   }
/*    */   
/*    */   public ClearAnimationCache(UUID girlUUID) {
/* 24 */     this.girlUUID = girlUUID;
/* 25 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 31 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 32 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 38 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<ClearAnimationCache, IMessage>
/*    */   {
/*    */     public IMessage onMessage(ClearAnimationCache message, MessageContext ctx) {
/* 47 */       if (message.messageValid) {
/*    */         
/* 49 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 51 */         for (GirlEntity girl : girlList)
/*    */         {
/* 53 */           if (ctx.side.isServer() && !girl.field_70170_p.field_72995_K) {
/*    */             
/* 55 */             PacketHandler.INSTANCE.sendToAllTracking(new ClearAnimationCache(message.girlUUID), (Entity)girl);
/*    */             break;
/*    */           } 
/* 58 */           if (ctx.side.isClient())
/*    */           {
/* 60 */             if (girl.actionController != null) {
/* 61 */               girl.actionController.clearAnimationCache();
/*    */             }
/*    */           }
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 68 */         System.out.println("received an invalid message @ClearAnimationCache :(");
/*    */       } 
/*    */       
/* 71 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\ClearAnimationCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */