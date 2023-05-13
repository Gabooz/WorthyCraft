package com.gabriel.worthycraft.inventory;

import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlocks;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class WorkBlockContainer extends AbstractContainerMenu {

     private BlockEntity blockEntity;
     private Player playerEntity;
     private IItemHandler playerInventory;
	
	 public WorkBlockContainer(int windowId, BlockPos pos, Inventory playerInventory, Player player) {
	        super(WorthyCraftContainers.WORKSTATION_CONTAINER.get(), windowId);
	        blockEntity = player.getCommandSenderWorld().getBlockEntity(pos);
	        this.playerEntity = player;
	        this.playerInventory = new InvWrapper(playerInventory);

	        if (blockEntity != null) {
	            blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
	                addSlot(new SlotItemHandler(h, 0, 64, 24));
	            });
	        }
	    }
	 
	 @Override
	    public boolean stillValid(Player playerIn) {
	        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity, WorthyCraftBlocks.WORKSTATION.get());
	    }
}
