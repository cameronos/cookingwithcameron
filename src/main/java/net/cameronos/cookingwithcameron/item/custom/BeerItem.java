package net.cameronos.cookingwithcameron.item.custom;

import net.cameronos.cookingwithcameron.CookingWithCameron;
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

public class BeerItem extends Item {
    private static final int MAX_USE_TIME = 40;
    public BeerItem(Settings settings) {
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
        user.eatFood(world, stack);
        ((PlayerEntity) user).getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE));
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 0));
        }
        return stack;
    }

    public SoundEvent getDrinkSound() {
        return CookingWithCameron.BEERSOUNDEVENT;
    }

    public SoundEvent getEatSound() {
        return CookingWithCameron.BEERSOUNDEVENT;
    }

}
