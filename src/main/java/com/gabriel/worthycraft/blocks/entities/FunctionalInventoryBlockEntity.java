package com.gabriel.worthycraft.blocks.entities;

import com.google.common.base.Preconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public abstract class FunctionalInventoryBlockEntity extends BlockEntity implements Clearable{
	
	private final SimpleContainer itemHandler = createItemHandler();
	
	protected FunctionalInventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
		itemHandler.addListener(i -> setChanged());
	}

	protected abstract SimpleContainer createItemHandler();
	
	@Override
	public void clearContent() {
		getItemHandler().clearContent();
	}
	
	public final Container getItemHandler() {
		return itemHandler;
	}
	
	public final int inventorySize() {
		return getItemHandler().getContainerSize();
	}
}
