package com.elytradev.engination.item;

import com.elytradev.engination.Engination;
import com.elytradev.engination.block.EnginationBlocks;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback.LootTableSetter;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class EnginationItems {
	public static TomatoItem       TOMATO;
	public static TomatoItem       CREATIVE_TOMATO;
	public static Item             CELERY;
	public static AliasedBlockItem TOMATO_SEEDS;
	
	public static final FoodComponent USELESS_FOOD = new FoodComponent.Builder()
			.alwaysEdible()
			.hunger(-1)
			.build();
	
	public static void init() {
		TOMATO = new TomatoItem(false);
		CREATIVE_TOMATO = new TomatoItem(true);
		CELERY = new Item(new Item.Settings().group(ItemGroup.FOOD).food(USELESS_FOOD));
		TOMATO_SEEDS = new AliasedBlockItem(EnginationBlocks.TOMATO_PLANT, new Item.Settings().group(Engination.ENGINATION_GADGETS));
		
		Registry.register(Registry.ITEM, new Identifier("engination", "tomato"), TOMATO);
		Registry.register(Registry.ITEM, new Identifier("engination", "creative_tomato"), CREATIVE_TOMATO);
		
		Registry.register(Registry.ITEM, new Identifier("engination", "celery"), CELERY);
		Registry.register(Registry.ITEM, new Identifier("engination", "tomato_seeds"), TOMATO_SEEDS);
		
		
		
		
		//TODO: Get help on the FabricLootSupplierBuilder front, I'm either doing something wrong here or the API doesn't work.
		LootTableLoadingCallback.EVENT.register(EnginationItems::onLootTableLoad);
	}
	
	
	public static void onLootTableLoad(ResourceManager resourceManager, LootManager manager, Identifier id, FabricLootSupplierBuilder supplier, LootTableSetter setter) {
		if (id.equals(new Identifier("minecraft", "blocks/grass"))) {
			System.out.println("Injecting tomato seeds");
			
			LootPool.Builder tomatoSeedsPool = new LootPool.Builder()
					.with( ItemEntry.builder(TOMATO_SEEDS) )
					.rolls(UniformLootTableRange.between(1, 1))
					.conditionally(RandomChanceLootCondition.builder(0.07f))
			;
					//.build();
			
			supplier.withPool(tomatoSeedsPool.build());
			
			//setter.set(supplier.create());
		} else {
			if (id.getPath().contains("grass")) System.out.println(id);
			
		}
	}
}