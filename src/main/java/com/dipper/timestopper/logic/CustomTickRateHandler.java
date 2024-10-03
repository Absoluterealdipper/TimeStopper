package com.dipper.timestopper.logic;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickRateManager;

public class CustomTickRateHandler {

    public static void setCustomTickRate(MinecraftServer server, float newTickRate, boolean isFrozen) {
        ServerTickRateManager tickRateManager = server.tickRateManager();
        tickRateManager.setTickRate(newTickRate); // Set new tick rate
        tickRateManager.setFrozen(isFrozen);
    }
}
