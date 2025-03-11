package io.github.jaminajar.jaminajarmod.entity.damage;

import io.github.jaminajar.jaminajarmod.entity.NoteProjectileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Nullable;

public class ModDamageSources {
    public final Registry<DamageType> registry;

    public ModDamageSources(DynamicRegistryManager registryManager){
        this.registry = registryManager.get(RegistryKeys.DAMAGE_TYPE);
    }
    public ModDamageSources(Registry<DamageType> registry) {
        this.registry = registry;
    }

    public DamageSource cacophonyNote(NoteProjectileEntity source, @Nullable Entity attacker){
        return attacker == null ? this.create(ModDamageTypes.UNATTRIBUTED_NOTE_PROJECTILE, source) : this.create(ModDamageTypes.NOTE_PROJECTILE, source, attacker);
    }
    public final DamageSource create(RegistryKey<DamageType> key) {
        return new DamageSource(this.registry.entryOf(key));
    }

    public final DamageSource create(RegistryKey<DamageType> key, @Nullable Entity attacker) {
        return new DamageSource(this.registry.entryOf(key), attacker);
    }

    public final DamageSource create(RegistryKey<DamageType> key, @Nullable Entity source, @Nullable Entity attacker) {
        return new DamageSource(this.registry.entryOf(key), source, attacker);
    }
}
