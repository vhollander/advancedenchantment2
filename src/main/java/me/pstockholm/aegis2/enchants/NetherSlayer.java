package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.MathHelper;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class NetherSlayer extends AEEnchantable {
    public NetherSlayer() {
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
        return 5;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return 0.0f;
    }

    @Override
    public void onTargetDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
      if ( MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 0) 
        if (target.isAlive() && target.getType() == EntityType.BLAZE || target.getType() == EntityType.ZOMBIFIED_PIGLIN || target.getType() == EntityType.PIGLIN) {      
            target.damage(target.getDamageSources().playerAttack((PlayerEntity)user),  ((SwordItem)user.getMainHandStack().getItem()).getAttackDamage());
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
