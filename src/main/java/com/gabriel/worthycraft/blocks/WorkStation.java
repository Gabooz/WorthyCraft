package com.gabriel.worthycraft.blocks;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

public class WorkStation extends Block implements EntityBlock  {
	
	public WorkStation(Properties props) {
        super(props);
    }
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn,
		BlockHitResult hit) {
			ItemStack item = player.getItemInHand(handIn);
			BlockEntity currentBlockEntityInstance = level.getBlockEntity(pos);
			if (item.isEmpty()) {
				if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
					Container currentWorkStationInventory = workstation.getItemHandler();
					for (int i = 0; i < workstation.inventorySize(); i++) {
						if (workstation.getItemHandler().getItem(i).isEmpty()) {
							if(i > 0) {
								ItemStack pulledItem = ItemHandlerHelper.insertItem(new ItemStackHandler(), workstation.getItemHandler().getItem(i-1), false);
								workstation.getItemHandler().setItem(i-1, ItemStack.EMPTY);
								player.setItemInHand(handIn, pulledItem);
								level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 0.1F, 10F);
								return InteractionResult.SUCCESS;
							} else {
								return InteractionResult.FAIL;
							}
						}
					}
					workstation.getItemHandler().setItem(1, item.split(1));
					player.setItemInHand(handIn, ItemStack.EMPTY);
					return InteractionResult.SUCCESS;
				} else {
					return InteractionResult.FAIL;
				}
			} else {
				if (currentBlockEntityInstance instanceof WorkStationBlockEntity workstation) {
					Container currentWorkStationInventory = workstation.getItemHandler();
					for (int i = 0; i < workstation.inventorySize(); i++) {
						if (workstation.getItemHandler().getItem(i).isEmpty()) {
							workstation.getItemHandler().setItem(i, item.split(1));
							player.setItemInHand(handIn, ItemStack.EMPTY);
							level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 0.1F, 10F);
							return InteractionResult.SUCCESS;
						}
					}
					workstation.getItemHandler().setItem(1, item.split(1));
					player.setItemInHand(handIn, ItemStack.EMPTY);
					return InteractionResult.SUCCESS;
				} else {
					return InteractionResult.FAIL;
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