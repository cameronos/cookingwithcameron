package net.cameronos.cookingwithcameron.entity.client;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.entity.client.CrabModel;
import net.cameronos.cookingwithcameron.entity.custom.CrabEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrabRenderer extends GeoEntityRenderer<CrabEntity> {
    public CrabRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CrabModel());
    }

    @Override
    public Identifier getTextureLocation(CrabEntity instance) {
        return new Identifier(CookingWithCameron.MOD_ID, "textures/entity/crab/crab.png");
    }
}