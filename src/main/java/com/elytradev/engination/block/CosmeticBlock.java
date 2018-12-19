/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Isaac Ellingson (Falkreon)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Language;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext.Builder;

public class CosmeticBlock extends Block {
	protected String group = null;
	//public static IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 15);
	//private boolean showTip = false;
	
	public CosmeticBlock(Material material, DyeColor color, String group) {
		this(material, color);
		this.group = group;
	}
	
	public CosmeticBlock(Material material, DyeColor color) {
		super(Settings.of(material, color)
				.strength(1.0f, 15.0f)
				);
		
		
		
		//super(material, color);
		//this.setUnlocalizedName("engination."+blockName);
		//this.setRegistryName("cosmetic."+blockName);
		
		//this.blockHardness = 1.0f;
		//this.blockResistance = 15.0f;
		
		
		
		//this.setHarvestLevel("pickaxe", 1);
		//this.setCreativeTab(Engination.TAB_COSMETIC);
	}
	
	/** USE AT OWN RISK: Does not set unlocalizedName or registryName! */
	/*protected BlockCosmetic(Material material, MapColor color) {
		super(material, color);
		this.blockHardness = 1.0f;
		this.blockResistance = 15.0f;
		this.setHarvestLevel("pickaxe", 1);
	}*/
	/*
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.getCreativeTabToDisplayOn().equals(tab)) {
			getVarieties(ItemBlock.getItemFromBlock(this), list);
		}
	}*/
	
	/**
	 * Behaves like getSubBlocks, but is available on the server
	 */
	/*
	public void getVarieties(Item itemBlock, List<ItemStack> list) {
		//System.out.println("getVarieties: returning 16 blocks.");
		for(int i=0; i<16; i++) {
			list.add(new ItemStack(this, 1));
		}
	}*/
	
	/*
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.blockState.getBaseState().withProperty(VARIANT, meta);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT);
	}*/
	
	//public BlockCosmetic setTip() { this.showTip = true; return this; }
	
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World playerWorld, List<String> tooltip, ITooltipFlag flags) {
		//if (showTip)
		tooltip.add(I18n.translateToLocal(this.getUnlocalizedName()+".tip"));
	}*/
	
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
