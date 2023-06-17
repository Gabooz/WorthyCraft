package com.gabriel.worthycraft.world;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.world.gen.WorthyCraftOreGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WorthyCraft.MODID)
public class ModWorldEvents {
	@SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        WorthyCraftOreGeneration.generateOres(event);
    }
}
