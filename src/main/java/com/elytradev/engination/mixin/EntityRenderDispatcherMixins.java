package com.elytradev.engination.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.elytradev.engination.entity.TomatoEntity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Entity;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixins {
	@Inject(at = @At("HEAD"), method = { "render(Lnet/minecraft/entity/Entity;DDDFFZ)V" } )
	public void render(Entity entity_1, double double_1, double double_2, double double_3, float float_1, float float_2, boolean boolean_1, CallbackInfo callbackInfo) {
		if (entity_1 instanceof TomatoEntity) {
			System.out.println("TRYING TO RENDER A FUCKING TOMATO");
		} else {
			System.out.println("TRYING TO RENDER SOME OTHER FUCKING THING - "+entity_1.getClass());
		}
	}
}
