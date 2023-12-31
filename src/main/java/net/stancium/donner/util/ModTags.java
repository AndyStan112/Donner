package net.stancium.donner.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.stancium.donner.Donner;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DETECTABLES = tag("metal_detector_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Donner.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Donner.MODID, name));
        }
    }
}