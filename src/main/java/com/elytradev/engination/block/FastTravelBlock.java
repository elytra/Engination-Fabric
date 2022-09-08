package com.elytradev.engination.block;

import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FastTravelBlock extends PressureTriggeredBlock {
	protected float travelForce = 0.2f;
	
	public FastTravelBlock(float force) {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
		travelForce = force;
	}
	
	@Override
	public void trigger(World world, BlockPos pos, LivingEntity entity) {
		if (world.isClient()) {
			if (entity.isSprinting()) {
				Vec3d toAdd = entity.getVelocity().normalize().multiply(travelForce);
				entity.addVelocity(toAdd.x, toAdd.y, toAdd.z);
			}
		}
	}
	
}
