package me.pstockholm.aegis2.enchants;
import me.pstockholm.aegis2.AEEnchantable;
import me.pstockholm.aegis2.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

// Rarity.COMMON = Simple, Unique
// Rarity.UNCOMMON = Elite
// Rarity.RARE = Ultimate
// Rarity.VERY_RARE = Legendary, Heroic (shares same slot for now)

public class Experience extends AEEnchantable {
    public Experience() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        bUsePickaxe = true;
        bHandleBlockDestruction = true;
        kEnchantmentLevel = Level.Simple;
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
    public void onEquip(LivingEntity user) {
        super.onEquip(user);
    }

    @Override
    public void onUnequip(LivingEntity user) { 
        super.onUnequip(user);
    }

    @Override
    public void onBlockDestruction(LivingEntity user, int level, World world, BlockPos blockpos, BlockState blockstate, BlockEntity blockentity) {
        if(  MathHelper.nextInt(user.getWorld().getRandom(), 0, 10 / level ) == 1)
           // if(blockstate.isToolRequired() && ((ToolItem)user.getActiveItem().getItem()).isSuitableFor(blockstate))
                user.getWorld().spawnEntity(new ExperienceOrbEntity(world, blockpos.getX(),blockpos.getY(), blockpos.getZ(), EnchantmentHelper.getLevel(Main.Enchants[4], user.getMainHandStack())));
    }

}
