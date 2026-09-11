# OPL Automation Suite - Setup Guide

## Download & Build

### 1. Clone Repository
```bash
git clone https://github.com/JadeSCRIPTZ/opl-mod.git
cd opl-mod
```

### 2. Build with Gradle
```bash
./gradlew build
```

If you're on Windows, use:
```cmd
gradlew.bat build
```

### 3. Find the JAR
```
build/libs/oplmod-1.0.0.jar
```

### 4. Install to Minecraft
Copy `oplmod-1.0.0.jar` to your Minecraft mods folder:

**Windows:**
```
%AppData%\.minecraft\mods\
```

**macOS:**
```
~/Library/Application Support/minecraft/mods/
```

**Linux:**
```
~/.minecraft/mods/
```

### 5. Launch Minecraft
1. Open Minecraft Launcher
2. Select **Minecraft 1.26.2** with **Fabric Loader**
3. Click **Play**

### 6. Use the Mod
1. Join any world
2. Press **T** to open chat
3. Type: `/opl`
4. Configure settings and enjoy!

---

## Requirements

- **Java 21+** - Download from https://www.oracle.com/java/technologies/downloads/
- **Gradle 8.8+** (OR use the wrapper: `./gradlew`)
- **Minecraft 1.26.2**
- **Fabric Loader 0.15.11+**

---

## Troubleshooting

### Build fails with "Java version"
Make sure Java 21+ is installed:
```bash
java -version
```

### Build fails with "Gradle not found"
Use the Gradle wrapper instead:
```bash
./gradlew build
```

### gradlew not executable (Linux/macOS)
```bash
chmod +x gradlew
./gradlew build
```

---

## Using the Mod

### /opl Command
Opens the automation GUI with options for:
- Fishing automation
- Garden automation
- Settings configuration

### Settings
Configure in-game:
- **Pixel Tolerance** (0-255) - Color detection precision
- **Reaction Delay** (ms) - Wait before action
- **Cooldown** (ms) - Wait between actions

Settings are automatically saved.

---

## Need Help?

1. Check Java version: `java -version` (must be 21+)
2. Make sure gradlew is executable: `chmod +x gradlew`
3. Try cleaning and rebuilding: `rm -rf build .gradle && ./gradlew build`
4. Open an issue on GitHub: https://github.com/JadeSCRIPTZ/opl-mod/issues

---

Enjoy your OPL Automation Suite! 🎮
