package me.pstockholm.aegis2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.pstockholm.aegis2.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Mixin(Block.class)
public class SmeltManager {

    

    @Inject(at = @At("RETURN"), cancellable = true, method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;")
	private static void getDrops(BlockState state, ServerWorld world, BlockPos pos,
			/* @Nullable */ BlockEntity blockEntity, /* @Nullable */ Entity entity, ItemStack stack,
			CallbackInfoReturnable<List<ItemStack>> info) {

		// Make sure a player broke the block
		if (entity == null || !(entity instanceof PlayerEntity)) {
			return;
		}

		final PlayerEntity player = (PlayerEntity) entity;

		final ItemStack tool = player.getMainHandStack();

		// Check if the tool is correct for the block
		// e.g. pickaxes and stone, axes and wood
		if (!tool.isSuitableFor(state)) {
			return;
		}

		final Map<Enchantment, Integer> enchants = EnchantmentHelper.get(tool);

		// Check if tool has the enchantment
		if (!enchants.containsKey(Main.Enchants[6])) {
			return;
		}

		// The new drops, if any
		List<ItemStack> newDrops = new ArrayList<>();
	     Optional<SmeltingRecipe> recipe = world.getServer().getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(new ItemStack(state.getBlock().asItem())), player.getWorld());
		if(recipe.orElse(null) != null) {
		    newDrops.add(recipe.orElse(null).getOutput(world.getRegistryManager()).copy());
        }
        else 
           return;
		if (newDrops.size() > 0) {

			// Change the return value
			info.setReturnValue(newDrops);
		}

	}



}
