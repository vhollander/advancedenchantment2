package me.pstockholm.aegis2.utils;

import me.pstockholm.aegis2.AEEnchantable;
import me.pstockholm.aegis2.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class EnchantManager extends LivingEntity {
    protected EnchantManager(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
       
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        ItemStack itemStackHead = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack itemStackLegs = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack itemStackChest = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackFeet = this.getEquippedStack(EquipmentSlot.FEET);
        ItemStack itemStackHand = this.getEquippedStack(EquipmentSlot.MAINHAND);

        for(AEEnchantable Enchantment : Main.Enchants) {
            if (Enchantment.bAccumulativeLevel) {
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackFeet) + EnchantmentHelper.getLevel(Enchantment, itemStackHand)
                + EnchantmentHelper.getLevel(Enchantment, itemStackLegs) + EnchantmentHelper.getLevel(Enchantment, itemStackHead) + EnchantmentHelper.getLevel(Enchantment, itemStackChest));
                continue;
            }
            
            if(Enchantment.bUseFeet)
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackFeet));
            if(Enchantment.bUsePickaxe || Enchantment.bUseSword || Enchantment.bUseAxe)
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackHand));
            if(Enchantment.bUseLeg)
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackLegs));
            if(Enchantment.bUseHead)
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackHead));
            if(Enchantment.bUseChest)
                Enchantment.onUserTick(this, EnchantmentHelper.getLevel(Enchantment, itemStackChest));
        }

        
    }

    public void setRange(boolean change_range, int level) {

    }
}
