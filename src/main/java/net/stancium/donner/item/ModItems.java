package net.stancium.donner.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stancium.donner.Donner;
import net.stancium.donner.item.custom.DivinerItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Donner.MODID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
 public static final RegistryObject<Item> SALT =
            ITEMS.register("salt",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_OXIDE =
            ITEMS.register("titanium_oxide",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGNESIUM_DUST =
            ITEMS.register("magnesium_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST =
            ITEMS.register("iron_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_DUST =
            ITEMS.register("demonic_dust",()->new Item(new Item.Properties()));


    public static final RegistryObject<Item> FERROSILICON_DUST =
            ITEMS.register("ferrosilicon_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORE_SAMPLE =
            ITEMS.register("ore_sample",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_ORE_SAMPLE =
            ITEMS.register("demonic_ore_sample",()->new Item(new Item.Properties()));


    public static final RegistryObject<Item> TITANIUM_INGOT =
            ITEMS.register("titanium_ingot",()->new Item(new Item.Properties()));
     public static final RegistryObject<Item> TITANIUM_DIVINER =
            ITEMS.register("titanium_diviner",()->new DivinerItem(new Item.Properties().durability(100),1));
    public static final RegistryObject<Item> ENDER_DIVINER =
            ITEMS.register("ender_diviner",()->new DivinerItem(new Item.Properties().durability(300),2));
    public static final RegistryObject<Item> DEMONIC_DIVINER =
            ITEMS.register("demonic_diviner",()->new DivinerItem(new Item.Properties().durability(1000),3));



}
