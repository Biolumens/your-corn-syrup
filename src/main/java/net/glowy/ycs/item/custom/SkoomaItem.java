package net.glowy.ycs.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class SkoomaItem extends MilkBucketItem {
    public SkoomaItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            if (user instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }
            if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                stack.decrement(1);
            }
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1800, 1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1800, 1));
            }
            return stack;
        }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
