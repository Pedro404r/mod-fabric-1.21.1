package com.whoami.mods.datagen;

import com.whoami.mods.block.BlocksRegister;
import com.whoami.mods.item.ItemsRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(BlocksRegister.ROYAL_COIN_BLOCK);
        addDrop(BlocksRegister.KING_ORE_BLOCK);
        addDrop(BlocksRegister.ROYAL_COIN_STAIRS);
        addDrop(BlocksRegister.ROYAL_COIN_FENCE);
        addDrop(BlocksRegister.ROYAL_COIN_WALL);
        addDrop(BlocksRegister.ROYAL_COIN_PRESSURE_PLATE);
        addDrop(BlocksRegister.ROYAL_COIN_BUTTON);
        addDrop(BlocksRegister.ROYAL_COIN_TRAPDOOR);

        addDrop(BlocksRegister.ROYAL_COIN_SLAB, slabDrops(BlocksRegister.ROYAL_COIN_SLAB));
        addDrop(BlocksRegister.ROYAL_COIN_DOOR, doorDrops(BlocksRegister.ROYAL_COIN_DOOR));

        addDrop(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK, 
            multipleOreDrops(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK, ItemsRegister.ROYAL_COIN, 2.0f, 5.0f));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float min, float max) {
        RegistryWrapper.Impl<Enchantment> enchantmentLookup = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return dropsWithSilkTouch(drop, 
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(drop, 
                ((LeafEntry.Builder<?>)ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max))))
                    .apply(ApplyBonusLootFunction.oreDrops(enchantmentLookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}