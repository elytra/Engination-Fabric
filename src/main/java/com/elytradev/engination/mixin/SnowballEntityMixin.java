package com.elytradev.engination.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

@Mixin(SnowballEntity.class)
public abstract class SnowballEntityMixin extends ThrownItemEntity {
	
	public SnowballEntityMixin(EntityType<? extends ThrownItemEntity> entityType_1, World world_1) {
		super(entityType_1, world_1); //System.out.println("KNUCKLESVOICE: OH NO");
	}

	@Inject(at={@At("RETURN")}, method= {"onCollision(Lnet/minecraft/util/hit/HitResult;)V"})
	protected void onCollision(HitResult hitResult_1, CallbackInfo callbackInfo) {
		if (world.isClient) { 
			//System.out.println("Magnifying Particles...");
			
			ParticleEffect params = this.getParticleParameters();
			
			for(int i = 0; i < 64; i++) {
				double vx = world.random.nextDouble() - 0.5;
				double vz = world.random.nextDouble() - 0.5;
				this.world.addParticle(params, this.getX(), this.getY(), this.getZ(), vx, 0.0D, vz);
			}
		}
	}

	@Shadow
	private ParticleEffect getParticleParameters() {
		return null;
	}
}
