package com.whoami.mods.datagen;

import com.whoami.mods.block.BlocksRegister;
import com.whoami.mods.item.ItemsRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> ROYAL_COIN_SMELTABLES = List.of(
                BlocksRegister.KING_ORE_BLOCK, 
                BlocksRegister.KING_DEEPSLATE_ORE_BLOCK
        );

        offerSmelting(exporter, ROYAL_COIN_SMELTABLES, RecipeCategory.MISC, ItemsRegister.ROYAL_COIN, 0.7f, 200, "royal_coin");
        offerBlasting(exporter, ROYAL_COIN_SMELTABLES, RecipeCategory.MISC, ItemsRegister.ROYAL_COIN, 0.7f, 100, "royal_coin");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlocksRegister.ROYAL_COIN_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ItemsRegister.ROYAL_COIN)
                .criterion(hasItem(ItemsRegister.ROYAL_COIN), conditionsFromItem(ItemsRegister.ROYAL_COIN))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemsRegister.MONARCH_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ItemsRegister.ROYAL_COIN)
                .input('S', Items.GOLDEN_SWORD)
                .criterion(hasItem(ItemsRegister.ROYAL_COIN), conditionsFromItem(ItemsRegister.ROYAL_COIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegister.ROYAL_COIN, 9)
                .input(BlocksRegister.ROYAL_COIN_BLOCK)
                .criterion(hasItem(BlocksRegister.ROYAL_COIN_BLOCK), conditionsFromItem(BlocksRegister.ROYAL_COIN_BLOCK))
                .offerTo(exporter, "royal_coin_from_block");

        createStairsRecipe(BlocksRegister.ROYAL_COIN_STAIRS, Ingredient.ofItems(BlocksRegister.ROYAL_COIN_BLOCK))
                .criterion(hasItem(BlocksRegister.ROYAL_COIN_BLOCK), conditionsFromItem(BlocksRegister.ROYAL_COIN_BLOCK))
                .offerTo(exporter);

        createDoorRecipe(BlocksRegister.ROYAL_COIN_DOOR, Ingredient.ofItems(BlocksRegister.ROYAL_COIN_BLOCK))
                .criterion(hasItem(BlocksRegister.ROYAL_COIN_BLOCK), conditionsFromItem(BlocksRegister.ROYAL_COIN_BLOCK))
                .offerTo(exporter);

        createTrapdoorRecipe(BlocksRegister.ROYAL_COIN_TRAPDOOR, Ingredient.ofItems(BlocksRegister.ROYAL_COIN_BLOCK))
                .criterion(hasItem(BlocksRegister.ROYAL_COIN_BLOCK), conditionsFromItem(BlocksRegister.ROYAL_COIN_BLOCK))
                .offerTo(exporter);
        
        offerPressurePlateRecipe(exporter, BlocksRegister.ROYAL_COIN_PRESSURE_PLATE, BlocksRegister.ROYAL_COIN_BLOCK);
        
    }
}