/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import com.schnurritv.sexmod.girls.slime.SlimeEntity;
/*    */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ public class SetSlimePregnant
/*    */   implements IMessage {
/*    */   boolean messageValid;
/*    */   UUID girlUUID;
/*    */   boolean pregnant;
/*    */   
/*    */   public SetSlimePregnant() {
/* 22 */     this.messageValid = false;
/*    */   }
/*    */   public SetSlimePregnant(UUID girlUUID, boolean pregnant) {
/* 25 */     this.girlUUID = girlUUID;
/* 26 */     this.pregnant = pregnant;
/* 27 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 33 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 34 */     this.pregnant = buf.readBoolean();
/* 35 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 41 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/* 42 */     buf.writeBoolean(this.pregnant);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SetSlimePregnant, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SetSlimePregnant message, MessageContext ctx) {
/* 50 */       if (message.messageValid) {
/*    */         
/* 52 */         List<GirlEntity> slimes = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 54 */         if (ctx.side.isServer()) {
/*    */           
/* 56 */           PacketHandler.INSTANCE.sendToAllTracking(new SetSlimePregnant(message.girlUUID, message.pregnant), (Entity)slimes.get(0));
/* 57 */           for (GirlEntity slime : slimes)
/*    */           {
/* 59 */             if (slime instanceof SlimeEntity)
/*    */             {
/* 61 */               ((SlimeEntity)slime).ticksUntilBirth = 300;
/*    */             }
/*    */           }
/*    */         
/*    */         } else {
/*    */           
/* 67 */           for (GirlEntity slime : slimes)
/*    */           {
/* 69 */             if (slime instanceof SlimeEntity)
/*    */             {
/* 71 */               ((SlimeEntity)slime).isPregnant = message.pregnant;
/*    */             }
/*    */           }
/*    */         
/*    */         } 
/*    */       } else {
/*    */         
/* 78 */         System.out.println("received an invalid message @SetSlimePregnant :(");
/*    */       } 
/*    */       
/* 81 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\SetSlimePregnant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */