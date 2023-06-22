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

public class Reaper extends AEEnchantable {
    public Reaper() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        bUseAxe = true;
        kEnchantmentLevel = Level.Elite;
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
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, level * 50, level, false, true, true));
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, (int)(level/3) * 50, 0, false, true, true));
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
