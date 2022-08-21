package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class PressureTriggeredBlock extends Block {

	public PressureTriggeredBlock(Settings var1) {
		super(var1);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, LootContext.Builder var2) {
		@SuppressWarnings("deprecation")
		List<ItemStack> superStacks = super.getDroppedStacks(var1, var2);
		if (!superStacks.isEmpty()) return superStacks;
		
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
	
	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (!(entity instanceof LivingEntity)) return;
		if (entity instanceof PlayerEntity) {
			if (world.isClient()) trigger(world, pos, (LivingEntity)entity);
		} else {
			if (!world.isClient()) trigger(world, pos, (LivingEntity)entity);
		}
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (!(entity instanceof LivingEntity)) return;
		if (entity instanceof PlayerEntity) {
			if (world.isClient()) trigger(world, pos, (LivingEntity)entity);
		} else {
			if (!world.isClient()) trigger(world, pos, (LivingEntity)entity);
		}
	}
	
	/**
	 * Called clientside for players and serverside for any other LivingEntity. 
	 */
	public abstract void trigger(World world, BlockPos pos, LivingEntity entity);
}
