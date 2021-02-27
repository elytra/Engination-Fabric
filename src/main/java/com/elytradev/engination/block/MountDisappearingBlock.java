package com.elytradev.engination.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.JumpingMount;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MountDisappearingBlock extends DisappearingBlock {
	public static ChainReactionType CHAINTYPE_MOUNT = new ChainReactionType();
	protected final boolean alive;
	
	
	public MountDisappearingBlock(boolean alive) {
		this.alive = alive;
	}
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		evaluateDisappear(state, world, pos, entity);
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, Entity entity) {
		evaluateDisappear(world.getBlockState(pos), world, pos, entity);
	}
	
	public void evaluateDisappear(BlockState state, World world, BlockPos pos, Entity entity) {
		if (world.isClient || !state.contains(DISAPPEARED) || state.get(DISAPPEARED)==true) return;
		
		if (entity instanceof PlayerEntity) return;
		
		if (alive) {
			//In the case of a living entity trigger, the entity *must* be currently ridden to activate.
			//Any nonliving/robotic entity that can narrowly classify as JumpingMount will also qualify.
			if ((entity instanceof LivingEntity || entity instanceof JumpingMount) && entity.hasPassengers()) {
				this.disappearChainHorizontal(world, pos);
			}
		} else {
			//any nonliving entity that is capable of being ridden should trigger disappearance.
			if (entity instanceof AbstractMinecartEntity || entity instanceof BoatEntity) {
				this.disappearChainHorizontal(world, pos);
			}
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext relativePosition) {
		if (state.get(DISAPPEARED)) {
			return VoxelShapes.empty();
		} else {
			//return VoxelShapes.cube(0.01, 0.01, 0.01, 0.99, 0.99, 0.99);
			return VoxelShapes.cuboid(0.005, 0.005, 0.005, 0.995, 0.995, 0.995);
			//return VoxelShapes.fullCube();
		}
	}
	
	@Override
	public ChainReactionType getChainReactionType() {
		return CHAINTYPE_MOUNT;
	}

}
