package com.gabriel.worthycraft.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModSetup {
	
	public static final String TAB_NAME = "worthycraft";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
    
	public static void init(FMLClientSetupEvent event) {
		
	}
}
