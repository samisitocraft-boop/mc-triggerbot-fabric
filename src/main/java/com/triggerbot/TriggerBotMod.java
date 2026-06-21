package com.triggerbot;

import net.fabricmc.api.ModInitializer;

public class TriggerBotMod implements ModInitializer {
	public static final String MOD_ID = "mc-triggerbot-fabric";

	@Override
	public void onInitialize() {
		System.out.println("TriggerBot Mod initialized for Minecraft 1.20.1");
	}
}
