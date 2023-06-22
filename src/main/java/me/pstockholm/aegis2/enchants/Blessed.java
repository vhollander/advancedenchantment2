package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Blessed extends AEEnchantable {
    public Blessed() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        bUseAxe = true;
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
        return 4;
    }

    @Override
    public void onTargetDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        if ( MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 0) {
            ((LivingEntity)user).removeStatusEffect(StatusEffects.WITHER);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.WEAKNESS);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.POISON);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.INSTANT_DAMAGE);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.HUNGER);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.SLOWNESS);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.BLINDNESS);
            ((LivingEntity)user).removeStatusEffect(StatusEffects.MINING_FATIGUE);
        }
    }

    @Override
    public void onEquip(LivingEntity user) {
        super.onEquip(user);
    }

    @Override
    public void onUnequip(LivingEntity user) { 
        super.onUnequip(user);
    }

}
