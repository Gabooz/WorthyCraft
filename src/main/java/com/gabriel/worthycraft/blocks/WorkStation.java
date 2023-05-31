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
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
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
import com.gabriel.worthycraft.recipes.WorkStationPickaxeRecipe;
import com.gabriel.worthycraft.recipes.WorkStationShovelRecipe;
import com.gabriel.worthycraft.recipes.WorkStationSwordRecipe;

public class WorkStation extends Block implements EntityBlock  {
	
	public WorkStation(Properties props) {
        super(props);
    }
	
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn,
		BlockHitResult hit) {
		if (level.isClientSide) {
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
		ItemStack item = player.getItemInHand(handIn);
		BlockEntity currentBlockEntityInstance = level.getBlockEntity(pos);
		
		if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
			if (item.isEmpty()) {
						if(workstation.getItemLastPutIn() >= 0) {
							player.setItemInHand(InteractionHand.MAIN_HAND, workstation.getItemHandler().getItem(workstation.getItemLastPutIn()));
							replaceWorkstationSlot(workstation.getItemLastPutIn(), ItemStack.EMPTY, workstation);
							level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
							return InteractionResult.sidedSuccess(!level.isClientSide);
						} else {
							return InteractionResult.FAIL;
						}
			} else {
				if(item.getItem() instanceof AxeItem) {
						Container inventory = workstation.getItemHandler();
						Optional<WorkStationAxeRecipe> match = level.getRecipeManager().getRecipeFor(WorkStationAxeRecipe.Type.INSTANCE, inventory, level);
							
						if(match.isPresent()) {
							ItemStack outputItem = match.get().getResultItem();
							replaceWorkstationSlot(workstation.getItemLastPutIn(), ItemStack.EMPTY, workstation);
							for (int i = 0; i < outputItem.getCount(); i++) {
								replaceWorkstationSlot(workstation.getEmptySpot(), new ItemStack(outputItem.getItem()), workstation);
							}
							level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
							return InteractionResult.sidedSuccess(!level.isClientSide);
						}else {
							return InteractionResult.FAIL;
						}
				} else if (item.getItem() instanceof PickaxeItem){
					Container inventory = workstation.getItemHandler();
					Optional<WorkStationPickaxeRecipe> match = level.getRecipeManager().getRecipeFor(WorkStationPickaxeRecipe.Type.INSTANCE, inventory, level);
						
					if(match.isPresent()) {
						ItemStack outputItem = match.get().getResultItem();
						replaceWorkstationSlot(workstation.getItemLastPutIn(), ItemStack.EMPTY, workstation);
						for (int i = 0; i < outputItem.getCount(); i++) {
							replaceWorkstationSlot(workstation.getEmptySpot(), new ItemStack(outputItem.getItem()), workstation);
						}
						level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
						return InteractionResult.sidedSuccess(!level.isClientSide);
					}else {
						return InteractionResult.FAIL;
					}
				} else if (item.getItem() instanceof ShovelItem){
					Container inventory = workstation.getItemHandler();
					Optional<WorkStationShovelRecipe> match = level.getRecipeManager().getRecipeFor(WorkStationShovelRecipe.Type.INSTANCE, inventory, level);
						
					if(match.isPresent()) {
						ItemStack outputItem = match.get().getResultItem();
						replaceWorkstationSlot(workstation.getItemLastPutIn(), ItemStack.EMPTY, workstation);
						for (int i = 0; i < outputItem.getCount(); i++) {
							replaceWorkstationSlot(workstation.getEmptySpot(), new ItemStack(outputItem.getItem()), workstation);
						}
						level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
						return InteractionResult.sidedSuccess(!level.isClientSide);
					}else {
						return InteractionResult.FAIL;
					}
				} else if (item.getItem() instanceof SwordItem){
					Container inventory = workstation.getItemHandler();
					Optional<WorkStationSwordRecipe> match = level.getRecipeManager().getRecipeFor(WorkStationSwordRecipe.Type.INSTANCE, inventory, level);
						
					if(match.isPresent()) {
						ItemStack outputItem = match.get().getResultItem();
						replaceWorkstationSlot(workstation.getItemLastPutIn(), ItemStack.EMPTY, workstation);
						for (int i = 0; i < outputItem.getCount(); i++) {
							replaceWorkstationSlot(workstation.getEmptySpot(), new ItemStack(outputItem.getItem()), workstation);
						}
						level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.1F, 10F);
						return InteractionResult.sidedSuccess(!level.isClientSide);
					}else {
						return InteractionResult.FAIL;
					}
				} else {
				
						if(workstation.getItemLastPutIn() < 10) {
							replaceWorkstationSlot(workstation.getEmptySpot(), item.split(1), workstation);
							if (item.getCount() > 0) {
								player.setItemInHand(handIn, item.split(item.getCount()));
								level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.5F, 50F);
								return InteractionResult.sidedSuccess(!level.isClientSide);
							} else {
								player.setItemInHand(handIn, ItemStack.EMPTY);
								level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.5F, 50F);
								return InteractionResult.sidedSuccess(!level.isClientSide);
							}
						} else {
							return InteractionResult.FAIL;
						}
					}
				}
		} else {
			return InteractionResult.FAIL;
		}
	}
	
	private void replaceWorkstationSlot(int slot, ItemStack item, WorkStationBlockEntity workstation) {
		workstation.getItemHandler().setItem(slot, item);
		workstation.contentsChanged(slot);
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
