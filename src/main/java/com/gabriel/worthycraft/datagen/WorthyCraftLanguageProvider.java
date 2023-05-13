package com.gabriel.worthycraft.datagen;

import com.gabriel.worthycraft.WorthyCraft;
import com.gabriel.worthycraft.setup.Registration;
import com.gabriel.worthycraft.setup.registryobjects.WorthyCraftItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.gabriel.worthycraft.setup.ModSetup.TAB_NAME;

public class WorthyCraftLanguageProvider extends LanguageProvider {

    public WorthyCraftLanguageProvider(DataGenerator gen, String locale) {
        super(gen, WorthyCraft.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "WorthyCraft");

        add(WorthyCraftItems.WORKSTATION_ITEM.get(), "Work Station");
    }
}
