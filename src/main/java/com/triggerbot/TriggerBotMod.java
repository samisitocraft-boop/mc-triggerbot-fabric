package com.triggerbot;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriggerBotMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mc-triggerbot-fabric");
	public static final String MOD_ID = "mc-triggerbot-fabric";

	@Override
	public void onInitialize() {
		LOGGER.info("TriggerBot Mod initialized for Minecraft 1.20.1");
	}
}