package com.gabriel.worthycraft.world.feature;

import java.util.function.Supplier;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import com.gabriel.worthycraft.world.feature.ModOrePlacement;

public class ModPlacedFeatures {
	public static final PlacedFeature IRON_ORE_PLACED = PlacementUtils.register("iron_ore_placed",
	        ModConfiguredFeatures.IRON_ORE.placed(ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(200)))));
}
