package io.github.jaminajar.jaminajarmod.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.jaminajar.jaminajarmod.ModDamageTypes;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

public class ModDamageTypeTagProvider extends TagProvider<DamageType> {
    public ModDamageTypeTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> maxChainedNeighborUpdates) {
        super(output, RegistryKeys.DAMAGE_TYPE, maxChainedNeighborUpdates);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {

        this.getOrCreateTagBuilder(DamageTypeTags.BYPASSES_SHIELD)
                .addTag(DamageTypeTags.BYPASSES_ARMOR)
                .addTag(DamageTypeTags.BYPASSES_INVULNERABILITY)
                .addTag(DamageTypeTags.BYPASSES_RESISTANCE)
                .addTag(DamageTypeTags.IS_PROJECTILE)
                .addTag(DamageTypeTags.AVOIDS_GUARDIAN_THORNS)
                .addTag(DamageTypeTags.ALWAYS_TRIGGERS_SILVERFISH)
                .addTag(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS)
                .add(ModDamageTypes.NOTE_PROJECTILE, ModDamageTypes.UNATTRIBUTED_NOTE_PROJECTILE);

    }
}
