//Code taken from Vaskii's Botania - https://github.com/VazkiiMods/Botania/blob/1.19.x/Xplat/src/main/java/vazkii/botania/common/block/block_entity/SimpleInventoryBlockEntity.java
package com.gabriel.worthycraft.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class SimpleInventoryBlockEntity extends BlockEntity implements Clearable{
	
	private final SimpleContainer itemHandler = createItemHandler();
	
	protected SimpleInventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
		itemHandler.addListener(i -> setChanged());
	}
	
	protected abstract SimpleContainer createItemHandler();
	
	@Override
	public void clearContent() {
		getItemHandler().clearContent();
	}
	
	public final int inventorySize() {
		return getItemHandler().getContainerSize();
	}
	
	public final Container getItemHandler() {
		return itemHandler;
	}
}
