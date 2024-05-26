package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class SwordArmorSwords extends SwordItem {

    /**
     * Constructor for a sword from the SwordArmor Mod.
     * @param material The material the sword is made from.
     * @param attackDamage The attack damage of the sword.
     * @param attackSpeed The attack speed of the sword.
     * @param settings The settings (typically ItemGroup) of the sword.
     */
    public SwordArmorSwords(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material,attackDamage, attackSpeed, settings);

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




