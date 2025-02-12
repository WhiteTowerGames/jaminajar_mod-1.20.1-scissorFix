package io.github.jaminajar.jaminajarmod.entity;

import io.github.jaminajar.jaminajarmod.JamInAJarMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.rmi.registry.Registry;

public class ModEntities {
    public static final EntityType<NoteProjectileEntity> NOTE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JamInAJarMod.MOD_ID, "note_projectile"),
            FabricEntityTypeBuilder.<NoteProjectileEntity>create(SpawnGroup.MISC, NoteProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build());
}
