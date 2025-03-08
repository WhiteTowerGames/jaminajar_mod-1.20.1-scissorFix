package io.github.jaminajar.jaminajarmod.items.custom;

import com.google.common.collect.ImmutableMultimap;
import io.github.jaminajar.jaminajarmod.effects.GooedEffect;
import io.github.jaminajar.jaminajarmod.enchantment.GooeynessEnchantment;
import io.github.jaminajar.jaminajarmod.items.ModItems;
import io.github.jaminajar.jaminajarmod.items.ModToolMaterials;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.math.MathHelper;

public class MarshmallowStickItem extends ToolItem {
    private final int yesCooked;
    private final int yesNetherite;
    public MarshmallowStickItem(ModToolMaterials toolMaterial, int attackDamage, float attackSpeed, Settings settings, int yesCooked, int yesNetherite) {
        super(toolMaterial, settings);
        this.yesCooked = yesCooked;
        this.yesNetherite = yesNetherite;

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.build();
    }
    public void setCooked(ItemStack stack,int cookedness){
        stack.getOrCreateNbt().putInt("Cookedness", MathHelper.clamp(cookedness,0,yesCooked));
    }
    public void setNetherite(ItemStack stack,int netherited){
        stack.getOrCreateNbt().putInt("Netherited", MathHelper.clamp(netherited,0,yesNetherite));
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean superHit = postHit(stack, target, attacker);
        StatusEffectInstance gooedEffect;
        if (stack.getItem()== ModItems.MARSHMALLOW_STICK) {
            setCooked(stack,0);
            setNetherite(stack,0);
        } else if (stack.getItem()==ModItems.COOKED_MARSHMALLOW_STICK){
            setCooked(stack,1);
            setNetherite(stack,0);
        }else if (stack.getItem()==ModItems.NETHERITE_MARSHMALLOW_STICK){
            setCooked(stack,0);
            setNetherite(stack,1);
        }else if (stack.getItem()==ModItems.COOKED_NETHERITE_MARSHMALLOW_STICK){
            setCooked(stack,1);
            setNetherite(stack,1);
        }
        int netheriteBooleanVar = stack.getOrCreateNbt().getInt("Netherited")+1;
        int cookedBooleanVar = stack.getOrCreateNbt().getInt("Cooked")+1;
        gooedEffect = new StatusEffectInstance(
                    new GooedEffect(StatusEffectCategory.HARMFUL, 2551000),
                    EnchantmentHelper.getLevel(new GooeynessEnchantment(), stack)*(10+2*netheriteBooleanVar)+10*cookedBooleanVar,
                    cookedBooleanVar*EnchantmentHelper.getLevel(new GooeynessEnchantment(), stack)
            );

        target.setStatusEffect(gooedEffect, attacker);
        return superHit;
    }
}
