package com.jadescript.oplmod.config;

/**
 * Fishing macro configuration with anti-cheat features
 */
public class FishingConfig {

	// Human-like behavior
	public boolean enableHumanRandomness = true;
	public int reactionTimeMs = 100;
	public int reactionVarianceMs = 50;
	
	// Anti-cheat
	public boolean enableMouseMovement = false; // Disable for safety
	public boolean enableChatObfuscation = true;
	public boolean enableRandomBreaks = true;
	public int breakFrequencyMinutes = 30;
	public int breakDurationSeconds = 5;
	
	// Detection
	public boolean detectBobberSplash = true;
	public boolean detectRarity = true;
	public boolean logStatistics = true;
	
	// Hypixel Skyblock specific
	public boolean optimizeForHypixel = true;
	public boolean avoidDetection = true;
	public int castDelay = 500; // Delay between casts (ms)
	public int reelDelay = 100; // Delay before reeling (ms)

	// Statistics
	public boolean trackStats = true;
	public boolean trackRarity = true;
	public boolean autoSaveStats = true;

	public FishingConfig() {
		// Default config for Hypixel Skyblock
	}

	public void enableSafeMode() {
		enableMouseMovement = false;
		enableRandomBreaks = true;
		breakFrequencyMinutes = 20;
		reactionVarianceMs = 30;
		castDelay = 600;
	}

	public void enableAggressive() {
		enableMouseMovement = false;
		enableRandomBreaks = false;
		reactionVarianceMs = 10;
		castDelay = 400;
	}

	public void printConfig() {
		System.out.println("=== Fishing Config ===");
		System.out.println("Human Randomness: " + enableHumanRandomness);
		System.out.println("Reaction Time: " + reactionTimeMs + "ms");
		System.out.println("Variance: " + reactionVarianceMs + "ms");
		System.out.println("Random Breaks: " + enableRandomBreaks);
		System.out.println("Cast Delay: " + castDelay + "ms");
		System.out.println("Optimize for Hypixel: " + optimizeForHypixel);
		System.out.println("======================");
	}
}
