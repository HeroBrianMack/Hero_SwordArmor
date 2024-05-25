package net.hero.swordarmor;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class DataGeneration implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        // fabricDataGenerator.addProvider(ModLootTableGenerator::new);
        fabricDataGenerator.addProvider(RecipeGen::new);
        //fabricDataGenerator.addProvider(ModModelProvider::new);
    }
}