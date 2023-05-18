package com.gabriel.worthycraft.blocks;

import javax.annotation.Nullable;

import java.util.Optional;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import com.gabriel.worthycraft.blocks.entities.*;
import com.gabriel.worthycraft.recipes.WorkStationAxeRecipe;

public class WorkStation extends Block implements EntityBlock  {
	
	public WorkStation(Properties props) {
        super(props);
    }
	
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn,
		BlockHitResult hit) { //When the block is clicked
		if (level.isClientSide) {
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
		player.sendMessage(new TextComponent("Not client side"), player.getUUID());
		ItemStack item = player.getItemInHand(handIn); //Get Item in hand
		BlockEntity currentBlockEntityInstance = level.getBlockEntity(pos);
		if (item.isEmpty()) { //If there is no item
			player.sendMessage(new TextComponent("hand empty"), player.getUUID());
			if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
				Container currentWorkStationInventory = workstation.getItemHandler();
				for (int i = 0; i < workstation.inventorySize(); i++) {  //Loop through the workstation inventory
					if (workstation.getItemHandler().getItem(i).isEmpty()) { //If an Item is empty
						if(i > 0) { //If the index is not 0 (so that we don't index a negative number)
							player.setItemInHand(InteractionHand.MAIN_HAND, workstation.getItemHandler().getItem(i-1)); //Put the last item (the one before we hit the empty spot) in the players hand
							workstation.getItemHandler().setItem(i-1, ItemStack.EMPTY); //Remove this item from the workstation
							level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
							return InteractionResult.sidedSuccess(!level.isClientSide); //End the sequence
						} else { //If the item will be negative then end
							return InteractionResult.FAIL;
						}						}
				}
				return InteractionResult.FAIL;
			} else {
				return InteractionResult.FAIL;
			}
			
		} else { //If there is an item in the players hand
			player.sendMessage(new TextComponent("hand full"), player.getUUID());
			if(item.getItem() instanceof AxeItem) { //If the player has a n axe in their hand (if the item is an axe)
				player.sendMessage(new TextComponent("hand has axe"), player.getUUID());
				if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
					Container inventory = workstation.getItemHandler();
					Optional<WorkStationAxeRecipe> match = level.getRecipeManager().getRecipeFor(WorkStationAxeRecipe.Type.INSTANCE, inventory, level);
						
					if(match.isPresent()) { //If there is a recipe
						player.sendMessage(new TextComponent("match present"), player.getUUID());
						Item outputItem = match.get().getResultItem().getItem();
						for (int i = 0; i < workstation.inventorySize(); i++) { //Go through workstation inventory
							workstation.getItemHandler().setItem(i, ItemStack.EMPTY); //make every item gone
						}
						workstation.getItemHandler().setItem(0, new ItemStack(outputItem)); //Put the output block in the workstation
						level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
						return InteractionResult.sidedSuccess(!level.isClientSide); //End
					}else { //If there is no recipe
						return InteractionResult.FAIL; //end
					}
				} else {
					return InteractionResult.FAIL;
				}
			} else { //If the hand does not have an axe
				player.sendMessage(new TextComponent("hand has no axe"), player.getUUID());
				if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
					Container currentWorkStationInventory = workstation.getItemHandler();
					for (int i = 0; i < workstation.inventorySize(); i++) { //go through the workstation inventory
						if (workstation.getItemHandler().getItem(i).isEmpty()) { //until there is an empty spot
							if(i < 11) { //as long if it's at eleven or under spots
								workstation.getItemHandler().setItem(i, item.split(1)); //set the spots item as the one in the players hand
								if (item.getCount() > 0) { //If the player has more than one item
									player.setItemInHand(handIn, item.split(item.getCount())); //Take away one from the stack
									level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.5F, 50F);
									return InteractionResult.sidedSuccess(!level.isClientSide); //end
								} else { // If the player has just one item
									player.setItemInHand(handIn, ItemStack.EMPTY); //Empty his hand slot
									level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.5F, 50F);
									return InteractionResult.sidedSuccess(!level.isClientSide); //end
								}
							} else {
								return InteractionResult.FAIL;
							}
						}
					}
					return InteractionResult.FAIL;
				} else {
					return InteractionResult.FAIL;
				}
			}
		}
	}
	
	@Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WorkStationBlockEntity(blockPos, blockState);
    }
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
		VoxelShape SLABSHAPE = Block.box(0, 0, 0, 16, 9, 16);
		return SLABSHAPE;
	}
	
	
	
}
