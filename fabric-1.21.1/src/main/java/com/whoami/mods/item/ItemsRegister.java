package com.whoami.mods.item;

import com.whoami.mods.Mod;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsRegister {

    public static final Item AETHER_INGOT = register(
        "aether_ingot", 
        new Item(new Item.Settings())
    );

    public static final Item MONARCH_SWORD = register(
        "monarch_sword", 
        new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F)))
    );
    
    public static final Item REGAL_PICKAXE = register(
        "regal_pickaxe", 
        new PickaxeItem(ToolMaterials.DIAMOND, new Item.Settings())
    );

    public static final Item ROYAL_COIN = register(
    	"royal_coin",
    	new Item(new Item.Settings())
    );
    
    public static final Item ROYAL_COIN_BLOCK = register(
    	"royal_coin_block",
    	new Item(new Item.Settings())
    );
    
    public static final Item ROYAL_FEAST = register(
        	"royal_feast",
        	new Item(new Item.Settings()
                .food(ModFoodComponents.ROYAL_FEAST))
     );
    
    
    public static final Item SOVEREIGN_COAL = register(
        	"sovereign_coal",
        	new Item(new Item.Settings())
        );
    
    private static Item register(String name, Item item) { 
        return Registry.register(Registries.ITEM, Identifier.of(Mod.MOD_ID, name), item);
    }
    
    public static void registerItems() {
        Mod.LOGGER.info("Registrando todos os itens do mod");
    }
}