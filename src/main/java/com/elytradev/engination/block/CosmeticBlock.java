package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import com.elytradev.engination.StringOps;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.item.ItemStack;
import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext.Builder;

public class CosmeticBlock extends Block {
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
	public void addInformation(ItemStack var1, BlockView var2, List<TextComponent> var3, TooltipOptions var4) {
		if (group!=null) {
			String key = "blockgroup.engination."+group+".tip";
			List<String> localized = StringOps.wordWrap(StringOps.localize(key), 36);
			for(String s : localized) {
				var3.add(new StringTextComponent(s).applyFormat(TextFormat.GRAY, TextFormat.ITALIC));
			}
			//var3.add(new TranslatableTextComponent("blockgroup.engination."+group+".tip").applyFormat(TextFormat.ITALIC, TextFormat.GRAY));
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
