package net.cameronos.cookingwithcameron.item;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.block.ModBlocks;
import net.cameronos.cookingwithcameron.entity.ModEntities;
import net.cameronos.cookingwithcameron.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    /*CONSUMABLES*/
    public static final Item CHOCOLATE_BAR = registerItem("chocolate_bar",
            new ChocolateBarItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.CHOCOLATE_BAR)));

    public static final Item OREO = registerItem("oreo",
            new OreoItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.OREO)));

    /*/PLANTS/*/
    public static final Item GRAPE = registerItem("grape", new Item(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.GRAPE)));
    public static final Item BLUEBERRY = registerItem("blueberry", new Item(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.BLUEBERRY)));
    public static final Item AVOCADO = registerItem("avocado", new Item(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.AVOCADO)));
    public static final Item PINEAPPLE = registerItem("pineapple", new PineappleItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.PINEAPPLE)));

    /*DRINKS*/
    public static final Item WINE = registerItem("wine", new WineBottleItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.WINE)));
    public static final Item WINEGLASS = registerItem("wine_glass", new WineGlassItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.WINEGLASS)));

    public static final Item BEER = registerItem("beer", new BeerItem(new FabricItemSettings().group(ModItemGroup.COOKING).food(ModFoodComponents.BEER)));
    /*SEEDS*/
    public static final Item GRAPE_SEEDS = registerItem("grape_seeds", new AliasedBlockItem(ModBlocks.GRAPE_VINE, new FabricItemSettings().group(ModItemGroup.COOKING)));
    public static final Item BLUEBERRY_SEEDS = registerItem("blueberry_seeds", new AliasedBlockItem(ModBlocks.BLUEBERRY_TREE, new FabricItemSettings().group(ModItemGroup.COOKING)));
    public static final Item PINEAPPLE_SEEDS = registerItem("pineapple_seeds", new AliasedBlockItem(ModBlocks.PINEAPPLE_SHRUB, new FabricItemSettings().group(ModItemGroup.COOKING)));

    /*/COMPONENTS*/
    public static final Item FOIL = registerItem("foil",
            new Item(new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item SALT = registerItem("salt",
            new Item(new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item CHEF_HAT = registerItem("chef_hat",
            new ArmorItem(ModArmorMaterials.CHEF, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item CHEF_SUIT = registerItem("chef_suit",
            new ArmorItem(ModArmorMaterials.CHEF, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item CHEF_LEGS = registerItem("chef_pants",
            new ArmorItem(ModArmorMaterials.CHEF, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item CHEF_BOOTS = registerItem("chef_boots",
            new ArmorItem(ModArmorMaterials.CHEF, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item KITCHENKNIFE = registerItem("kitchen_knife",
            new SwordItem(ToolMaterials.IRON, 1, 1f, new FabricItemSettings().group(ModItemGroup.COOKING)));

    public static final Item CRAB_SPAWN_EGG = registerItem("crab_spawn_egg",
            new SpawnEggItem(ModEntities.CRAB, 0x983132, 0xE8DFB0, new FabricItemSettings().group(ModItemGroup.COOKING)));

    /*/Registry/*/
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CookingWithCameron.MOD_ID, name), item);
    }
    public static void registerModItems() {
        CookingWithCameron.LOGGER.info("Registering mod items for " + CookingWithCameron.MOD_ID);
    }

}
