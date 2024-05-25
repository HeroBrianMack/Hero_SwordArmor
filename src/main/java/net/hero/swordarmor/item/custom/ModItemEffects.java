package net.hero.swordarmor.item.custom;

import net.hero.swordarmor.item.ModArmorMaterials;
import net.hero.swordarmor.item.ModMaterials;
import net.hero.swordarmor.item.ModToolMaterials;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.Map;

import static net.hero.swordarmor.item.custom.Effects.effectMake;

public class ModItemEffects {
    public static ArrayList<Map> mapList = new ArrayList<Map>();
    public static final Map<ModMaterials, StatusEffectInstance> AM_TOOL =
            effectMake(StatusEffects.GLOWING, 60, 0, ModToolMaterials.AMETHYST);
    static {
        mapList.add(effectMake(StatusEffects.GLOWING, 60, 0, ModToolMaterials.AMETHYST));
        mapList.add(effectMake(StatusEffects.HASTE, 60, 0, ModToolMaterials.SLATE));
        mapList.add(effectMake(StatusEffects.SPEED, 60, 1, ModToolMaterials.SAND));
        mapList.add(effectMake(StatusEffects.NAUSEA, 200, 0, ModToolMaterials.SAND));
        mapList.add(effectMake(StatusEffects.RESISTANCE, 60, 0, ModArmorMaterials.AMETHYST));
        mapList.add(effectMake(StatusEffects.NIGHT_VISION, 60, 0, ModArmorMaterials.SLATE));
        mapList.add(effectMake(StatusEffects.FIRE_RESISTANCE, 60, 0, ModArmorMaterials.SAND));

    }



//    public ModItemEffects(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
//        //super(material,attackDamage, attackSpeed, settings);
//
//    }

    public static void evaluateEffects(PlayerEntity player) {
        for (Map<ModMaterials, StatusEffectInstance> itemMap: mapList) {
            for (Map.Entry<ModMaterials, StatusEffectInstance> entry : itemMap.entrySet()) {
                ModMaterials mapMaterial = entry.getKey();
                StatusEffectInstance mapStatusEffect = entry.getValue();

                if (isCorrect(mapMaterial, player)) {
                    addStatusEffectForMaterial(player, mapStatusEffect);
                }
            }
        }
    }

    public static void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (!hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }

    public static boolean isCorrect(ModMaterials material, PlayerEntity player) {
        if (material instanceof ModArmorMaterials) {
            //System.out.println(material + " ARMOR");
            return hasCorrectArmorOn(material, player);
        } else if (material instanceof ModToolMaterials) {
            //System.out.println(material + " TOOL");
            return hasCorrectItemHeld(material, player);
        }
        return (material instanceof ModArmorMaterials && hasCorrectArmorOn(material, player)) ||
                (material instanceof ModToolMaterials && hasCorrectItemHeld(material, player));
    }

    // Item Checks
    public static boolean itemHeld(PlayerEntity player) {
        ItemStack hand = player.getInventory().getMainHandStack();

        return !hand.isEmpty();
    }
    // Held Item Check
    public static boolean hasCorrectItemHeld(ModMaterials material, PlayerEntity player) {
        String test = (player.getInventory().getMainHandStack().getItem().toString());
        if (test.contains("sword") || test.contains("axe") || test.contains("hoe") || test.contains("shovel")) {
            ToolItem hand = ((ToolItem) player.getInventory().getMainHandStack().getItem());


            return hand.getMaterial() == material;
        }
        else {
            return false;
        }
    }
    // Armor Section
    public static boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    public static boolean hasCorrectArmorOn(ModMaterials material, PlayerEntity player) {
        String test1 = player.getInventory().getArmorStack(0).getItem().toString();
        String test2 = player.getInventory().getArmorStack(1).getItem().toString();
        String test3 = player.getInventory().getArmorStack(2).getItem().toString();
        String test4 = player.getInventory().getArmorStack(3).getItem().toString();
        if (test1.contains("boots") && test2.contains("leggings") && test3.contains("chestplate") && test4.contains("helmet")) {
            ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
            ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
            ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
            ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());
            return helmet.getMaterial() == material && chestplate.getMaterial() == material &&
                    leggings.getMaterial() == material && boots.getMaterial() == material;
        }
        else {
            return false;
        }
    }
}
