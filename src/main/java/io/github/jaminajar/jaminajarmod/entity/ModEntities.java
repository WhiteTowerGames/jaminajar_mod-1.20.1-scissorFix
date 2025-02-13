package io.github.jaminajar.jaminajarmod.entity;

import io.github.jaminajar.jaminajarmod.JamInAJarMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class ModEntities {
    public static final EntityType<NoteProjectileEntity> NOTE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JamInAJarMod.MOD_ID, "note_projectile"),
            FabricEntityTypeBuilder.<NoteProjectileEntity>create(SpawnGroup.MISC, NoteProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build());
    private World world;


    public World getWorld() {
        return this.world;
    }
    protected void setWorld(World world) {
        this.world = world;
    }
}
