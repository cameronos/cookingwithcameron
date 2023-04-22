package net.cameronos.cookingwithcameron.item;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup COOKING = FabricItemGroupBuilder.build(new Identifier(CookingWithCameron.MOD_ID, "cooking"),
            () -> new ItemStack(ModItems.CHOCOLATE_BAR));
}