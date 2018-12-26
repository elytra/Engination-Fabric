package com.elytradev.engination.entity;

import com.elytradev.engination.Engination;
import com.elytradev.engination.item.EnginationItems;

import net.minecraft.class_3857;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.particle.BlockStateParticleParameters;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.HitResult;
import net.minecraft.world.World;

public class TomatoEntity extends class_3857 {
	public TomatoEntity(World world) {
		super(Engination.ENTITY_TYPE_TOMATO, world);
	}

	public TomatoEntity(World world, LivingEntity thrower) {
		super(Engination.ENTITY_TYPE_TOMATO, thrower, world);
	}

	public TomatoEntity(World world, double x, double y, double z) {
		super(Engination.ENTITY_TYPE_TOMATO, x, y, z, world);
	}

	@Override
	protected void onCollision(HitResult result) {
		if (result.entity != null && result.entity instanceof LivingEntity) {
			((LivingEntity) result.entity).damage(DamageSource.thrownProjectile(this, this.getOwner()), 0.0f);
		}
		BlockStateParticleParameters params = new BlockStateParticleParameters(ParticleTypes.BLOCK, Blocks.REDSTONE_BLOCK.getDefaultState());
		
		for (int i = 0; i < 128; ++i) {
			this.world.addParticle(params, this.x, this.y, this.z, this.random.nextGaussian()*0.3 + (this.velocityX/2), this.random.nextDouble()*0.3 + (this.velocityY/2), this.random.nextGaussian()*0.3 + (this.velocityZ/2));
		}

		this.world.playSound(null, this.x, this.y, this.z, Engination.SOUND_SQUISH, SoundCategory.PLAYER, 0.4f, 0.9f + random.nextFloat()*0.2f);

		if (!this.world.isClient()) {
			this.kill();
		}
	}

	@Override
	protected void initDataTracker() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Item method_16942() {
		return EnginationItems.TOMATO;
	}
}
