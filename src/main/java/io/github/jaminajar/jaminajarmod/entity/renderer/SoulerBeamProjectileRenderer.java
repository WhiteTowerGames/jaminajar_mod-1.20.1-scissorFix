package io.github.jaminajar.jaminajarmod.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;

public class SoulerBeamProjectileRenderer extends ProjectileEntityRenderer<PersistentProjectileEntity> {
    public SoulerBeamProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    @Override
    public Identifier getTexture(PersistentProjectileEntity entity) {
        return null;
    }
}
