package com.elytradev.engination.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandingPadBlock extends Block {

	public LandingPadBlock() {
		super(Settings.of(Material.METAL, DyeColor.WHITE).strength(1, 15));
	}

	@Override
	public void onLandedUpon(World var1, BlockPos var2, Entity var3, float var4) {
		var3.fallDistance = 0;
	}

}
