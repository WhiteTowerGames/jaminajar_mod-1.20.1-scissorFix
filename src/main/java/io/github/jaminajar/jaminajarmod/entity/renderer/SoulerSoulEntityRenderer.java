package io.github.jaminajar.jaminajarmod.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;

public class SoulerSoulEntityRenderer extends ProjectileEntityRenderer<ProjectileEntity> {
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean lit;
    public SoulerSoulEntityRenderer(EntityRendererFactory.Context context)  {
        this(context, 1.0F, false);
    }
    public SoulerSoulEntityRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
        super(ctx);
        this.itemRenderer = ctx.getItemRenderer();
        this.scale = scale;
        this.lit = lit;
    }


    @Override
    public Identifier getTexture(PersistentProjectileEntity entity) {
        return null;
    }
}
