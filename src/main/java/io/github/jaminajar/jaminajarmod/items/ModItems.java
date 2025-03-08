package io.github.jaminajar.jaminajarmod.items;

import io.github.jaminajar.jaminajarmod.JamInAJarMod;
import io.github.jaminajar.jaminajarmod.items.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.*;
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
	public static final Item BOOM_TUBE = registerItem("boom_tube", new BoomtubeItem(ModToolMaterials.BOOM_TUBE,0, -2.6f,new Item.Settings(),32));
	public static final Item CACOPHONY = registerItem("cacophony",new CacophonyItem(new Item.Settings()));
	public static final Item BIOSPEAKER = registerItem("biospeaker", new Item(new Item.Settings()));
	public static final Item NOTEPROJECTILE = registerItem("noteprojectile",new Item(new Item.Settings()));
	public static final Item MARSHMALLOW = registerItem("marshmallow",new Item(new Item.Settings().food(ModFoods.MARSHMALLOW)));
	public static final Item COOKED_MARSHMALLOW = registerItem("cooked_marshmallow",new Item(new Item.Settings().food(ModFoods.COOKED_MARSHMALLOW)));
	public static final Item MARSHMALLOW_STICK =registerItem("marshmallow_stick",new MarshmallowStickItem(ModToolMaterials.MARSHMALLOW_STICK,4,-2.2f,new Item.Settings()));
	public static final Item NETHERITE_MARSHMALLOW_STICK =registerItem("netherite_marshmallow_stick",new MarshmallowStickItem(ModToolMaterials.NETHERITE_MARSHMALLOW_STICK,8,-2.2f,new Item.Settings()));
	public static final Item COOKED_MARSHMALLOW_STICK = registerItem("cooked_marshmallow_stick",new MarshmallowStickItem(ModToolMaterials.MARSHMALLOW_STICK,5,-2.8f,new Item.Settings()));
	public static final Item COOKED_NETHERITE_MARSHMALLOW_STICK =registerItem("cooked_netherite_marshmallow_stick",new MarshmallowStickItem(ModToolMaterials.NETHERITE_MARSHMALLOW_STICK,9,-2.8f,new Item.Settings()));
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
