@echo off
REM OPL Automation Suite - Windows Installer
REM No Java required - just Python!

echo.
echo ========================================
echo OPL Automation Suite - Installer
echo ========================================
echo.

REM Check Python
python --version >nul 2>&1
if errorlevel 1 (
    echo Error: Python not found!
    echo.
    echo Download Python from: https://www.python.org/downloads/
    echo Make sure to check "Add Python to PATH" during installation
    pause
    exit /b 1
)

echo Python found!
echo.

REM Run launcher
python launcher.py

if errorlevel 1 (
    echo.
    echo Installation failed. Try downloading manually from:
    echo https://github.com/JadeSCRIPTZ/opl-mod/releases
    pause
    exit /b 1
)

echo.
echo Press any key to exit...
pause
