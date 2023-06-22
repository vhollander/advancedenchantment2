package me.pstockholm.aegis2.utils;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.pstockholm.aegis2.Main;

@Mixin(Entity.class)
public class GodDrinksJava {
    @Inject(method = "net.minecraft.entity.LivingEntity.setOnFireFromLava", at = @At("RETURN"), cancellable =  true)
    private void isFireImmune(CallbackInfoReturnable<Boolean> ci) {
            LivingEntity livingEntity = (LivingEntity) (Object) this;

            if (EnchantmentHelper.getLevel(Main.Enchants[42], livingEntity.getEquippedStack(EquipmentSlot.FEET)) > 0 && livingEntity.canWalkOnFluid(Fluids.LAVA.getDefaultState())) {
                ci.setReturnValue(true);
                ci.cancel();
            }
        }
    
}
