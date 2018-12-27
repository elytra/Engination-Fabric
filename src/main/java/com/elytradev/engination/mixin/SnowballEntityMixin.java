package com.elytradev.engination.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.class_3857;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.thrown.SnowballEntity;
import net.minecraft.particle.ParticleParameters;
import net.minecraft.util.HitResult;
import net.minecraft.world.World;

@Mixin(SnowballEntity.class)
public abstract class SnowballEntityMixin extends class_3857 {

	public SnowballEntityMixin(EntityType<?> entityType_1, World world_1) {
		super(entityType_1, world_1); System.out.println("KNUCKLESVOICE: OH NO");
	}

	@Inject(at={@At("RETURN")}, method= {"onCollision(Lnet/minecraft/util/HitResult;)V"})
	protected void onCollision(HitResult hitResult_1, CallbackInfo callbackInfo) {
		if (world.isClient) { 
			System.out.println("Magnifying Particles...");
			ParticleParameters params = this.method_16939();
			
			for(int i = 0; i < 64; i++) {
				double vx = world.random.nextDouble() - 0.5;
				double vz = world.random.nextDouble() - 0.5;
				this.world.addParticle(params, this.x, this.y, this.z, vx, 0.0D, vz);
			}
		}
	}

	@Shadow
	private ParticleParameters method_16939() {
		return null;
	}
}
