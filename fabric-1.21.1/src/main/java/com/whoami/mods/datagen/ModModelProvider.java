package com.whoami.mods.datagen;

import com.whoami.mods.block.BlocksRegister;
import com.whoami.mods.item.ItemsRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Registra o bloco principal e cria o "Pool" para derivar escadas, lajes, etc.
        BlockStateModelGenerator.BlockTexturePool royalCoinPool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlocksRegister.ROYAL_COIN_BLOCK);
        

        royalCoinPool.stairs(BlocksRegister.ROYAL_COIN_STAIRS);
        royalCoinPool.slab(BlocksRegister.ROYAL_COIN_SLAB);
        royalCoinPool.button(BlocksRegister.ROYAL_COIN_BUTTON);
        royalCoinPool.pressurePlate(BlocksRegister.ROYAL_COIN_PRESSURE_PLATE);
        royalCoinPool.fence(BlocksRegister.ROYAL_COIN_FENCE);
        royalCoinPool.wall(BlocksRegister.ROYAL_COIN_WALL);
        
        blockStateModelGenerator.registerSimpleCubeAll(BlocksRegister.KING_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksRegister.KING_DEEPSLATE_ORE_BLOCK);
        
        blockStateModelGenerator.registerDoor(BlocksRegister.ROYAL_COIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(BlocksRegister.ROYAL_COIN_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Registra os itens 2D (texturas que ficam na pasta item)
        itemModelGenerator.register(ItemsRegister.ROYAL_COIN, Models.GENERATED);
        itemModelGenerator.register(ItemsRegister.SOVEREIGN_COAL, Models.GENERATED);
        itemModelGenerator.register(ItemsRegister.AETHER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemsRegister.ROYAL_FEAST, Models.GENERATED);
        
        // Registra ferramentas (Modelos "handheld" para ficarem certas na mão)
        itemModelGenerator.register(ItemsRegister.MONARCH_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ItemsRegister.REGAL_PICKAXE, Models.HANDHELD);
    }
}