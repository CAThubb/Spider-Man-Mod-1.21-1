package com.dimoch1c.spidermanmod.world;

import com.dimoch1c.spidermanmod.Spidermanmod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {

    // Configured Feature -> Placed Feature -> WorldGen (BiomeConfiguration)

    // Configured Feature is a feature, that can be spawned
    // Feature is something like new ores, buildings, trees etc.
    // Configure here is how it is going to look like.

    // Placed Feature is how it is going to be placed in a world (XYZ levels).

    // BiomeConfiguration defines where things will be placed (place this in savanna biomes).

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {}

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Spidermanmod.MOD_ID));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
