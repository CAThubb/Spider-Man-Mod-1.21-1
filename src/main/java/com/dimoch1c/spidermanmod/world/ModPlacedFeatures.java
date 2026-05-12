package com.dimoch1c.spidermanmod.world;

import com.dimoch1c.spidermanmod.Spidermanmod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Spidermanmod.MOD_ID));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
