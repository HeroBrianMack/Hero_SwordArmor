package net.hero.swordarmor.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

import static net.minecraft.item.Items.*;

public enum ModToolMaterials implements ToolMaterial {
    AMETHYST(3, 1256, 8.0F, 5F, 30,
            () -> Ingredient.ofItems(AMETHYST_SHARD)),
    SLATE(1, 88, 4.0F, 3F, 8,
            () -> Ingredient.ofItems(DEEPSLATE)),
    SAND(0, 36, 3.0F, 1.0F, 15,
            () -> Ingredient.ofItems(Items.SAND));
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;


    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                             int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
