package org.zombie.universe.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.zombie.universe.Universe;
import org.zombie.universe.blocks.custom.*;
import org.zombie.universe.item.ModItems;

import java.util.function.Supplier;

public class Modblocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Universe.MOD_ID);

    public static final RegistryObject<Block> INFERIUM_UNIVERSE = registerBlock("inferium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PRUDENTIUM_UNIVERSE = registerBlock("prudentium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> TERTIUM_UNIVERSE = registerBlock("tertium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> IMPERIUM_UNIVERSE = registerBlock("imperium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SUPREMIUM_UNIVERSE = registerBlock("supremium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> INSANIUM_UNIVERSE = registerBlock("insanium_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CREATIVE_UNIVERSE = registerBlock("creative_universe",
            ()->new UniverseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }


    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
