/*     */ package com.schnurritv.sexmod.Packets;
/*     */ 
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ public class TeleportPlayer
/*     */   implements IMessage
/*     */ {
/*     */   boolean messageValid;
/*     */   String playerUUID;
/*     */   Vec3d pos;
/*     */   float yaw;
/*     */   float pitch;
/*     */   
/*     */   public TeleportPlayer() {
/*  24 */     this.messageValid = false;
/*     */   }
/*     */   
/*     */   public TeleportPlayer(String playerUUID, Vec3d pos) {
/*  28 */     this.playerUUID = playerUUID;
/*  29 */     this.pos = pos;
/*  30 */     this.yaw = 0.0F;
/*  31 */     this.pitch = 0.0F;
/*  32 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TeleportPlayer(String playerUUID, Vec3d pos, float yaw, float pitch) {
/*  37 */     this.playerUUID = playerUUID;
/*  38 */     this.pos = pos;
/*  39 */     this.yaw = yaw;
/*  40 */     this.pitch = pitch;
/*  41 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TeleportPlayer(String playerUUID, double x, double y, double z, float yaw, float pitch) {
/*  46 */     this.playerUUID = playerUUID;
/*  47 */     this.pos = new Vec3d(x, y, z);
/*  48 */     this.yaw = yaw;
/*  49 */     this.pitch = pitch;
/*  50 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buf) {
/*  56 */     this.playerUUID = ByteBufUtils.readUTF8String(buf);
/*  57 */     this.pos = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
/*  58 */     this.yaw = buf.readFloat();
/*  59 */     this.pitch = buf.readFloat();
/*  60 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buf) {
/*  66 */     ByteBufUtils.writeUTF8String(buf, this.playerUUID);
/*  67 */     buf.writeDouble(this.pos.field_72450_a);
/*  68 */     buf.writeDouble(this.pos.field_72448_b);
/*  69 */     buf.writeDouble(this.pos.field_72449_c);
/*  70 */     buf.writeFloat(this.yaw);
/*  71 */     buf.writeFloat(this.pitch);
/*     */     
/*  73 */     this.messageValid = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Handler
/*     */     implements IMessageHandler<TeleportPlayer, IMessage>
/*     */   {
/*     */     public IMessage onMessage(TeleportPlayer message, MessageContext ctx) {
/*  82 */       if (message.messageValid && ctx.side == Side.SERVER) {
/*     */ 
/*     */         
/*     */         try {
/*  86 */           System.out.println("teleporting player " + message.playerUUID + " to " + message.pos);
/*  87 */           EntityPlayerMP player = Reference.server.func_184103_al().func_177451_a(UUID.fromString(message.playerUUID));
/*     */           
/*  89 */           player.func_70080_a(message.pos.field_72450_a, message.pos.field_72448_b, message.pos.field_72449_c, message.yaw, message.pitch);
/*  90 */           player.func_70634_a(message.pos.field_72450_a, message.pos.field_72448_b, message.pos.field_72449_c);
/*  91 */           player.field_70159_w = 0.0D;
/*  92 */           player.field_70181_x = 0.0D;
/*  93 */           player.field_70179_y = 0.0D;
/*     */         }
/*  95 */         catch (Exception e) {
/*  96 */           System.out.println("couldn't find player with UUID: " + message.playerUUID);
/*  97 */           System.out.println("could only find the following players:");
/*  98 */           System.out.println(Reference.server.func_184103_al().func_181058_b(true));
/*     */         } 
/*     */       } else {
/*     */         
/* 102 */         System.out.println("received an invalid message @TeleportPlayer :(");
/*     */       } 
/*     */       
/* 105 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\Packets\TeleportPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */