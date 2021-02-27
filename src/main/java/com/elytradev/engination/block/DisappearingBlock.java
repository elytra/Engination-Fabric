package com.elytradev.engination.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.*;

public abstract class DisappearingBlock extends Block {
	public static final BooleanProperty DISAPPEARED = BooleanProperty.of("disappeared");
	
	public static int DELAY_REAPPEAR = 20 * 5;
	public static int DISAPPEAR_CHAIN_MAX = 16;
	public static final int FLAGS = 2;
	public static final ChainReactionType CHAINTYPE_NONE = new ChainReactionType();
	
	public DisappearingBlock() {
		super(
				FabricBlockSettings.of(Material.METAL)
				.materialColor(DyeColor.WHITE)
				.hardness(1)
				.resistance(15)
				.build()
				);
		
		this.setDefaultState(this.stateManager.getDefaultState().with(DISAPPEARED, false));
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(DISAPPEARED);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, LootContext.Builder var2) {
		List<ItemStack> superStacks = super.getDroppedStacks(var1, var2);
		if (!superStacks.isEmpty()) return superStacks;
		
		List<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this));
		return result;
	}
	
	@Override
	public boolean hasDynamicBounds() {
		return true;
	}
	
	
	/*
	@Override
	public boolean canCollideWith(BlockState state) {
		return !state.get(DISAPPEARED);
	}*/

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext relativePosition) {
		if (state.get(DISAPPEARED)) {
			return VoxelShapes.empty();
		} else {
			return VoxelShapes.fullCube();
		}
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		
		world.setBlockState(pos, state.with(DISAPPEARED, false), FLAGS);
	}
	
	public void disappear(World world, BlockPos pos) {
		disappearInternal(world, pos);
		//TODO: Register a "pop" sound and play it here.
	}
	
	public void disappearChainReaction(World world, BlockPos pos) {
		if (getChainReactionType()==CHAINTYPE_NONE) {
			disappear(world,pos);
			return;
		}
		
		HashSet<BlockPos> flood = new HashSet<>();
		chainToFull(world, pos, getChainReactionType(), 0, flood);
		
		for(BlockPos cur : flood) {
			disappearInternal(world, cur);
		}
	}
	
	public void disappearChainHorizontal(World world, BlockPos pos) {
		if (getChainReactionType()==CHAINTYPE_NONE) {
			disappear(world,pos);
			return;
		}
		
		HashSet<BlockPos> flood = new HashSet<>();
		chainToHorizontal(world, pos, getChainReactionType(), 0, flood);
		
		for(BlockPos cur : flood) {
			disappearInternal(world, cur);
		}
	}
	
	private static void chainToHorizontal(World world, BlockPos pos, ChainReactionType sourceChainType, int depth, Set<BlockPos> set) {
		if (set.contains(pos)) return;
		BlockState targetBlockState = world.getBlockState(pos);
		if (targetBlockState.getBlock() instanceof DisappearingBlock) {
			ChainReactionType targetChainType = ((DisappearingBlock)targetBlockState.getBlock()).getChainReactionType();
			if (sourceChainType==targetChainType) set.add(pos);
			if (depth<DISAPPEAR_CHAIN_MAX) {
				chainToFull(world, pos.north(), sourceChainType, depth+1, set);
				chainToFull(world, pos.east(), sourceChainType, depth+1, set);
				chainToFull(world, pos.south(), sourceChainType, depth+1, set);
				chainToFull(world, pos.west(), sourceChainType, depth+1, set);
			}
		}
	}
	
	private static void chainToFull(World world, BlockPos pos, ChainReactionType sourceChainType, int depth, Set<BlockPos> set) {
		if (set.contains(pos)) return;
		BlockState targetBlockState = world.getBlockState(pos);
		if (targetBlockState.getBlock() instanceof DisappearingBlock) {
			ChainReactionType targetChainType = ((DisappearingBlock)targetBlockState.getBlock()).getChainReactionType();
			if (sourceChainType==targetChainType) set.add(pos);
			if (depth<DISAPPEAR_CHAIN_MAX) {
				chainToFull(world, pos.north(), sourceChainType, depth+1, set);
				chainToFull(world, pos.east(), sourceChainType, depth+1, set);
				chainToFull(world, pos.south(), sourceChainType, depth+1, set);
				chainToFull(world, pos.west(), sourceChainType, depth+1, set);
				if (pos.getY()<world.getHeight()-1) chainToFull(world, pos.up(), sourceChainType, depth+1, set);
				if (pos.getY()>0) chainToFull(world, pos.down(), sourceChainType, depth+1, set);
			}
		}
	}
	
	protected void disappearInternal(World world, BlockPos pos) {
		BlockState curState = world.getBlockState(pos);
		if (!curState.contains(DISAPPEARED)) return;
		if (curState.get(DISAPPEARED)) return;
		
		world.setBlockState(pos, curState.with(DISAPPEARED, true), FLAGS);
		world.getBlockTickScheduler().schedule(pos, this, getTickRate(world), TickPriority.LOW);
	}
	
//	@Override
	public int getTickRate(WorldView world) {
		return DELAY_REAPPEAR;
	}
	
	public abstract ChainReactionType getChainReactionType();
	
	/**
	 * Tagging class for chain reaction IDs. For blocks to chain-react together, their chaintypes must be equal (==).
	 * 
	 * Before this system, I was using obnoxious magic numbers like 0x57ABB3D and 0xC0DE_404. Don't do that, it's bad.
	 *
	 */
	public static class ChainReactionType {}
}
