package com.jadescript.oplmod.config;

import net.minecraft.client.Minecraft;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ConfigManager {

	private static ConfigManager instance;

	private int pixelTolerance = 15;
	private int reactionDelay = 100;
	private int cooldown = 500;

	private ConfigManager() {
		load();
	}

	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}

	public void load() {
		try {
			File configFile = getConfigFile();
			if (!configFile.exists()) {
				save();
				return;
			}

			StringBuilder sb = new StringBuilder();
			try (FileReader reader = new FileReader(configFile)) {
				char[] chars = new char[1024];
				int len;
				while ((len = reader.read(chars)) != -1) {
					sb.append(chars, 0, len);
				}
			}

			String[] lines = sb.toString().split("\n");
			for (String line : lines) {
				if (line.startsWith("pixelTolerance=")) {
					pixelTolerance = Integer.parseInt(line.split("=")[1].trim());
				} else if (line.startsWith("reactionDelay=")) {
					reactionDelay = Integer.parseInt(line.split("=")[1].trim());
				} else if (line.startsWith("cooldown=")) {
					cooldown = Integer.parseInt(line.split("=")[1].trim());
				}
			}
		} catch (Exception e) {
		}
	}

	public void save() {
		try {
			File configFile = getConfigFile();
			configFile.getParentFile().mkdirs();

			try (FileWriter writer = new FileWriter(configFile)) {
				writer.write("pixelTolerance=" + pixelTolerance + "\n");
				writer.write("reactionDelay=" + reactionDelay + "\n");
				writer.write("cooldown=" + cooldown + "\n");
			}
		} catch (IOException e) {
		}
	}

	private File getConfigFile() {
		File gameDir = Minecraft.getInstance().gameDirectory;
		File configDir = new File(gameDir, "config/oplmod");
		return new File(configDir, "settings.properties");
	}

	public int getPixelTolerance() { return pixelTolerance; }
	public void setPixelTolerance(int value) { this.pixelTolerance = Math.max(0, Math.min(255, value)); }
	
	public int getReactionDelay() { return reactionDelay; }
	public void setReactionDelay(int value) { this.reactionDelay = Math.max(0, value); }
	
	public int getCooldown() { return cooldown; }
	public void setCooldown(int value) { this.cooldown = Math.max(0, value); }
}
