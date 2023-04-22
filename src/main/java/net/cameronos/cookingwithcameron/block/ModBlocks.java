package net.cameronos.cookingwithcameron.block;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.block.custom.*;
import net.cameronos.cookingwithcameron.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block TAPERECORDER = registerBlock("taperecorder", new TapeRecorderBlock(FabricBlockSettings.of(Material.METAL).strength(2f).nonOpaque()), ItemGroup.MISC);
    public static final Block OVEN = registerBlock("oven", new OvenBlock(FabricBlockSettings.of(Material.METAL).strength(2f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block DISTILLERY = registerBlock("distillery", new DistilleryBlock(FabricBlockSettings.of(Material.METAL).strength(2f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block PLATE = registerBlock("plate", new PlateBlock(FabricBlockSettings.of(Material.STONE).strength(1f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block TOASTER = registerBlock("toaster", new ToasterBlock(FabricBlockSettings.of(Material.METAL).strength(1f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block FRIDGE = registerBlock("fridge", new FridgeBlock(FabricBlockSettings.of(Material.METAL).strength(1f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block WINE_RACK = registerBlock("wine_rack", new WineRackBlock(FabricBlockSettings.of(Material.WOOD).strength(1f).nonOpaque()), ModItemGroup.COOKING);
    public static final Block GRAPE_VINE = registerBlockWithoutBlockItem("grape_vine", new GrapeVineBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()), ModItemGroup.COOKING);
    public static final Block BLUEBERRY_TREE = registerBlockWithoutBlockItem("blueberry_tree", new BlueberryTree(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()), ModItemGroup.COOKING);
    public static final Block PINEAPPLE_SHRUB = registerBlockWithoutBlockItem("pineapple_shrub", new PineappleShrub(FabricBlockSettings.copy(Blocks.CARROTS).nonOpaque()), ModItemGroup.COOKING);
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(CookingWithCameron.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(CookingWithCameron.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(CookingWithCameron.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        CookingWithCameron.LOGGER.info("Registering modblocks for " + CookingWithCameron.MOD_ID);
    }
}
