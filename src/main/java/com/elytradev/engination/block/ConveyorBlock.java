package com.elytradev.engination.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class ConveyorBlock extends PressureTriggeredBlock {
	public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
	protected double force;
	
	protected ConveyorBlock(double force) {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
		this.force = force;
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> var1) {
		var1.add(FACING);
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getPlayerFacing());
	}
	
	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return state.rotate(mirror.getRotation(state.get(FACING)));
	}
	
	@Override
	public void trigger(World world, BlockPos pos, LivingEntity entity) {
		Direction facing = world.getBlockState(pos).get(FACING);
		Vec3i vec = facing.getVector();
		Vec3d motion = new Vec3d(vec.getX()*force, vec.getY()*force, vec.getZ()*force);
		entity.move(MovementType.SELF, motion);
	}
}
