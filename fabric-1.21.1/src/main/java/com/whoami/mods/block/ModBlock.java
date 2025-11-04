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

public class ModBlock {

    public static final Block KING_COIN_BLOCK = register(
        new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO)),
        "king_coin_block",
        true
    );

    private static Block register(Block block, String name, boolean registerItem) {
        Identifier id = Identifier.of(Mod.MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        if (registerItem) {
            BlockItem item = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, item);
        }
        return block;
    }

    public static void initialize() {
    }
}
