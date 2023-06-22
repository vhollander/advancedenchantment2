package me.pstockholm.aegis2.enchants;
import java.util.List;

import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Pummel extends AEEnchantable {
    public Pummel() {
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
    public void onTargetDamaged(net.minecraft.entity.LivingEntity user, net.minecraft.entity.Entity target, int level) {
        if ( MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 0) { // Get the player's position
            double playerX = user.getX();
            double playerY = user.getY();
            double playerZ = user.getZ();
            
            // Create a bounding box around the player with the specified range
            Box playerBox = new Box(playerX - level*2, playerY - level*2, playerZ - level*2,
                    playerX + level*2, playerY + level*2, playerZ + level*2);
            
            // Iterate over all entities within the player's range
            ServerWorld world = user.getServer().getWorld(user.getWorld().getRegistryKey());
            List<Entity> entities = world.getEntitiesByClass(Entity.class, playerBox, entity -> entity instanceof LivingEntity);
            for (Entity entity : entities) 
                if(entity.isLiving() && entity.getUuid() != user.getUuid())
                    ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, level * 500, 0, false, true, true));
            
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
