package net.cameronos.cookingwithcameron.item.custom;

import net.cameronos.cookingwithcameron.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WineGlassItem extends Item {
    private static final int MAX_USE_TIME = 40;
    public WineGlassItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAction(ItemUsageContext context, ItemStack stack) {
        return UseAction.DRINK;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user)
    {
        spawnFoundParticles(world, user.getBlockPos());
        user.eatFood(world, stack);
        ((PlayerEntity) user).getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE));
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250, 0));
        }
        return stack;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    private void spawnFoundParticles(World world, BlockPos positionClicked) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                world.addParticle(ModParticles.WINE_PARTICLE,
                        positionClicked.getX() + 1d, positionClicked.getY() + 1, positionClicked.getZ() + 0.2d,
                        Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
            }
        }
    }

}
