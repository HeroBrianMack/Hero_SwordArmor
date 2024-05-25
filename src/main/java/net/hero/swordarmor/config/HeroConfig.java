package net.hero.swordarmor.config;

import com.mojang.datafixers.util.Pair;
import net.hero.swordarmor.SwordArmor;

public class HeroConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String TEST;
    public static int SOME_INT;
    public static double SOME_DOUBLE;
    public static int AMETHYST_ARMOR_EFFECT;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(SwordArmor.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("key.test.value1", "Just a Testing string!"), "String");
        configs.addKeyValuePair(new Pair<>("key.test.value2", 50), "int");
        configs.addKeyValuePair(new Pair<>("key.test.value3", 4142.5), "double");
        configs.addKeyValuePair(new Pair<>("amethyst.armor.effect", "resistance"), "String");
    }

    private static void assignConfigs() {
        TEST = CONFIG.getOrDefault("key.test.value1", "Nothing");
        SOME_INT = CONFIG.getOrDefault("key.test.value2", 42);
        SOME_DOUBLE = CONFIG.getOrDefault("key.test.value3", 42.0d);
        AMETHYST_ARMOR_EFFECT = CONFIG.getOrDefault("amethyst.armor.effect", 32);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}