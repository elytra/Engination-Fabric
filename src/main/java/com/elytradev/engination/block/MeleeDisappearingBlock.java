package com.elytradev.engination.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MeleeDisappearingBlock extends DisappearingBlock {
	public static final ChainReactionType CHAINTYPE_PUNCH = new ChainReactionType();
	
	@Override
	public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
		if (world.isClient()) return; 
		if (player.getStackInHand(Hand.MAIN).isEmpty()) {
			this.disappearChainReaction(world, pos);
		}
	}
	
	//@Override
	public ChainReactionType getChainReactionType() {
		return CHAINTYPE_PUNCH;
	}
}
