package net.stancium.donner.datagen;

import net.stancium.donner.Donner;
import net.stancium.donner.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Donner.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.MAGNESIUM_DUST);
        simpleItem(ModItems.TITANIUM_OXIDE);
        simpleItem(ModItems.IRON_DUST);
        simpleItem(ModItems.DEMONIC_DUST);

        simpleItem(ModItems.FERROSILICON_DUST);
        simpleItem(ModItems.ORE_SAMPLE);
        simpleItem(ModItems.DEMONIC_ORE_SAMPLE);

        simpleItem(ModItems.TITANIUM_INGOT);

        simpleItem(ModItems.TITANIUM_DIVINER);
        simpleItem(ModItems.ENDER_DIVINER);
        simpleItem(ModItems.DEMONIC_DIVINER);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Donner.MODID,"item/" + item.getId().getPath()));
    }
}