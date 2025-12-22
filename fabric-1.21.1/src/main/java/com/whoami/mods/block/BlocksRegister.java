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

  public static final Block ROYAL_COIN_BLOCK =
      registerBlock(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO)),
          "royal_coin_block");

  public static final Block KING_ORE_BLOCK = registerBlock(
      new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "king_ore_block");

  public static final Block KING_DEEPSLATE_ORE_BLOCK =
      registerBlock(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE)),
          "king_deepslate_ore_block");

  public static final BlockItem ROYAL_COIN_BLOCK_ITEM =
      registerBlockItem(ROYAL_COIN_BLOCK, "royal_coin_block");


  private static Block registerBlock(Block block, String name) {
    Identifier id = Identifier.of(Mod.MOD_ID, name);
    return Registry.register(Registries.BLOCK, id, block);
  }

  private static BlockItem registerBlockItem(Block block, String name) {
    BlockItem item = new BlockItem(block, new Item.Settings());
    Identifier id = Identifier.of(Mod.MOD_ID, name);
    return Registry.register(Registries.ITEM, id, item);
  }


  public static void initialize() {}
}
