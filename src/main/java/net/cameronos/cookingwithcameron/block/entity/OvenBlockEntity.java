package net.cameronos.cookingwithcameron.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SmokerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class OvenBlockEntity extends AbstractFurnaceBlockEntity {
    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OVEN, pos, state, RecipeType.SMOKING);
    }

    protected Text getContainerName() {
        return new TranslatableText("cookingwithcameron.container.oven");
    }

    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 4;
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new SmokerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public int getDuplicationChance() {
        return 0;
    }
}
