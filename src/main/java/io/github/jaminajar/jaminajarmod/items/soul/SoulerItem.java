package io.github.jaminajar.jaminajarmod.items.soul;

import io.github.jaminajar.jaminajarmod.entity.ModEntities;
import io.github.jaminajar.jaminajarmod.entity.SoulerSoulProjectile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class SoulerItem extends Item {
    double soulEnergyCount = 0;
    public SoulerItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if(user.isSneaking()&&Math.floor(soulEnergyCount/3) >=0){
            soulEnergyCount-=3;

        }else if(user.isSneaking()&&soulEnergyCount<=0){
            user.sendMessage(Text.literal("No Soul Energy!"),true);
        } else if(!user.isSneaking()){
            if(!world.isClient()) {
                SoulerSoulProjectile soulerSoulProjectile = new SoulerSoulProjectile(ModEntities.SOULER_SOUL_PROJECTILE, world);
                soulerSoulProjectile.setVelocity(user,
                        user.getPitch(),
                        user.getYaw(),
                        0.0F,
                        1.5F,
                        2.0F);
                world.spawnEntity(soulerSoulProjectile);
            }
        }
        user.getItemCooldownManager().set(this, 20);
        return TypedActionResult.success(itemStack);
    }

}
