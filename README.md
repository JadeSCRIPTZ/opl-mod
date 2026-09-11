# OPL Automation Suite

Minecraft Fabric mod for version 1.26.2 with automation macros.

## Installation

1. Download `oplmod-1.0.0.jar` from Releases
2. Copy to `~/.minecraft/mods/`
3. Launch Minecraft 1.26.2 with Fabric Loader

## Usage

Type `/opl` in chat to open the automation GUI.

### Features

- Fishing Macro with pixel detection
- Garden automation
- Configurable settings (in-game)
  - Pixel Tolerance
  - Reaction Delay
  - Cooldown

### Settings

Configure in-game:
- Pixel Tolerance: 0-255
- Reaction Delay: milliseconds
- Cooldown: milliseconds

Settings are automatically saved.

## Building

```bash
./gradlew build
```

Output: `build/libs/oplmod-1.0.0.jar`

## Requirements

- Minecraft 1.26.2
- Fabric Loader 0.15.11+
- Java 21+

## License

MIT License
