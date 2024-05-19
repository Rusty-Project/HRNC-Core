package com.rusty.hrnhcore.block;

import com.rusty.hrnhcore.HrCore;
import com.rusty.hrnhcore.item.CreativeTabRegistry;
import com.rusty.hrnhcore.item.ItemRegistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HrCore.MOD_ID);

    public static final RegistryObject<Block> BLOCK_VANADIUM = registerBlock("block_vanadium",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeTabRegistry.HRNH_TAB_MATS);
    public static final RegistryObject<Block> ORE_VANADIUM = registerBlock("ore_vanadium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), CreativeTabRegistry.HRNH_TAB_MATS);
    public static final RegistryObject<Block> ORE_DEEPSLATE_VANADIUM = registerBlock("ore_deepslate_vanadium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), CreativeTabRegistry.HRNH_TAB_MATS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
