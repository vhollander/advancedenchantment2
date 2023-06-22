package me.pstockholm.aegis2.enchants;

import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class UndeadRuse extends AEEnchantable {
    public UndeadRuse() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.CHEST, EquipmentSlot.FEET,EquipmentSlot.LEGS,EquipmentSlot.HEAD});
        bUseHead = true;
        bUseChest = true;
        bUseFeet = true;
        bUseLeg = true;
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
            if (!target.isAlive())
                return;
       // if (user.getHealth() < user.getMaxHealth() * 0.4) {
            // Vec3d pos = target.getPos();
            // World world = target.getWorld();

            // for (int x = -level; x < level; x++) {
            // for (int y = 0; y < level; y++) {
            // for (int z = -level; z < level; z++) {

            //     ZombieEntity zombie = EntityType.ZOMBIE.create(world);
            //     if (zombie != null) {
            //         try {
            //         zombie.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).addPersistentModifier(new EntityAttributeModifier("e", 1.5, EntityAttributeModifier.Operation.ADDITION));       
            //         } catch(IllegalArgumentException e) { }
            //         zombie.tryAttack(target);
            //         zombie.refreshPositionAndAngles(new BlockPos((int)pos.x + x,(int)pos.y + y,(int)pos.z + z), 0.0F, 0.0F);
            //         zombie.setTarget((LivingEntity)target);
            //         zombie.setAttacking(true);
            //         if(target.isPlayer())
            //             zombie.setAttacking((PlayerEntity)target);
            //         world.spawnEntity(zombie);

            //     // Apply additional effects or modifications to the spawned zombies if desired
            //     }
            // }}}
     //   }
    }


}
