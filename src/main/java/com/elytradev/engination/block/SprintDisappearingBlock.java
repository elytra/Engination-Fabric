package com.elytradev.engination.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SprintDisappearingBlock extends DisappearingBlock {
	protected static ChainReactionType CHAINTYPE_SPEED = new ChainReactionType();
	
	@Override
	public ChainReactionType getChainReactionType() {
		return CHAINTYPE_SPEED;
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (world.isClient()) return;
		
		if (entity.isSprinting()) {
			this.disappearChainHorizontal(world, pos);
		}
	}
}
