#!/bin/bash
# OPL Automation Suite - Linux/macOS Installer
# No Java required - just Python!

echo ""
echo "========================================"
echo "OPL Automation Suite - Installer"
echo "========================================"
echo ""

# Check Python
if ! command -v python3 &> /dev/null; then
    echo "❌ Python not found!"
    echo ""
    echo "Install Python 3:"
    echo "  macOS: brew install python3"
    echo "  Linux: sudo apt install python3"
    exit 1
fi

echo "✅ Python found!"
echo ""

# Run launcher
python3 launcher.py

if [ $? -ne 0 ]; then
    echo ""
    echo "Installation failed. Try downloading manually from:"
    echo "https://github.com/JadeSCRIPTZ/opl-mod/releases"
    exit 1
fi

echo ""
