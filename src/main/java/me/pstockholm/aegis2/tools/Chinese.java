package me.pstockholm.aegis2.tools;

import me.pstockholm.aegis2.AEEnchantable;
import me.pstockholm.aegis2.Main;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class Chinese {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, blockpos, block, entity) -> {
            ItemStack itemStackHead = player.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack itemStackLegs = player.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack itemStackChest = player.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack itemStackFeet = player.getEquippedStack(EquipmentSlot.FEET);
            ItemStack itemStackHand = player.getEquippedStack(EquipmentSlot.MAINHAND);
    
            for(AEEnchantable Enchantment : Main.Enchants) {
                if (!Enchantment.bHandleBlockDestruction)
                    continue;

                if (EnchantmentHelper.getLevel(Enchantment, itemStackFeet) > 0 && Enchantment.bUseFeet) 
                    Enchantment.onBlockDestruction(player, EnchantmentHelper.getLevel(Enchantment, itemStackFeet), world, blockpos, block, entity);
                if (EnchantmentHelper.getLevel(Enchantment, itemStackHand) > 0  && (Enchantment.bUsePickaxe || Enchantment.bUseAxe)) 
                    Enchantment.onBlockDestruction(player, EnchantmentHelper.getLevel(Enchantment, itemStackHand), world, blockpos, block, entity);
                if (EnchantmentHelper.getLevel(Enchantment, itemStackLegs) > 0  && Enchantment.bUseLeg) 
                    Enchantment.onBlockDestruction(player, EnchantmentHelper.getLevel(Enchantment, itemStackLegs), world, blockpos, block, entity);
                if (EnchantmentHelper.getLevel(Enchantment, itemStackHead) > 0  && Enchantment.bUseHead) 
                    Enchantment.onBlockDestruction(player, EnchantmentHelper.getLevel(Enchantment, itemStackHead), world, blockpos, block, entity);
                if (EnchantmentHelper.getLevel(Enchantment, itemStackChest) > 0 && Enchantment.bUseChest) 
                    Enchantment.onBlockDestruction(player, EnchantmentHelper.getLevel(Enchantment, itemStackChest), world, blockpos, block, entity);
            }

            
        });

        
    }
}
