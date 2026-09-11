package com.jadescript.oplmod.automation;

import net.minecraft.client.Minecraft;

/**
 * Central automation manager for OPL Mod
 * Handles fishing, gardening, and other macros
 */
public class AutomationManager {

	private static AutomationManager instance;
	private Minecraft client;
	private FishingMacro fishingMacro;
	private boolean isActive = false;

	public enum AutomationType {
		NONE, FISHING, GARDENING
	}

	private AutomationType currentType = AutomationType.NONE;

	private AutomationManager() {
		this.client = Minecraft.getInstance();
		this.fishingMacro = new FishingMacro(client);
	}

	public static AutomationManager getInstance() {
		if (instance == null) {
			instance = new AutomationManager();
		}
		return instance;
	}

	public void setActive(boolean active) {
		this.isActive = active;
		if (!active) {
			stopAll();
		}
	}

	public void startFishing() {
		if (isActive && currentType != AutomationType.FISHING) {
			stopAll();
			currentType = AutomationType.FISHING;
			fishingMacro.start();
		}
	}

	public void startGardening() {
		if (isActive && currentType != AutomationType.GARDENING) {
			stopAll();
			currentType = AutomationType.GARDENING;
			// Garden automation (can be added later)
		}
	}

	public void stopAll() {
		if (fishingMacro != null) {
			fishingMacro.stop();
		}
		currentType = AutomationType.NONE;
	}

	public void stop() {
		stopAll();
		isActive = false;
	}

	// Fishing statistics
	public int getFishingCatches() {
		return fishingMacro != null ? fishingMacro.getTotalCatches() : 0;
	}

	public int getFishingCommon() {
		return fishingMacro != null ? fishingMacro.getCommonCatches() : 0;
	}

	public int getFishingUncommon() {
		return fishingMacro != null ? fishingMacro.getUncommonCatches() : 0;
	}

	public int getFishingRare() {
		return fishingMacro != null ? fishingMacro.getRareCatches() : 0;
	}

	public int getFishingEpic() {
		return fishingMacro != null ? fishingMacro.getEpicCatches() : 0;
	}

	public int getFishingLegendary() {
		return fishingMacro != null ? fishingMacro.getLegendaryCatches() : 0;
	}

	public long getFishingTime() {
		return fishingMacro != null ? fishingMacro.getTotalTimeSpent() : 0;
	}

	public boolean isFishingActive() {
		return fishingMacro != null && fishingMacro.isRunning();
	}

	public FishingMacro getFishingMacro() {
		return fishingMacro;
	}

	public boolean isActive() { return isActive; }
	public AutomationType getCurrentType() { return currentType; }
}
