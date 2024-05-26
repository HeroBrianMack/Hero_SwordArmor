package net.hero.swordarmor;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hero.swordarmor.item.ModItems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeGen extends FabricRecipeProvider {
    public RecipeGen(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_PICKAXE)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_AXE)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_SWORD)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_SHOVEL)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_HOE)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_HELMET)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(ModItems.AMETHYST_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.AMETHYST_SHARD)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AMETHYST_BOOTS)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_PICKAXE)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_AXE)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_SWORD)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_SHOVEL)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_HOE)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_HELMET)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(ModItems.SLATE_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.DEEPSLATE)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.DEEPSLATE),
                        RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SLATE_BOOTS)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_PICKAXE)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_PICKAXE)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_AXE)
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_AXE)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_SWORD)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_SWORD)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_SHOVEL)
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_SHOVEL)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_HOE)
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_HOE)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_HELMET)
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_HELMET)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_CHESTPLATE)
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_LEGGINGS)
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(ModItems.SAND_BOOTS)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .input('W', Items.SAND)
                .criterion(RecipeProvider.hasItem(Items.STICK),
                        RecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(RecipeProvider.hasItem(Items.SAND),
                        RecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.SAND_BOOTS)));
    }
}