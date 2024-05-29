package net.hero.swordarmor.item;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

import static net.minecraft.item.Items.*;

public enum ModToolMaterials implements ToolMaterial, ModMaterials {
    AMETHYST(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1256, 8.0F, 5F, 30,
            () -> Ingredient.ofItems(AMETHYST_SHARD)),
    SLATE(BlockTags.INCORRECT_FOR_STONE_TOOL, 88, 4.0F, 3F, 8,
            () -> Ingredient.ofItems(DEEPSLATE)),
    SAND(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 36, 3.0F, 1.0F, 15,
            () -> Ingredient.ofItems(Items.SAND));

    private final TagKey<Block> tagKey;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;


    private ModToolMaterials(TagKey<Block> tagKey, int itemDurability, float miningSpeed, float attackDamage,
                             int enchantability, Supplier<Ingredient> repairIngredient) {
        this.tagKey = tagKey;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.tagKey;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
