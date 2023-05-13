package com.gabriel.worthycraft.setup.registryobjects;

import static com.gabriel.worthycraft.WorthyCraft.MODID;

import com.gabriel.worthycraft.setup.ModSetup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.gabriel.worthycraft.blocks.*;

public class WorthyCraftItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
	
	public static final RegistryObject<Item> WORKSTATION_ITEM = fromBlock(WorthyCraftBlocks.WORKSTATION);
	
	// Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
