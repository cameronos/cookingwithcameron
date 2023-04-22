package net.cameronos.cookingwithcameron.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.cameronos.cookingwithcameron.entity.custom.CrabEntity;
import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<CrabEntity> CRAB = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(CookingWithCameron.MOD_ID, "crab"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrabEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());
}