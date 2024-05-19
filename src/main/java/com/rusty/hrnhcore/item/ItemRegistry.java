package com.rusty.hrnhcore.item;

import com.rusty.hrnhcore.HrCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rusty.hrnhcore.HrCore.MOD_ID;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> INGOT_VANADIUM = ITEMS.register("ingot_vanadium",
            () -> new Item(new Item.Properties().tab(CreativeTabRegistry.HRNH_TAB_MATS)));
    public static final RegistryObject<Item> RAW_ORE_VANADIUM = ITEMS.register("raw_ore_vanadium",
            () -> new Item(new Item.Properties().tab(CreativeTabRegistry.HRNH_TAB_MATS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
