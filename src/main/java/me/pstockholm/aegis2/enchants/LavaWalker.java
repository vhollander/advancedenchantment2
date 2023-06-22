package me.pstockholm.aegis2.enchants;

import me.pstockholm.aegis2.AEEnchantable;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class LavaWalker extends AEEnchantable {
    public LavaWalker() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
        bUseFeet = true;
        bHandleEntityMovement = true;
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
        return 1;
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
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
       

    }
    public void onUserTick(LivingEntity user, int level) {
        if (level <= 0)
             return;

        if ((user.isInLava() || user.isOnFire())) {
            // Apply custom behavior for lava damage
            user.extinguish();
            // Add fire resistance effect to the user
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 0, true, false ,false));
            

            // Extinguish the target entity if it is on fire
            if (user.isOnFire()) 
                user.setOnFire(false);
            

            // Additional custom behavior for lava damage...
        }

        // World world = user.getWorld();
        // BlockPos pos = user.getBlockPos().down(2);
        // BlockPos.Mutable mutable = new BlockPos.Mutable();

        // mutable.set(pos.getX(), pos.getY() + 1, pos.getZ());
        // BlockState blockState2 = world.getBlockState(mutable);

        // if (blockState2.isAir()) {
        //     Block block = blockState2.getBlock();
        //     if (blockState2.isOf(Blocks.LAVA) && block instanceof FluidBlock) {
        //         user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 0, true, false, false));
        //         user.setOnFire(false);
        //     }
        // }

    }

    @Override
    public void onUserMove(LivingEntity user, int level, World world, BlockPos pos ) {



    //   //  if (user.isOnGround()) {
    //         BlockState blockState = Blocks.OBSIDIAN.getDefaultState();
    //         int f = Math.min(16, 2 + level);
    //         BlockPos.Mutable mutable = new BlockPos.Mutable();

    //         for (BlockPos blockPos2 : BlockPos.iterate(pos.add(-f, -1, -f), pos.add(f, -1, f))) {
    //             if (blockPos2.isWithinDistance(user.getPos(), f)) {
    //                 mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
    //                 BlockState blockState2 = world.getBlockState(mutable);
    //                 if (blockState2.isAir()) {
    //                     BlockState blockState3 = world.getBlockState(blockPos2);
    //                     Block block = blockState3.getBlock();
    //                     if (blockState3.isOf(Blocks.LAVA) && block instanceof FluidBlock && blockState3.get(FluidBlock.LEVEL) == 0 && blockState.canPlaceAt(world, blockPos2) && world.canPlace(blockState, blockPos2, ShapeContext.absent())) {


    //                     }
    //                 }
    //             }
    //         }
      //  }

    }
    
}
