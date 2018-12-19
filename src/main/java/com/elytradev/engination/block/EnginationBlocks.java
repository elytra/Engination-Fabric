package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnginationBlocks {
	public static List<CosmeticBlock> GROUP_ONEUP = new ArrayList<>();
	
	public static void init() {
		//TODO: ItemGroups (creative tabs)
		block("oneup_cyan_block",          Material.STONE, DyeColor.CYAN,   "oneup", GROUP_ONEUP);
		block("oneup_orange_block",        Material.STONE, DyeColor.ORANGE, "oneup", GROUP_ONEUP);
		block("oneup_cyan_brick",          Material.STONE, DyeColor.CYAN,   "oneup", GROUP_ONEUP);
		block("oneup_orange_brick",        Material.STONE, DyeColor.ORANGE, "oneup", GROUP_ONEUP);
		block("oneup_gray_dents",          Material.STONE, DyeColor.GRAY,   "oneup", GROUP_ONEUP);
		block("oneup_orange_dents",        Material.STONE, DyeColor.ORANGE, "oneup", GROUP_ONEUP);
		block("oneup_ghost_brick",         Material.STONE, DyeColor.BROWN,  "oneup", GROUP_ONEUP);
		block("oneup_ghost_wood",          Material.WOOD,  DyeColor.BROWN,  "oneup", GROUP_ONEUP);
		block("oneup_reinforced",          Material.METAL, DyeColor.BLUE,   "oneup", GROUP_ONEUP);
		block("oneup_minty_rivets",        Material.METAL, DyeColor.LIME,   "oneup", GROUP_ONEUP);
		block("oneup_aqua_seastone",       Material.STONE, DyeColor.CYAN,   "oneup", GROUP_ONEUP);
		block("oneup_lime_seastone",       Material.STONE, DyeColor.LIME,   "oneup", GROUP_ONEUP);
		block("oneup_castle_brick",        Material.STONE, DyeColor.ORANGE, "oneup", GROUP_ONEUP);
		block("oneup_bevel",               Material.STONE, DyeColor.YELLOW, "oneup", GROUP_ONEUP);
		block("oneup_uneven_gray_brick",   Material.STONE, DyeColor.GRAY,   "oneup", GROUP_ONEUP);
		block("oneup_uneven_orange_brick", Material.STONE, DyeColor.ORANGE, "oneup", GROUP_ONEUP);
		
		
	}
	
	
	
	public static CosmeticBlock block(String name, Material material, DyeColor color, String group, List<CosmeticBlock> blockGroup) {
		CosmeticBlock result = new CosmeticBlock(material, color, group);
		if (blockGroup!=null) blockGroup.add(result);
		Registry.register(Registry.BLOCK, new Identifier("engination", name), result);
		
		Item.Settings itemSettings = new Item.Settings();
		BlockItem item = new BlockItem(result, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return result;
	}
}
