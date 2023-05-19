package com.gabriel.worthycraft.setup;

import com.gabriel.worthycraft.setup.ModSetup;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.gabriel.worthycraft.WorthyCraft.MODID;

import com.gabriel.worthycraft.inventory.WorkBlockContainer;
import com.gabriel.worthycraft.setup.registryobjects.*;;

public class Registration {

    public static void registerWorthyCraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        WorthyCraftBlocks.BLOCKS.register(bus);
        WorthyCraftItems.ITEMS.register(bus);
        WorthyCraftBlockEntities.BLOCK_ENTITIES.register(bus);
        WorthyCraftContainers.CONTAINERS.register(bus);
        WorthyCraftRecipeTypes.SERIALIZERS.register(bus);
        WorthyCraftRecipeTypes.RegisterRecipeTypes();
    }
}
