package net.stancium.donner.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.stancium.donner.Donner;
import net.stancium.donner.block.ModBlocks;
import net.stancium.donner.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Donner.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.DETECTABLES)
                .add(ModBlocks.SALT_ORE.get()).addTag((Tags.Blocks.ORES));


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SALT_ORE.get(),
                        ModBlocks.TITANIUM_BLOCK.get(),
                      //  ModBlocks.SALT_ORE.get(),
                        ModBlocks.TITANIUM_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SALT_BLOCK.get(),
                        ModBlocks.DEMONIC_DUST_BLOCK.get());


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SALT_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_ORE.get(),
                        ModBlocks.TITANIUM_BLOCK.get());

    }

}
