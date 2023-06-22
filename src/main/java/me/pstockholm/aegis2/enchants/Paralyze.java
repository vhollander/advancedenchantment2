package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Paralyze extends AEEnchantable {
    public Paralyze() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        bUseSword = true;
        kEnchantmentLevel = Level.Elite;
    }

    public int getMinPower(int level) {
        return level * 10;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }


    public int getMaxLevel() {
        return 4;
    }

    @Override
    public void onTargetDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        if ( MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 0) {
            LightningEntity lighting = new LightningEntity(EntityType.LIGHTNING_BOLT, target.getWorld());
            user.getWorld().spawnEntity(lighting);
            lighting.setPos(target.getX(), target.getY(), target.getZ());
            ((LivingEntity)user).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, level * 100, level, false, true, true));
            ((LivingEntity)user).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, (int)(level/3) * 1000, 0, false, true, true));
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
