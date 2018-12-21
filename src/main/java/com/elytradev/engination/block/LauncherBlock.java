package com.elytradev.engination.block;

import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LauncherBlock extends PressureTriggeredBlock {
	protected double force = 2.0;
	
	public LauncherBlock(double force) {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
		this.force = force;
	}
	/*
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, LootContext.Builder var2) {
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
	
	@Override
	public void onLandedUpon(World world, BlockPos pos, Entity entity, float var4) {
		if (entity instanceof PlayerEntity) {
			if (world.isClient()) launch(entity, world);
		} else {
			if (!world.isClient()) launch(entity, world);
		}
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, Entity entity) {
		if (entity instanceof PlayerEntity) {
			if (world.isClient()) launch(entity, world);
		} else {
			if (!world.isClient()) launch(entity, world);
		}
	}*/
	
	@Override
	public void onLandedUpon(World world, BlockPos pos, Entity entity, float var4) {
		entity.fallDistance = 0; //both sides, all entities
		super.onLandedUpon(world, pos, entity, var4);
	}
	
	@Override
	public void trigger(World world, BlockPos pos, LivingEntity entity) {
		double newY = adjustScalar(entity.velocityY, force*0.6);
		if (newY!=entity.velocityY) {
			entity.velocityY = newY;
			//TODO: Register the mario jump sound
			//world.playSound(entity.x, entity.y, entity.z, Engination.SOUND_LAUNCH, net.minecraft.sound.SoundCategory.PLAYER, 0.5F, world.getRandom().nextFloat() * 0.4F + 1.0F);
		}
	}
	
	private double adjustScalar(double in, double floor) {
		if (floor<0) {
			return (floor < in) ? floor : in;
		} else if (floor>0) {
			return (floor > in) ? floor : in;
		}
		
		return in;
	}
}
