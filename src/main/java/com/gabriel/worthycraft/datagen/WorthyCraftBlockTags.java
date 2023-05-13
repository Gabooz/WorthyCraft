package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WorthyCraftBlockTags extends BlockTagsProvider {

    public WorthyCraftBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, WorthyCraft.MODID, helper);
    }

    @Override
    protected void addTags() {
    }

    @Override
    public String getName() {
        return "WorthyCraft Tags";
    }
}
