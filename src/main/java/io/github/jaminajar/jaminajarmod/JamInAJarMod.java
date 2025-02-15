package io.github.jaminajar.jaminajarmod;

import io.github.jaminajar.jaminajarmod.items.ModItems;
import io.github.jaminajar.jaminajarmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JamInAJarMod implements ModInitializer {
	public static final String MOD_ID = "jaminajarmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}
}