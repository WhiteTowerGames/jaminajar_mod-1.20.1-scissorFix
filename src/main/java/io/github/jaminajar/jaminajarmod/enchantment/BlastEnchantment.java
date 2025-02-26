package io.github.jaminajar.jaminajarmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;


public class BlastEnchantment extends ModEnchantment {
    public BlastEnchantment() {
        super(Rarity.RARE, ModEnchantmentTarget.BOOMTUBE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    @Override
    public int getMinPower(int level){
        return 20;
    }
    @Override
    public int getMaxLevel(){
        return 3;
    }
}
