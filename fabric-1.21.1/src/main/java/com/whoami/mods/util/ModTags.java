package com.whoami.mods.util;

import com.whoami.mods.Mod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;

public class ModTags { // classe central caso eu queira colocar mais tags

  public static class Blocks {

    private static TagKey<Block> createTag(String name) {
      return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Mod.MOD_ID, name));
    }
  }

  public static class Items {
    public static final TagKey<Item> ITENS_TRANSFORMAVEIS = createTag("itens_transformaveis");

    private static TagKey<Item> createTag(String name) {
      return TagKey.of(RegistryKeys.ITEM, Identifier.of(Mod.MOD_ID, name));
    }
  }
}
