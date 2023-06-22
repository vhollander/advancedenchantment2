package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.SwordItem;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Insanity extends AEEnchantable {
    public Insanity() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        bUseAxe = true;
        bUseSword = true;
        kEnchantmentLevel = Level.Legendary;
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
        return 6;
    }

    @Override
    public void onTargetDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        if (target.isLiving())
            if (((LivingEntity)target).getActiveItem().getItem() instanceof SwordItem) {
                ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, level, false, true, true));
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
