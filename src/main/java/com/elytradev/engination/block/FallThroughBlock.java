package com.elytradev.engination.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FallThroughBlock extends DisappearingBlock {
	protected static ChainReactionType CHAINTYPE_FALL = new ChainReactionType();
	
	@Override
	public ChainReactionType getChainReactionType() {
		return CHAINTYPE_FALL;
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (world.isClient()) return;
		
		this.disappearChainHorizontal(world, pos);
	}

}
