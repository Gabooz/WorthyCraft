package com.gabriel.worthycraft.world.feature;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class IronOreFeature extends Feature<NoneFeatureConfiguration> {

			public IronOreFeature() {
				super(NoneFeatureConfiguration.CODEC);
			}

			@Override
			public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
				WorldGenLevel worldgenlevel = config.level();
				BlockPos blockpos = config.origin();
				Random rng = config.random();

				int setPos = new int(blockpos.getX(), blockpos.getY(), blockpos.getZ());
				for(int i = -6; i < 7; i++)
					for(int j = -6; j < 7; j++) 
						for(int k = -2; k < 3; k++) {
							setPos.set(blockpos.getX() + i, blockpos.getY() + k, blockpos.getZ() + j);
							double dist = blockpos.distSqr(setPos);
							worldgenlevel.setBlock(setPos.above(), Blocks.IRON_ORE, 2);
						}

				return true;
			}
	 }
}
