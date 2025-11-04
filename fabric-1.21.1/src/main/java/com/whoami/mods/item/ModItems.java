package com.whoami.mods.item;

import com.whoami.mods.Mod;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
    

    public static final Item KING_MEAT = register(
            new Item(new Item.Settings().food(
                new FoodComponent.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .statusEffect(
                        new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1), 
                        1.0f 
                    )
                    .statusEffect(
                        new StatusEffectInstance(StatusEffects.REGENERATION, 900, 0), 
                        1.0f
                    )
                    .build()
            )),
            "king_meat"
        );

    private static Item register(Item item, String name) {
        return Registry.register(Registries.ITEM, Identifier.of(Mod.MOD_ID, name), item);
    }

    public static void registerItems() {
        Mod.LOGGER.info("Registrando itens do mod");
    }
}
