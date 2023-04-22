package net.cameronos.cookingwithcameron.entity.client;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.entity.custom.CrabEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CrabModel extends AnimatedGeoModel<CrabEntity> {
    @Override
    public Identifier getModelLocation(CrabEntity object) {
        return new Identifier(CookingWithCameron.MOD_ID, "geo/crab.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CrabEntity object) {
        return new Identifier(CookingWithCameron.MOD_ID, "textures/entity/crab/crab.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CrabEntity animatable) {
        return new Identifier(CookingWithCameron.MOD_ID, "animations/crab.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CrabEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("crab");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}