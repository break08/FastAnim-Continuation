package net.lunade.fastanim;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MOD_ID = "faster_entity_animations";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final float PIHalf_f = 1.5707964f;

	@Override
	public void onInitialize() {
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
