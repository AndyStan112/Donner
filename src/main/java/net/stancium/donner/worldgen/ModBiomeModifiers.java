package net.stancium.donner.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.stancium.donner.Donner;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_SALT_ORE = registerKey("add_salt_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEMONIC_DUST_ORE = registerKey("add_demonic_dust_salt_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
            var placedFeatures= context.lookup(Registries.PLACED_FEATURE);
            var biomes = context.lookup(Registries.BIOME);

            context.register(ADD_SALT_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                    HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SALT_ORE_PLACED_KEY)),
                    GenerationStep.Decoration.UNDERGROUND_ORES));

            context.register(ADD_DEMONIC_DUST_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEMONIC_DUST_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Donner.MODID, name));
    }
}
