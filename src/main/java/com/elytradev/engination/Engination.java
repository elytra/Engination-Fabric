package com.elytradev.engination;

import com.elytradev.engination.block.EnginationBlocks;

import net.fabricmc.api.ModInitializer;

public class Engination implements ModInitializer {
	@Override
	public void onInitialize() {
		// Proceeding with mild caution.
		
		EnginationBlocks.init();
	}
}
