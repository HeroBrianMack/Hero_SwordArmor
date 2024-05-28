package net.hero.swordarmor.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hero.swordarmor.SwordArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SwordGroup {

    public static final RegistryKey<ItemGroup> Tools = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(SwordArmor.MOD_ID, "sword"));
    public static final RegistryKey<ItemGroup> Armors = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(SwordArmor.MOD_ID, "armor"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, Tools, FabricItemGroup.builder().
                icon(() -> new ItemStack(ModItems.SLATE_AXE)).displayName(Text.translatable("Tool-group"))
                .build());
        Registry.register(Registries.ITEM_GROUP, Armors, FabricItemGroup.builder().
                icon(() -> new ItemStack(ModItems.AMETHYST_CHESTPLATE)).displayName(Text.translatable("Armor-group"))
                .build());
    }

    public static void addItemToGroup(Item item, RegistryKey<ItemGroup> itemGroup) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
            content.add(item);
        });
    }

}
