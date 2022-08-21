package com.elytradev.engination;

import com.elytradev.engination.block.EnginationBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class EnginationClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		for(Block block : EnginationBlocks.BLOCK_GROUPS.get("disappearing")) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
		}
		BlockRenderLayerMap.INSTANCE.putBlock(EnginationBlocks.TOMATO_PLANT, RenderLayer.getCutoutMipped());
	}
}
