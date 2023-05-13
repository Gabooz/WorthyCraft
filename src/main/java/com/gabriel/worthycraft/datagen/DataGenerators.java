package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.WorthyCraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WorthyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
        	WorthyCraftBlockTags blockTags = new WorthyCraftBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(new WorthyCraftRecipes(generator));
            generator.addProvider(blockTags);
            generator.addProvider(new WorthyCraftItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new WorthyCraftBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new WorthyCraftItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new WorthyCraftLanguageProvider(generator, "en_us"));
        }
    }
}
