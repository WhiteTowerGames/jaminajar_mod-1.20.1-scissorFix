package io.github.jaminajar.jaminajarmod.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BoomtubeItem extends ToolItem {
    private final int maxGunpowder;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public BoomtubeItem(ToolMaterial toolMaterial, Settings settings, int maxGunpowder) {
        super(toolMaterial, settings);
        this.maxGunpowder = maxGunpowder;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 8.0, EntityAttributeModifier.Operation.ADDITION)
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.9F, EntityAttributeModifier.Operation.ADDITION)
        );
        this.attributeModifiers = builder.build();
    }
    public int getGunpowder(ItemStack stack){

        return stack.getOrCreateNbt().getInt("Gunpowder");
    }



    public void setGunpowder(ItemStack stack, int storedGunpowder){
        stack.getOrCreateNbt().putInt("Gunpowder", MathHelper.clamp(storedGunpowder,0,maxGunpowder));
    }
    public int getMaxGunpowder(){
        return maxGunpowder;
    }



    public ActionResult use(PlayerEntity player, Hand hand){
        ItemStack stack = player.getStackInHand(hand);
        int currentGunpowder = getGunpowder(stack);
        if(currentGunpowder<maxGunpowder){
            setGunpowder(stack, currentGunpowder+1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    public void explodeOnHit(Entity entity, ItemStack stack) {
        if (getGunpowder(stack)>=maxGunpowder){
            entity.getWorld().createExplosion(null,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    2.0F,
                    false,
                    World.ExplosionSourceType.MOB);
            setGunpowder(stack,getGunpowder(stack)-1);
        }

    }

    public void onHit(LivingEntity target, ItemStack stack){
        explodeOnHit(target,stack);
    }
    @Override
    public Text getName(ItemStack stack) {
        // Append the gunpowder amount to the tool's name
        super.getName(stack);
        return Text.literal(" (Gunpowder: " + getGunpowder(stack) + "/" + getMaxGunpowder() + ")");
    }

}
