package net.cameronos.cookingwithcameron.block.entity;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.cameronos.cookingwithcameron.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<OvenBlockEntity> OVEN;
    public static BlockEntityType<DistilleryBlockEntity> DISTILLERY;
    public static void registerAllBlockEntities() {
        OVEN = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CookingWithCameron.MOD_ID, "oven"),
                FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new,
                        ModBlocks.OVEN).build(null));

        DISTILLERY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CookingWithCameron.MOD_ID, "distillery"),
                FabricBlockEntityTypeBuilder.create(DistilleryBlockEntity::new,
                        ModBlocks.DISTILLERY).build(null));
    }
    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, CookingWithCameron.MOD_ID, type);
    }
}