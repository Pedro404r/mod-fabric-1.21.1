package com.whoami.mods.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import com.whoami.mods.block.BlocksRegister;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(BlocksRegister.ROYAL_COIN_BLOCK)
            .add(BlocksRegister.KING_ORE_BLOCK)
            .add(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK)
            .add(BlocksRegister.ROYAL_COIN_STAIRS)
            .add(BlocksRegister.ROYAL_COIN_SLAB)
            .add(BlocksRegister.ROYAL_COIN_FENCE)
            .add(BlocksRegister.ROYAL_COIN_WALL)
            .add(BlocksRegister.ROYAL_COIN_DOOR)
            .add(BlocksRegister.ROYAL_COIN_TRAPDOOR)
            .add(BlocksRegister.ROYAL_COIN_PRESSURE_PLATE)
            .add(BlocksRegister.ROYAL_COIN_BUTTON);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(BlocksRegister.KING_ORE_BLOCK)
            .add(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(BlocksRegister.ROYAL_COIN_FENCE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(BlocksRegister.ROYAL_COIN_WALL);
        getOrCreateTagBuilder(BlockTags.DOORS).add(BlocksRegister.ROYAL_COIN_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(BlocksRegister.ROYAL_COIN_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(BlocksRegister.ROYAL_COIN_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(BlocksRegister.ROYAL_COIN_BUTTON);
    }
}