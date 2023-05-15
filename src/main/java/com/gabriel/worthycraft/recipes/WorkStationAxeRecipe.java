package com.gabriel.worthycraft.recipes;

import javax.annotation.Nullable;

import com.gabriel.worthycraft.WorthyCraft;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class WorkStationAxeRecipe implements Recipe<Container>{

	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> inputs;
	
	public WorkStationAxeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputs) {
		super();
		this.id = id;
		this.output = output;
		this.inputs = inputs;
	}
	
	@Override
	public boolean matches(Container pContainer, Level p_44003_) {
		return inputs.get(0).test(pContainer.getItem(0));
	}

	@Override
	public ItemStack assemble(Container pContainer) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		// TODO Auto-generated method stub
		return false;
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

	public static class Type implements RecipeType<WorkStationAxeRecipe> {
		private Type() {
			
		}
		public static final Type INSTANCE = new Type();
		public static final String ID = "item_crafting";
	}
	
	public static class Serializer implements RecipeSerializer<WorkStationAxeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(WorthyCraft.MODID,"item_crafting");

        @Override
        public WorkStationAxeRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new WorkStationAxeRecipe(id, output, inputs);
        }

        @Override
        public WorkStationAxeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new WorkStationAxeRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, WorkStationAxeRecipe recipe) {
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