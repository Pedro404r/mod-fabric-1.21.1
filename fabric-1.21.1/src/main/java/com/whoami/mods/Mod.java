package com.whoami.mods;

import com.whoami.mods.block.BlocksRegister;
import com.whoami.mods.item.ItemsRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod implements ModInitializer {

    public static final String MOD_ID = "mod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemsRegister.registerItems();
        BlocksRegister.initialize();
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(ItemsRegister.ROYAL_COIN));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
        		.register((itemGroup) -> itemGroup.add(ItemsRegister.AETHER_INGOT));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
        		.register((itemGroup) -> itemGroup.add(ItemsRegister.ROYAL_FEAST));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
        		.register((itemGroup) -> itemGroup.add(ItemsRegister.ROYAL_COIN_BLOCK));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
        		.register((itemGroup) -> itemGroup.add(ItemsRegister.REGAL_PICKAXE));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
        		.register((itemGroup) -> itemGroup.add(ItemsRegister.MONARCH_SWORD));
        
        
        LOGGER.info("Mod inicializado com sucesso!");
    }
}
