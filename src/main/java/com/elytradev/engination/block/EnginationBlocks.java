package com.elytradev.engination.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.elytradev.engination.Engination;
import com.elytradev.engination.Grouped;
import com.elytradev.engination.item.CosmeticBlockItem;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@ParametersAreNonnullByDefault
public class EnginationBlocks {
	
	public static Map<String, List<Block>> BLOCK_GROUPS = new HashMap<>();
	
	public static TomatoBlock TOMATO_PLANT = null;
	
	public static void init() {
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
		
		blocks("wooden", Material.WOOD, DyeColor.BROWN,
				"crate",
				"wattle", "horizontal_wattle", "small_square_wattle", "eave_wattle", "brace_wattle", "port_wattle", "star_brace_wattle",
				"mini_window", "laminated", "lofi", "lofi_panel", "polished"
				);
		
		/** LooseStone */
		blocks("loosestone", Material.STONE, DyeColor.PURPLE, "zozo");
		blocks("loosestone", Material.STONE, DyeColor.BLACK,  "zozo_roof_slate");
		blocks("loosestone", Material.STONE, DyeColor.RED,    "thamasa_bricks");
		blocks("loosestone", Material.STONE, DyeColor.BROWN,  "figaro_edging", "figaro_shingles");
		blocks("loosestone", Material.STONE, DyeColor.GRAY,
				"vector", "thamasa", "figaro", "figaro_path", "figaro_bright_canal", "figaro_regular_canal",
				"figaro_dark_canal", "figaro_black_canal", "figaro_bricks", "vector_bricks", "zozo_acidic_gravel"
				);
		
		/** WingFortress */
		blocks("wingfortress", Material.METAL, DyeColor.LIGHT_GRAY, "yoku", "rivets");
		blocks("wingfortress", Material.METAL, DyeColor.GRAY,       "gadgets", "caution", "intricate", "dark_gray");
		blocks("wingfortress", Material.METAL, DyeColor.BLUE,       "fluids");
		blocks("wingfortress", Material.METAL, DyeColor.LIGHT_BLUE,
				"orb", "platforms", "panel", "scaffold", "boiler", "corroded", "ledge", "support", "vent"
				);
		
//		TODO: uncomment this, find replacement material
//		block("sanic_dark_checker",        Material.CLAY,  DyeColor.BLUE,   "sanic");
//		block("sanic_medium_checker",      Material.CLAY,  DyeColor.CYAN,   "sanic");
//		block("sanic_bright_checker",      Material.CLAY,  DyeColor.WHITE,  "sanic");
//		block("sanic_white_checker",       Material.CLAY,  DyeColor.WHITE,  "sanic");
//		block("sanic_darkest_tiles",       Material.CLAY,  DyeColor.BLUE,   "sanic");
//		block("sanic_dark_tiles",          Material.CLAY,  DyeColor.BLUE,   "sanic");
//		block("sanic_medium_tiles",        Material.CLAY,  DyeColor.CYAN,   "sanic");
//		block("sanic_bright_tiles",        Material.CLAY,  DyeColor.WHITE,  "sanic");
//		block("sanic_white_tiles",         Material.CLAY,  DyeColor.WHITE,  "sanic");
//		block("sanic_darkest_large_tile",  Material.CLAY,  DyeColor.BLUE,   "sanic");
//		block("sanic_dark_large_tile",     Material.CLAY,  DyeColor.BLUE,   "sanic");
//		block("sanic_medium_large_tile",   Material.CLAY,  DyeColor.CYAN,   "sanic");
//		block("sanic_bright_large_tile",   Material.CLAY,  DyeColor.WHITE,  "sanic");
//		block("sanic_white_large_tile",    Material.CLAY,  DyeColor.WHITE,  "sanic");
		block("sanic_gold_oil_spike",      Material.METAL, DyeColor.YELLOW, "sanic");
		block("sanic_purple_oil_spike",    Material.METAL, DyeColor.PURPLE, "sanic");
		block("sanic_gold_oil_spikes",     Material.METAL, DyeColor.YELLOW, "sanic");
		block("sanic_purple_oil_spikes",   Material.METAL, DyeColor.PURPLE, "sanic");
		block("sanic_oil_checker",         Material.METAL, DyeColor.PURPLE, "sanic");
		
		blocks("dolomite", Material.STONE, DyeColor.BROWN,
				"brick", "smooth", "tiles", "small_tiles", "large_tile", "hexagons", "prism",
				"dark_brick", "dark_smooth", "dark_tiles", "dark_small_tiles", "dark_large_tile", "dark_hexagons", "dark_prism",
				"checker", "small_checker"
				);
		
		blocks("celestite", Material.STONE, DyeColor.LIGHT_BLUE,
				"brick", "smooth", "tiles", "small_tiles", "large_tile", "hexagons", "prism",
				"dark_brick", "dark_smooth", "dark_tiles", "dark_small_tiles", "dark_large_tile", "dark_hexagons", "dark_prism",
				"checker", "small_checker"
				);
		
		blocks("peridot", Material.STONE, DyeColor.LIME,
				"brick", "rock", "tiles", "small_tiles", "large_tile", "hexagons", "prism",
				"dark_brick", "dark_rock", "dark_tiles", "dark_small_tiles", "dark_large_tile", "dark_hexagons", "dark_prism",
				"checker", "small_checker"
				);
		
		lamps("lamp", Material.GLASS, DyeColor.WHITE,
				"golbez", "pulsing", "black", "undersea_palace", "magenta", "pink", "orange", "yellow", "lime",
				"green", "mint", "sky", "blue"
				);
		
		blocks("carmine", Material.STONE, DyeColor.RED,
				"brick", "smooth", "tiles", "small_tiles", "large_tile"
				);
		
		blocks("erechtheion", Material.STONE, DyeColor.WHITE,
				"brick", "smooth", "tiles", "small_tiles", "large_tile"
				);
		
		blocks("verdigris", Material.METAL, DyeColor.GREEN,
				"surface", "grate", "spout", "yoku_block", "tiles", "triangles"
				);
		
		blocks("presidential", Material.METAL, DyeColor.YELLOW,
				"large_tile", "tiles", "dots", "grate", "embossed", "brick", "panel", "t"
				);
		
		block("conveyor", "conveyor",                new ConveyorBlock(2.0), Engination.ENGINATION_GADGETS);
		block("conveyor", "fast_conveyor",           new ConveyorBlock(4.0), Engination.ENGINATION_GADGETS);
		block("conveyor", "ultra_fast_conveyor",     new ConveyorBlock(8.0), Engination.ENGINATION_GADGETS);
		
		block("launcher", "launcher",                new LauncherBlock(2.0), Engination.ENGINATION_GADGETS);
		block("launcher", "forceful_launcher",       new LauncherBlock(3.0), Engination.ENGINATION_GADGETS);
		block("launcher", "ultra_forceful_launcher", new LauncherBlock(5.0), Engination.ENGINATION_GADGETS);
		
		block("landingpad", "landing_pad",           new LandingPadBlock(),  Engination.ENGINATION_GADGETS);
		
		block("disappearing", "disappearing_melee",  new MeleeDisappearingBlock(), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_wooden_sword", new HeldItemDisappearingBlock(new ItemStack(Items.WOODEN_SWORD)), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_stone_sword", new HeldItemDisappearingBlock(new ItemStack(Items.STONE_SWORD)), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_iron_sword", new HeldItemDisappearingBlock(new ItemStack(Items.IRON_SWORD)), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_gold_sword", new HeldItemDisappearingBlock(new ItemStack(Items.GOLDEN_SWORD)), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_diamond_sword", new HeldItemDisappearingBlock(new ItemStack(Items.DIAMOND_SWORD)), Engination.ENGINATION_GADGETS);
		
		block("disappearing", "disappearing_sprint_speed", new SprintDisappearingBlock(), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_mount_speed", new MountDisappearingBlock(true), Engination.ENGINATION_GADGETS);
		block("disappearing", "disappearing_cart_speed", new MountDisappearingBlock(false), Engination.ENGINATION_GADGETS);
		
		block("disappearing", "fall_through", new FallThroughBlock(), Engination.ENGINATION_GADGETS);
		block("disappearing", "disguised_fall_through", new FallThroughBlock(), Engination.ENGINATION_GADGETS);
		
		TOMATO_PLANT = new TomatoBlock(FabricBlockSettings.copy(Blocks.WHEAT));
		Registry.register(Registry.BLOCK, new Identifier("engination", "tomato_plant"), TOMATO_PLANT);
	}
	
	
	public static void blocks(String group, Material material, DyeColor color, String... varieties) {
		for(String variety : varieties) {
			block(group+"_"+variety, material, color, group);
		}
	}
	
	public static void lamps(String group, Material material, DyeColor color, String... varieties) {
		for(String variety : varieties) {
			lamp(group+"_"+variety, material, color, group);
		}
	}
	
	public static Block block(String group, String name, Block block, ItemGroup itemGroup) {
		List<Block> blockGroup = BLOCK_GROUPS.get(group);
		if (blockGroup==null) {
			blockGroup = new ArrayList<>();
			BLOCK_GROUPS.put(group, blockGroup);
		}
		blockGroup.add(block);
		
		Registry.register(Registry.BLOCK, new Identifier("engination", name), block);
		
		Item.Settings itemSettings = new Item.Settings().group(Engination.ENGINATION_COSMETIC);
		if (itemGroup!=null) itemSettings.group(itemGroup);
		BlockItem item = (block instanceof Grouped) ? new CosmeticBlockItem(block, itemSettings) : new BlockItem(block, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return block;
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
		
		Item.Settings itemSettings = new Item.Settings().group(Engination.ENGINATION_COSMETIC);;
		itemSettings.group(Engination.ENGINATION_COSMETIC);
		//BlockItem item = new BlockItem(result, itemSettings);
		BlockItem item = (result instanceof Grouped) ? new CosmeticBlockItem(result, itemSettings) : new BlockItem(result, itemSettings);
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
		
		Item.Settings itemSettings = new Item.Settings().group(Engination.ENGINATION_COSMETIC);;
		itemSettings.group(Engination.ENGINATION_COSMETIC);
		BlockItem item = (result instanceof Grouped) ? new CosmeticBlockItem(result, itemSettings) : new BlockItem(result, itemSettings);
		//BlockItem item = new BlockItem(result, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return result;
	}
	
	public static CosmeticBlock lamp(String name, Material material, DyeColor color, String group) {
		FabricBlockSettings settings = FabricBlockSettings.of(material).materialColor(color).strength(1f, 15f).lightLevel(15);
		
		CosmeticBlock result = new CosmeticBlock(settings, group);
		List<Block> blockGroup = BLOCK_GROUPS.get(group);
		if (blockGroup==null) {
			blockGroup = new ArrayList<>();
			BLOCK_GROUPS.put(group, blockGroup);
		}
		blockGroup.add(result);
		Registry.register(Registry.BLOCK, new Identifier("engination", name), result);
		
		Item.Settings itemSettings = new Item.Settings().group(Engination.ENGINATION_COSMETIC);;
		itemSettings.group(Engination.ENGINATION_COSMETIC);
		//BlockItem item = new BlockItem(result, itemSettings);
		BlockItem item = (result instanceof Grouped) ? new CosmeticBlockItem(result, itemSettings) : new BlockItem(result, itemSettings);
		Registry.register(Registry.ITEM, new Identifier("engination", name), item);
		
		return result;
	}
	
	@Nullable
	public static ItemStack getNextItem(ItemStack stack, String groupId) {
		if (stack.getItem() instanceof BlockItem) {
			Block curBlock = ((BlockItem)stack.getItem()).getBlock();
			
			List<Block> blockGroup = BLOCK_GROUPS.get(groupId);
			if (blockGroup==null) return null;
			for(int i=0; i<blockGroup.size(); i++) {
				Block b = blockGroup.get(i);
				if (b==curBlock) {
					int nextBlock = (i + 1) % blockGroup.size();
					ItemStack result = new ItemStack(blockGroup.get(nextBlock), stack.getCount());
					return result;
				}
			}
		}
		
		return null;
	}
}
