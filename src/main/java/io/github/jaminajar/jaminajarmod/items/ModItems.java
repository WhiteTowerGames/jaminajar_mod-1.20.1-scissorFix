package io.github.jaminajar.jaminajarmod.items;

import io.github.jaminajar.jaminajarmod.JamInAJarMod;
import io.github.jaminajar.jaminajarmod.items.custom.BoomtubeItem;
import io.github.jaminajar.jaminajarmod.items.custom.CacophonyItem;
import io.github.jaminajar.jaminajarmod.items.custom.ScissorbladeItem;
import io.github.jaminajar.jaminajarmod.items.custom.SolbrandItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SkullItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems{

	public static final Item MACHETE = registerItem("machete", new SwordItem(ModToolMaterials.MACHETE, 7, -3.1f, new Item.Settings()));
	public static final Item COMFY_HANDLE = registerItem("comfy_handle", new Item(new Item.Settings()));
	public static final Item UNTREATED_SCISSOR_BLADE = registerItem("untreated_blade", new Item(new Item.Settings()));
	public static final Item FORGED_BLADE = registerItem("forged_blade",new Item(new Item.Settings()));
	public static final Item SCISSOR_BLADE = registerItem("scissor_blade", new Item(new Item.Settings()));
	public static final Item SCISSORS = registerItem("scissors", new ScissorbladeItem(ModToolMaterials.SCISSORS,12,-3.0f,new Item.Settings().fireproof()));
	public static final Item RAVAGER_TOOTH = registerItem("ravager_tooth", new Item(new Item.Settings()));
	public static final Item RAVAGER_SCREW = registerItem("ravager_screw", new Item(new Item.Settings()));
	public static final Item SUN_BLADE = registerItem("solarimbued_blade", new Item(new Item.Settings().fireproof()));
	public static final Item SOLBRAND = registerItem("solbrand", new SolbrandItem(ModToolMaterials.SOLBRAND, 10, -2.6f, new Item.Settings().fireproof()));
	public static final Item BOOM_TUBE = registerItem("boom_tube", new BoomtubeItem(ModToolMaterials.BOOM_TUBE,new Item.Settings()));
	public static final Item CACOPHONY = registerItem("cacophony",new CacophonyItem(new Item.Settings()));
	public static final Item BIOSPEAKER = registerItem("biospeaker", new Item(new Item.Settings()));
	public static final Item NOTEPROJECTILE = registerItem("noteprojectile",new Item(new Item.Settings()));
	private static Item registerItem(String name, Item item){
		return Registry.register(Registries.ITEM, new Identifier(JamInAJarMod.MOD_ID, name), item);
	}
	public static void registerModItems(){
		JamInAJarMod.LOGGER.info("Registering Mod Items for "+ JamInAJarMod.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(MACHETE);
			entries.add(SCISSORS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(COMFY_HANDLE);
			entries.add(UNTREATED_SCISSOR_BLADE);
			entries.add(FORGED_BLADE);
			entries.add(SCISSOR_BLADE);
			entries.add(RAVAGER_TOOTH);
			entries.add(RAVAGER_SCREW);
		});
	}


}
