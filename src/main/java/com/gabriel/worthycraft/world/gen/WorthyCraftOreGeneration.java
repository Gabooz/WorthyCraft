package com.gabriel.worthycraft.world.gen;

import java.util.List;
import java.util.function.Supplier;

import com.gabriel.worthycraft.world.feature.ModPlacedFeatures;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorthyCraftOreGeneration {

	
	public static void generateOres(final BiomeLoadingEvent event) {
	   event.getGeneration().addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.IRON_ORE_PLACED);
	}

}
