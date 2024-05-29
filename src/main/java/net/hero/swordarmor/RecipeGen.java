package net.hero.swordarmor;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hero.swordarmor.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends FabricRecipeProvider {
    public RecipeGen(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {

        super(dataGenerator, registries);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /*ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.AMETHYST_BOOTS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SLATE_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SLATE_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLATE_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SLATE_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SLATE_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLATE_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLATE_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLATE_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLATE_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SLATE_BOOTS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAND_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAND_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAND_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAND_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAND_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAND_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAND_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAND_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_LEGGINGS)));

         */
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAND_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(ModItems.SAND_BOOTS)));


    }
}