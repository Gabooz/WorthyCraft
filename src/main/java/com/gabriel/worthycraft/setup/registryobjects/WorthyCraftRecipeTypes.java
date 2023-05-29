package com.gabriel.worthycraft.setup.registryobjects;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.recipes.*;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WorthyCraftRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, WorthyCraft.MODID);
	
	public static RegistryObject<RecipeSerializer<WorkStationAxeRecipe>> WORK_STATION_AXE_RECIPE_SERIALIZER;
	public static RegistryObject<RecipeSerializer<WorkStationShovelRecipe>> WORK_STATION_SHOVEL_RECIPE_SERIALIZER;
	public static RegistryObject<RecipeSerializer<WorkStationSwordRecipe>> WORK_STATION_SWORD_RECIPE_SERIALIZER;
	public static RegistryObject<RecipeSerializer<WorkStationPickaxeRecipe>> WORK_STATION_PICKAXE_RECIPE_SERIALIZER;
	
	public static void RegisterRecipeTypes() {
		WORK_STATION_AXE_RECIPE_SERIALIZER =  SERIALIZERS.register("work_station_axe_recipe", () -> WorkStationAxeRecipe.Serializer.INSTANCE);
		WORK_STATION_SHOVEL_RECIPE_SERIALIZER =  SERIALIZERS.register("work_station_shovel_recipe", () -> WorkStationShovelRecipe.Serializer.INSTANCE);
		WORK_STATION_SWORD_RECIPE_SERIALIZER =  SERIALIZERS.register("work_station_sword_recipe", () -> WorkStationSwordRecipe.Serializer.INSTANCE);
		WORK_STATION_PICKAXE_RECIPE_SERIALIZER =  SERIALIZERS.register("work_station_pickaxe_recipe", () -> WorkStationPickaxeRecipe.Serializer.INSTANCE);
	}       

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
