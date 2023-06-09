package com.gabriel.worthycraft.blocks.entities.renderers;

import com.gabriel.worthycraft.blocks.WorkStation;
import com.gabriel.worthycraft.blocks.entities.WorkStationBlockEntity;
import com.ibm.icu.impl.PropsVectors;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3d;
import com.mojang.math.Vector3f;

import mcjty.theoneprobe.rendering.RenderHelper.Vector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;

public class WorkStationBlockEntityRenderer implements BlockEntityRenderer<WorkStationBlockEntity>{
	public WorkStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }
	
	@Override
	public void render(WorkStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
	                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		
		Container renderedItems = new SimpleContainer(10);
		int o = 0;
		
		for (int i = 0; i < pBlockEntity.inventorySize(); i++) {
			ItemStack itemStack = pBlockEntity.getItemHandler().getItem(i);
				if(!itemStack.isEmpty()) {
					renderedItems.setItem(o, itemStack);
					o++;
					
				}
		}
		
		if(o == 0) {
		}else if(o==1) {
				pPoseStack.pushPose();
				
				pPoseStack.translate(0.5f, 0.5f, 0.5f);
		        pPoseStack.scale(1f, 1f, 1f);
		        
		        
			    itemRenderer.renderStatic(renderedItems.getItem(0), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
		        
			    pPoseStack.popPose();
		}else if (o == 2) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.25f, 0.5f, 0.25f);
			        pPoseStack.scale(0.8f, 0.8f, 0.8f);
			        pPoseStack.mulPose(Vector3f.XP.rotationDegrees(90f));
			        pPoseStack.mulPose(Vector3f.YP.rotationDegrees(90f));
			        pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(90f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.75f, 0.5f, 0.75f);
			        pPoseStack.scale(0.8f, 0.8f, 0.8f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(30f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 3) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.65f, 0.5f, 0.5f);
			        pPoseStack.scale(0.75f, 0.75f, 0.75f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(40f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.3f, 0.5f, 0.25f);
			        pPoseStack.scale(0.75f, 0.75f, 0.75f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(60f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.3f, 0.5f, 0.75f);
			        pPoseStack.scale(0.75f, 0.75f, 0.75f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(70f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 4) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.25f, 0.5f, 0.25f);
			        pPoseStack.scale(0.6f, 0.6f, 0.6f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(80f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.25f, 0.5f, 0.75f);
			        pPoseStack.scale(0.6f, 0.6f, 0.6f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(90f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.75f, 0.5f, 0.25f);
			        pPoseStack.scale(0.6f, 0.6f, 0.6f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(100f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.75f, 0.5f, 0.75f);
			        pPoseStack.scale(0.6f, 0.6f, 0.6f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(110f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 5) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.4f);
			        pPoseStack.scale(0.4f, 0.4f, 0.4f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(120f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.6f);
			        pPoseStack.scale(0.4f, 0.4f, 0.4f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(130f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.6f, 0.5f, 0.2f);
			        pPoseStack.scale(0.4f, 0.4f, 0.4f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(140f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.6f, 0.5f, 0.8f);
			        pPoseStack.scale(0.4f, 0.4f, 0.4f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(150f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.5f);
			        pPoseStack.scale(0.4f, 0.4f, 0.4f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(160f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 6) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.3f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(170f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.6f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(180f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.2f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(190f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.8f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(200f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 4) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.3f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(210f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.6f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(220f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 7) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.3f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(230f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.6f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(240f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.2f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(250f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.8f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(260f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 4) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.5f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(270f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 5) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.3f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(280f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.6f);
			        pPoseStack.scale(0.3f, 0.3f, 0.3f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(290f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 8) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.3f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(300f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.3f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(310f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.3f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(320f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.7f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(330f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 4) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.7f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(340f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 5) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.7f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(350f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 6) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.3f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(360f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.7f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 9) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.5f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 4) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.5f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 5) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 6) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 7) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.5f);
			        pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else if (o == 10) {
			for (int i = 0; i < o; i++) {
				if (i == 0) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 1) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.5f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 2) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.2f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 3) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 4) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.4f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 5) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 6) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.2f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 7) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.5f);
			        pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else if (i == 8) {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.5f, 0.5f, 0.6f);
			        pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				} else {
					pPoseStack.pushPose();
					
					pPoseStack.translate(0.8f, 0.5f, 0.8f);
					pPoseStack.scale(0.2f, 0.2f, 0.2f);
			        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
			        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
			        
			        
				    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
			        
				    pPoseStack.popPose();
				}
			}
		}else {
			for (int i = 0; i < o; i++) {
				pPoseStack.pushPose();
				
				pPoseStack.translate(0.5f, 0.5f, 0.5f);
				pPoseStack.scale(1f, 1f, 1f);
		        pPoseStack.mulPose(Vector3f.XP.rotation(0f));
		        pPoseStack.mulPose(Vector3f.YP.rotation(0f));
		        pPoseStack.mulPose(Vector3f.ZP.rotation(0f));
		        
		        
			    itemRenderer.renderStatic(renderedItems.getItem(i), ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
		        
			    pPoseStack.popPose();
			}
		}
		
	}
}
