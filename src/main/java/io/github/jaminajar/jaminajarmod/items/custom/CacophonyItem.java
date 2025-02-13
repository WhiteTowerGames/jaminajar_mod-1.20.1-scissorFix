package io.github.jaminajar.jaminajarmod.items.custom;

import io.github.jaminajar.jaminajarmod.entity.NoteProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class CacophonyItem extends RangedWeaponItem {
    public CacophonyItem(Item.Settings settings) {super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public int getRange() {
        return 0;
    }


    public TypedActionResult<ItemStack> use(ItemStack stack, World world, PlayerEntity user, Hand hand, int remainingUseTicks) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.MUSIC,
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {

            int i;
            for (i = 0; i < 600; i++) {
                NoteProjectileEntity noteProjectileEntity = new NoteProjectileEntity(world, user);
                noteProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.5F, 2.0F);
                world.spawnEntity(noteProjectileEntity);
            }
            user.getItemCooldownManager().set(this, 200 + i);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
    public int getMaxUseTime(ItemStack stack) {
        return 600;
    }

}
