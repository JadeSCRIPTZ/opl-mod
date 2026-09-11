package com.jadescript.oplmod.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import com.jadescript.oplmod.config.ConfigManager;

public class SettingsScreen extends Screen {

	private Screen parentScreen;
	private EditBox pixelToleranceInput;
	private EditBox reactionDelayInput;
	private EditBox cooldownInput;
	private ConfigManager configManager;

	public SettingsScreen(Screen parentScreen) {
		super(Component.literal("OPL Settings"));
		this.parentScreen = parentScreen;
		this.configManager = ConfigManager.getInstance();
	}

	@Override
	protected void init() {
		this.clearWidgets();
		int centerX = this.width / 2;
		int startY = 30;
		int spacing = 40;

		this.addRenderableWidget(Button.builder(
			Component.literal("Settings - Configure Automation"),
			button -> {}
		).pos(centerX - 120, startY).width(240).build());

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Pixel Tolerance (0-255):"),
			button -> {}
		).pos(centerX - 140, startY).width(120).build());

		this.pixelToleranceInput = new EditBox(this.font, centerX + 20, startY, 100, 20, 
			Component.literal("Pixel Tolerance"));
		this.pixelToleranceInput.setValue(String.valueOf(configManager.getPixelTolerance()));
		this.addRenderableWidget(this.pixelToleranceInput);

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Reaction Delay (ms):"),
			button -> {}
		).pos(centerX - 140, startY).width(120).build());

		this.reactionDelayInput = new EditBox(this.font, centerX + 20, startY, 100, 20,
			Component.literal("Reaction Delay"));
		this.reactionDelayInput.setValue(String.valueOf(configManager.getReactionDelay()));
		this.addRenderableWidget(this.reactionDelayInput);

		startY += spacing;
		this.addRenderableWidget(Button.builder(
			Component.literal("Cooldown (ms):"),
			button -> {}
		).pos(centerX - 140, startY).width(120).build());

		this.cooldownInput = new EditBox(this.font, centerX + 20, startY, 100, 20,
			Component.literal("Cooldown"));
		this.cooldownInput.setValue(String.valueOf(configManager.getCooldown()));
		this.addRenderableWidget(this.cooldownInput);

		startY += spacing + 20;
		this.addRenderableWidget(Button.builder(
			Component.literal("Save"),
			button -> {
				saveSettings();
				this.minecraft.setScreen(parentScreen);
			}
		).pos(centerX - 100, startY).width(200).build());

		startY += 35;
		this.addRenderableWidget(Button.builder(
			Component.literal("Cancel"),
			button -> this.minecraft.setScreen(parentScreen)
		).pos(centerX - 100, startY).width(200).build());
	}

	private void saveSettings() {
		try {
			int tolerance = Integer.parseInt(this.pixelToleranceInput.getValue());
			int delay = Integer.parseInt(this.reactionDelayInput.getValue());
			int cooldown = Integer.parseInt(this.cooldownInput.getValue());

			tolerance = Math.max(0, Math.min(255, tolerance));
			delay = Math.max(0, delay);
			cooldown = Math.max(0, cooldown);

			configManager.setPixelTolerance(tolerance);
			configManager.setReactionDelay(delay);
			configManager.setCooldown(cooldown);
			configManager.save();
		} catch (NumberFormatException e) {
		}
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
