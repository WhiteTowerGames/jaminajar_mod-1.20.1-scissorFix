package io.github.jaminajar.jaminajarmod.datagen;

import io.github.jaminajar.jaminajarmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ///blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.block);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COMFY_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FORGED_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MACHETE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGER_SCREW, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGER_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCISSOR_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCISSORS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNTREATED_SCISSORBLADE, Models.GENERATED);
    }
}
