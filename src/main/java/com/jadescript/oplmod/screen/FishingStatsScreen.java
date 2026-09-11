package com.jadescript.oplmod.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.jadescript.oplmod.automation.AutomationManager;

/**
 * Fishing statistics display screen
 */
public class FishingStatsScreen extends Screen {

	private Screen parentScreen;
	private AutomationManager automationManager;

	public FishingStatsScreen(Screen parentScreen) {
		super(Component.literal("Fishing Statistics"));
		this.parentScreen = parentScreen;
		this.automationManager = AutomationManager.getInstance();
	}

	@Override
	protected void init() {
		this.clearWidgets();
		int centerX = this.width / 2;
		int startY = 20;

		this.addRenderableWidget(Button.builder(
			Component.literal("Fishing Statistics"),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 40;
		this.addRenderableWidget(Button.builder(
			Component.literal("Total Catches: " + automationManager.getFishingCatches()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 30;
		this.addRenderableWidget(Button.builder(
			Component.literal("Common: " + automationManager.getFishingCommon()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 25;
		this.addRenderableWidget(Button.builder(
			Component.literal("Uncommon: " + automationManager.getFishingUncommon()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 25;
		this.addRenderableWidget(Button.builder(
			Component.literal("Rare: " + automationManager.getFishingRare()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 25;
		this.addRenderableWidget(Button.builder(
			Component.literal("Epic: " + automationManager.getFishingEpic()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 25;
		this.addRenderableWidget(Button.builder(
			Component.literal("Legendary: " + automationManager.getFishingLegendary()),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 35;
		long timeSpent = automationManager.getFishingTime() / 1000; // Convert to seconds
		long minutes = timeSpent / 60;
		long seconds = timeSpent % 60;
		
		this.addRenderableWidget(Button.builder(
			Component.literal("Time: " + minutes + "m " + seconds + "s"),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += 40;
		this.addRenderableWidget(Button.builder(
			Component.literal("Close"),
			button -> this.minecraft.setScreen(parentScreen)
		).pos(centerX - 80, startY).width(160).build());
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
		super.render(guiGraphics, mouseX, mouseY, partialTick);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
}
