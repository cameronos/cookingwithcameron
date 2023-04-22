package net.cameronos.cookingwithcameron.util;

import net.cameronos.cookingwithcameron.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("minecraft", "blocks/grass");

    private static final Identifier JUNGLELEAVES_ID = new Identifier("minecraft", "blocks/jungle_leaves");
    private static final Identifier OAKLEAVES_ID = new Identifier("minecraft", "blocks/oak_leaves");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for grass block loot table.
            if(GRASS_BLOCK_ID.equals(id)) {
                // Adds Grape Seeds to the grass loot table.
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 35% of the time
                        .with(ItemEntry.builder(ModItems.GRAPE_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                supplier.pool(poolBuilder.build());
            }
            if(GRASS_BLOCK_ID.equals(id)) {
                // Adds Blueberry Seeds to the grass loot table.
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.08f)) // Drops 35% of the time
                        .with(ItemEntry.builder(ModItems.BLUEBERRY_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                supplier.pool(poolBuilder.build());
            }
            if(JUNGLELEAVES_ID.equals(id) || OAKLEAVES_ID.equals(id)) {
                // Adds Avocados to the leaves loot table.
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 35% of the time
                        .with(ItemEntry.builder(ModItems.AVOCADO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                supplier.pool(poolBuilder.build());
            }
        }));
    }
}