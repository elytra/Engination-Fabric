package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnginationBlocks {
	
	public static Map<String, List<Block>> BLOCK_GROUPS = new HashMap<>();
	
	public static void init() {
		//TODO: ItemGroups (creative tabs)
		block("oneup_cyan_block",          Material.STONE, DyeColor.CYAN,   "oneup");
		block("oneup_orange_block",        Material.STONE, DyeColor.ORANGE, "oneup");
		block("oneup_cyan_brick",          Material.STONE, DyeColor.CYAN,   "oneup");
		block("oneup_orange_brick",        Material.STONE, DyeColor.ORANGE, "oneup");
		block("oneup_gray_dents",          Material.STONE, DyeColor.GRAY,   "oneup");
		block("oneup_orange_dents",        Material.STONE, DyeColor.ORANGE, "oneup");
		block("oneup_ghost_brick",         Material.STONE, DyeColor.BROWN,  "oneup");
		block("oneup_ghost_wood",          Material.WOOD,  DyeColor.BROWN,  "oneup");
		block("oneup_reinforced",          Material.METAL, DyeColor.BLUE,   "oneup");
		block("oneup_minty_rivets",        Material.METAL, DyeColor.LIME,   "oneup");
		block("oneup_aqua_seastone",       Material.STONE, DyeColor.CYAN,   "oneup");
		block("oneup_lime_seastone",       Material.STONE, DyeColor.LIME,   "oneup");
		block("oneup_castle_brick",        Material.STONE, DyeColor.ORANGE, "oneup");
		block("oneup_bevel",               Material.STONE, DyeColor.YELLOW, "oneup");
		block("oneup_uneven_gray_brick",   Material.STONE, DyeColor.GRAY,   "oneup");
		block("oneup_uneven_orange_brick", Material.STONE, DyeColor.ORANGE, "oneup");
		
		block("gestahl_treads",            Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_domino",            Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_light_panel",       Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_medium_panel",      Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_dark_panel",        Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_tangled_pipes",     Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_grate",             Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_platform",          Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_shadowed",          Material.METAL, DyeColor.BLACK,  "gestahl");
		block("gestahl_smooth_tech",       Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_rumpled_tech",      Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_steps",             Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_surface",           Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_smooth_surface",    Material.METAL, DyeColor.BROWN,  "gestahl");
		block("gestahl_gray_treads",       Material.METAL, DyeColor.GRAY,   "gestahl");
		block("gestahl_catapult_tech",     Material.METAL, DyeColor.BROWN,  "gestahl");
		pillar("gestahl_scaffold",         Material.METAL, DyeColor.BROWN,  "gestahl");
		pillar("gestahl_girder",           Material.METAL, DyeColor.BROWN,  "gestahl");
		pillar("gestahl_rusted_girder",    Material.METAL, DyeColor.BROWN,  "gestahl");
		
		block("tourian_spawner",           Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_small_blocks",      Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_bevel",             Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_dented_bevel",      Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_block",             Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_cracked_block",     Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_vent",              Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_rock",              Material.STONE, DyeColor.PURPLE,     "tourian");
		block("tourian_dark_rock",         Material.STONE, DyeColor.BLUE,       "tourian");
		block("tourian_meteoric_rock",     Material.STONE, DyeColor.PURPLE,     "tourian");
		block("tourian_pedestal",          Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		block("tourian_interface",         Material.METAL, DyeColor.PURPLE,     "tourian");
		pillar("tourian_pillar",           Material.METAL, DyeColor.LIGHT_GRAY, "tourian");
		
		block("wooden_crate",              Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_wattle",             Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_horizontal_wattle",  Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_small_square_wattle",Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_eave_wattle",        Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_brace_wattle",       Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_port_wattle",        Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_star_brace_wattle",  Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_mini_window",        Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_laminated",          Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_lofi",               Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_lofi_panel",         Material.WOOD, DyeColor.BROWN, "wooden");
		block("wooden_polished",           Material.WOOD, DyeColor.BROWN, "wooden");
		
		block("loosestone_zozo",                 Material.STONE, DyeColor.PURPLE, "loosestone");
		block("loosestone_vector",               Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_thamasa",              Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro",               Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_path",          Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_bright_canal",  Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_regular_canal", Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_dark_canal",    Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_black_canal",   Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_figaro_bricks",        Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_zozo_roof_slate",      Material.STONE, DyeColor.BLACK,  "loosestone");
		block("loosestone_vector_bricks",        Material.STONE, DyeColor.GRAY,   "loosestone");
		block("loosestone_thamasa_bricks",       Material.STONE, DyeColor.RED,    "loosestone");
		block("loosestone_figaro_edging",        Material.STONE, DyeColor.BROWN,  "loosestone");
		block("loosestone_figaro_shingles",      Material.STONE, DyeColor.BROWN,  "loosestone");
		block("loosestone_zozo_acidic_gravel",   Material.STONE, DyeColor.GRAY,   "loosestone");
		
		block("wingfortress_yoku",         Material.METAL, DyeColor.GRAY,       "wingfortress");
		block("wingfortress_orb",          Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_platforms",    Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_gadgets",      Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_panel",        Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_caution",      Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_scaffold",     Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_intricate",    Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_fluids",       Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_boiler",       Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_corroded",     Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_ledge",        Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_support",      Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_vent",         Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_dark_gray",    Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
		block("wingfortress_rivets",       Material.METAL, DyeColor.LIGHT_BLUE, "wingfortress");
	}
	
	
	public static CosmeticBlock block(String name, Material material, DyeColor color, String group) {
		CosmeticBlock result = new CosmeticBlock(material, color, group);
		List<Block> blockGroup = BLOCK_GROUPS.get(group);
		if (blockGroup==null) {
			blockGroup = new ArrayList<>();
			BLOCK_GROUPS.put(group, blockGroup);
		}
		blockGroup.add(result);
		Registry.register(Registry.BLOCK, new Identifier("engination", name), result);
		
		Item.Settings itemSettings = new Item.Settings();
		itemSettings.itemGroup(ItemGroup.DECORATIONS);
		BlockItem item = new BlockItem(result, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return result;
	}
	
	public static CosmeticPillar pillar(String name, Material material, DyeColor color, String group) {
		CosmeticPillar result = new CosmeticPillar(material, color, group);
		List<Block> blockGroup = BLOCK_GROUPS.get(group);
		if (blockGroup==null) {
			blockGroup = new ArrayList<>();
			BLOCK_GROUPS.put(group, blockGroup);
		}
		blockGroup.add(result);
		Registry.register(Registry.BLOCK, new Identifier("engination", name), result);
		
		Item.Settings itemSettings = new Item.Settings();
		itemSettings.itemGroup(ItemGroup.DECORATIONS);
		BlockItem item = new BlockItem(result, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return result;
	}
}
