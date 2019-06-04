package com.elytradev.engination;

import com.elytradev.engination.block.EnginationBlocks;
import com.elytradev.engination.item.EnginationItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Engination implements ModInitializer {
	public static SoundEvent SOUND_JUMP;
	public static SoundEvent SOUND_THROW;
	public static SoundEvent SOUND_SQUISH;
	
	public static ItemGroup ENGINATION_COSMETIC = 
			FabricItemGroupBuilder.build(new Identifier("engination","cosmetic"), ()->new ItemStack(EnginationBlocks.BLOCK_GROUPS.get("tourian").get(0)));
	public static ItemGroup ENGINATION_GADGETS = 
			FabricItemGroupBuilder.build(new Identifier("engination","gadgets"), ()->new ItemStack(EnginationBlocks.BLOCK_GROUPS.get("launcher").get(0)));
	
	@Override
	public void onInitialize() {
		SOUND_JUMP =  new SoundEvent(new Identifier("engination", "launcher_activate"));
		SOUND_THROW =  new SoundEvent(new Identifier("engination", "projectile_throw"));
		SOUND_SQUISH = new SoundEvent(new Identifier("engination", "squish"));
		
		Registry.register(Registry.SOUND_EVENT, "engination:launcher_activate", SOUND_JUMP);
		Registry.register(Registry.SOUND_EVENT, "engination:projectile_throw",  SOUND_THROW);
		Registry.register(Registry.SOUND_EVENT, "engination:squish",            SOUND_SQUISH);
		
		EnginationBlocks.init();
		EnginationItems.init();
		
	}
}
