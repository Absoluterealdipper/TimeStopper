package com.dipper.timestopper.sound;

import com.dipper.timestopper.TimeStopper;
import com.dipper.timestopper.item.custom.TimeWatch;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TimeStopper.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> TIME_FREEZE = SOUND_EVENTS.register(
            "time_freeze", // must match the resource location on the next line
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TimeStopper.MODID, "time_freeze"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> TIME_UNFREEZE = SOUND_EVENTS.register(
            "time_unfreeze", // must match the resource location on the next line
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TimeStopper.MODID, "time_unfreeze"))
    );

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

