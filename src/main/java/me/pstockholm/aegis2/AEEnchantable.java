package me.pstockholm.aegis2;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AEEnchantable extends Enchantment {
    public enum Level {
        Simple, // grey
        Unique, //green
        Elite, //blue
        Ultimate, //yellow
        Legendary, //orange
        Heroic, //purple
        Soul, //red
        Mastery,
    };
    public Boolean bEquipped = false;
    public Boolean bUseLeg = false, bUseFeet = false, bUseHead = false, bUseChest = false, bUseBow = false, bUseAxe = false, bUseSword = false, bUsePickaxe = false;
    public Boolean bCalledThisTick = false;
    public Boolean bHandleEntityMovement = false;
    public Boolean bHandleBlockDestruction = false;
    public Boolean bAccumulativeLevel = false;
    public Level kEnchantmentLevel = Level.Simple;
    public AEEnchantable(net.minecraft.enchantment.Enchantment.Rarity weight, net.minecraft.enchantment.EnchantmentTarget target, net.minecraft.entity.EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public Text getName(int level) {
        MutableText mutableText = Text.translatable(this.getTranslationKey());
        Formatting format = Formatting.GRAY;
        if (this.isCursed()) {
            mutableText.formatted(Formatting.RED);
        } else {
            switch (kEnchantmentLevel) {
                case Unique:
                    format = (Formatting.GREEN);
                    break;
                case Elite:
                    format = (Formatting.AQUA);
                    break;
                case Ultimate:
                    format = (Formatting.YELLOW);
                    break;
                case Legendary:
                    format = (Formatting.GOLD);
                    break;
                case Heroic:
                    format = (Formatting.LIGHT_PURPLE);
                    break;
                case Soul:
                    format = (Formatting.RED);
                    break;
                case Mastery:
                    format = (Formatting.BLUE);
                    break;
                default:
                case Simple:
                    format = (Formatting.GRAY);
                    break;
            };
        }

         mutableText.formatted(format);
        if (level != 1 || this.getMaxLevel() != 1) {
            mutableText.append(ScreenTexts.SPACE).append(Text.translatable("enchantment.level." + level).formatted(format));
        }
        return mutableText;
    }

    public void onUserTick(LivingEntity user, int level) {}
    public void onUserTick(PlayerEntity user, int level) {}
    public void onUserMove(LivingEntity user, int level, World world, BlockPos pos ) {}
    public void onBlockDestruction(LivingEntity user, int level, World world, BlockPos pos, BlockState state, BlockEntity entity) {}
    public void onEquip(LivingEntity user) {bEquipped = true;}
    public void onUnequip(LivingEntity user) {bEquipped = false;}

}