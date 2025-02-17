package io.github.jaminajar.jaminajarmod.items.custom;

import io.github.jaminajar.jaminajarmod.items.ModToolMaterials;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BoomtubeItem extends SwordItem {
    private final int maxGunpowder;
    public BoomtubeItem(ModToolMaterials toolMaterial, int attackDamage, float attackSpeed, Settings settings, int maxGunpowder) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.maxGunpowder = maxGunpowder;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.isSneaking()) {
            stack = user.getStackInHand(hand);
            int currentGunpowder = getGunpowder(stack);
            if (currentGunpowder < maxGunpowder && playerHasItem(user, Items.GUNPOWDER)) {
                setGunpowder(stack, currentGunpowder + 1);
                reduceItem(user, Items.GUNPOWDER, 1);
                return TypedActionResult.success(stack);
            }
            return TypedActionResult.pass(stack);
        }
        return TypedActionResult.fail(stack);
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
    public boolean isItemBarVisible(ItemStack stack) {
        return getGunpowder(stack) > 0;
    }
    @Override
    public int getItemBarStep(ItemStack stack) {
        int charge = getGunpowder(stack);
        return MathHelper.ceil(charge * 13.0F / maxGunpowder);
    }
    @Override
    public int getItemBarColor(ItemStack stack) {
        int charge = getGunpowder(stack);
        return charge == 0 ? 0xFF0000 : 0x00FF00;
    }

    public static boolean playerHasItem(PlayerEntity player, Item itemToCheck) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == itemToCheck) {
                return true;
            }
        }
        return false;
    }
    public static void reduceItem(PlayerEntity player, Item itemToReduce, int amount) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == itemToReduce) {
                int currentCount = stack.getCount();
                if (currentCount >= amount) {
                    stack.decrement(amount);
                }
                return;
            }
        }
    }


    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean superHit = super.postHit(stack,target,attacker);
        if (getGunpowder(stack)>=maxGunpowder){
            target.getWorld().createExplosion(target,
                    target.getX(),
                    target.getY(),
                    target.getZ(),
                    2.0F,
                    false,
                    World.ExplosionSourceType.MOB);
            setGunpowder(stack,getGunpowder(stack)-1);
            return superHit;
        }
        return false;
    }
}
