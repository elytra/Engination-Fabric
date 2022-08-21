package com.elytradev.engination.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HeldItemDisappearingBlock extends DisappearingBlock{
	public static final ChainReactionType CHAINTYPE_SWORD = new ChainReactionType();
	protected final ItemStack trigger;
	
	public HeldItemDisappearingBlock(ItemStack trigger) {
		this.trigger = trigger;
	}
	
	public boolean isTrigger(ItemStack stack) {
		if (stack.getItem()!=trigger.getItem()) return false;
		
		//If you supply a stack with non-empty tags, they must be equal. Otherwise ignore NBT.
		return ItemStack.areNbtEqual(trigger, stack);
	}
	
	@Override
	public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
		if (world.isClient()) return; 
		if (isTrigger(player.getStackInHand(Hand.MAIN_HAND))) {
			this.disappearChainReaction(world, pos);
		}
	}
	
	//@Override
	public ChainReactionType getChainReactionType() {
		return CHAINTYPE_SWORD;
	}
}
