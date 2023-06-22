package me.pstockholm.aegis2.utils;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.pstockholm.aegis2.AEEnchantable;
import me.pstockholm.aegis2.Main;

@Mixin(LivingEntity.class)
public class PlayerMovement {



    @Inject(method = "canWalkOnFluid", at = @At("HEAD"), cancellable = true)
    private void canWalkOnFluid(FluidState state, CallbackInfoReturnable<Boolean> ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (EnchantmentHelper.getLevel(Main.Enchants[42], livingEntity.getEquippedStack(EquipmentSlot.FEET)) > 0 && state.getFluid() == Fluids.LAVA) {
            ci.setReturnValue(true);
            ci.cancel();
        }
    }

    @Inject(method = "applyMovementEffects", at = @At("HEAD"))
    private void applyMovementEffects(BlockPos blockPos, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStackHead = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack itemStackLegs = livingEntity.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack itemStackChest = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackFeet = livingEntity.getEquippedStack(EquipmentSlot.FEET);
        ItemStack itemStackHand = livingEntity.getEquippedStack(EquipmentSlot.MAINHAND);
        
          for(AEEnchantable Enchantment : Main.Enchants) {
                if (!Enchantment.bHandleEntityMovement)
                    continue;
            
                if (EnchantmentHelper.getLevel(Enchantment, itemStackFeet) > 0 && Enchantment.bUseFeet) 
                    Enchantment.onUserMove(livingEntity, EnchantmentHelper.getLevel(Enchantment, itemStackFeet), livingEntity.getWorld(), blockPos );
                if (EnchantmentHelper.getLevel(Enchantment, itemStackHand) > 0  && Enchantment.bUseSword) 
                    Enchantment.onUserMove(livingEntity, EnchantmentHelper.getLevel(Enchantment, itemStackHand), livingEntity.getWorld(), blockPos );
                if (EnchantmentHelper.getLevel(Enchantment, itemStackLegs) > 0  && Enchantment.bUseLeg) 
                    Enchantment.onUserMove(livingEntity, EnchantmentHelper.getLevel(Enchantment, itemStackLegs), livingEntity.getWorld(), blockPos );
                if (EnchantmentHelper.getLevel(Enchantment, itemStackHead) > 0  && Enchantment.bUseHead) 
                    Enchantment.onUserMove(livingEntity, EnchantmentHelper.getLevel(Enchantment, itemStackHead), livingEntity.getWorld(), blockPos );
                if (EnchantmentHelper.getLevel(Enchantment, itemStackChest) > 0 && Enchantment.bUseChest) 
                    Enchantment.onUserMove(livingEntity, EnchantmentHelper.getLevel(Enchantment, itemStackChest), livingEntity.getWorld(), blockPos );
            }
    }
}
