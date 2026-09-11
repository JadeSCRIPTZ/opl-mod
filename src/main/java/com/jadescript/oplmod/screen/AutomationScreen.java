package com.jadescript.oplmod.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.jadescript.oplmod.automation.AutomationManager;

/**
 * Main OPL Automation Suite GUI
 * Controls fishing, gardening, and other macros
 */
public class AutomationScreen extends Screen {

	private AutomationManager automationManager;
	private boolean isActive = false;

	public AutomationScreen() {
		super(Component.literal("OPL Automation Suite"));
		this.automationManager = AutomationManager.getInstance();
	}

	@Override
	protected void init() {
		this.clearWidgets();
		int centerX = this.width / 2;
		int startY = 30;
		int spacing = 30;

		this.addRenderableWidget(Button.builder(
			Component.literal("OPL - Automation Suite"),
			button -> {}
		).pos(centerX - 100, startY).width(200).build());

		startY += spacing + 10;
		this.addRenderableWidget(Button.builder(
			Component.literal(isActive ? "Status: ACTIVE" : "Status: INACTIVE"),
			button -> {}
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal(isActive ? "STOP Automation" : "START Automation"),
			button -> {
				isActive = !isActive;
				automationManager.setActive(isActive);
			}
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing;
		String fishingStatus = automationManager.isFishingActive() ? "STOP Fishing" : "START Fishing";
		this.addRenderableWidget(Button.builder(
			Component.literal(fishingStatus),
			button -> {
				if (automationManager.isFishingActive()) {
					automationManager.stopAll();
				} else if (isActive) {
					automationManager.startFishing();
				}
			}
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Fishing Stats"),
			button -> this.minecraft.setScreen(new FishingStatsScreen(this))
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Garden Macro"),
			button -> {
				if (isActive) automationManager.startGardening();
			}
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Settings"),
			button -> this.minecraft.setScreen(new SettingsScreen(this))
		).pos(centerX - 80, startY).width(160).build());

		startY += spacing + 20;
		this.addRenderableWidget(Button.builder(
			Component.literal("Close"),
			button -> this.minecraft.setScreen(null)
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
