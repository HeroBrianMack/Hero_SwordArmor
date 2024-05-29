package net.hero.swordarmor.config;

import net.hero.swordarmor.item.ModArmorMaterials;
import net.hero.swordarmor.item.ModMaterials;
import net.hero.swordarmor.item.ModToolMaterials;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static net.hero.effects.Effects.effectMake;
import static net.hero.swordarmor.SwordArmor.LOGGER;
import static net.hero.swordarmor.SwordArmor.MOD_ID;
import static net.hero.swordarmor.config.HeroConfigurations.getEffects;
import static net.hero.swordarmor.item.custom.ModItemEffects.mapList;

public class HeroConfig {
    private static HeroConfigurations configs = new HeroConfigurations(MOD_ID, LOGGER);

    public static void registerConfigs() {
        createConfigs(configs);
        configs.configSetup("SwordArmor.cfg");
//        mapList.add(effectReader(configs.CONFIG_LIST.get(0), ModArmorMaterials.AMETHYST.value()));
//        mapList.add(effectReader(configs.CONFIG_LIST.get(1), ModArmorMaterials.SLATE.value()));
//        mapList.add(effectReader(configs.CONFIG_LIST.get(2), ModArmorMaterials.SAND.value()));
        //mapList.add(effectReader(configs.CONFIG_LIST.get(3), ModToolMaterials.AMETHYST));
        //mapList.add(effectReader(configs.CONFIG_LIST.get(4), ModToolMaterials.SLATE));
        //mapList.add(effectReader(configs.CONFIG_LIST.get(5), ModToolMaterials.SAND));
    }

    public static Map effectReader(String line, ModMaterials material) {
        ArrayList<StatusEffectInstance> statusEffects = new ArrayList<>();
        Scanner lineReader = new Scanner(line);
        ArrayList<RegistryEntry<StatusEffect>> statReg = new ArrayList<>();
        try {//
            while (lineReader.hasNext()) {
                String effectName = lineReader.next().replace(",", "");
                if (effectName.contains("&")) {
                    effectName = lineReader.next().replace(",", "");
                }
                statusEffects.add(new StatusEffectInstance(RegistryEntry.of(getEffects(effectName)),
                        Integer.parseInt(lineReader.next().replace(",", "")),
                        Integer.parseInt(lineReader.next().replace(",", ""))));
            }
            LOGGER.info("Successfully read : \"" + line + "\" !");
            LOGGER.info("Effects: " + statusEffects.size());
            for (StatusEffectInstance s: statusEffects) {
                LOGGER.info(s.toString());
            }
        } catch(Exception e) {
            // Unable to read config properly!
            LOGGER.error("Unable to read: \"" + line + "\" !");
            LOGGER.error(e.getMessage());
            configs.defaultValues();
            mapList.clear();
            registerConfigs();
        }
        StatusEffectInstance[] instanceArr = new StatusEffectInstance[statusEffects.size()];
        statReg.add(statusEffects.get(0).getEffectType());
        //return effectMake(statusEffects.toArray(instanceArr), material);
        return effectMake(RegistryEntry.of(statusEffects.toArray(instanceArr)), material);
    }

    public static Map effectReader(String line, ArmorMaterial material) {
        ArrayList<StatusEffectInstance> statusEffects = new ArrayList<>();
        Scanner lineReader = new Scanner(line);
        try {
            while (lineReader.hasNext()) {
                String effectName = lineReader.next().replace(",", "");
                if (effectName.contains("&")) {
                    effectName = lineReader.next().replace(",", "");
                }
                statusEffects.add(new StatusEffectInstance(RegistryEntry.of(getEffects(effectName)),
                        Integer.parseInt(lineReader.next().replace(",", "")),
                        Integer.parseInt(lineReader.next().replace(",", ""))));
            }
            LOGGER.info("Successfully read : \"" + line + "\" !");
            LOGGER.info("Effects: " + statusEffects.size());
            for (StatusEffectInstance s: statusEffects) {
                LOGGER.info(s.toString());
            }
        } catch(Exception e) {
            // Unable to read config properly!
            LOGGER.error("Unable to read: \"" + line + "\" !");
            LOGGER.error(e.getMessage());
            configs.defaultValues();
            mapList.clear();
            registerConfigs();
        }
        StatusEffectInstance[] instanceArr = new StatusEffectInstance[statusEffects.size()];
        return effectMake(statusEffects.toArray(instanceArr), material);
    }

    private static void createConfigs(HeroConfigurations configs) {
        configs.DEFAULT_CONFIG_LIST.add("Amethyst Armor Effect: minecraft:resistance, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Deep Slate Armor Effect: minecraft:night_vision, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Sand Armor Effect: minecraft:fire_resistance, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Amethyst Tool Effect: minecraft:glowing, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Deep Slate Tool Effect: minecraft:haste, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Sand Tool Effect: minecraft:speed, 60, 1 &" +
                " minecraft:nausea, 200, 0");

    }




}