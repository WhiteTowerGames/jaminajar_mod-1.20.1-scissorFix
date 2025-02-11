package io.github.jaminajar.jaminajarmod.items;

import net.fabricmc.yarn.constants.MiningLevels;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

	MACHETE(MiningLevels.IRON, 1031, 5.0F, 4.0F, 5, () -> Ingredient.ofItems(Items.IRON_INGOT)),
	SCISSORS(MiningLevels.NETHERITE, 1500, 5.0F, 0F, 10, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
	SOLBRAND(MiningLevels.DIAMOND,991, 5.0F, 0F, 15, () -> Ingredient.ofItems(Items.BLAZE_ROD))
	;


	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairIngredient;

	ModToolMaterials(int miningLevel,int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient){
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient =repairIngredient;
	}

	@Override
	public int getDurability() {
		return this.itemDurability;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return this.miningLevel;
	}



	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}

