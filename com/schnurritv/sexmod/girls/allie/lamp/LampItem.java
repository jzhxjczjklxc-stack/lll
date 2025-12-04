/*     */ package com.schnurritv.sexmod.girls.allie.lamp;
/*     */ import com.schnurritv.sexmod.Packets.SummonAllie;
/*     */ import com.schnurritv.sexmod.events.HandlePlayerMovement;
/*     */ import com.schnurritv.sexmod.util.Handlers.PacketHandler;
/*     */ import com.schnurritv.sexmod.util.Reference;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.loot.LootEntry;
/*     */ import net.minecraft.world.storage.loot.LootEntryItem;
/*     */ import net.minecraft.world.storage.loot.LootPool;
/*     */ import net.minecraft.world.storage.loot.LootTableList;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import net.minecraftforge.client.model.ModelLoader;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.LootTableLoadEvent;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ import software.bernie.geckolib3.core.IAnimatable;
/*     */ import software.bernie.geckolib3.core.PlayState;
/*     */ import software.bernie.geckolib3.core.builder.AnimationBuilder;
/*     */ import software.bernie.geckolib3.core.controller.AnimationController;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.core.manager.AnimationData;
/*     */ import software.bernie.geckolib3.core.manager.AnimationFactory;
/*     */ 
/*     */ public class LampItem extends Item implements IAnimatable {
/*  49 */   public static final LampItem LAMP_ITEM = new LampItem();
/*  50 */   private final AnimationFactory factory = new AnimationFactory(this);
/*     */ 
/*     */   
/*     */   AnimationController<LampItem> controller;
/*     */ 
/*     */   
/*     */   int tick;
/*     */ 
/*     */   
/*     */   public static void registerLamp() {
/*  60 */     LAMP_ITEM.setRegistryName("sexmod", "allies_lamp");
/*  61 */     LAMP_ITEM.func_77655_b("allies_lamp");
/*  62 */     MinecraftForge.EVENT_BUS.register(LampItem.class);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void register(RegistryEvent.Register<Item> event) {
/*  67 */     event.getRegistry().register((IForgeRegistryEntry)LAMP_ITEM);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public static void registerModel(ModelRegistryEvent event) {
/*  73 */     ModelLoader.setCustomModelResourceLocation(LAMP_ITEM, 0, new ModelResourceLocation("sexmod:allies_lamp"));
/*  74 */     LAMP_ITEM.setTileEntityItemStackRenderer((TileEntityItemStackRenderer)new LampRenderer());
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public void hideHotbar(RenderGameOverlayEvent.Pre event) {
/*  81 */     Minecraft mc = Minecraft.func_71410_x();
/*  82 */     ItemStack stack = mc.field_71439_g.func_184614_ca();
/*     */     
/*  84 */     if (stack.func_77973_b() instanceof LampItem && stack.func_77942_o() && 
/*  85 */       stack.func_77978_p().func_186857_a("user").equals(mc.field_71439_g.getPersistentID()) && 
/*  86 */       event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
/*  87 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void putInChest(LootTableLoadEvent event) {
/*  97 */     HashSet<ResourceLocation> lootChests = new HashSet<>();
/*  98 */     lootChests.add(LootTableList.field_186424_f);
/*  99 */     lootChests.add(LootTableList.field_186429_k);
/* 100 */     lootChests.add(LootTableList.field_186422_d);
/* 101 */     lootChests.add(LootTableList.field_191192_o);
/*     */     
/* 103 */     if (lootChests.contains(event.getName())) {
/*     */       
/* 105 */       LootPool pool = event.getTable().getPool("pool3");
/*     */       
/* 107 */       if (pool == null) {
/* 108 */         pool = event.getTable().getPool("pool2");
/*     */       }
/*     */       
/* 111 */       if (pool != null) {
/* 112 */         pool.addEntry((LootEntry)new LootEntryItem(LAMP_ITEM, 5, 0, new net.minecraft.world.storage.loot.functions.LootFunction[0], new net.minecraft.world.storage.loot.conditions.LootCondition[0], "sexmod:allies_lamp"));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerControllers(AnimationData data) {
/* 119 */     this.controller = new AnimationController(this, "controller", 2.0F, this::predicate);
/* 120 */     data.addAnimationController(this.controller);
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimationFactory getFactory() {
/* 125 */     return this.factory;
/*     */   }
/*     */   
/*     */   public ActionResult<ItemStack> func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/*     */     NBTTagCompound nbt;
/* 130 */     ItemStack stack = playerIn.func_184586_b(handIn);
/*     */     
/* 132 */     if (!(stack.func_77973_b() instanceof LampItem)) {
/* 133 */       return super.func_77659_a(worldIn, playerIn, handIn);
/*     */     }
/*     */     
/* 136 */     if (stack.func_77942_o()) {
/* 137 */       nbt = stack.func_77978_p();
/*     */     } else {
/*     */       
/* 140 */       nbt = new NBTTagCompound();
/*     */     } 
/*     */     
/* 143 */     if (nbt.func_74762_e("uses") >= 3) {
/* 144 */       (Minecraft.func_71410_x()).field_71439_g.func_145747_a((ITextComponent)new TextComponentString("you are out of wishes. Find a new lamp!"));
/*     */     } else {
/*     */       
/* 147 */       nbt.func_74768_a("uses", nbt.func_74762_e("uses") + 1);
/* 148 */       nbt.func_186854_a("user", playerIn.getPersistentID());
/* 149 */       stack.func_77982_d(nbt);
/*     */     } 
/*     */     
/* 152 */     return super.func_77659_a(worldIn, playerIn, handIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
/* 159 */     if (stack.func_77942_o()) {
/*     */       
/* 161 */       int wishesLeft = 3 - stack.func_77978_p().func_74762_e("uses");
/*     */       
/* 163 */       switch (wishesLeft) {
/*     */         
/*     */         case 2:
/* 166 */           tooltip.add("2 wishes left");
/*     */           break;
/*     */         
/*     */         case 1:
/* 170 */           tooltip.add("1 wish left");
/*     */           break;
/*     */         
/*     */         case 0:
/* 174 */           tooltip.add("no wishes left");
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 181 */     super.func_77624_a(stack, worldIn, tooltip, flagIn);
/*     */   }
/*     */   public LampItem() {
/* 184 */     this.tick = 0;
/*     */     func_77637_a(CreativeTabs.field_78026_f);
/*     */     this.field_77777_bU = 1;
/*     */   } public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/* 188 */     super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
/*     */     
/* 190 */     if (stack.func_77942_o())
/*     */     {
/* 192 */       if (worldIn.field_72995_K && stack.func_77978_p().func_186857_a("user") != null && stack.func_77978_p().func_186857_a("user").equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID()) && 
/* 193 */         ++this.tick > 60) {
/* 194 */         EntityPlayer player = (EntityPlayer)entityIn;
/*     */         
/* 196 */         Vec3d pos = entityIn.func_174791_d().func_72441_c(-Math.sin(player.field_70759_as * 0.017453292519943295D) * 2.0D, 0.0D, Math.cos(player.field_70759_as * 0.017453292519943295D) * 2.0D);
/* 197 */         for (int i = 0; i < 40; i++) {
/* 198 */           double factor = Reference.RANDOM.nextDouble() + 1.0D;
/* 199 */           double motionX = Reference.RANDOM.nextGaussian() * factor * 0.1D;
/* 200 */           double motionY = Reference.RANDOM.nextGaussian() * factor * 0.1D;
/* 201 */           double motionZ = Reference.RANDOM.nextGaussian() * factor * 0.1D;
/* 202 */           worldIn.func_175688_a(EnumParticleTypes.PORTAL, pos.field_72450_a + (Reference.RANDOM
/*     */               
/* 204 */               .nextFloat() * 0.5F), pos.field_72448_b + Reference.RANDOM
/* 205 */               .nextFloat(), pos.field_72449_c + (Reference.RANDOM
/* 206 */               .nextFloat() * 0.5F), motionX, motionY, motionZ, new int[0]);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 212 */         if (this.tick == 100) {
/*     */           
/* 214 */           HandlePlayerMovement.setActive(false);
/* 215 */           PacketHandler.INSTANCE.sendToServer((IMessage)new SummonAllie());
/*     */         } 
/*     */         
/* 218 */         if (this.tick > 120) {
/* 219 */           stack.func_77978_p().func_186854_a("user", UUID.randomUUID());
/* 220 */           this.tick = 0;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected <segs extends IAnimatable> PlayState predicate(AnimationEvent<segs> event) {
/* 235 */     ItemStack stack = (Minecraft.func_71410_x()).field_71439_g.func_184614_ca();
/* 236 */     if (!(stack.func_77973_b() instanceof LampItem)) {
/* 237 */       this.controller.setAnimation((new AnimationBuilder()).addAnimation("animation.lamp.null", Boolean.valueOf(true)));
/*     */     }
/*     */     
/* 240 */     if (stack.func_77942_o()) {
/* 241 */       UUID userId = stack.func_77978_p().func_186857_a("user");
/*     */       
/* 243 */       if (userId.equals((Minecraft.func_71410_x()).field_71439_g.getPersistentID())) {
/*     */         
/* 245 */         this.controller.setAnimation((new AnimationBuilder()).addAnimation("animation.lamp.rub", Boolean.valueOf(false)));
/*     */       } else {
/*     */         
/* 248 */         this.controller.setAnimation((new AnimationBuilder()).addAnimation("animation.lamp.null", Boolean.valueOf(true)));
/*     */       } 
/*     */     } 
/*     */     
/* 252 */     return PlayState.CONTINUE;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\allie\lamp\LampItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */