package net.hero.swordarmor.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class SwordArmorSwords extends SwordItem {

/*    private static final Map<ToolMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ToolMaterial, StatusEffectInstance>())
                    .put(ModToolMaterials.AMETHYST,
                            new StatusEffectInstance(StatusEffects.GLOWING, 60, 0)).build();
    private static final Map<ToolMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP2 =
            (new ImmutableMap.Builder<ToolMaterial, StatusEffectInstance>())
                    .put(ModToolMaterials.SLATE,
                            new StatusEffectInstance(StatusEffects.HASTE, 60, 0)).build();
    private static final Map<ToolMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP3 =
            (new ImmutableMap.Builder<ToolMaterial, StatusEffectInstance>())
                    .put(ModToolMaterials.SAND,
                            new StatusEffectInstance(StatusEffects.SPEED, 60, 1)).build();
    private static final Map<ToolMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP4 =
            (new ImmutableMap.Builder<ToolMaterial, StatusEffectInstance>())
                    .put(ModToolMaterials.SAND,
                            new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0)).build();

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

/*    private void evaluateSwordEffects(PlayerEntity player) {
        for (Map.Entry<ToolMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ToolMaterial mapToolMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectSwordOn(mapToolMaterial, player)) {
                addStatusEffectForMaterial(player, mapToolMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ToolMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP2.entrySet()) {
            ToolMaterial mapToolMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectSwordOn(mapToolMaterial, player)) {
                addStatusEffectForMaterial(player, mapToolMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ToolMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP3.entrySet()) {
            ToolMaterial mapToolMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectSwordOn(mapToolMaterial, player)) {
                addStatusEffectForMaterial(player, mapToolMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ToolMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP4.entrySet()) {
            ToolMaterial mapToolMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectSwordOn(mapToolMaterial, player)) {
                addStatusEffectForMaterial(player, mapToolMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ToolMaterial mapToolMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (hasCorrectSwordOn(mapToolMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }

    private boolean swordHeld(PlayerEntity player) {
        ItemStack hand = player.getInventory().getMainHandStack();

        return !hand.isEmpty();
    }

    private boolean hasCorrectSwordOn(ToolMaterial material, PlayerEntity player) {
        String test = (player.getInventory().getMainHandStack().getItem().toString());
        if (test.contains("sword")) {
            ToolItem hand = ((ToolItem) player.getInventory().getMainHandStack().getItem());


        return hand.getMaterial() == material;
        }
        else {
            return false;
        }
    } */
}




