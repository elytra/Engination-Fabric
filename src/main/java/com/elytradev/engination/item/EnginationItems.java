package com.elytradev.engination.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnginationItems {
	public static TomatoItem TOMATO;
	public static TomatoItem CREATIVE_TOMATO;
	
	public static final FoodComponent USELESS_FOOD = new FoodComponent.Builder()
			.alwaysEdible()
			.hunger(-1)
			.build();
	
	public static void init() {
		TOMATO = new TomatoItem(false);
		CREATIVE_TOMATO = new TomatoItem(true);
		
		Registry.register(Registry.ITEM, new Identifier("engination", "tomato"), TOMATO);
		Registry.register(Registry.ITEM, new Identifier("engination", "creative_tomato"), CREATIVE_TOMATO);
		
		Registry.register(Registry.ITEM, new Identifier("engination", "celery"), new Item(new Item.Settings().group(ItemGroup.FOOD).food(USELESS_FOOD)));
	}
}