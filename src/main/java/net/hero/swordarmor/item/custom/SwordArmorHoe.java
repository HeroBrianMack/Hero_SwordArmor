package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class SwordArmorHoe extends HoeItem {

    /**
     * Constructor for a hoe from the SwordArmor Mod.
     * @param material The material the hoe is made from.
     * @param attackDamage The attack damage of the hoe.
     * @param attackSpeed The attack speed of the hoe.
     * @param settings The settings (typically ItemGroup) of the hoe.
     */
    public SwordArmorHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (ModItemEffects.itemHeld(player)) {
                    ModItemEffects.evaluateEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}



