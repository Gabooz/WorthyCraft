package com.gabriel.worthycraft.setup.registryobjects;

import static com.gabriel.worthycraft.WorthyCraft.MODID;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.gabriel.worthycraft.blocks.entities.*;

public class WorthyCraftBlockEntities {
	 public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

	 public static final RegistryObject<BlockEntityType<WorkStationBlockEntity>> WORKSTATION_BLOCKENTITY = BLOCK_ENTITIES.register("workstation", () -> BlockEntityType.Builder.of(WorkStationBlockEntity::new, WorthyCraftBlocks.WORKSTATION.get()).build(null));
}
