package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SwordItem;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Valor extends AEEnchantable {
    private int iProtectionAmount = 0;
    public Valor() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.CHEST, EquipmentSlot.FEET,EquipmentSlot.LEGS,EquipmentSlot.HEAD});
        bUseHead = true;
        bUseChest = true;
        bUseFeet = true;
        bUseLeg = true;
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

    @Override
    public int getProtectionAmount(int level, net.minecraft.entity.damage.DamageSource source) { 

        return iProtectionAmount;
    }

    @Override
    public void onUserDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        iProtectionAmount = 0;
        if (user.getActiveItem().getItem() instanceof SwordItem) {
            iProtectionAmount = 22 / ((getMaxLevel() + 1)-level);
        }   
    }

}
