package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import com.elytradev.engination.Grouped;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

public class CosmeticPillar extends PillarBlock implements Grouped {
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

	@Environment(EnvType.CLIENT)
	@Override
	public void appendTooltip(ItemStack stack, BlockView world, List<Text> var3, TooltipContext var4) {
		if (group!=null) {
			var3.add(Text.translatable("blockgroup.engination."+group+".tip").formatted(Formatting.ITALIC, Formatting.GRAY));
		}
		super.appendTooltip(stack, world, var3, var4);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, LootContext.Builder var2) {
		@SuppressWarnings("deprecation")
		List<ItemStack> superStacks = super.getDroppedStacks(var1, var2);
		if (!superStacks.isEmpty()) return superStacks;
		
		ArrayList<ItemStack> result = new ArrayList<>();
		result.add(new ItemStack(this, 1));
		return result;
	}
	
	//implements Grouped {
		@Override
		public String getGroupId() {
			return group;
		}
	//}
	
}
