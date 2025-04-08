package io.github.jaminajar.jaminajarmod.entity.renderer;

import io.github.jaminajar.jaminajarmod.entity.SoulerBeamProjectile;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SoulerBeamProjectileRenderer extends EntityRenderer<SoulerBeamProjectile> {
    public SoulerBeamProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(SoulerBeamProjectile entity) {
        return null;
    }




}
