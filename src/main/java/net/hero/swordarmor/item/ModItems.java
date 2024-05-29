package net.hero.swordarmor.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hero.swordarmor.SwordArmor;
import net.hero.swordarmor.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static net.hero.swordarmor.item.SwordGroup.Armors;
import static net.hero.swordarmor.item.SwordGroup.Tools;

public class ModItems {
    public static final Item SAND_SWORD = registerItem("sand_sword",
            new SwordArmorSwords(ModToolMaterials.SAND, 2, -2.4f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword",
            new SwordArmorSwords(ModToolMaterials.AMETHYST, 1, -2.4f,
                    new Item.Settings()), Tools);
    public static final Item SLATE_SWORD = registerItem("slate_sword",
            new SwordArmorSwords(ModToolMaterials.SLATE, 1, -2.4f,
                    new Item.Settings()), Tools);
    public static final Item SLATE_PICKAXE = registerItem("slate_pickaxe",
            new SwordArmorPickaxe(ModToolMaterials.SLATE, -2, -2.8f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe",
            new SwordArmorPickaxe(ModToolMaterials.AMETHYST, -1, -2.8f,
                    new Item.Settings()), Tools);
    public static final Item SAND_PICKAXE = registerItem("sand_pickaxe",
            new SwordArmorPickaxe(ModToolMaterials.SAND, -1, -2.8f,
                    new Item.Settings()), Tools);
    public static final Item SAND_AXE = registerItem("sand_axe",
            new SwordArmorAxe(ModToolMaterials.SAND, 5, -3.2f,
                    new Item.Settings()), Tools);
    public static final Item SLATE_AXE = registerItem("slate_axe",
            new SwordArmorAxe(ModToolMaterials.SLATE, 5,-3.1f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_AXE = registerItem("amethyst_axe",
            new SwordArmorAxe(ModToolMaterials.AMETHYST, 3,-3f,
                    new Item.Settings()), Tools);
    public static final Item SLATE_HOE = registerItem("slate_hoe",
            new SwordArmorHoe(ModToolMaterials.SLATE, -3, -2f,
                    new Item.Settings()), Tools);
    public static final Item SAND_HOE = registerItem("sand_hoe",
            new SwordArmorHoe(ModToolMaterials.SAND, -1, -3f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe",
            new SwordArmorHoe(ModToolMaterials.AMETHYST, -5, 0f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel",
            new SwordArmorShovel(ModToolMaterials.AMETHYST, -3.5f, -3f,
                    new Item.Settings()), Tools);
    public static final Item SAND_SHOVEL = registerItem("sand_shovel",
            new SwordArmorShovel(ModToolMaterials.SAND, .5f, -3f,
                    new Item.Settings()), Tools);
    public static final Item SLATE_SHOVEL = registerItem("slate_shovel",
            new SwordArmorShovel(ModToolMaterials.SLATE, -.5f, -3f,
                    new Item.Settings()), Tools);
    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet",
            new SwordArmorArmors(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET,
                    new Item.Settings()), Armors);
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate",
            new SwordArmorArmors(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()), Armors);
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings",
            new SwordArmorArmors(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS,
                    new Item.Settings()), Armors);
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots",
            new SwordArmorArmors(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS,
                    new Item.Settings()), Armors);
    public static final Item SAND_HELMET = registerItem("sand_helmet",
            new SwordArmorArmors(ModArmorMaterials.SAND, ArmorItem.Type.HELMET,
                    new Item.Settings()), Armors);
    public static final Item SAND_CHESTPLATE = registerItem("sand_chestplate",
            new SwordArmorArmors(ModArmorMaterials.SAND, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()), Armors);
    public static final Item SAND_LEGGINGS = registerItem("sand_leggings",
            new SwordArmorArmors(ModArmorMaterials.SAND, ArmorItem.Type.LEGGINGS,
                    new Item.Settings()), Armors);
    public static final Item SAND_BOOTS = registerItem("sand_boots",
            new SwordArmorArmors(ModArmorMaterials.SAND, ArmorItem.Type.BOOTS,
                    new Item.Settings()), Armors);
    public static final Item SLATE_HELMET = registerItem("slate_helmet",
            new SwordArmorArmors(ModArmorMaterials.SLATE, ArmorItem.Type.HELMET,
                    new Item.Settings()), Armors);
    public static final Item SLATE_CHESTPLATE = registerItem("slate_chestplate",
            new SwordArmorArmors(ModArmorMaterials.SLATE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()), Armors);
    public static final Item SLATE_LEGGINGS = registerItem("slate_leggings",
            new SwordArmorArmors(ModArmorMaterials.SLATE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings()), Armors);
    public static final Item SLATE_BOOTS = registerItem("slate_boots",
            new SwordArmorArmors(ModArmorMaterials.SLATE, ArmorItem.Type.BOOTS,
                    new Item.Settings()), Armors);


    private static Item registerItem(String name, Item item, RegistryKey<ItemGroup> group) {
        SwordGroup.addItemToGroup(item, group);
        return registerItem(name, item);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwordArmor.MOD_ID, name), item);
    }


    public static void registerModItems() {
        SwordArmor.LOGGER.debug("Registering Mod Items for " + SwordArmor.MOD_ID);
    }
}
