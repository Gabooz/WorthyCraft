package com.gabriel.worthycraft.oregen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

public class OreManager {
	public static void setup() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        OreDeconstruction.deconstruct(forgeBus);
        OreReconstruction.reconstruct(forgeBus);
    }
}
