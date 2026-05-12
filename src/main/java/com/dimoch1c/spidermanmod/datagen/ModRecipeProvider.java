package com.dimoch1c.spidermanmod.datagen;

import com.dimoch1c.spidermanmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> SILICON_SMELLABLE = List.of(
                ModItems.RAW_SILICON_ORE
        );

        offerSmelting(
                exporter,
                SILICON_SMELLABLE,
                RecipeCategory.MISC,
                ModItems.SILICON_INGOT,
                0.25f, 200,
                "silicon"
        );
        offerBlasting(
                exporter,
                SILICON_SMELLABLE,
                RecipeCategory.MISC,
                ModItems.SILICON_INGOT,
                0.25f, 100,
                "silicon"
        );
    }
}
