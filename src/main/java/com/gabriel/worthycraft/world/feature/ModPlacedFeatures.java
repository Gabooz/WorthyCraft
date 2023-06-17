package com.gabriel.worthycraft.world.feature;

import java.util.function.Supplier;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
	public static final Supplier<PlacedFeature> CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
	        ModConfiguredFeatures.CITRINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
	                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}
