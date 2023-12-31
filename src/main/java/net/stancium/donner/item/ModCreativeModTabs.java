package net.stancium.donner.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.stancium.donner.Donner;
import net.stancium.donner.block.ModBlocks;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Donner.MODID);
    public static final RegistryObject<CreativeModeTab> DONNER_TAB =
            CREATIVE_MODE_TABS.register("donner_tab",
                    ()->CreativeModeTab.builder().icon(
                            ()->new ItemStack(ModItems.SALT.get()))
                            .title(Component.translatable("creativetab.donner_tab"))
                            .displayItems((pParameters,pOutput)->{

                                pOutput.accept(ModItems.SALT.get());
                                pOutput.accept(ModBlocks.SALT_BLOCK.get());
                                pOutput.accept(ModBlocks.SALT_ORE.get());

                            })
                            .build() );
    public static void register(IEventBus eventbus){
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
