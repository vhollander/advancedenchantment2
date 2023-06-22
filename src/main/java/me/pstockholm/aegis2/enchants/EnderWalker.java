package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class EnderWalker extends AEEnchantable {
    public EnderWalker() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
        bUseFeet = true;
        kEnchantmentLevel = Level.Ultimate;
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

    public void onUserTick(LivingEntity user, int level) {
        if (level == 0)
            return;
        user.removeStatusEffect(StatusEffects.WITHER);
        user.removeStatusEffect(StatusEffects.POISON);
        if ( MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 0)
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5, 4 + 2 * level, true, false, false));

        super.onUserTick(user, level);
    }
}
