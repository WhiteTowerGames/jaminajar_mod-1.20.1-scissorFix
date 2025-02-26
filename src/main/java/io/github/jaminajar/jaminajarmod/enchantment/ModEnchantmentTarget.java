package io.github.jaminajar.jaminajarmod.enchantment;

import io.github.jaminajar.jaminajarmod.items.custom.BoomtubeItem;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.Item;

public enum ModEnchantmentTarget {
    BOOMTUBE {
        @Override
        public boolean isAcceptableItem(Item item) {
            return item instanceof BoomtubeItem;
        }
    };

    public abstract boolean isAcceptableItem(Item item);
}
