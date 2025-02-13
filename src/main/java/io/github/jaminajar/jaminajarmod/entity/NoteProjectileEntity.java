package io.github.jaminajar.jaminajarmod.entity;

import io.github.jaminajar.jaminajarmod.ModDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class NoteProjectileEntity extends ProjectileEntity implements FlyingItemEntity {
    public NoteProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public NoteProjectileEntity(World world, LivingEntity owner){
        super(ModEntities.NOTE_PROJECTILE, world);
    }
    @Override
    protected void initDataTracker() {

    }
    public float getGravity(){
        return 0.0F;
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(){
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult){
        if (!this.getWorld().isClient()){
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            entity.damage(this.getDamageSources().sonicBoom(this), 1.0F);
            if (entity2 instanceof LivingEntity) {
                this.applyDamageEffects((LivingEntity)entity2, entity);
        }
    }

}

    @Override
    public ItemStack getStack() {
        return null;
    }
}
