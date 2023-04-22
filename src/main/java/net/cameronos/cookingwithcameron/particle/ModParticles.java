package net.cameronos.cookingwithcameron.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType WINE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(CookingWithCameron.MOD_ID, "wine_particle"),
                WINE_PARTICLE);
    }
}