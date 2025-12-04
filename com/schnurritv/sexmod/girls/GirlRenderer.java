/*     */ package com.schnurritv.sexmod.girls;
/*     */ 
/*     */ import com.schnurritv.sexmod.girls.bia.BiaModel;
/*     */ import com.schnurritv.sexmod.girls.ellie.EllieModel;
/*     */ import com.schnurritv.sexmod.girls.jenny.JennyModel;
/*     */ import com.schnurritv.sexmod.util.MatrixHelper;
/*     */ import com.schnurritv.sexmod.util.PenisMath;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.util.Arrays;
/*     */ import java.util.Base64;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.vecmath.Tuple3f;
/*     */ import javax.vecmath.Tuple4f;
/*     */ import javax.vecmath.Vector3f;
/*     */ import javax.vecmath.Vector4f;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import software.bernie.geckolib3.core.IAnimatable;
/*     */ import software.bernie.geckolib3.core.IAnimatableModel;
/*     */ import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoBone;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoCube;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoModel;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoQuad;
/*     */ import software.bernie.geckolib3.geo.render.built.GeoVertex;
/*     */ import software.bernie.geckolib3.model.AnimatedGeoModel;
/*     */ import software.bernie.geckolib3.model.provider.GeoModelProvider;
/*     */ import software.bernie.geckolib3.model.provider.data.EntityModelData;
/*     */ import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
/*     */ import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
/*     */ import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
/*     */ import software.bernie.geckolib3.renderers.geo.RenderHurtColor;
/*     */ import software.bernie.shadowed.eliotlash.mclib.utils.Interpolations;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GirlRenderer<T extends GirlEntity & IAnimatable>
/*     */   extends GeoEntityRenderer<T>
/*     */ {
/*     */   protected double leashHeightOffset;
/*     */   protected T girl;
/*     */   Minecraft mc;
/*     */   
/*     */   public GirlRenderer(RenderManager renderManager, AnimatedGeoModel<T> model, double leashHeightOffset) {
/*  79 */     super(renderManager, model);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.cockColor = new Color(245, 199, 165);
/* 110 */     this.nutColor = new Color(245, 157, 169);
/* 111 */     this.alreadySaid = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     this.pull = 0.0F;
/*     */     this.leashHeightOffset = leashHeightOffset;
/*     */     this.mc = Minecraft.func_71410_x();
/*     */     this.field_76989_e = 0.2F;
/*     */   } protected static HashMap<UUID, ResourceLocation> playerSkins = new HashMap<>(); Color cockColor; Color nutColor; boolean alreadySaid; float pull;
/* 436 */   public void renderRecursively(BufferBuilder builder, GeoBone bone, float red, float green, float blue, float alpha) { if (((GirlEntity)this.girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) {
/*     */       return;
/*     */     }
/* 439 */     String boneName = bone.getName();
/*     */     
/* 441 */     if (boneName.equals("weapon")) {
/* 442 */       renderWeapon(builder, bone);
/*     */     }
/* 444 */     if (boneName.equals("itemRenderer") && this.girl.currentAction() == GirlEntity.Action.PAYMENT) {
/* 445 */       renderItems(builder, bone);
/*     */     }
/* 447 */     MATRIX_STACK.push();
/* 448 */     MATRIX_STACK.translate(bone);
/* 449 */     MATRIX_STACK.moveToPivot(bone);
/* 450 */     MATRIX_STACK.rotate(bone);
/* 451 */     MATRIX_STACK.scale(bone);
/* 452 */     MATRIX_STACK.moveBackFromPivot(bone);
/*     */     
/* 454 */     if (!bone.isHidden) {
/*     */       
/* 456 */       double xOffset = 0.0D;
/*     */       
/* 458 */       if (boneName.startsWith("armor") && ((Integer)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.CURRENT_MODEL)).intValue() != 0) {
/*     */         ItemArmor.ArmorMaterial material;
/*     */ 
/*     */         
/*     */         BiaModel biaModel;
/*     */         
/* 464 */         if (this.girl instanceof com.schnurritv.sexmod.girls.jenny.JennyEntity) {
/* 465 */           JennyModel jennyModel = new JennyModel();
/* 466 */         } else if (this.girl instanceof com.schnurritv.sexmod.girls.ellie.EllieEntity) {
/* 467 */           EllieModel ellieModel = new EllieModel();
/*     */         } else {
/*     */           
/* 470 */           biaModel = new BiaModel();
/*     */         } 
/*     */ 
/*     */         
/*     */         try {
/* 475 */           if (Arrays.<String>asList(biaModel.getHelmetBones()).contains(boneName)) {
/* 476 */             material = ((ItemArmor)((ItemStack)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.HELMET)).func_77973_b()).func_82812_d();
/* 477 */           } else if (Arrays.<String>asList(biaModel.getChestPlateBones()).contains(boneName)) {
/* 478 */             material = ((ItemArmor)((ItemStack)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.CHEST_PLATE)).func_77973_b()).func_82812_d();
/* 479 */           } else if (Arrays.<String>asList(biaModel.getPantsBones()).contains(boneName)) {
/* 480 */             material = ((ItemArmor)((ItemStack)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.PANTS)).func_77973_b()).func_82812_d();
/*     */           } else {
/* 482 */             material = ((ItemArmor)((ItemStack)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.SHOES)).func_77973_b()).func_82812_d();
/*     */           } 
/* 484 */         } catch (ClassCastException e) {
/* 485 */           System.out.println("couldn't get the armor material");
/* 486 */           material = ItemArmor.ArmorMaterial.GOLD;
/*     */         } 
/*     */ 
/*     */         
/* 490 */         double factor = 0.0D;
/*     */         
/* 492 */         switch (material) {
/*     */           
/*     */           case GOLD:
/* 495 */             factor = 1.0D;
/*     */             break;
/*     */           
/*     */           case IRON:
/* 499 */             factor = 2.0D;
/*     */             break;
/*     */           
/*     */           case CHAIN:
/* 503 */             factor = 3.0D;
/*     */             break;
/*     */           
/*     */           case LEATHER:
/* 507 */             factor = 4.0D;
/*     */             break;
/*     */         } 
/*     */         
/* 511 */         xOffset = 72.0D * factor / 4096.0D;
/*     */       } 
/*     */       
/* 514 */       for (GeoCube cube : bone.childCubes) {
/* 515 */         MATRIX_STACK.push();
/* 516 */         GlStateManager.func_179094_E();
/* 517 */         renderCube(builder, cube, red, green, blue, alpha, xOffset);
/* 518 */         GlStateManager.func_179121_F();
/* 519 */         MATRIX_STACK.pop();
/*     */       } 
/* 521 */       for (GeoBone childBone : bone.childBones) {
/*     */         
/* 523 */         if (xOffset == 0.0D) {
/* 524 */           renderRecursively(builder, childBone, red, green, blue, alpha); continue;
/*     */         } 
/* 526 */         renderRecursively(builder, childBone, red, green, blue, alpha, xOffset);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 532 */       MATRIX_STACK.pop();
/*     */     }
/* 534 */     catch (IllegalStateException illegalStateException) {} } protected ResourceLocation getPlayerSkin(T girl) throws IOException { ResourceLocation playerSkin; if (((GirlEntity)girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld || girl.playerSheHasSexWith() == null) { playerSkin = playerSkins.get(this.mc.func_110432_I().func_148256_e().getId()); if (playerSkin == null) return producePlayerSkin(this.mc.func_110432_I().func_148256_e().getId(), ((GirlEntity)girl).field_70170_p);  } else { playerSkin = playerSkins.get(girl.playerSheHasSexWith()); if (playerSkin == null)
/*     */         return producePlayerSkin(girl.playerSheHasSexWith(), ((GirlEntity)girl).field_70170_p);  }  return playerSkin; }
/*     */   protected ResourceLocation producePlayerSkin(UUID player, World world) throws IOException { BufferedImage skinImage; try { URL SessionURL = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + player.toString().replace("-", "")); BufferedReader reader = new BufferedReader(new InputStreamReader(SessionURL.openStream())); String profileText = reader.lines().collect(Collectors.joining()); int charsUntilValue = profileText.indexOf("\"value\" : "); int charsUntilBase64 = charsUntilValue + 11; StringBuilder base64 = new StringBuilder(); for (int i = 0; profileText.charAt(charsUntilBase64 + i) != '"'; i++)
/*     */         base64.append(profileText.charAt(charsUntilBase64 + i));  String skinText = new String(Base64.getDecoder().decode(base64.toString())); int charsUntilURL = skinText.indexOf("\"url\" : "); int charsUntilLink = charsUntilURL + 9; StringBuilder url = new StringBuilder(); for (int j = 0; skinText.charAt(charsUntilLink + j) != '"'; j++)
/*     */         url.append(skinText.charAt(charsUntilLink + j));  URL skinUrl = new URL(url.toString()); skinImage = ImageIO.read(skinUrl); Graphics graphics = skinImage.getGraphics(); graphics.setColor(this.cockColor); graphics.fillRect(0, 0, 4, 3); graphics.setColor(this.nutColor); graphics.fillRect(4, 0, 3, 3); } catch (Exception e) { if (!this.alreadySaid) { this.alreadySaid = true; System.out.println("couldn't load player skin... offline or cracked? what is it sir?"); }  skinImage = ImageIO.read(this.mc.func_110442_L().func_110536_a(new ResourceLocation("sexmod", "textures/player/steve.png")).func_110527_b()); }  playerSkins.put(player, this.field_76990_c.field_78724_e.func_110578_a("player" + player, new DynamicTexture(skinImage))); return playerSkins.get(player); }
/* 539 */   public void renderRecursively(BufferBuilder builder, GeoBone bone, float red, float green, float blue, float alpha, double xOffset) { if (((GirlEntity)this.girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld) {
/*     */       return;
/*     */     }
/*     */     
/* 543 */     if (bone.getName().equals("weapon")) {
/* 544 */       renderWeapon(builder, bone);
/*     */     }
/*     */     
/* 547 */     MATRIX_STACK.push();
/* 548 */     MATRIX_STACK.translate(bone);
/* 549 */     MATRIX_STACK.moveToPivot(bone);
/* 550 */     MATRIX_STACK.rotate(bone);
/* 551 */     MATRIX_STACK.scale(bone);
/* 552 */     MATRIX_STACK.moveBackFromPivot(bone);
/*     */     
/* 554 */     if (!bone.isHidden) {
/* 555 */       for (GeoCube cube : bone.childCubes) {
/* 556 */         MATRIX_STACK.push();
/* 557 */         GlStateManager.func_179094_E();
/* 558 */         renderCube(builder, cube, red, green, blue, alpha, xOffset);
/* 559 */         GlStateManager.func_179121_F();
/* 560 */         MATRIX_STACK.pop();
/*     */       } 
/* 562 */       for (GeoBone childBone : bone.childBones) {
/* 563 */         renderRecursively(builder, childBone, red, green, blue, alpha, xOffset);
/*     */       }
/*     */     } 
/*     */     
/* 567 */     MATRIX_STACK.pop(); }
/*     */   public void render(GeoModel model, T animatable, float partialTicks, float red, float green, float blue, float alpha) { GlStateManager.func_179129_p(); GlStateManager.func_179091_B(); renderEarly(animatable, partialTicks, red, green, blue, alpha); renderLate(animatable, partialTicks, red, green, blue, alpha); BufferBuilder builder = Tessellator.func_178181_a().func_178180_c(); builder.func_181668_a(7, DefaultVertexFormats.field_181712_l); GeoBone steveBone = null; func_110776_a(Objects.<ResourceLocation>requireNonNull(getEntityTexture((EntityLivingBase)this.girl))); for (GeoBone group : model.topLevelBones) { if (group.getName().equals("steve")) { steveBone = group; continue; }  renderRecursively(builder, group, red, green, blue, alpha); }
/*     */      Tessellator.func_178181_a().func_78381_a(); if (steveBone != null) { builder.func_181668_a(7, DefaultVertexFormats.field_181712_l); try { (Minecraft.func_71410_x()).field_71446_o.func_110577_a(getPlayerSkin(this.girl)); }
/*     */       catch (IOException e) { e.printStackTrace(); }
/*     */        renderRecursively(builder, steveBone, red, green, blue, alpha); Tessellator.func_178181_a().func_78381_a(); }
/* 572 */      renderAfter(animatable, partialTicks, red, green, blue, alpha); GlStateManager.func_179101_C(); GlStateManager.func_179089_o(); } public void renderCube(BufferBuilder builder, GeoCube cube, float red, float green, float blue, float alpha, double xOffset) { MATRIX_STACK.moveToPivot(cube);
/* 573 */     MATRIX_STACK.rotate(cube);
/* 574 */     MATRIX_STACK.moveBackFromPivot(cube);
/*     */     
/* 576 */     for (GeoQuad quad : cube.quads)
/* 577 */     { if (quad != null)
/*     */       
/*     */       { 
/* 580 */         Vector3f normal = new Vector3f(quad.normal.func_177958_n(), quad.normal.func_177956_o(), quad.normal.func_177952_p());
/*     */         
/* 582 */         MATRIX_STACK.getNormalMatrix().transform((Tuple3f)normal);
/*     */ 
/*     */         
/* 585 */         if ((cube.size.y == 0.0F || cube.size.z == 0.0F) && normal.getX() < 0.0F) {
/* 586 */           normal.x *= -1.0F;
/*     */         }
/* 588 */         if ((cube.size.x == 0.0F || cube.size.z == 0.0F) && normal.getY() < 0.0F) {
/* 589 */           normal.y *= -1.0F;
/*     */         }
/* 591 */         if ((cube.size.x == 0.0F || cube.size.y == 0.0F) && normal.getZ() < 0.0F) {
/* 592 */           normal.z *= -1.0F;
/*     */         }
/*     */         
/* 595 */         for (GeoVertex vertex : quad.vertices)
/*     */         
/*     */         { 
/* 598 */           Vector4f vector4f = new Vector4f(vertex.position.getX(), vertex.position.getY(), vertex.position.getZ(), 1.0F);
/*     */           
/* 600 */           MATRIX_STACK.getModelMatrix().transform((Tuple4f)vector4f);
/* 601 */           builder.func_181662_b(vector4f.getX(), vector4f.getY(), vector4f.getZ()).func_187315_a(vertex.textureU + xOffset, vertex.textureV).func_181666_a(red, green, blue, alpha).func_181663_c(normal.getX(), normal.getY(), normal.getZ()).func_181675_d(); }  }  }  }
/*     */   public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) { this.girl = entity; if (!(((GirlEntity)this.girl).field_70170_p instanceof com.daripher.sexmod.client.util.FakeWorld)) { EntityDataManager dataManager = this.girl.func_184212_Q(); if (!((String)dataManager.func_187225_a(GirlEntity.MASTER)).equals("")) { EntityPlayer master = ((GirlEntity)this.girl).field_70170_p.func_152378_a(UUID.fromString((String)dataManager.func_187225_a(GirlEntity.MASTER))); if (master != null && master.func_184218_aH() && master.func_184187_bx() instanceof EntityHorse && ((EntityHorse)master.func_184187_bx()).func_110257_ck()) { EntityLiving ridingEntity = (EntityLiving)master.func_184187_bx(); EntityPlayerSP entityPlayerSP = this.mc.field_71439_g; Vec3d lookVec = ridingEntity.func_70040_Z(); Vec3d masterRenderPos = PenisMath.Lerp(new Vec3d(master.field_70142_S, master.field_70137_T, master.field_70136_U), master.func_174791_d(), partialTicks); Vec3d playerRenderPos = PenisMath.Lerp(new Vec3d(((EntityPlayer)entityPlayerSP).field_70142_S, ((EntityPlayer)entityPlayerSP).field_70137_T, ((EntityPlayer)entityPlayerSP).field_70136_U), entityPlayerSP.func_174791_d(), partialTicks); playerRenderPos = masterRenderPos.func_178788_d(playerRenderPos); x = playerRenderPos.field_72450_a + lookVec.field_72450_a * -0.5D; y = playerRenderPos.field_72448_b + 0.15000000596046448D; z = playerRenderPos.field_72449_c + lookVec.field_72449_c * -0.5D; ((GirlEntity)entity).field_70761_aq = ridingEntity.field_70761_aq; }  } else if (((Boolean)dataManager.func_187225_a(GirlEntity.SHOULD_BE_AT_TARGET)).booleanValue()) { Vec3d playerRenderPos = PenisMath.Lerp(new Vec3d(this.mc.field_71439_g.field_70142_S, this.mc.field_71439_g.field_70137_T, this.mc.field_71439_g.field_70136_U), this.mc.field_71439_g.func_174791_d(), partialTicks); Vec3d dependantPos = this.girl.targetPos().func_178788_d(playerRenderPos); x = dependantPos.field_72450_a; y = dependantPos.field_72448_b; z = dependantPos.field_72449_c; ((GirlEntity)entity).field_70761_aq = ((Float)dataManager.func_187225_a(GirlEntity.TARGET_YAW)).floatValue(); }  }  if (entity.func_110167_bD()) renderLeash((GirlEntity)entity, x, y + this.leashHeightOffset, z, partialTicks);  GlStateManager.func_179094_E(); GlStateManager.func_179137_b(x, y, z); GL11.glDisable(2896); GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.5F); GlStateManager.func_179108_z(); GlStateManager.func_179147_l(); GlStateManager.func_187401_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA); boolean shouldSit = (entity.func_184187_bx() != null && entity.func_184187_bx().shouldRiderSit()); EntityModelData entityModelData = new EntityModelData(); entityModelData.isSitting = shouldSit; entityModelData.isChild = entity.func_70631_g_(); float f = Interpolations.lerpYaw(((GirlEntity)entity).field_70760_ar, ((GirlEntity)entity).field_70761_aq, partialTicks); float f1 = Interpolations.lerpYaw(((GirlEntity)entity).field_70758_at, ((GirlEntity)entity).field_70759_as, partialTicks); float netHeadYaw = f1 - f; if (shouldSit && entity.func_184187_bx() instanceof EntityLivingBase) { EntityLivingBase livingentity = (EntityLivingBase)entity.func_184187_bx(); f = Interpolations.lerpYaw(livingentity.field_70760_ar, livingentity.field_70761_aq, partialTicks); netHeadYaw = f1 - f; float f3 = MathHelper.func_76142_g(netHeadYaw); if (f3 < -85.0F) f3 = -85.0F;  if (f3 >= 85.0F) f3 = 85.0F;  f = f1 - f3; if (f3 * f3 > 2500.0F) f += f3 * 0.2F;  netHeadYaw = f1 - f; }  float headPitch = Interpolations.lerp(((GirlEntity)entity).field_70127_C, ((GirlEntity)entity).field_70125_A, partialTicks); float f7 = handleRotationFloat((EntityLivingBase)entity, partialTicks); applyRotations((EntityLivingBase)entity, f7, f, partialTicks); float limbSwingAmount = 0.0F; float limbSwing = 0.0F; if (!shouldSit && entity.func_70089_S()) { limbSwingAmount = Interpolations.lerp(((GirlEntity)entity).field_184618_aE, ((GirlEntity)entity).field_70721_aZ, partialTicks); limbSwing = ((GirlEntity)entity).field_184619_aG - ((GirlEntity)entity).field_70721_aZ * (1.0F - partialTicks); if (entity.func_70631_g_())
/*     */         limbSwing *= 3.0F;  if (limbSwingAmount > 1.0F)
/*     */         limbSwingAmount = 1.0F;  }  entityModelData.headPitch = -headPitch; entityModelData.netHeadYaw = -netHeadYaw; AnimationEvent<T> predicate = new AnimationEvent((IAnimatable)entity, limbSwing, limbSwingAmount, partialTicks, (limbSwingAmount <= -0.15F || limbSwingAmount >= 0.15F), Collections.singletonList(entityModelData)); GeoModelProvider modelProvider = getGeoModelProvider(); ResourceLocation location = modelProvider.getModelLocation(entity); GeoModel model = modelProvider.getModel(location); if (modelProvider instanceof IAnimatableModel)
/*     */       ((IAnimatableModel)modelProvider).setLivingAnimations(entity, Integer.valueOf(entity.func_110124_au().hashCode()), predicate);  GlStateManager.func_179094_E(); GlStateManager.func_179109_b(0.0F, 0.01F, 0.0F); (Minecraft.func_71410_x()).field_71446_o.func_110577_a(getEntityTexture((EntityLivingBase)entity)); Color renderColor = getRenderColor(entity, partialTicks); boolean flag = setDoRenderBrightness((EntityLivingBase)entity, partialTicks); render(model, entity, partialTicks, renderColor.getRed() / 255.0F, renderColor.getBlue() / 255.0F, renderColor.getGreen() / 255.0F, renderColor.getAlpha() / 255.0F); if (flag)
/*     */       RenderHurtColor.unset();  for (GeoLayerRenderer<T> layerRenderer : (Iterable<GeoLayerRenderer<T>>)this.layerRenderers)
/*     */       layerRenderer.render((EntityLivingBase)entity, limbSwing, limbSwingAmount, partialTicks, limbSwing, netHeadYaw, headPitch, renderColor);  GL11.glEnable(2896); GlStateManager.func_179084_k(); GlStateManager.func_179133_A(); GlStateManager.func_179121_F(); GlStateManager.func_179121_F(); }
/* 608 */   protected void renderLeash(GirlEntity entityLivingIn, double x, double y, double z, float partialTicks) { Entity entity = entityLivingIn.func_110166_bE(); if (entity != null) { y -= (1.6D - entityLivingIn.field_70131_O) * 0.5D; Tessellator tessellator = Tessellator.func_178181_a(); BufferBuilder bufferbuilder = tessellator.func_178180_c(); double d0 = PenisMath.Lerp(entity.field_70126_B, entity.field_70177_z, (partialTicks * 0.5F)) * 0.01745329238474369D; double d1 = PenisMath.Lerp(entity.field_70127_C, entity.field_70125_A, (partialTicks * 0.5F)) * 0.01745329238474369D; double d2 = Math.cos(d0); double d3 = Math.sin(d0); double d4 = Math.sin(d1); if (entity instanceof net.minecraft.entity.EntityHanging) { d2 = 0.0D; d3 = 0.0D; d4 = -1.0D; }  double d5 = Math.cos(d1); double d6 = PenisMath.Lerp(entity.field_70169_q, entity.field_70165_t, partialTicks) - d2 * 0.7D - d3 * 0.5D * d5; double d7 = PenisMath.Lerp(entity.field_70167_r + entity.func_70047_e() * 0.7D, entity.field_70163_u + entity.func_70047_e() * 0.7D, partialTicks) - d4 * 0.5D - 0.25D; double d8 = PenisMath.Lerp(entity.field_70166_s, entity.field_70161_v, partialTicks) - d3 * 0.7D + d2 * 0.5D * d5; double d9 = PenisMath.Lerp(entityLivingIn.field_70760_ar, entityLivingIn.field_70761_aq, partialTicks) * 0.01745329238474369D + 1.5707963267948966D; d2 = Math.cos(d9) * entityLivingIn.field_70130_N * 0.4D; d3 = Math.sin(d9) * entityLivingIn.field_70130_N * 0.4D; double d10 = PenisMath.Lerp(entityLivingIn.field_70169_q, entityLivingIn.field_70165_t, partialTicks) + d2; double d11 = PenisMath.Lerp(entityLivingIn.field_70167_r, entityLivingIn.field_70163_u, partialTicks); double d12 = PenisMath.Lerp(entityLivingIn.field_70166_s, entityLivingIn.field_70161_v, partialTicks) + d3; x += d2; z += d3; double d13 = (float)(d6 - d10); double d14 = (float)(d7 - d11); double d15 = (float)(d8 - d12); GlStateManager.func_179090_x(); GlStateManager.func_179140_f(); GlStateManager.func_179129_p(); bufferbuilder.func_181668_a(5, DefaultVertexFormats.field_181706_f); for (int j = 0; j <= 24; j++) { float f = 0.5F; float f1 = 0.4F; float f2 = 0.3F; if (j % 2 == 0) { f *= 0.7F; f1 *= 0.7F; f2 *= 0.7F; }  float f3 = j / 24.0F; bufferbuilder.func_181662_b(x + d13 * f3 + 0.0D, y + d14 * (f3 * f3 + f3) * 0.5D + ((24.0F - j) / 18.0F + 0.125F), z + d15 * f3).func_181666_a(f, f1, f2, 1.0F).func_181675_d(); bufferbuilder.func_181662_b(x + d13 * f3 + 0.025D, y + d14 * (f3 * f3 + f3) * 0.5D + ((24.0F - j) / 18.0F + 0.125F) + 0.025D, z + d15 * f3).func_181666_a(f, f1, f2, 1.0F).func_181675_d(); }  tessellator.func_78381_a(); bufferbuilder.func_181668_a(5, DefaultVertexFormats.field_181706_f); for (int k = 0; k <= 24; k++) { float f4 = 0.5F; float f5 = 0.4F; float f6 = 0.3F; if (k % 2 == 0) { f4 *= 0.7F; f5 *= 0.7F; f6 *= 0.7F; }  float f7 = k / 24.0F; bufferbuilder.func_181662_b(x + d13 * f7 + 0.0D, y + d14 * (f7 * f7 + f7) * 0.5D + ((24.0F - k) / 18.0F + 0.125F) + 0.025D, z + d15 * f7).func_181666_a(f4, f5, f6, 1.0F).func_181675_d(); bufferbuilder.func_181662_b(x + d13 * f7 + 0.025D, y + d14 * (f7 * f7 + f7) * 0.5D + ((24.0F - k) / 18.0F + 0.125F), z + d15 * f7 + 0.025D).func_181666_a(f4, f5, f6, 1.0F).func_181675_d(); }  tessellator.func_78381_a(); GlStateManager.func_179145_e(); GlStateManager.func_179098_w(); GlStateManager.func_179089_o(); }  } void renderItems(BufferBuilder builder, GeoBone bone) { Item boneItem = Items.field_151043_k;
/* 609 */     int amount = 1;
/* 610 */     ItemRenderer itemRenderer = Minecraft.func_71410_x().func_175597_ag();
/*     */ 
/*     */     
/* 613 */     switch ((String)((GirlEntity)this.girl).field_70180_af.func_187225_a(GirlEntity.ANIMATION_FOLLOW_UP)) {
/*     */       
/*     */       case "doggy":
/* 616 */         boneItem = Items.field_151045_i;
/* 617 */         amount = 2;
/*     */         break;
/*     */       
/*     */       case "blowjob":
/* 621 */         boneItem = Items.field_151166_bC;
/* 622 */         amount = 3;
/*     */         break;
/*     */       
/*     */       case "strip":
/* 626 */         boneItem = Items.field_151043_k;
/* 627 */         amount = 1;
/*     */         break;
/*     */       
/*     */       case "boobjob":
/* 631 */         boneItem = Items.field_151079_bi;
/* 632 */         amount = 2;
/*     */         break;
/*     */     } 
/* 635 */     for (int i = 0; i < amount; i++) {
/*     */       
/* 637 */       GlStateManager.func_179094_E();
/* 638 */       Tessellator.func_178181_a().func_78381_a();
/* 639 */       MatrixHelper.multiplyMatrix(IGeoRenderer.MATRIX_STACK, bone);
/* 640 */       GL11.glEnable(2896);
/*     */       
/* 642 */       GL11.glRotated(bone.getRotationX() + 2.5D, 0.0D, 0.0D, 1.0D);
/* 643 */       GL11.glRotated(bone.getRotationY(), 0.0D, 1.0D, 0.0D);
/* 644 */       GL11.glRotated(bone.getRotationZ(), 1.0D, 0.0D, 0.0D);
/*     */ 
/*     */ 
/*     */       
/* 648 */       switch (i) {
/*     */         case 1:
/* 650 */           GL11.glRotated(-15.0D, 0.0D, 0.0D, 1.0D);
/* 651 */           GlStateManager.func_179137_b(0.0D, 0.0D, -0.025D);
/*     */           break;
/*     */         
/*     */         case 2:
/* 655 */           GL11.glRotated(15.0D, 0.0D, 0.0D, 1.0D);
/* 656 */           GlStateManager.func_179137_b(0.0D, 0.0D, 0.025D);
/*     */           break;
/*     */       } 
/*     */       
/* 660 */       itemRenderer.func_178099_a((EntityLivingBase)this.girl, new ItemStack(boneItem, 1), ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
/*     */       
/* 662 */       func_110776_a(Objects.<ResourceLocation>requireNonNull(getEntityTexture((EntityLivingBase)this.girl)));
/* 663 */       builder.func_181668_a(7, DefaultVertexFormats.field_181712_l);
/* 664 */       GL11.glDisable(2896);
/* 665 */       GlStateManager.func_179121_F();
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void renderWeapon(BufferBuilder builder, GeoBone bone) {
/* 672 */     EntityDataManager dataManager = this.girl.func_184212_Q();
/*     */     
/* 674 */     int attackMode = ((Integer)dataManager.func_187225_a(GirlEntity.ATTACK_MODE)).intValue();
/*     */     
/* 676 */     if (this.girl.currentAction() != GirlEntity.Action.BOW) {
/* 677 */       this.pull = 0.0F;
/*     */     }
/* 679 */     if (attackMode != 0 || this.girl.currentAction() == GirlEntity.Action.ATTACK) {
/*     */       ItemStack boneItem;
/*     */ 
/*     */       
/* 683 */       if (attackMode == 1) {
/*     */         
/* 685 */         boneItem = (ItemStack)dataManager.func_187225_a(GirlEntity.WEAPON);
/* 686 */       } else if (attackMode == 2) {
/*     */         
/* 688 */         boneItem = (ItemStack)dataManager.func_187225_a(GirlEntity.BOW);
/*     */         
/* 690 */         if (this.girl.currentAction() == GirlEntity.Action.BOW) {
/* 691 */           this.pull += 0.015F;
/* 692 */           this.girl.setActiveStackUse(Math.round(-this.pull * 20.0F + boneItem.func_77988_m()));
/* 693 */           this.girl.setActiveItemStack(boneItem);
/*     */         } 
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */       
/* 699 */       GlStateManager.func_179094_E();
/* 700 */       Tessellator.func_178181_a().func_78381_a();
/* 701 */       MatrixHelper.multiplyMatrix(IGeoRenderer.MATRIX_STACK, bone);
/* 702 */       GL11.glEnable(2896);
/*     */       
/* 704 */       if (boneItem.func_77973_b() instanceof net.minecraft.item.ItemBow) {
/*     */         
/* 706 */         GL11.glRotatef(((GirlEntity)this.girl).holdBowRot, 1.0F, 0.0F, 0.0F);
/*     */       }
/* 708 */       else if (this.girl.currentAction() == GirlEntity.Action.ATTACK && ((GirlEntity)this.girl).nextAttack == 0) {
/*     */         
/* 710 */         GlStateManager.func_179137_b(((GirlEntity)this.girl).swordOffsetStab.field_72450_a, ((GirlEntity)this.girl).swordOffsetStab.field_72448_b, ((GirlEntity)this.girl).swordOffsetStab.field_72449_c);
/* 711 */         GL11.glRotatef(((GirlEntity)this.girl).stabSwordRot, 1.0F, 0.0F, 0.0F);
/*     */       }
/*     */       else {
/*     */         
/* 715 */         GL11.glRotatef(((GirlEntity)this.girl).slashSwordRot, 1.0F, 0.0F, 0.0F);
/*     */       } 
/* 717 */       Minecraft.func_71410_x().func_175597_ag().func_178099_a((EntityLivingBase)this.girl, boneItem, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
/* 718 */       func_110776_a(Objects.<ResourceLocation>requireNonNull(getEntityTexture((EntityLivingBase)this.girl)));
/* 719 */       builder.func_181668_a(7, DefaultVertexFormats.field_181712_l);
/* 720 */       GL11.glDisable(2896);
/* 721 */       GlStateManager.func_179121_F();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\girls\GirlRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */