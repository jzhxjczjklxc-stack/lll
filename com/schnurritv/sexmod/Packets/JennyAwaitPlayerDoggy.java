/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.ellie.EllieEntity;
/*    */ import com.schnurritv.sexmod.girls.jenny.JennyEntity;
/*    */ import com.schnurritv.sexmod.util.Reference;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.management.PlayerList;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ public class JennyAwaitPlayerDoggy
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girlUUID;
/*    */   UUID playerUUID;
/*    */   
/*    */   public JennyAwaitPlayerDoggy() {
/* 26 */     this.messageValid = false;
/*    */   }
/*    */   
/*    */   public JennyAwaitPlayerDoggy(UUID girlUUID, UUID playerUUID) {
/* 30 */     this.girlUUID = girlUUID;
/* 31 */     this.playerUUID = playerUUID;
/* 32 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 38 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 39 */     this.playerUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 40 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 46 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/* 47 */     ByteBufUtils.writeUTF8String(buf, this.playerUUID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<JennyAwaitPlayerDoggy, IMessage>
/*    */   {
/*    */     public IMessage onMessage(JennyAwaitPlayerDoggy message, MessageContext ctx) {
/* 56 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 58 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 60 */         for (GirlEntity girl : girlList)
/*    */         {
/* 62 */           PlayerList playerList = Reference.server.func_184103_al();
/*    */           
/*    */           try {
/* 65 */             playerList.func_177451_a(message.playerUUID).func_70005_c_();
/*    */           }
/* 67 */           catch (NullPointerException e) {
/* 68 */             System.out.println("couldn't find player with UUID: " + message.playerUUID);
/* 69 */             System.out.println("could only find players with thsese UUID's:");
/*    */             
/* 71 */             for (EntityPlayerMP player : playerList.func_181057_v())
/*    */             {
/* 73 */               System.out.println(player.func_70005_c_() + " " + player.func_110124_au());
/*    */             }
/*    */             
/*    */             continue;
/*    */           } 
/*    */           
/* 79 */           if (girl instanceof JennyEntity) {
/*    */             
/* 81 */             ((JennyEntity)girl).awaitPlayer = true;
/*    */           }
/* 83 */           else if (girl instanceof EllieEntity) {
/*    */             
/* 85 */             ((EllieEntity)girl).awaitPlayer = true;
/*    */           } 
/*    */           
/* 88 */           girl.setPlayer(message.playerUUID);
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 93 */         System.out.println("received an invalid message @SetPlayerForGirl :(");
/*    */       } 
/*    */       
/* 96 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\JennyAwaitPlayerDoggy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */