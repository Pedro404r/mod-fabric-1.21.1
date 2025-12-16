package com.whoami.mods.block;

import com.whoami.mods.Mod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlocksRegister {

    // Registra o Bloco
    public static final Block ROYAL_COIN_BLOCK = registerBlock(
        new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO)),
        "royal_coin_block"
    );

    // Registra o Item Block (Usado no Inventário e na classe Mod.java)
    public static final BlockItem ROYAL_COIN_BLOCK_ITEM = registerBlockItem(ROYAL_COIN_BLOCK, "royal_coin_block");

    // Método para registrar o Bloco
    private static Block registerBlock(Block block, String name) {
        Identifier id = Identifier.of(Mod.MOD_ID, name);
        return Registry.register(Registries.BLOCK, id, block);
    }

    // Método para registrar o Item Block (Item que representa o Bloco)
    private static BlockItem registerBlockItem(Block block, String name) {
        BlockItem item = new BlockItem(block, new Item.Settings());
        Identifier id = Identifier.of(Mod.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void initialize() {
    }
}