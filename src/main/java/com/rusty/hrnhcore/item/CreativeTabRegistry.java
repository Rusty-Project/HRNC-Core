package com.rusty.hrnhcore.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabRegistry {
    public static final CreativeModeTab HRNH_TAB_MATS = new CreativeModeTab("hrnh_tab_mats") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.INGOT_VANADIUM.get());
        }
    };
}
