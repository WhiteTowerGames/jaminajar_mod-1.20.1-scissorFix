package io.github.jaminajar.jaminajarmod.items.custom;

import com.mojang.datafixers.Typed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BoomtubeItem extends ToolItem {
    private final int maxGunpowder;
    public BoomtubeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int maxGunpowder) {
        super(toolMaterial, settings);
        this.maxGunpowder = maxGunpowder;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (player.isSneaking()) {
            stack = player.getStackInHand(hand);
            int currentGunpowder = getGunpowder(stack);
            if (currentGunpowder < maxGunpowder && playerHasItem(player, Items.GUNPOWDER)) {
                setGunpowder(stack, currentGunpowder + 1);
                reduceItem(player, Items.GUNPOWDER, 1);
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
        return getGunpowder(stack) > 0;  // Show the bar if charge is greater than 0
    }

    // Step 2: Get the fill amount of the bar (float from 0.0 to 1.0)
    @Override
    public int getItemBarStep(ItemStack stack) {
        int charge = getGunpowder(stack);
        return MathHelper.ceil(charge * 13.0F / maxGunpowder);  // Calculate the bar step (13 steps)
    }

    // Step 3: Define the color of the item bar (here we return green when full, red when empty)
    @Override
    public int getItemBarColor(ItemStack stack) {
        int charge = getGunpowder(stack);
        // Return a color: Green when full, Red when empty
        return charge == 0 ? 0xFF0000 : 0x00FF00; // Red: 0xFF0000, Green: 0x00FF00
    }

    public static boolean playerHasItem(PlayerEntity player, Item itemToCheck) {
        // Loop through the player's inventory and check for the item
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == itemToCheck) {
                return true; // Player has the item
            }
        }
        return false; // Player does not have the item
    }
    public static boolean reduceItem(PlayerEntity player, Item itemToReduce, int amount) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == itemToReduce) {
                int currentCount = stack.getCount();
                if (currentCount >= amount) {
                    stack.decrement(amount); // Decrease the count by the specified amount
                    return true; // Successfully reduced the item
                } else {
                    // If the player doesn't have enough of the item
                    return false;
                }
            }
        }
        return false; // Item not found in inventory
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

    public void onEntityHit(LivingEntity target, ItemStack stack){
        explodeOnHit(target,stack);
    }

}
