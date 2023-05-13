package com.gabriel.worthycraft.setup.registryobjects;

import static com.gabriel.worthycraft.WorthyCraft.MODID;

import com.gabriel.worthycraft.inventory.WorkBlockContainer;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WorthyCraftContainers {
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);

	public static final RegistryObject<MenuType<WorkBlockContainer>> WORKSTATION_CONTAINER = CONTAINERS.register("workstation", () -> IForgeMenuType.create((windowId, inv, data) -> new WorkBlockContainer(windowId, data.readBlockPos(), inv, inv.player)));
}
