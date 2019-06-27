package com.elytradev.engination.block;

import com.elytradev.engination.item.EnginationItems;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class TomatoBlock extends CropBlock {

	protected TomatoBlock(Settings block$Settings_1) {
		super(block$Settings_1);
		
	}
	
	@Environment(EnvType.CLIENT)
	protected ItemConvertible getSeedsItem() {
		return EnginationItems.TOMATO_SEEDS;
	}
}
