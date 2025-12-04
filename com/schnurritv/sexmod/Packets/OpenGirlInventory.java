/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.Main;
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenGirlInventory
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid;
/*    */   UUID girlID;
/*    */   UUID playerID;
/*    */   
/*    */   public OpenGirlInventory() {}
/*    */   
/*    */   public OpenGirlInventory(UUID girlId, UUID playerID) {
/* 26 */     this.girlID = girlId;
/* 27 */     this.playerID = playerID;
/* 28 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 34 */     this.girlID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 35 */     this.playerID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 36 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 42 */     ByteBufUtils.writeUTF8String(buf, this.girlID.toString());
/* 43 */     ByteBufUtils.writeUTF8String(buf, this.playerID.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<OpenGirlInventory, IMessage>
/*    */   {
/*    */     public IMessage onMessage(OpenGirlInventory message, MessageContext ctx) {
/* 52 */       if (message.messageValid && ctx.side == Side.SERVER)
/*    */       {
/* 54 */         for (GirlEntity girl : GirlEntity.girlEntities) {
/*    */           
/* 56 */           if (!girl.field_70170_p.field_72995_K && girl.girlId().equals(message.girlID))
/*    */           {
/* 58 */             ((EntityPlayerMP)girl.field_70170_p.func_152378_a(message.playerID)).openGui(Main.instance, 0, girl.field_70170_p, girl.func_180425_c().func_177958_n(), girl.func_180425_c().func_177956_o(), girl.func_180425_c().func_177952_p());
/*    */           }
/*    */         } 
/*    */       }
/* 62 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\OpenGirlInventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */