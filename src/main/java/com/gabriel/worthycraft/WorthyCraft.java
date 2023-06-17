package com.gabriel.worthycraft;

import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.ModSetup;
import com.gabriel.worthycraft.networking.ModMessages;
import com.gabriel.worthycraft.oregen.OreManager;
import com.gabriel.worthycraft.setup.ClientSetup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WorthyCraft.MODID)
public class WorthyCraft {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "worthycraft";

    public WorthyCraft() {

        // Register the deferred registry
        Registration.registerWorthyCraft();

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register 'ModSetup::init' to be called at mod setup time (server and client)
        modbus.addListener(ModSetup::init);
        // Register 'ClientSetup::init' to be called at mod setup time (client only)
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
        
        modbus.addListener(this::commonSetup);
        
        OreManager.setup();
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        	ModMessages.register();
        });
    }
}