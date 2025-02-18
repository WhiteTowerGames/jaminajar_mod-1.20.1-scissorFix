package io.github.jaminajar.jaminajarmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class HonkProjectileEntity extends ProjectileEntity {
    public HonkProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public HonkProjectileEntity(World world, LivingEntity owner){
        super(ModEntities.HONK_PROJECTILE, world);
    }

    @Override
    protected void initDataTracker() {

    }
    protected void onEntityHit(EntityHitResult entityHitResult){
        if (!this.getWorld().isClient()){
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            entity.damage(this.getDamageSources().sonicBoom(this), 10.0F);
            if (entity2 instanceof LivingEntity) {
                this.applyDamageEffects((LivingEntity)entity2, entity);


            }
        }
}
}
