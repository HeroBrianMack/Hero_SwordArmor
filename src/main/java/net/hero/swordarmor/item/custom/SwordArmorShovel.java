package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class SwordArmorShovel extends ShovelItem {

    /**
     * Constructor for a shovel from the SwordArmor Mod.
     * @param material The material the shovel is made from.
     * @param attackDamage The attack damage of the shovel.
     * @param attackSpeed The attack speed of the shovel.
     * @param settings The settings (typically ItemGroup) of the shovel.
     */
    public SwordArmorShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(material, attackDamage, attackSpeed)));
        //super(ToolMaterials.STONE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.STONE, 1.5F, -3.0F)));
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
