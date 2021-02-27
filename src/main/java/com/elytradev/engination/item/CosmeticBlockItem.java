package com.elytradev.engination.item;

import java.util.List;

import com.elytradev.engination.Grouped;
import com.elytradev.engination.block.EnginationBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
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
		
		if (world.isClient || !player.isSneaking()) return new TypedActionResult<>(ActionResult.PASS, existing);
		
		if (getBlock() instanceof Grouped) {
			String groupId = ((Grouped)getBlock()).getGroupId();
			ItemStack stack = EnginationBlocks.getNextItem(existing, groupId);
			if (stack!=null) {
				return new TypedActionResult<>(ActionResult.SUCCESS, stack);
			} else {
				System.out.println("NULL DEST?");
			}
		}
		return new TypedActionResult<>(ActionResult.PASS, existing);
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack_1, World world_1, List<Text> list, TooltipContext tooltipOptions_1) {
		list.add(new TranslatableText("tip.engination.sneak_use").formatted(Formatting.AQUA));
		super.appendTooltip(itemStack_1, world_1, list, tooltipOptions_1);
	}
}
