package net.hero.swordarmor.config;

import net.hero.swordarmor.item.ModArmorMaterials;
import net.hero.swordarmor.item.ModMaterials;
import net.hero.swordarmor.item.ModToolMaterials;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static net.hero.effects.Effects.effectMake;
import static net.hero.swordarmor.SwordArmor.LOGGER;
import static net.hero.swordarmor.SwordArmor.MOD_ID;
import static net.hero.swordarmor.config.HeroConfigTest.getEffects;
import static net.hero.swordarmor.item.custom.ModItemEffects.mapList;

public class HeroConfig {

    //public static HeroConfigTest configs = new HeroConfigTest(MOD_ID);

    public static void registerConfigs() {
        //configs = new ModConfigProvider();
        HeroConfigTest configs = new HeroConfigTest(MOD_ID, LOGGER);
        createConfigs(configs);
        configs.configSetup("test.cfg");
        mapList.add(effectReader(configs.CONFIG_LIST.get(0), ModArmorMaterials.AMETHYST));
        mapList.add(effectReader(configs.CONFIG_LIST.get(1), ModArmorMaterials.SLATE));
        mapList.add(effectReader(configs.CONFIG_LIST.get(2), ModArmorMaterials.SAND));
        mapList.add(effectReader(configs.CONFIG_LIST.get(3), ModToolMaterials.AMETHYST));
        mapList.add(effectReader(configs.CONFIG_LIST.get(4), ModToolMaterials.SLATE));
        mapList.add(effectReader(configs.CONFIG_LIST.get(5), ModToolMaterials.SAND));
    }

    public static Map effectReader(String line, ModMaterials material) {
        ArrayList<StatusEffectInstance> statusEffects = new ArrayList<>();
        Scanner lineReader = new Scanner(line);
        try {
            while (lineReader.hasNext()) {
                String effectName = lineReader.next().replace(",", "");
                if (effectName.contains("&")) {
                    effectName = lineReader.next().replace(",", "");
                }
                statusEffects.add(new StatusEffectInstance(getEffects(effectName),
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
        }
        StatusEffectInstance[] instanceArr = new StatusEffectInstance[statusEffects.size()];
        return effectMake(statusEffects.toArray(instanceArr), material);
    }

    private static void createConfigs(HeroConfigTest configs) {
        configs.DEFAULT_CONFIG_LIST.add("Amethyst Armor Effect: minecraft:resistance, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Deep Slate Armor Effect: minecraft:night_vision, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Sand Armor Effect: minecraft:fire_resistance, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Amethyst Tool Effect: minecraft:glowing, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Deep Slate Tool Effect: minecraft:haste, 60, 0");
        configs.DEFAULT_CONFIG_LIST.add("Sand Tool Effect: minecraft:speed, 60, 1, &" +
                " minecraft:nausea, 200, 0");

    }




}