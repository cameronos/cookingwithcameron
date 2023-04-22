package net.cameronos.cookingwithcameron.block.custom;

import net.cameronos.cookingwithcameron.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;


public class PineappleShrub extends CropBlock {
    public PineappleShrub(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.PINEAPPLE_SEEDS;
    }
}