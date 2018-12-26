package com.elytradev.engination.item;

import net.minecraft.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnginationItems {
	public static TomatoItem TOMATO;
	public static TomatoItem CREATIVE_TOMATO;
	
	public static void init() {
		TOMATO = new TomatoItem(false);
		CREATIVE_TOMATO = new TomatoItem(true);
		
		Registry.register(Registry.ITEM, new Identifier("engination", "tomato"), TOMATO);
		Registry.register(Registry.ITEM, new Identifier("engination", "creative_tomato"), CREATIVE_TOMATO);
		
		Registry.register(Registry.ITEM, new Identifier("engination", "celery"), new FoodItem(-1, 0, false, new Item.Settings().itemGroup(ItemGroup.FOOD)));
	}
}
