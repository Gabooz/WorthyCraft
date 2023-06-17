package com.gabriel.worthycraft.world.feature;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModConfiguredFeatures {

public static final List<OreConfiguration.TargetBlockState> OVERWORLD_IRON_ORES = List.of(
        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.IRON_ORE.defaultBlockState()),
        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.IRON_ORE.defaultBlockState()));
	
	public static final ConfiguredFeature<OreConfiguration, ?> IRON_ORE = FeatureUtils.register("iron_ore",
			Feature.ORE.configured(new OreConfiguration(OVERWORLD_IRON_ORES, 9)));
}
