package com.elytradev.engination;

import com.elytradev.engination.block.EnginationBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class EnginationClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
				EnginationBlocks.BLOCK_GROUPS.get("disappearing").toArray(new Block[0]));
	}
}
