package com.whoami.mods.block;

import com.whoami.mods.Mod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlocksRegister {

  public static final Block ROYAL_COIN_BLOCK =
      registerBlock(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO)),
          "royal_coin_block");

  public static final Block KING_ORE_BLOCK = registerBlock(
      new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "king_ore_block");

  public static final Block KING_DEEPSLATE_ORE_BLOCK = registerBlock(
      new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
          .strength(4f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),
      "king_deepslate_ore_block");

  public static final BlockItem ROYAL_COIN_BLOCK_ITEM =
      registerBlockItem(ROYAL_COIN_BLOCK, "royal_coin_block");

public static final Block ROYAL_COIN_STAIRS = registerBlock(
   new StairsBlock(BlocksRegister.ROYAL_COIN_BLOCK.getDefaultState(), 
       AbstractBlock.Settings.copy(BlocksRegister.ROYAL_COIN_BLOCK)), 
   "royal_coin_block_stairs"
);

public static final Item ROYAL_COIN_STAIRS_ITEM = registerBlockItem(ROYAL_COIN_STAIRS, "royal_coin_block_stairs");

  public static final Block ROYAL_COIN_SLAB =
      registerBlock(new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()),
          "royal_coin_block_slab");

  public static final Block ROYAL_COIN_BUTTON = registerBlock(
      new ButtonBlock(BlockSetType.STONE, 20,
          AbstractBlock.Settings.create().strength(0.5f).requiresTool().noCollision()),
      "royal_coin_block_button");

  public static final Block ROYAL_COIN_PRESSURE_PLATE = registerBlock(
      new PressurePlateBlock(BlockSetType.STONE,
          AbstractBlock.Settings.create().strength(0.5f).requiresTool()),
      "royal_coin_block_pressure_plate");

  public static final Block ROYAL_COIN_FENCE =
      registerBlock(new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()),
          "royal_coin_block_fence");;


  public static final Block ROYAL_COIN_WALL = registerBlock(
      new WallBlock(
          AbstractBlock.Settings.create().strength(2f).requiresTool()
      ),
      "royal_coin_block_wall"
  );

  public static final Block ROYAL_COIN_DOOR = registerBlock(
      new DoorBlock(
          BlockSetType.STONE,
          AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()
      ),
      "royal_coin_block_door"
  );

  public static final Block ROYAL_COIN_TRAPDOOR = registerBlock(
      new TrapdoorBlock(
          BlockSetType.STONE, 
          AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()
      ),
      "royal_coin_block_trapdoor"
  );
  
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
