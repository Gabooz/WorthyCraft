package com.gabriel.worthycraft.event;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.recipes.WorkStationAxeRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WorthyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	@SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, WorkStationAxeRecipe.Type.ID, WorkStationAxeRecipe.Type.INSTANCE);
    }
}

