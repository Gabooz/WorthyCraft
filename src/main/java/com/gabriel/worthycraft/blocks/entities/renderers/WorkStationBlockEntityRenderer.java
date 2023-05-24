package com.gabriel.worthycraft.blocks.entities.renderers;

import com.gabriel.worthycraft.blocks.WorkStation;
import com.gabriel.worthycraft.blocks.entities.WorkStationBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class WorkStationBlockEntityRenderer implements BlockEntityRenderer<WorkStationBlockEntity>{
	public WorkStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }
	
	@Override
	public void render(WorkStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
	                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		
        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.5f, 0.5f);
        pPoseStack.scale(1f, 1f, 1f);
        
        pPoseStack.mulPose(new Quaternion(0, 0, 0, true));

	    itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI, LightTexture.pack(pBlockEntity.getLevel().getBrightness(LightLayer.BLOCK, pBlockEntity.getBlockPos()), pBlockEntity.getLevel().getBrightness(LightLayer.SKY, pBlockEntity.getBlockPos())), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
	    pPoseStack.popPose();
		
	}
}
