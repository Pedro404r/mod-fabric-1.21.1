package com.whoami.mods.item;

import com.whoami.mods.Mod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

	public static final Item KING_COIN = register(
			new Item(new Item.Settings()),
			"king_coin"
	);
	
	public static final Item KING_COIN_PART_1 = register(
			new Item(new Item.Settings()),
			"king_coin_part_1"
	);
	
	public static final Item KING_COIN_PART_2 = register(
			new Item(new Item.Settings()),
			"king_coin_part_2"
	);

    private static Item register(Item item, String name) {
        return Registry.register(Registries.ITEM, Identifier.of(Mod.MOD_ID, name), item);
    }

    public static void registerItems() {
        Mod.LOGGER.info("registrando items");
    }
}