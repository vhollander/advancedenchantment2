package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Glowing extends AEEnchantable {
    public Glowing() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
        bUseHead = true;
        bCalledThisTick = true;
        kEnchantmentLevel = Level.Simple;
    }

    public int getMinPower(int level) {
        return level * 10;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }


    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onEquip(LivingEntity user) {
        super.onEquip(user);
    }

    @Override
    public void onUnequip(LivingEntity user) { 
        super.onUnequip(user);
    }

    public void onUserTick(LivingEntity user, int level) {
        
        if (level == 0) {
            if (!bCalledThisTick) {
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);
                bCalledThisTick = true;
            }
            
        }
        else
            bCalledThisTick = false;

        if (bCalledThisTick)
            return;

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000, 0, true, false, false));
        super.onUserTick(user, level);
    }
}
