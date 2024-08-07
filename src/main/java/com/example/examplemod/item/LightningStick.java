package com.example.examplemod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class LightningStick extends SwordItem {

    public LightningStick() {
        super(Tiers.DIAMOND, 4, -2.4F, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if(!pAttacker.level().isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();
            EntityType.LIGHTNING_BOLT.spawn(world, null, (Player)null, position, MobSpawnType.TRIGGERED, true, true);
        };
        return true;
    }
}

