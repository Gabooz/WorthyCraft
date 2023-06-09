package com.gabriel.worthycraft.recipes;

import javax.annotation.Nullable;

import com.gabriel.worthycraft.WorthyCraft;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class WorkStationShovelRecipe implements Recipe<Container>{

	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> inputs;
	
	public WorkStationShovelRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputs) {
		super();
		this.id = id;
		this.output = output;
		this.inputs = inputs;
	}

	@Override
	public boolean matches(Container pContainer, Level p_44003_) {
		SimpleContainer ItemRecipe = new SimpleContainer(11);
		int o = 0;
		for (int i = 0; i < inputs.size(); i++) {
			for (int u = 0; u < inputs.get(i).getItems().length; u++) {
				ItemRecipe.setItem(o, inputs.get(i).getItems()[u]);
				o++;
			}
		}
		
		for (int i = 0; i < ItemRecipe.getContainerSize(); i++) {
			if(!ItemRecipe.getItem(i).isEmpty()) {
				if (pContainer.getItem(i).isEmpty()) {
					return false;
				} else if (!ItemRecipe.getItem(i).sameItem(pContainer.getItem(i))){
					return false;
				}
			} else {
				if (!pContainer.getItem(i).isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public ItemStack assemble(Container pContainer) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	public static class Type implements RecipeType<WorkStationShovelRecipe> {
		private Type() {
			
		}
		public static final Type INSTANCE = new Type();
		public static final String ID = "work_station_shovel_recipe";
	}
	
	public static class Serializer implements RecipeSerializer<WorkStationShovelRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(WorthyCraft.MODID,"work_station_shovel_recipe");

        @Override
        public WorkStationShovelRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new WorkStationShovelRecipe(id, output, inputs);
        }

        @Override
        public WorkStationShovelRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new WorkStationShovelRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, WorkStationShovelRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
