package com.elytradev.engination.mixin;

import java.io.InputStream;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.audio.SoundEntry;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloadListener;
import net.minecraft.util.Tickable;

@Mixin(SoundLoader.class)
public abstract class SoundLoaderMixins implements Tickable, ResourceReloadListener {
	
	@Inject(method = "onResourceReload(Lnet/minecraft/resource/ResourceManager;)V", at = @At("HEAD"))
	public void onResourceReload(ResourceManager resourceManager_1, CallbackInfo info) {
		System.out.println("OnResourceReload");
	}
	
	@Inject(method = "readSounds(Ljava/io/InputStream;)Ljava/util/Map;", at = @At("HEAD"))
	protected Map<String, SoundEntry> readSounds(InputStream inputStream_1, CallbackInfoReturnable<Map<String, SoundEntry>> info) {
		System.out.println("Deserializing some sounds...");

		return null;
	}
}
