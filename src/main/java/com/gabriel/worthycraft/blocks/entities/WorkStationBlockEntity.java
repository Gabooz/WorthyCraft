package com.gabriel.worthycraft.blocks.entities;

import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WorkStationBlockEntity extends FunctionalInventoryBlockEntity {
	

	public WorkStationBlockEntity(BlockPos pos, BlockState state) {
        super(WorthyCraftBlockEntities.WORKSTATION_BLOCKENTITY.get(), pos, state);
    }

	@Override
	protected SimpleContainer createItemHandler() {
		return new SimpleContainer(16) {
			@Override
			public int getMaxStackSize() {
				return 1;
			}
		};
	}

	public ItemStack getRenderStack() {
		return getItemHandler().getItem(0);
	}
}
