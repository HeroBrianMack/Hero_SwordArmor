package net.hero.swordarmor.item.custom;

import net.hero.swordarmor.item.ModMaterials;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Effects {

    /**
     * The method to assign a status effect to a tool.
     * @param effect
     * @param duration
     * @param amp
     * @param material
     * @return
     */
    public static Map effectMake(StatusEffect effect, int duration, int amp, ModMaterials material) {
        Map temp = new HashMap<ModMaterials, StatusEffectInstance>();
                temp.put(material, new StatusEffectInstance(effect, duration, amp));
        return temp;
    }

    public static Map effectMake(StatusEffect[] effects, int duration, int amp, ModMaterials material) {
        for (StatusEffect effect: effects) {
            Map temp = new HashMap<ModMaterials, StatusEffectInstance>();
            temp.put(material, new StatusEffectInstance(effect, duration, amp));
            return temp;
        }
        return null;
    }

    /**
     * The method to assign a status effect to an armor.
     * @param effect
     * @param duration
     * @param amp
     * @param material
     * @return
     */
    public static void listAdd(ArrayList<Map> mapList, Map map) {

        mapList.add(map);
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

    public static void allEffectsMake() {

    }


}
