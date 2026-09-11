package com.jadescript.oplmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import com.jadescript.oplmod.screen.AutomationScreen;
import net.minecraft.client.Minecraft;

public class OplCommand {

	public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
		dispatcher.register(ClientCommandManager.literal("opl")
			.executes(context -> {
				Minecraft client = Minecraft.getInstance();
				if (client != null) {
					client.setScreen(new AutomationScreen());
				}
				return 1;
			})
		);
	}
}
