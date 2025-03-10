package io.github.jaminajar.jaminajarmod.blocks.custom;

import io.github.jaminajar.jaminajarmod.JamInAJarMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //public static final Block MARSHMALLOW_BLOCK = registerBlock("marshmallow_block",new MarshmallowBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK)));
    //public static final Block MARSHMALLOW_SLAB = registerBlock("marshmallow_slab",new MarshmallowSlabBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(JamInAJarMod.MOD_ID,name),block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(JamInAJarMod.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
