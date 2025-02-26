package io.github.jaminajar.jaminajarmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public abstract class ModEnchantment extends Enchantment {
    public final ModEnchantmentTarget target;
    @Nullable
    protected String translationKey;
    protected ModEnchantment(Enchantment.Rarity weight, ModEnchantmentTarget target, EquipmentSlot[] slotTypes, ModEnchantmentTarget target1) {
        super(weight,
                target,
                slotTypes);

        this.target = target;
    }
}
