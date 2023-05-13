package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WorthyCraftItemModels extends ItemModelProvider {

    public WorthyCraftItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WorthyCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(WorthyCraftItems.WORKSTATION_ITEM.get().getRegistryName().getPath(), modLoc("block/workstation"));
    }
}
