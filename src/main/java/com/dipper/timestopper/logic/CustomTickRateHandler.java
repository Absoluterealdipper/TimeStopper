package com.dipper.timestopper.logic;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickRateManager;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class CustomTickRateHandler {

    private static int tickRate = 20; // Starting tick rate
    private static final int step = 1; // Amount to decrease per step
    private static final long interval = 75; // 50ms per step (1000ms/20 steps = 50ms)



    //*
    // todo:
    //    1. Play sound when time slows down
    //    2. Make Player ignore tickspeed constantly
    // *//

    public static void setCustomTickRate(MinecraftServer server, float newTickRate, boolean isFrozen) {
        ServerTickRateManager tickRateManager = server.tickRateManager();
        tickRateManager.setTickRate(newTickRate); // Set new tick rate
        tickRateManager.setFrozen(isFrozen);
    }

    public static void freezeTime(Player player) {


        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (tickRate > 0) {
                    CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), tickRate, false);
                    System.out.println("Tick rate set to: " + tickRate);
                    tickRate -= step;  // Reduce tick rate by step
                } else {
                    CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), tickRate, true);  // Freeze at 0 ticks
                    System.out.println("Tick rate set to 0. Time frozen.");
                    timer.cancel();  // Stop the task once tick rate reaches 0
                }
            }
        };

        // Schedule the task to run every 50ms (adjust this for your timing)
        timer.scheduleAtFixedRate(task, 0, interval);
    }

    public static void unfreezeTime(Player player) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (tickRate < 20) {
                    CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), tickRate, false);
                    System.out.println("Tick rate set to: " + tickRate);
                    tickRate += step;  // Reduce tick rate by step
                } else {
                    CustomTickRateHandler.setCustomTickRate(Objects.requireNonNull(player.getServer()), tickRate, false);  // Freeze at 0 ticks
                    System.out.println("Tick rate set to 0. Time frozen.");
                    timer.cancel();  // Stop the task once tick rate reaches 0
                }
            }
        };

        // Schedule the task to run every 50ms (adjust this for your timing)
        timer.scheduleAtFixedRate(task, 0, interval);
    }
}
