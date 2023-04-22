package net.cameronos.cookingwithcameron.recipe;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.screen.DistilleryScreen;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(CookingWithCameron.MOD_ID, DistilleryRecipe.Serializer.ID), DistilleryRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(CookingWithCameron.MOD_ID, DistilleryRecipe.Type.ID), DistilleryRecipe.Type.INSTANCE);
    }
}
