package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class SwordArmorPickaxe extends PickaxeItem {

    /**
     * Constructor for a pickaxe from the SwordArmor Mod.
     * @param material The material the pickaxe is made from.
     * @param attackDamage The attack damage of the pickaxe.
     * @param attackSpeed The attack speed of the pickaxe.
     * @param settings The settings (typically ItemGroup) of the pickaxe.
     */
    public SwordArmorPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, settings.attributeModifiers(PickaxeItem.createAttributeModifiers(material, attackDamage, attackSpeed)));
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