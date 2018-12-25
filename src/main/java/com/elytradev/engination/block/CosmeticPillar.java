package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext.Builder;

public class CosmeticPillar extends PillarBlock {
	protected String group = null;
	
	public CosmeticPillar(Material material, DyeColor color, String group) {
		this(material, color);
		this.group = group;
	}
	
	public CosmeticPillar(Material material, DyeColor color) {
		super(Settings.of(material, color)
				.strength(1.0f, 15.0f)
				);
	}

	@Override
	public void addInformation(ItemStack var1, BlockView var2, List<TextComponent> var3, TooltipOptions var4) {
		if (group!=null) {
			var3.add(new TranslatableTextComponent("blockgroup.engination."+group+".tip").applyFormat(TextFormat.ITALIC, TextFormat.GRAY));
		}
		super.addInformation(var1, var2, var3, var4);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, Builder var2) {
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
	
}
