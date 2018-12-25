package com.elytradev.engination.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerMixins {
	/*
	PlayerManager playerManager;
	
	@Inject(at = @At("HEAD"), method = "tick(Ljava/util/function/BooleanSupplier;)V")
	private void init(CallbackInfo info) {
		//System.out.println("Server tick?");
		if (playerManager==null) {
			System.out.println("NULL");
		} else {
			for(ServerPlayerEntity player : playerManager.getPlayerList()) {
				player.interactionManager;
				double dx = player.x - player.prevX;
				double dy = player.y - player.prevY;
				double dz = player.z - player.prevZ;
				//Doesn't work -- prevX is always x
				double hVelocity = Math.abs(dx*dx + dy*dy);
				System.out.println(player.getDisplayName().getText()+" dx: "+dx+", dy: "+dy+", dz: "+dz);
			}
		}
	}*/
}
