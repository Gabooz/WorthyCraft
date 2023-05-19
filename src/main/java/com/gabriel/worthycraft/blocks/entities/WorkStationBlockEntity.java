package com.gabriel.worthycraft.blocks.entities;

import com.gabriel.worthycraft.networking.ModMessages;
import com.gabriel.worthycraft.networking.packet.ItemStackSyncS2CPacket;
import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemStackHandler;

public class WorkStationBlockEntity extends FunctionalInventoryBlockEntity {
	

    public void contentsChanged(int item) {
		setChanged();
        if(!level.isClientSide()) {
            ModMessages.sendToClients(new ItemStackSyncS2CPacket((SimpleContainer) getItemHandler(), worldPosition));
        }
    }

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

	public void setHandler(SimpleContainer itemContainer) {
		for (int i = 0; i < itemContainer.getContainerSize(); i++) {
            getItemHandler().setItem(i, itemContainer.getItem(i));
        }	
	}
}
