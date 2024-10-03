package com.dipper.timestopper.item;
import com.dipper.timestopper.TimeStopper;
import com.dipper.timestopper.item.custom.TimeWatch;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TimeStopper.MODID);

    public static final DeferredItem<Item> TIME_WATCH = ITEMS.register("timewatch",
            () -> new TimeWatch(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}