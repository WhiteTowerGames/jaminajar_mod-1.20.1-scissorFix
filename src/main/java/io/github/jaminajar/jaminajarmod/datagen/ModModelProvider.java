package io.github.jaminajar.jaminajarmod.datagen;

import io.github.jaminajar.jaminajarmod.blocks.custom.ModBlocks;
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
        BlockStateModelGenerator.BlockTexturePool marshmallowPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARSHMALLOW_BLOCK);

        marshmallowPool.slab((ModBlocks.MARSHMALLOW_SLAB));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COMFY_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FORGED_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGER_SCREW, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGER_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCISSOR_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNTREATED_SCISSOR_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIOSPEAKER,Models.GENERATED);
        itemModelGenerator.register(ModItems.SUN_BLADE,Models.GENERATED);
        itemModelGenerator.register(ModItems.NOTEPROJECTILE,Models.GENERATED);

    }
}
