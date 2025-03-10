package io.github.jaminajar.jaminajarmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //addDrop(ModBlocks.MARSHMALLOW_SLAB,copperLikeDrops(ModBlocks.MARSHMALLOW_SLAB,ModItems.MARSHMALLOW));
        //addDrop(ModBlocks.MARSHMALLOW_BLOCK,copperLikeDropsTimesTwo(ModBlocks.MARSHMALLOW_BLOCK,ModItems.MARSHMALLOW));
    }

    public LootTable.Builder copperLikeDrops(Block drop, Item item){
        return BlockLootTableGenerator.
                dropsWithSilkTouch(drop,(LootPoolEntry.Builder)
                        this.applyExplosionDecay(drop, (LeafEntry.Builder) ItemEntry.
                        builder(item).apply(SetCountLootFunction.
                                builder(UniformLootNumberProvider.create(4.0f,8.0f)))));
    }
    public LootTable.Builder copperLikeDropsTimesTwo(Block drop, Item item){
        return BlockLootTableGenerator.
                dropsWithSilkTouch(drop,(LootPoolEntry.Builder)
                        this.applyExplosionDecay(drop, (LeafEntry.Builder) ItemEntry.
                                builder(item).apply(SetCountLootFunction.
                                        builder(UniformLootNumberProvider.create(8.0f,16.0f)))));
    }
}
