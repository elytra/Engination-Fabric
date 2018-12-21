package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.loot.context.LootContext;

public abstract class PressureTriggeredBlock extends Block {

	public PressureTriggeredBlock(Settings var1) {
		super(var1);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, LootContext.Builder var2) {
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
	
	@Override
	public void onLandedUpon(World world, BlockPos pos, Entity entity, float var4) {
		if (!(entity instanceof LivingEntity)) return;
		if (entity instanceof PlayerEntity) {
			if (world.isClient()) trigger(world, pos, (LivingEntity)entity);
		} else {
			if (!world.isClient()) trigger(world, pos, (LivingEntity)entity);
		}
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, Entity entity) {
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
