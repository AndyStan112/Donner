package net.stancium.donner.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.stancium.donner.block.ModBlocks;
import net.stancium.donner.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    public LootTable.Builder createOreLikeDrop(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }



    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SALT_BLOCK.get());
        this.dropSelf(ModBlocks.DEMONIC_DUST_BLOCK.get());

        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());

        this.add(ModBlocks.SALT_ORE.get(),
                block-> createOreLikeDrop(
                        ModBlocks.SALT_ORE.get(),
                        ModItems.SALT.get()));
        this.add(ModBlocks.TITANIUM_ORE.get(),
                block-> createOreLikeDrop(
                        ModBlocks.TITANIUM_ORE.get(),
                        ModItems.TITANIUM_OXIDE.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
