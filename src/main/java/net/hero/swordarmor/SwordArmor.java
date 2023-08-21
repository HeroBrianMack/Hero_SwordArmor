package net.hero.swordarmor;

import net.fabricmc.api.ModInitializer;
import net.hero.swordarmor.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwordArmor implements ModInitializer {
	public static final String MOD_ID = "swordarmor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
	}
}
