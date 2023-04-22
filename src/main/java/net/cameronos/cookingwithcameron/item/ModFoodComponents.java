package net.cameronos.cookingwithcameron.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHOCOLATE_BAR = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.3F).build();
    public static final FoodComponent OREO = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.4F).build();
    public static final FoodComponent WINE = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent WINEGLASS = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent BEER = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent GRAPE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.3F).build();
    public static final FoodComponent BLUEBERRY = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.7F).build();
    public static final FoodComponent PINEAPPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(2.0F).build();
    public static final FoodComponent AVOCADO = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.5F).build();
}
