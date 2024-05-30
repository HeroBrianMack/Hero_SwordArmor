package net.hero.swordarmor.item;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.registry.Registry.registerReference;

public class ModArmorMaterials extends ArmorMaterials implements ModMaterials {
    /*AMETHYST("amethyst", 30, new int[]{3, 6, 8, 3}, 20, SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.AMETHYST_SHARD});
    }),*/
    private static RegistryEntry<ArmorMaterial> heroRegister(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] armor = ArmorItem.Type.values();
        int armorLength = armor.length;

        for(int i = 0; i < armorLength; ++i) {
            ArmorItem.Type type = armor[i];
            enumMap.put(type, defense.get(type));
        }

        return registerReference(Registries.ARMOR_MATERIAL, Identifier.ofVanilla(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
    private static RegistryEntry<ArmorMaterial> heroRegister(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.ofVanilla(id)));
        return heroRegister(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }
    public static final RegistryEntry<ArmorMaterial> AMETHYST;
    public static final RegistryEntry<ArmorMaterial> SLATE;
    public static final RegistryEntry<ArmorMaterial> SAND;
    static{
        AMETHYST = heroRegister("amethyst", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 10);
        }), 15, Registry.registerReference(Registries.SOUND_EVENT, SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP.getId(),
                SoundEvent.of(SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP.getId())), 2.0F, 0.0F, () ->
                Ingredient.ofItems(new ItemConvertible[]{Items.AMETHYST_SHARD}));

        SLATE = heroRegister("slate", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 5);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 8);
        }), 15, Registry.registerReference(Registries.SOUND_EVENT, SoundEvents.BLOCK_DEEPSLATE_STEP.getId(),
                SoundEvent.of(SoundEvents.BLOCK_DEEPSLATE_STEP.getId())), 2.0F, 0.0F, () ->
                Ingredient.ofItems(new ItemConvertible[]{Items.DEEPSLATE}));

        SAND = heroRegister("sand", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 3);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 4);
        }), 15, Registry.registerReference(Registries.SOUND_EVENT, SoundEvents.BLOCK_SAND_STEP.getId(),
                SoundEvent.of(SoundEvents.BLOCK_SAND_STEP.getId())), 2.0F, 0.0F, () ->
                Ingredient.ofItems(new ItemConvertible[]{Items.SAND}));
    }

    /*SLATE("slate", 8, new int[]{1, 3, 5, 1}, 8, SoundEvents.BLOCK_DEEPSLATE_STEP, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DEEPSLATE});
    }),
    SAND("sand", 2, new int[]{1, 2, 3, 1}, 20, SoundEvents.BLOCK_SAND_STEP, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.SAND});
    });*/

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);

    }


    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * this.durabilityMultiplier;
    }


    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.getEquipmentSlot().getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}


