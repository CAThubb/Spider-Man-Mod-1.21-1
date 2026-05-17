package com.dimoch1c.spidermanmod.world;

import com.dimoch1c.spidermanmod.Spidermanmod;
import com.dimoch1c.spidermanmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    // Configured Feature -> Placed Feature -> WorldGen (BiomeConfiguration)

    // Configured Feature is a feature, that can be spawned
    // Feature is something like new ores, buildings, trees etc.
    // Configure here is how it is going to look like.

    // Placed Feature is how it is going to be placed in a world (XYZ levels).

    // BiomeConfiguration defines where things will be placed (place this in savanna biomes).

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILICON_ORE_KEY = registryKey("silicon_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILICON_ORE_SMALL_KEY = registryKey("silicon_ore_small");

    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_SILICON_ORE_KEY = registryKey("deepslate_silicon_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSiliconOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SILICON_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SILICON_ORE.getDefaultState())
        );

        register(context, SILICON_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(overworldSiliconOres, 9));

        register(context, SILICON_ORE_SMALL_KEY, Feature.ORE,
                new OreFeatureConfig(overworldSiliconOres, 4));

        register(context, DEEPSLATE_SILICON_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(overworldSiliconOres, 9));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Spidermanmod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
