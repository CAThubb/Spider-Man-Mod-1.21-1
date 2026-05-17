package com.dimoch1c.spidermanmod.world;

import com.dimoch1c.spidermanmod.Spidermanmod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SILICON_ORE_SMALL_KEY = registryKey("silicon_ore_small");

    public static final RegistryKey<PlacedFeature> SILICON_ORE_MIDDLE_KEY = registryKey("silicon_ore_middle");

    public static final RegistryKey<PlacedFeature> SILICON_ORE_UPPER_KEY = registryKey("silicon_ore_upper");

    public static final RegistryKey<PlacedFeature> ALUMINIUM_ORE_SMALL_KEY = registryKey("aluminium_ore_small");

    public static final RegistryKey<PlacedFeature> ALUMINIUM_ORE_LARGE_KEY = registryKey("aluminium_ore_large");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SILICON_ORE_SMALL_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICON_ORE_SMALL_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(74))));

        register(context, SILICON_ORE_MIDDLE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICON_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56))));

        register(context, SILICON_ORE_UPPER_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICON_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(80), YOffset.fixed(384))));

        register(context, ALUMINIUM_ORE_SMALL_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALUMINIUM_ORE_SMALL_KEY),
                ModOrePlacement.modifiersWithCount(16,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(112))));

        register(context, ALUMINIUM_ORE_LARGE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALUMINIUM_ORE_LARGE_KEY),
                ModOrePlacement.modifiersWithCount(16,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(112))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Spidermanmod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
