package net.stancium.donner.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.stancium.donner.Donner;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SALT_ORE_PLACED_KEY= registerKey("salt_ore_placed");
    public static final ResourceKey<PlacedFeature> DEMONIC_DUST_ORE_PLACED_KEY= registerKey("demonic_dust_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures =  context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,SALT_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SALT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80)))
                );

        register(context,DEMONIC_DUST_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_DEMONIC_DUST_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80)))
        );

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Donner.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
