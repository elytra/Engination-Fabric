package com.elytradev.engination;

import com.elytradev.engination.block.EnginationBlocks;
import com.elytradev.engination.entity.TomatoEntity;
import com.elytradev.engination.item.EnginationItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.client.render.EntityRendererRegistry;
import net.fabricmc.fabric.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.SnowballEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Engination implements ModInitializer, ClientModInitializer {
	public static SoundEvent SOUND_JUMP;
	public static SoundEvent SOUND_THROW;
	public static SoundEvent SOUND_SQUISH;
	
	public static EntityType<TomatoEntity> ENTITY_TYPE_TOMATO;
	
	@Override
	public void onInitialize() {
		SOUND_JUMP =  new SoundEvent(new Identifier("engination", "launcher_activate"));
		SOUND_THROW =  new SoundEvent(new Identifier("engination", "projectile_throw"));
		SOUND_SQUISH = new SoundEvent(new Identifier("engination", "squish"));
		
		Registry.register(Registry.SOUND_EVENT, "engination:launcher_activate", SOUND_JUMP);
		Registry.register(Registry.SOUND_EVENT, "engination:projectile_throw",  SOUND_THROW);
		Registry.register(Registry.SOUND_EVENT, "engination:squish",            SOUND_SQUISH);
		
		ENTITY_TYPE_TOMATO = FabricEntityTypeBuilder.create(TomatoEntity.class, TomatoEntity::new).build("engination:tomato");
		Registry.register(Registry.ENTITY_TYPE, "engination:tomato", ENTITY_TYPE_TOMATO);
		
		EnginationBlocks.init();
		EnginationItems.init();
		
	}

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(TomatoEntity.class, (dispatcher, context)->{
			return new SnowballEntityRenderer<TomatoEntity>(dispatcher, context.getItemRenderer());
		});
	}
}
