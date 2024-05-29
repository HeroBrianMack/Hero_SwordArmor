package net.hero.effects;

import net.hero.swordarmor.item.ModMaterials;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
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
    public static Map effectMake(RegistryEntry<StatusEffect> effect, int duration, int amp, ModMaterials material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
                temp.put(material, new StatusEffectInstance[]{new StatusEffectInstance(effect, duration, amp)});
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
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
        for (StatusEffect effect: effects) {
            temp.put(material, new StatusEffectInstance(RegistryEntry.of(effect), duration, amp));
        }
        return temp;
    }

    public static Map effectMake(StatusEffectInstance[] effectInstances, ModMaterials material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
        temp.put(material, effectInstances);
        return temp;
    }

    public static Map effectMake(StatusEffectInstance[] effectInstances, ArmorMaterial material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
        temp.put(material, effectInstances);
        return temp;
    }

    public static Map effectMake(RegistryEntry<StatusEffect>[] effectInstances, ArmorMaterial material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
        temp.put(material, effectInstances);
        return temp;
    }
    public static Map effectMake(RegistryEntry<StatusEffectInstance[]> effectInstances, ModMaterials material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance[]>();
        //for (RegistryEntry<StatusEffectInstance> effectInstance: effectInstances) {
            temp.put(material, effectInstances.value());
        //}
        return temp;
    }

    /**
     * Helper method to create StatusEffectInstances
     * @param effect
     * @param duration
     * @param amp
     * @return
     */
    public static StatusEffectInstance statusEffect(StatusEffect effect, int duration, int amp) {
        return new StatusEffectInstance(RegistryEntry.of(effect), duration, amp);
    }
}
