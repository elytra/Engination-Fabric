package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import com.elytradev.engination.Grouped;
import com.elytradev.engination.StringOps;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext.Builder;

public class CosmeticBlock extends Block implements Grouped {
	protected String group = null;
	
	public CosmeticBlock(Material material, DyeColor color, String group) {
		this(material, color);
		this.group = group;
	}
	
	public CosmeticBlock(Material material, DyeColor color) {
		super(Settings.of(material, color)
				.strength(1.0f, 15.0f)
				);
	}
	
	public CosmeticBlock(Settings settings, String group) {
		super(settings);
		this.group = group;
	}
		
	@Environment(EnvType.CLIENT)
	@Override
	public void buildTooltip(ItemStack var1, BlockView var2, List<Text> var3, TooltipContext var4) {
		if (group!=null) {
			String key = "blockgroup.engination."+group+".tip";
			List<String> localized = StringOps.wordWrap(StringOps.localize(key), 36);
			for(String s : localized) {
				var3.add(new LiteralText(s).formatted(Formatting.GRAY, Formatting.ITALIC));
			}
		}
		super.buildTooltip(var1, var2, var3, var4);
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState var1, Builder var2) {
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
