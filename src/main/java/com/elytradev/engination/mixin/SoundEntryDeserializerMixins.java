package com.elytradev.engination.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEntry;
import net.minecraft.client.audio.SoundEntryDeserializer;
import net.minecraft.util.JsonHelper;

@Mixin(SoundEntryDeserializer.class)
public abstract class SoundEntryDeserializerMixins implements JsonDeserializer<SoundEntry> {
	/* THIS IS JUST A DIAGNOSTIC MIXIN! We probably want to disable this for production.
	 * This helps unravel some of the opaque BS that is "Missing sound for event: foo:bar_baz"
	 */
	
	private List<Sound> method_4792(JsonObject jsonObject_1) {
		System.out.println("Loading in sounds for "+jsonObject_1.toString());
		List<Sound> list_1 = Lists.newArrayList();
		if (jsonObject_1.has("sounds")) {
			JsonArray jsonArray_1 = JsonHelper.getArray(jsonObject_1, "sounds");
			
			for(int int_1 = 0; int_1 < jsonArray_1.size(); ++int_1) {
				JsonElement jsonElement_1 = jsonArray_1.get(int_1);
				if (JsonHelper.isString(jsonElement_1)) {
					String string_1 = JsonHelper.asString(jsonElement_1, "sound");
					System.out.println("Sound: "+string_1);
					list_1.add(new Sound(string_1, 1.0F, 1.0F, 1, Sound.RegistrationType.FILE, false, false, 16));
				} else {
					System.out.println("Sound Object: "+jsonElement_1.toString());
					list_1.add(this.method_4790(JsonHelper.asObject(jsonElement_1, "sound")));
				}
			}
		}
		
		return list_1;
	}
	
	@Shadow
	private Sound method_4790(JsonObject jsonObject_1) { return null; }
}
