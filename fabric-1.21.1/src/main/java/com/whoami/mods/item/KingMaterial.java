package com.whoami.mods.item;

import net.minecraft.block.Block;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class KingMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 455;
	}
	
	@Override
	public int getEnchantability() {
		return 100;
	}
	
	@Override
	public float getMiningSpeedMultiplier() {
		return 16.0F;
	}
	
	@Override
	public float getAttackDamage() {
		return 3.5F;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ItemsRegister.KING_INGOT);
	}

	@Override
	public TagKey<Block> getInverseTag() {
		return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
	}
}