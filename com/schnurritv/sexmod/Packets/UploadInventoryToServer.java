/*    */ package com.schnurritv.sexmod.Packets;
/*    */ 
/*    */ import com.schnurritv.sexmod.girls.GirlEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UploadInventoryToServer
/*    */   implements IMessage
/*    */ {
/*    */   boolean messageValid = false;
/* 21 */   ItemStack[] stacks = new ItemStack[42];
/*    */   UUID girlUUID;
/*    */   UUID player;
/*    */   
/*    */   public UploadInventoryToServer() {}
/*    */   
/*    */   public UploadInventoryToServer(UUID girlUUID, UUID player, ItemStack[] stacks) {
/* 28 */     this.girlUUID = girlUUID;
/* 29 */     this.stacks = stacks;
/* 30 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 36 */     this.girlUUID = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 37 */     this.player = UUID.fromString(ByteBufUtils.readUTF8String(buf));
/* 38 */     for (int i = 0; i < 42; i++) {
/* 39 */       this.stacks[i] = ByteBufUtils.readItemStack(buf);
/*    */     }
/* 41 */     this.messageValid = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 47 */     ByteBufUtils.writeUTF8String(buf, this.girlUUID.toString());
/* 48 */     ByteBufUtils.writeUTF8String(buf, this.player.toString());
/* 49 */     for (int i = 0; i < 42; i++) {
/* 50 */       ByteBufUtils.writeItemStack(buf, this.stacks[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<UploadInventoryToServer, IMessage>
/*    */   {
/*    */     public IMessage onMessage(UploadInventoryToServer message, MessageContext ctx) {
/* 59 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*    */         
/* 61 */         ArrayList<GirlEntity> girlList = GirlEntity.getGirlsByUUID(message.girlUUID);
/*    */         
/* 63 */         for (GirlEntity girl : girlList) {
/* 64 */           if (girl.field_70170_p.field_72995_K) {
/*    */             continue;
/*    */           }
/* 67 */           InventoryPlayer inventoryPlayer = (girl.field_70170_p.func_152378_a(message.player)).field_71071_by;
/*    */           
/* 69 */           for (int i = 0; i < 36; i++) {
/* 70 */             inventoryPlayer.func_70299_a(i, message.stacks[i]);
/*    */           }
/*    */           
/* 73 */           girl.inventory.setStackInSlot(0, message.stacks[36]);
/* 74 */           girl.inventory.setStackInSlot(1, message.stacks[37]);
/* 75 */           girl.inventory.setStackInSlot(2, message.stacks[38]);
/* 76 */           girl.inventory.setStackInSlot(3, message.stacks[39]);
/* 77 */           girl.inventory.setStackInSlot(4, message.stacks[40]);
/* 78 */           girl.inventory.setStackInSlot(5, message.stacks[41]);
/*    */         } 
/*    */       } else {
/*    */         
/* 82 */         System.out.println("received an invalid message @UploadInventoryToServer :(");
/*    */       } 
/*    */       
/* 85 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\UploadInventoryToServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */