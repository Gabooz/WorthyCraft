package com.gabriel.worthycraft.setup.registryobjects;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.recipes.WorkStationAxeRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WorthyCraftRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, WorthyCraft.MODID);
	
	public static RegistryObject<RecipeSerializer<WorkStationAxeRecipe>> ITEM_CRAFTING_SERIALIZER;
	
	public static void RegisterRecipeTypes() {
		ITEM_CRAFTING_SERIALIZER =  SERIALIZERS.register("item_crafting", () -> WorkStationAxeRecipe.Serializer.INSTANCE);
	}       

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
