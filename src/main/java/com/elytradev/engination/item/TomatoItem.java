package com.elytradev.engination.item;

import com.elytradev.engination.Engination;
import com.elytradev.engination.entity.TomatoEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SystemUtil;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TomatoItem extends Item {
	private final boolean creative;
	
	public TomatoItem(boolean creative) {
		super(new Item.Settings().stackSize(16).itemGroup(ItemGroup.FOOD));
		this.creative = creative;
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (!player.abilities.creativeMode && !creative) {
			itemStack.subtractAmount(1);
		}
		
		world.playSound((PlayerEntity)null, player.x, player.y, player.z, Engination.SOUND_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!world.isClient) {
			TomatoEntity entity = new TomatoEntity(world, player);
			
			//this.getDataTracker().set(field_17082, SystemUtil.consume(itemStack_1.copy(), (itemStack_1x) -> {
	        //    itemStack_1x.setAmount(1);
	        // }));
			
			
			entity.method_16940(new ItemStack(EnginationItems.TOMATO));//itemStack);
			entity.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entity);
		}
		
		player.incrementStat(Stats.USED.method_14956(this));
		return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
	}
}