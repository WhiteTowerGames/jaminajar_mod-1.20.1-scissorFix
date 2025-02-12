package io.github.jaminajar.jaminajarmod;

import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public interface ModDamageTypes {
    RegistryKey<DamageType> UNATTRIBUTED_NOTE_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("unattributed_note_projectile"));
    RegistryKey<DamageType> NOTE_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("note_projectile"));
    static void bootstrap(Registerable<DamageType> damageTypeRegisterable){
        damageTypeRegisterable.register(UNATTRIBUTED_NOTE_PROJECTILE, new DamageType("onFire", 0.1F,DamageEffects.BURNING));
        damageTypeRegisterable.register(NOTE_PROJECTILE, new DamageType("onFire", 0.1F,DamageEffects.BURNING));
    }
}



