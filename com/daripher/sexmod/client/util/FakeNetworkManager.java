/*     */ package com.daripher.sexmod.client.util;
/*     */ 
/*     */ import io.netty.buffer.ByteBufAllocator;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelConfig;
/*     */ import io.netty.channel.ChannelFuture;
/*     */ import io.netty.channel.ChannelId;
/*     */ import io.netty.channel.ChannelMetadata;
/*     */ import io.netty.channel.ChannelOutboundInvoker;
/*     */ import io.netty.channel.ChannelPipeline;
/*     */ import io.netty.channel.ChannelProgressivePromise;
/*     */ import io.netty.channel.ChannelPromise;
/*     */ import io.netty.channel.EventLoop;
/*     */ import io.netty.util.Attribute;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.net.SocketAddress;
/*     */ import net.minecraft.network.EnumPacketDirection;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ 
/*     */ public class FakeNetworkManager extends NetworkManager {
/*     */   public FakeNetworkManager(EnumPacketDirection packetDirection) {
/*  22 */     super(packetDirection);
/*     */   }
/*     */   
/*     */   public Channel channel() {
/*  26 */     return new Channel() {
/*     */         public ChannelId id() {
/*  28 */           return null;
/*     */         }
/*     */         
/*     */         public EventLoop eventLoop() {
/*  32 */           return null;
/*     */         }
/*     */         
/*     */         public Channel parent() {
/*  36 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelConfig config() {
/*  40 */           return null;
/*     */         }
/*     */         
/*     */         public boolean isOpen() {
/*  44 */           return false;
/*     */         }
/*     */         
/*     */         public boolean isRegistered() {
/*  48 */           return false;
/*     */         }
/*     */         
/*     */         public boolean isActive() {
/*  52 */           return false;
/*     */         }
/*     */         
/*     */         public ChannelMetadata metadata() {
/*  56 */           return null;
/*     */         }
/*     */         
/*     */         public SocketAddress localAddress() {
/*  60 */           return null;
/*     */         }
/*     */         
/*     */         public SocketAddress remoteAddress() {
/*  64 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture closeFuture() {
/*  68 */           return null;
/*     */         }
/*     */         
/*     */         public boolean isWritable() {
/*  72 */           return false;
/*     */         }
/*     */         
/*     */         public long bytesBeforeUnwritable() {
/*  76 */           return 0L;
/*     */         }
/*     */         
/*     */         public long bytesBeforeWritable() {
/*  80 */           return 0L;
/*     */         }
/*     */         
/*     */         public Channel.Unsafe unsafe() {
/*  84 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelPipeline pipeline() {
/*  88 */           return null;
/*     */         }
/*     */         
/*     */         public ByteBufAllocator alloc() {
/*  92 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelPromise newPromise() {
/*  96 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelProgressivePromise newProgressivePromise() {
/* 100 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture newSucceededFuture() {
/* 104 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture newFailedFuture(Throwable cause) {
/* 108 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelPromise voidPromise() {
/* 112 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture bind(SocketAddress localAddress) {
/* 116 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture connect(SocketAddress remoteAddress) {
/* 120 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
/* 124 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture disconnect() {
/* 128 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture close() {
/* 132 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture deregister() {
/* 136 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
/* 140 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
/* 144 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
/* 148 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture disconnect(ChannelPromise promise) {
/* 152 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture close(ChannelPromise promise) {
/* 156 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture deregister(ChannelPromise promise) {
/* 160 */           return null;
/*     */         }
/*     */         
/*     */         public Channel read() {
/* 164 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture write(Object msg) {
/* 168 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture write(Object msg, ChannelPromise promise) {
/* 172 */           return null;
/*     */         }
/*     */         
/*     */         public Channel flush() {
/* 176 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
/* 180 */           return null;
/*     */         }
/*     */         
/*     */         public ChannelFuture writeAndFlush(Object msg) {
/* 184 */           return null;
/*     */         }
/*     */         
/*     */         public <T> Attribute<T> attr(AttributeKey<T> key) {
/* 188 */           return new Attribute<T>() {
/*     */               public T setIfAbsent(T value) {
/* 190 */                 return null;
/*     */               }
/*     */               
/*     */               public T getAndSet(T value) {
/* 194 */                 return null;
/*     */               }
/*     */               
/*     */               public AttributeKey<T> key() {
/* 198 */                 return null;
/*     */               }
/*     */               
/*     */               public T getAndRemove() {
/* 202 */                 return null;
/*     */               }
/*     */ 
/*     */               
/*     */               public void remove() {}
/*     */               
/*     */               public T get() {
/* 209 */                 return null;
/*     */               }
/*     */               
/*     */               public boolean compareAndSet(T oldValue, T newValue) {
/* 213 */                 return false;
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(T value) {}
/*     */             };
/*     */         }
/*     */         
/*     */         public <T> boolean hasAttr(AttributeKey<T> key) {
/* 222 */           return false;
/*     */         }
/*     */         
/*     */         public int compareTo(Channel o) {
/* 226 */           return 0;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\daripher\sexmod\clien\\util\FakeNetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */