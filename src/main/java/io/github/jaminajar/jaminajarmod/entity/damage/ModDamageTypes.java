package io.github.jaminajar.jaminajarmod.entity.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public interface ModDamageTypes {
    RegistryKey<DamageType> SOULER_SOULED_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("data", "souled"));
    RegistryKey<DamageType> SOULER_LASERED_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("data", "lasered"));
    RegistryKey<DamageType> UNATTRIBUTED_NOTE_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("unattributed_note_projectile"));
    RegistryKey<DamageType> NOTE_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("note_projectile"));
    RegistryKey<DamageType> HELICOPTER_SWORD_SPIN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("heli_sword_spin"));
   // static void bootstrap(Registerable<DamageType> damageTypeRegisterable){
    //}
}



