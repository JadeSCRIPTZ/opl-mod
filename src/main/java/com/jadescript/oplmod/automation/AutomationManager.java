package com.jadescript.oplmod.automation;

import net.minecraft.client.Minecraft;
import com.jadescript.oplmod.config.ConfigManager;
import java.util.Timer;
import java.util.TimerTask;

public class AutomationManager {

	private static AutomationManager instance;

	private Minecraft client;
	private Timer automationTimer;
	private boolean isActive = false;
	private AutomationType currentType = AutomationType.NONE;
	private ConfigManager configManager;

	public enum AutomationType {
		NONE, FISHING, GARDENING
	}

	private AutomationManager() {
		this.client = Minecraft.getInstance();
		this.configManager = ConfigManager.getInstance();
	}

	public static AutomationManager getInstance() {
		if (instance == null) {
			instance = new AutomationManager();
		}
		return instance;
	}

	public void setActive(boolean active) {
		this.isActive = active;
		if (!active && automationTimer != null) {
			automationTimer.cancel();
			automationTimer = null;
		}
	}

	public void startFishing() {
		if (isActive && currentType != AutomationType.FISHING) {
			stop();
			currentType = AutomationType.FISHING;
			startAutomation();
		}
	}

	public void startGardening() {
		if (isActive && currentType != AutomationType.GARDENING) {
			stop();
			currentType = AutomationType.GARDENING;
			startAutomation();
		}
	}

	private void startAutomation() {
		if (automationTimer != null) {
			automationTimer.cancel();
		}

		automationTimer = new Timer("OPL-Automation", true);

		switch (currentType) {
			case FISHING:
				int fishingCooldown = configManager.getCooldown();
				automationTimer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						executeFishing();
					}
				}, 100, fishingCooldown);
				break;

			case GARDENING:
				int gardenCooldown = configManager.getCooldown() + 300;
				automationTimer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						executeGardening();
					}
				}, 100, gardenCooldown);
				break;

			default:
				break;
		}
	}

	private void executeFishing() {
		if (client.player == null) return;
		try {
			Thread.sleep(configManager.getReactionDelay());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void executeGardening() {
		if (client.player == null) return;
		try {
			Thread.sleep(configManager.getReactionDelay());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void stop() {
		if (automationTimer != null) {
			automationTimer.cancel();
			automationTimer = null;
		}
		isActive = false;
		currentType = AutomationType.NONE;
	}

	public boolean isActive() { return isActive; }
	public AutomationType getCurrentType() { return currentType; }
}
