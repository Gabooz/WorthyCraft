package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WorthyCraftItemTags extends ItemTagsProvider {

    public WorthyCraftItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, WorthyCraft.MODID, helper);
    }

    @Override
    protected void addTags() {
    }

    @Override
    public String getName() {
        return "WorthyCraft Tags";
    }
}
