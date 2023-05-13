package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftBlocks;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class WorthyCraftRecipes extends RecipeProvider {

    public WorthyCraftRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(WorthyCraftBlocks.WORKSTATION.get())
        		.requires(Ingredient.of(Blocks.OAK_LOG)) // Add item to the recipe
        		.requires(Ingredient.of(Blocks.COBBLESTONE))
        		.unlockedBy("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OAK_LOG)) // How the recipe is unlocked
        		.save(consumer); // Add data to builder
    }
}
