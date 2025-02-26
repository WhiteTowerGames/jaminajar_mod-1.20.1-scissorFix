package io.github.jaminajar.jaminajarmod;

import io.github.jaminajar.jaminajarmod.enchantment.BlastEnchantment;
import io.github.jaminajar.jaminajarmod.items.ModItems;
import io.github.jaminajar.jaminajarmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JamInAJarMod implements ModInitializer {
	public static final String MOD_ID = "jaminajarmod";
	public static Enchantment BLAST = new BlastEnchantment();

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
		Registry.register(Registries.ENCHANTMENT,new Identifier(MOD_ID,"blast"),BLAST);
	}
}