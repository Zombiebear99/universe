package org.zombie.universe;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.zombie.universe.blocks.Modblocks;
import org.zombie.universe.item.ModItems;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,Universe.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("universetab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Modblocks.CREATIVE_UNIVERSE.get()))
                    .title(Component.translatable("creativetab.universetab"))
                    .displayItems(((itemDisplayParameters, output) ->{
                        output.accept(Modblocks.INFERIUM_UNIVERSE.get());
                        output.accept(Modblocks.PRUDENTIUM_UNIVERSE.get());
                        output.accept(Modblocks.TERTIUM_UNIVERSE.get());
                        output.accept(Modblocks.IMPERIUM_UNIVERSE.get());
                        output.accept(Modblocks.SUPREMIUM_UNIVERSE.get());
                        output.accept(Modblocks.INSANIUM_UNIVERSE.get());
                        output.accept(Modblocks.CREATIVE_UNIVERSE.get());
                    }))

                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
