package com.dimoch1c.spidermanmod.datagen;

import com.dimoch1c.spidermanmod.block.ModBlocks;
import com.dimoch1c.spidermanmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SILICON_ORE, oreDrops(ModBlocks.SILICON_ORE, ModItems.RAW_SILICON_ORE));
    }
}
