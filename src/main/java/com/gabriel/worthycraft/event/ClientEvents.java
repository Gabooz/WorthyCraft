package com.gabriel.worthycraft.event;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.blocks.entities.renderers.WorkStationBlockEntityRenderer;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlockEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	 @Mod.EventBusSubscriber(modid = WorthyCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
	    public static class ClientModBusEvents {

	        @SubscribeEvent
	        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
	            event.registerBlockEntityRenderer(WorthyCraftBlockEntities.WORKSTATION_BLOCKENTITY.get(),
	                    WorkStationBlockEntityRenderer::new);
	        }
	        
	    }
}
