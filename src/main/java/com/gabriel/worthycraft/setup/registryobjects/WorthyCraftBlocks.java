package com.gabriel.worthycraft.setup.registryobjects;

import static com.gabriel.worthycraft.WorthyCraft.MODID;

import com.gabriel.worthycraft.blocks.WorkStation;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WorthyCraftBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	
	public static final RegistryObject<WorkStation> WORKSTATION = BLOCKS.register("workstation", () -> new WorkStation(BlockBehaviour.Properties.of(Material.WOOD)));
}
