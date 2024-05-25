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

    public SwordArmorArmors(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (ModItemEffects.hasFullSuitOfArmorOn(player)) {
                    evaluateEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

}

