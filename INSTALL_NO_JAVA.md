# OPL Automation Suite - Installation (No Java Required!)

**Easiest way to install - just Python!**

## 📋 Requirements

- ✅ Minecraft 1.26.2 installed
- ✅ Fabric Loader 0.15.11+ installed
- ✅ Python 3 (any version)
- ❌ NO Java needed!

## 🚀 Quick Install (3 Steps)

### Step 1: Install Python (if not already installed)

**Windows:**
1. Go to: https://www.python.org/downloads/
2. Download Python installer
3. ⚠️ **IMPORTANT**: Check "Add Python to PATH" during installation
4. Click Install

**macOS:**
```bash
brew install python3
```

**Linux:**
```bash
sudo apt install python3
```

### Step 2: Download Installer

**Option A: Fastest**
- Go to: https://github.com/JadeSCRIPTZ/opl-mod
- Click "Code" → Download ZIP
- Extract ZIP to a folder

**Option B: Clone with Git**
```bash
git clone https://github.com/JadeSCRIPTZ/opl-mod.git
cd opl-mod
```

### Step 3: Run Installer

**Windows:**
1. Double-click: `install-opl.bat`
2. Wait for download to complete
3. Done! ✅

**macOS/Linux:**
```bash
./install-opl.sh
```

## 📍 What the Installer Does

✅ Checks if Minecraft is installed
✅ Checks if Fabric Loader is installed  
✅ Downloads the pre-built OPL JAR
✅ Copies it to `~/.minecraft/mods/`
✅ Done!

## 🎮 Using the Mod

1. **Launch Minecraft**
   - Open Minecraft Launcher
   - Select: Minecraft 1.26.2
   - Select: Fabric Loader profile
   - Click: PLAY

2. **Join World**
   - Single Player or Hypixel Skyblock
   - Join any world

3. **Open Mod**
   - Press: `T` (chat)
   - Type: `/opl`
   - Press: ENTER

4. **Configure**
   - Click: Settings
   - Adjust options
   - Click: Save

5. **Fish!**
   - Click: START Automation
   - Click: START Fishing
   - Equip fishing rod
   - Cast and macro catches automatically! 🎣

## 🆘 Troubleshooting

### "Python not found" (Windows)
- Python not installed or not in PATH
- Solution:
  1. Install Python from: https://www.python.org/downloads/
  2. **IMPORTANT**: Check "Add Python to PATH" during installation
  3. Restart computer
  4. Try again

### "Minecraft not found"
- Minecraft installation path not detected
- Solution:
  1. Make sure Minecraft is installed
  2. Try launching Minecraft once
  3. Close installer and try again

### "Fabric Loader not found"
- Fabric not installed yet
- Solution:
  1. Download Fabric from: https://fabricmc.net/use/installer/
  2. Install Fabric for Minecraft 1.26.2
  3. Try installer again

### Installer still fails
- Download manually:
  1. Go to: https://github.com/JadeSCRIPTZ/opl-mod/releases
  2. Download: `oplmod-1.0.0.jar`
  3. Copy to: `~/.minecraft/mods/`
  4. Done!

## 📊 System Paths

The installer automatically detects and uses:

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

## ✅ Verification

After installation, verify:

1. ✅ Check mods folder contains: `oplmod-1.0.0.jar`
2. ✅ Launch Minecraft 1.26.2 + Fabric
3. ✅ See mod loading in launcher
4. ✅ Type `/opl` in game
5. ✅ GUI appears

## 📞 Support

If installation fails:

1. Check GitHub Issues: https://github.com/JadeSCRIPTZ/opl-mod/issues
2. Manual download: https://github.com/JadeSCRIPTZ/opl-mod/releases
3. Try alternative installation method

---

**Enjoy OPL Automation Suite!** 🎣
