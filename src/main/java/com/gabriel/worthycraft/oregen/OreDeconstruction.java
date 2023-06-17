package com.gabriel.worthycraft.oregen;


import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.ScatteredOreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class OreDeconstruction {
	
	public static List<Supplier<PlacedFeature>> destroy = new LinkedList<>();

	public static void deconstruct(IEventBus forgeBus) {
		forgeBus.addListener(EventPriority.LOWEST, OreDeconstruction :: BiomeLoadingEvent);
	}
	
	private static final List<GenerationStep.Decoration> decorations = new LinkedList<>();

	static {
	    decorations.add(GenerationStep.Decoration.UNDERGROUND_ORES);
	    decorations.add(GenerationStep.Decoration.UNDERGROUND_DECORATION);
	}

	public static void BiomeLoadingEvent(BiomeLoadingEvent event) {
	    BiomeGenerationSettingsBuilder biomeBuilder = event.getGeneration();
	    for (GenerationStep.Decoration deco : decorations) {
	        destroyFeature(biomeBuilder.getFeatures(deco), filterFeatures(biomeBuilder.getFeatures(deco)), event.getGeneration());
	    }
	}

	private static void destroyFeature(List<Supplier<PlacedFeature>> features,
	List<Supplier<PlacedFeature>> filterFeatures, BiomeGenerationSettingsBuilder biomeBuilder) {
		for (Supplier<PlacedFeature> feature : destroy) {
            features.remove(feature);
        }
		
	}
	
	 private static OreConfiguration configureFeature(Block ore, Tag<Block> filler, int maxVeinSize, float discardChanceOnAirExposure) {
	        return new OreConfiguration(new TagMatchTest(filler), ore.defaultBlockState(), maxVeinSize, discardChanceOnAirExposure);
	    }
	 
	private static List<Supplier<PlacedFeature>> filterFeatures(List<Supplier<PlacedFeature>> features) {
	    for (Supplier<PlacedFeature> feature : features) {
	
	        Block targetBlock;
	        PlacedFeature targetFeature = getFeature(feature.get());
	        targetBlock = Blocks.IRON_ORE;
	        incinerator(targetBlock, feature);
	    }
	    return destroy;
	}
	
	public static PlacedFeature getFeature(PlacedFeature feature) {
        return feature;
    }
	
	private static void incinerator(Block targetBlock, Supplier<PlacedFeature> targetFeature) {
        if (targetBlock != null) {
            destroy.add(targetFeature);
        }
    }
}