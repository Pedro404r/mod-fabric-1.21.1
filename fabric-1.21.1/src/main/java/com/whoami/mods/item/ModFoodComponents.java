package com.whoami.mods.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
	public static final FoodComponent ROYAL_FEAST = new
			FoodComponent.Builder().saturationModifier(2f).nutrition(14)
			.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1500, 1), 1.0f)
			.build();
}