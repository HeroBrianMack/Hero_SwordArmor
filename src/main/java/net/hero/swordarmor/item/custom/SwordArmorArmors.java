package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.hero.swordarmor.item.custom.ModItemEffects.evaluateEffects;

public class SwordArmorArmors extends ArmorItem {

    /**
     * Constructor for an armor from the SwordArmor mod.
     * @param material The material the armor is made from.
     * @param type The equipment slot the armor goes into.
     * @param settings The settings (typically ItemGroup) of the armor.
     */
    public SwordArmorArmors(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                evaluateEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

}

