package com.gabriel.worthycraft.networking.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import com.gabriel.worthycraft.blocks.entities.WorkStationBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkEvent;

public class ItemStackSyncS2CPacket {
	private final SimpleContainer itemContainer;
    private final BlockPos pos;

    public ItemStackSyncS2CPacket(SimpleContainer itemContainer, BlockPos pos) {
        this.itemContainer = itemContainer;
        this.pos = pos;
    }

    public ItemStackSyncS2CPacket(FriendlyByteBuf buf) {
        List<ItemStack> collection = buf.readCollection(ArrayList::new, FriendlyByteBuf::readItem);
        itemContainer = new SimpleContainer(collection.size());
        for (int i = 0; i < collection.size(); i++) {
            itemContainer.setItem(i, collection.get(i));
        }
        
		this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        Collection<ItemStack> list = new ArrayList<>();
        for(int i = 0; i < itemContainer.getContainerSize(); i++) {
            list.add(itemContainer.getItem(i));
        }

        buf.writeCollection(list, FriendlyByteBuf::writeItem);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof WorkStationBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemContainer);
            }
        });
        return true;
    }
}
