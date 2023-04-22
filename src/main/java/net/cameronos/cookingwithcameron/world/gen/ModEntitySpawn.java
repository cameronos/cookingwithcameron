package net.cameronos.cookingwithcameron.world.gen;

import net.cameronos.cookingwithcameron.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
    public class ModEntitySpawn {
        public static void addEntitySpawn() {
            BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.BEACH),
                    SpawnGroup.CREATURE, ModEntities.CRAB, 25, 2, 5);
            BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.DESERT),
                    SpawnGroup.CREATURE, ModEntities.CRAB, 17, 1, 3);
            SpawnRestrictionAccessor.callRegister(ModEntities.CRAB, SpawnRestriction.Location.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        }
    }