package net.stancium.donner.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stancium.donner.Donner;
import net.stancium.donner.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, Donner.MODID);
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block" ,
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> DEMONIC_DUST_BLOCK = registerBlock("demonic_dust_block" ,
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block" ,
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block){
        RegistryObject<Block> registeredBlock = BLOCKS.register(name,block);
        registerBlockItem(name,registeredBlock);
        return registeredBlock;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block ){
        return ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
}
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
