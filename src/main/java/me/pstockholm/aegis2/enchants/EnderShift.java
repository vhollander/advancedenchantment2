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

public class EnderShift extends AEEnchantable {
    public EnderShift() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.FEET,EquipmentSlot.HEAD});
        bUseFeet = true;
        bUseHead = true;
        kEnchantmentLevel = Level.Unique;
    }

    public int getMinPower(int level) {
        return level * 10;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    public boolean isTreasure() {
        return true;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onEquip(LivingEntity user) {
        super.onEquip(user);
    }

    @Override
    public void onUnequip(LivingEntity user) { 
        super.onUnequip(user);
    }

    @Override
    public void onUserDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        if (user.getHealth() < user.getMaxHealth() * 0.4) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, level * 50, level - 1, true, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, level * 50, level - 1, true, false, false));
        }
    }

}
