package io.github.jaminajar.jaminajarmod.entity.renderer;

import io.github.jaminajar.jaminajarmod.entity.SoulerSoulProjectile;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public class SoulerSoulEntityRenderer extends EntityRenderer<SoulerSoulProjectile> {

    public SoulerSoulEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(SoulerSoulProjectile entity) {
        return null;
    }
}

