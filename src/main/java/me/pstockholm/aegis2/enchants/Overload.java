package me.pstockholm.aegis2.enchants;
import java.util.UUID;

import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Overload extends AEEnchantable {
    public Overload() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.CHEST, EquipmentSlot.FEET,EquipmentSlot.LEGS,EquipmentSlot.HEAD});
        bUseHead = true;
        bUseChest = true;
        bUseFeet = true;
        bUseLeg = true;
        bAccumulativeLevel = true;
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

    public int iPrevLevel = 0;
    @Override
    public void onUserTick(net.minecraft.entity.LivingEntity user, int level) {
        if (level != iPrevLevel ) {
            user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).tryRemoveModifier(UUID.fromString("40845832-e642-4347-b489-23c41eff37ad"));
            if (level == 0)
                return;
        }
        try{
            user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addPersistentModifier(new EntityAttributeModifier(UUID.fromString("40845832-e642-4347-b489-23c41eff37ad"), "thisnamedosentmatter", level*10, EntityAttributeModifier.Operation.ADDITION));
        } catch(IllegalArgumentException e) {

        }
        iPrevLevel = level;
        super.onUserTick(user, level);
    }


}
