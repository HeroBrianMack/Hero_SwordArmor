package net.hero.effects;

import net.hero.swordarmor.item.ModMaterials;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.HashMap;
import java.util.Map;

public class Effects {

    /**
     * The method to assign a status effect to a material in a Map.
     * @param effect The status effect.
     * @param duration The duration of the effect.
     * @param amp The amplifier of the effect.
     * @param material The material.
     * @return A Map with the material as a key, and the status effect as a value.
     */
    public static Map effectMake(StatusEffect effect, int duration, int amp, ModMaterials material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance>();
                temp.put(material, new StatusEffectInstance(effect, duration, amp));
        return temp;
    }

    /**
     * The method that allows for multiple status effects to be given to a material in a Map
     * @param effects The status effects.
     * @param duration The duration of the effects.
     * @param amp The amplifier of the effects.
     * @param material The material.
     * @return A Map with the material as a key, and the status effects as values.
     */
    public static Map effectMake(StatusEffect[] effects, int duration, int amp, ModMaterials material) {
        for (StatusEffect effect: effects) {
            Map temp = new HashMap<ModMaterials, StatusEffectInstance>();
            temp.put(material, new StatusEffectInstance(effect, duration, amp));
            return temp;
        }
        return null;
    }

    /**
     * Helper method to create StatusEffectInstances
     * @param effect
     * @param duration
     * @param amp
     * @return
     */
    public static StatusEffectInstance statusEffect(StatusEffect effect, int duration, int amp) {
        return new StatusEffectInstance(effect, duration, amp);
    }
}
