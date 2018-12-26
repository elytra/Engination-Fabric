package com.elytradev.engination.item;

import java.util.List;

import com.elytradev.engination.Grouped;
import com.elytradev.engination.block.EnginationBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.block.BlockItem;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CosmeticBlockItem extends BlockItem {
	public CosmeticBlockItem(Block block, Settings settings) {
		super(block, settings);
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack existing = player.getStackInHand(hand);
		
		if (world.isClient || !player.isSneaking()) return new TypedActionResult<ItemStack>(ActionResult.PASS, existing);
		
		if (getBlock() instanceof Grouped) {
			String groupId = ((Grouped)getBlock()).getGroupId();
			ItemStack stack = EnginationBlocks.getNextItem(existing, groupId);
			if (stack!=null) {
				return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, stack);
			} else {
				System.out.println("NULL DEST?");
			}
		}
		return new TypedActionResult<ItemStack>(ActionResult.PASS, existing);
	}
	
	@Override
	public void buildTooltip(ItemStack itemStack_1, World world_1, List<TextComponent> list, TooltipOptions tooltipOptions_1) {
		list.add(new TranslatableTextComponent("tip.engination.sneak_use").applyFormat(TextFormat.AQUA));
		super.buildTooltip(itemStack_1, world_1, list, tooltipOptions_1);
	}
}
