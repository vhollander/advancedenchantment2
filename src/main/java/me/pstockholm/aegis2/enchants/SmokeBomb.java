package me.pstockholm.aegis2.enchants;
import com.mojang.brigadier.ParseResults;

import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class SmokeBomb extends AEEnchantable {
    public SmokeBomb() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
        bUseHead = true;
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
       // if (user.getHealth() < user.getMaxHealth() * 0.4) {
            // Vec3d pos = user.getPos();
            // World world = user.getWorld();
            // double offsetX = 0.0;
            // double offsetY = 1.0;
            // double offsetZ = 0.0;

            // for (int x = -5; x < 5; x++) {
            // for (int y = -5; y < 5; y++) {
            // for (int z = -5; z < 5; z++) {
            //     x += pos.x;
            //     y += pos.y;
            //     z += pos.z;

            //     double motionX = world.random.nextGaussian() * 0.1;
            //     double motionY = world.random.nextDouble() * 0.02;
            //     double motionZ = world.random.nextGaussian() * 0.1;

            //     user.getWorld().getServer().getCommandManager().execute(new ParseResults<>(null, null, null), "/particle minecraft:smoke ~ ~1 ~ 0 0 0 0.1 100");
                // Adjust the offsets to create a scattered particle effect
                // offsetX = world.random.nextDouble() * 2 - 1;
                // offsetY = world.random.nextDouble() * 2 - 1;
                // offsetZ = world.random.nextDouble() * 2 - 1;
            //}}}
     //s   }
    }


}
