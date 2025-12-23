package com.whoami.mods.item.custom;

import com.whoami.mods.Mod;
import com.whoami.mods.block.BlocksRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ROYAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Mod.MOD_ID, "royal_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.royal_group"))
                    .icon(() -> new ItemStack(BlocksRegister.ROYAL_COIN_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(BlocksRegister.ROYAL_COIN_BLOCK);
                        entries.add(BlocksRegister.KING_ORE_BLOCK);
                        entries.add(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK);
                        entries.add(BlocksRegister.ROYAL_COIN_STAIRS);
                        entries.add(BlocksRegister.ROYAL_COIN_SLAB);
                        entries.add(BlocksRegister.ROYAL_COIN_FENCE);
                        entries.add(BlocksRegister.ROYAL_COIN_WALL);
                        entries.add(BlocksRegister.ROYAL_COIN_DOOR);
                        entries.add(BlocksRegister.ROYAL_COIN_TRAPDOOR);
                        entries.add(BlocksRegister.ROYAL_COIN_PRESSURE_PLATE);
                        entries.add(BlocksRegister.ROYAL_COIN_BUTTON);
                    }).build());

    public static void registerItemGroups() {
        Mod.LOGGER.info("Registrando Item Groups para " + Mod.MOD_ID);
    }
}