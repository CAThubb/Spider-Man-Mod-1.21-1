package com.dimoch1c.spidermanmod.block;

import com.dimoch1c.spidermanmod.Spidermanmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModBlocks {

    public static final Block SILICON_ORE = registerBlock("silicon_ore",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(3.0f, 3.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            )
    );

    public static final Block DEEPSLATE_SILICON_ORE = registerBlock("deepslate_silicon_ore",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(4.5f, 3.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)
            )
    );

    // Main method to register blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Identifier blockId = Identifier.of(Spidermanmod.MOD_ID, name);
        return Registry.register(Registries.BLOCK, blockId, block);
    }

    // Helper method to register block items
    private static void registerBlockItem(String name, Block block) {
        Identifier itemId = Identifier.of(Spidermanmod.MOD_ID, name);
        Registry.register(Registries.ITEM, itemId,
                new BlockItem(block, new Item.Settings().rarity(Rarity.COMMON)));
    }

    public static void registerModBlocks() {
        Spidermanmod.LOGGER.info(Spidermanmod.MOD_ID + ": registered Mod Block class");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.SILICON_ORE);
            entries.add(ModBlocks.DEEPSLATE_SILICON_ORE);
        });
    }
}
