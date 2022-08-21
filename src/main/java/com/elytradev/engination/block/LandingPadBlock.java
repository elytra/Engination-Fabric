package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandingPadBlock extends Block {

	public LandingPadBlock() {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
	}

	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		entity.fallDistance = 0;
	}

	@Override
	public List<ItemStack> getDroppedStacks(BlockState blockState_1, LootContext.Builder lootContext$Builder_1) {
		@SuppressWarnings("deprecation")
		List<ItemStack> superStacks = super.getDroppedStacks(blockState_1, lootContext$Builder_1);
		if (!superStacks.isEmpty()) return superStacks;
		
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
}
