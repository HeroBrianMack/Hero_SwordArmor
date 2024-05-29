package net.hero.swordarmor.config;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class HeroConfigurations {
    ArrayList<String> DEFAULT_CONFIG_LIST = new ArrayList<>();
    ArrayList<String> CONFIG_LIST = new ArrayList<>();
    private String ModID;
    private String configDivider;
    private Logger logger;
    private File folder;


    public HeroConfigurations(String ModID, Logger logger) {
        this.ModID = ModID;
        this.logger = logger;
        folder = new File(FabricLoader.getInstance().getConfigDir() + "/" + ModID);
        configDivider = ":";
    }

    public boolean configCreate(String fileName) {
        if (!folder.exists() && !folder.mkdirs()) {
            logger.error("SwordArmor's config folder could not generate!");
        }
        try {
           if (!new File(folder, fileName).exists()) {
                logger.error("Config file not found!");
                logger.info("Creating default configurations...");
                PrintWriter pw = new PrintWriter(new File(folder, fileName));
                defaultConfig(pw);
                pw.close();
                return true;
            }
        } catch (FileNotFoundException e) {
            logger.error("Configuration file missing!");
            logger.info("Using default configs!");
        }
        return false;
    }

    public final void defaultConfig(PrintWriter pw) {
        logger.info("Size: " + DEFAULT_CONFIG_LIST.size());
        for (String s: DEFAULT_CONFIG_LIST) {
            pw.println(s);
        }
    }

    public void configRead(String fileName) {
        try {
            Scanner configReader = new Scanner(new File(folder, fileName));
            logger.info("Trying to read config file...");
            while(configReader.hasNext()) {
                CONFIG_LIST.add(configFilter(configReader.nextLine()));
            }
            configReader.close();
        } catch (FileNotFoundException e) {
            logger.error("Config file unable to be read!");
            logger.info("Attempting to regen config file...");
            if (!configCreate(fileName)) {
                logger.error("Config file unable to be created, please report to mod author!");
            }
        } catch (IncorrectConfigurationException e) {
            logger.error(e.getMessage());
            defaultValues();
        }
    }

    public void defaultValues() {
        logger.info("Loading default values...");
        for (int i = 0; i < DEFAULT_CONFIG_LIST.size(); i++) {
            if (i >= CONFIG_LIST.size()) {
                CONFIG_LIST.add(configFilter(DEFAULT_CONFIG_LIST.get(i)));
            } else {
                CONFIG_LIST.set(i, configFilter(DEFAULT_CONFIG_LIST.get(i)));
            }
        }
    }

    public String configFilter(String line) {
        if (!line.contains(":")) {
            throw new IncorrectConfigurationException("Config file not setup correctly!");
        }
        if (line.indexOf(" ", line.indexOf(":")) == -1) {
            return line.substring(line.indexOf(configDivider) + 1);
        } else {
            return line.substring(line.indexOf(configDivider) + 1).trim();
        }
    }

    public static StatusEffect getEffects(String str) {
        return Registries.STATUS_EFFECT.get(Identifier.of(str));
    }

    public void configSetup(String fileName) {
        configCreate(fileName);
        configRead(fileName);
    }

    class IncorrectConfigurationException extends RuntimeException {
        IncorrectConfigurationException(String errorMessage) {
            super(errorMessage);
        }

    }

}
