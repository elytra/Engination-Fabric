package com.elytradev.engination.item;

import com.elytradev.engination.Engination;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TomatoItem extends Item {
	private final boolean creative;
	
	public TomatoItem(boolean creative) {
		super(new Item.Settings().maxCount(16).group(ItemGroup.FOOD));
		this.creative = creative;
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (!player.abilities.creativeMode && !creative) {
			itemStack.decrement(1);
		}
		
		world.playSound((PlayerEntity)null, player.x, player.y, player.z, Engination.SOUND_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
		if (!world.isClient) {
			SnowballEntity entity = new SnowballEntity(world, player);
			entity.setItem(new ItemStack(EnginationItems.TOMATO));
			//TomatoEntity entity = new TomatoEntity(world, player);
			
			//this.getDataTracker().set(field_17082, SystemUtil.consume(itemStack_1.copy(), (itemStack_1x) -> {
	        //    itemStack_1x.setAmount(1);
	        // }));
			
			
			entity.setItem(new ItemStack(EnginationItems.TOMATO));//itemStack);
			entity.method_19207(player, player.pitch, player.yaw, 0.0f, 1.5f, 1.0f);
			//entity.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entity);
		}
		
		player.incrementStat(Stats.USED.getOrCreateStat(this));
		return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
	}
}