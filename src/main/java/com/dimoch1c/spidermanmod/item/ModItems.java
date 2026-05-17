package com.dimoch1c.spidermanmod.item;

import com.dimoch1c.spidermanmod.Spidermanmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static Item RAW_SILICON_ORE = registerItem("raw_silicon_ore",
            new Item(new Item.Settings().rarity(Rarity.COMMON))
    );

    public static Item SILICON_INGOT = registerItem("silicon_ingot",
            new Item(new Item.Settings().rarity(Rarity.COMMON))
    );

    public static Item RAW_ALUMINIUM_ORE = registerItem("raw_aluminium_ore",
            new Item(new Item.Settings().rarity(Rarity.COMMON))
    );

    public static Item ALUMINIUM_INGOT = registerItem("aluminium_ingot",
            new Item(new Item.Settings().rarity(Rarity.COMMON))
    );

    // Method to register an Item
    private static Item registerItem(String name, Item item) {
        Identifier itemId = Identifier.of(Spidermanmod.MOD_ID, name);
        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static void registerModItems() {
        Spidermanmod.LOGGER.info(Spidermanmod.MOD_ID + ": registered Mod Item");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RAW_SILICON_ORE);
            entries.add(ModItems.SILICON_INGOT);
            entries.add(ModItems.RAW_ALUMINIUM_ORE);
            entries.add(ModItems.ALUMINIUM_INGOT);
        });
    }
}
