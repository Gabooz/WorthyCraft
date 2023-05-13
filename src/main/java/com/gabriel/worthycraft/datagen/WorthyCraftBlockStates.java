package com.gabriel.worthycraft.datagen;

import net.minecraft.data.DataProvider;

import java.util.Set;
import java.util.stream.Collectors;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlocks;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WorthyCraftBlockStates extends BlockStateProvider {

    public WorthyCraftBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, WorthyCraft.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(WorthyCraftBlocks.WORKSTATION.get());
    }
}
