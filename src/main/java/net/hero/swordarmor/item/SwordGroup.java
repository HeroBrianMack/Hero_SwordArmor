package net.hero.swordarmor.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.hero.swordarmor.SwordArmor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class SwordGroup {

    public static final ItemGroup Tools = FabricItemGroupBuilder.build(
            new Identifier(SwordArmor.MOD_ID, "sword"), () -> new ItemStack(ModItems.SLATE_AXE));
    public static final ItemGroup AMETHYST_HELMET = FabricItemGroupBuilder.build(
            new Identifier(SwordArmor.MOD_ID, "armor"), () -> new ItemStack(ModItems.AMETHYST_CHESTPLATE));

}
