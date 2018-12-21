package com.elytradev.engination.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class ConveyorBlock extends PressureTriggeredBlock {
	public static DirectionProperty FACING = Properties.FACING_HORIZONTAL;
	protected double force = 2.0;
	
	protected ConveyorBlock(double force) {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
		this.force = force;
	}
	
	@Override
	protected void appendProperties(StateFactory.Builder<Block, BlockState> var1) {
		var1.with(FACING);
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getPlayerHorizontalFacing());
	}
	
	@Override
	public BlockState applyRotation(BlockState state, Rotation rotation) {
		return state.with(FACING, rotation.method_10503(state.get(FACING)));
	}
	
	@Override
	public BlockState applyMirror(BlockState state, Mirror mirror) {
		return state.applyRotation(mirror.getRotation(state.get(FACING)));
	}
	
	@Override
	public void trigger(World world, BlockPos pos, LivingEntity entity) {
		Direction facing = world.getBlockState(pos).get(FACING);
		Vec3i vec = facing.getVector();
		Vec3d motion = new Vec3d(vec.getX()*force, vec.getY()*force, vec.getZ()*force);
		
		entity.velocityX = adjustScalar(entity.velocityX, motion.x);
		entity.velocityY = adjustScalar(entity.velocityY, motion.y);
		entity.velocityZ = adjustScalar(entity.velocityZ, motion.z);
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
