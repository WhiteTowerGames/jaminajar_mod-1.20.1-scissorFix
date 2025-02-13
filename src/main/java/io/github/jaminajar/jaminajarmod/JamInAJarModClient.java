package io.github.jaminajar.jaminajarmod;

import io.github.jaminajar.jaminajarmod.entity.ModEntities;
import io.github.jaminajar.jaminajarmod.entity.NoteProjectileEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.minecraft.client.particle.NoteParticle;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class JamInAJarModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.NOTE_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
