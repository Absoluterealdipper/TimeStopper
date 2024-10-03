package com.dipper.timestopper.item.custom;

import com.dipper.timestopper.logic.CustomTickRateHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.ServerTickRateManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class TimeWatch extends Item {
    public TimeWatch(Properties properties) {
        super(properties);
    }

    private static final Logger LOGGER = LogUtils.getLogger();
    private static boolean timeIsFrozen = false;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (timeIsFrozen) {
                timeIsFrozen = false;
                CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), 20, false);
            } else {
                timeIsFrozen = true;
                CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), 20, true);
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

}
