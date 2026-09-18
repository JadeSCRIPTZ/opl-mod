"""
OPL Automation Suite - Python Launcher
Downloads and runs the pre-built Minecraft mod without needing Java installed locally
"""
import os
import sys
import json
import platform
import subprocess
import urllib.request
import zipfile
from pathlib import Path

class OPLLauncher:
    def __init__(self):
        self.mod_name = "oplmod"
        self.version = "1.0.0"
        self.repo = "JadeSCRIPTZ/opl-mod"
        self.os_type = platform.system()  # Windows, Linux, Darwin
        self.home = str(Path.home())
        
    def get_minecraft_path(self):
        """Get Minecraft installation path based on OS"""
        if self.os_type == "Windows":
            return os.path.join(os.environ.get("APPDATA", ""), ".minecraft")
        elif self.os_type == "Darwin":  # macOS
            return os.path.join(self.home, "Library/Application Support/minecraft")
        else:  # Linux
            return os.path.join(self.home, ".minecraft")
    
    def get_mods_path(self):
        """Get mods folder path"""
        mc_path = self.get_minecraft_path()
        mods_path = os.path.join(mc_path, "mods")
        os.makedirs(mods_path, exist_ok=True)
        return mods_path
    
    def check_java(self):
        """Check if Java is installed"""
        try:
            result = subprocess.run(["java", "-version"], 
                                  capture_output=True, text=True)
            if result.returncode == 0:
                return True
        except:
            pass
        return False
    
    def download_jar(self):
        """Download pre-built JAR from GitHub releases"""
        print("📥 Downloading OPL mod JAR...")
        
        # GitHub API to get latest release
        api_url = f"https://api.github.com/repos/{self.repo}/releases/latest"
        
        try:
            with urllib.request.urlopen(api_url) as response:
                data = json.loads(response.read().decode())
                
            # Find JAR asset
            jar_url = None
            for asset in data.get("assets", []):
                if "oplmod" in asset["name"] and asset["name"].endswith(".jar"):
                    jar_url = asset["browser_download_url"]
                    break
            
            if not jar_url:
                print("❌ JAR not found in releases")
                print(f"📍 Download manually from: https://github.com/{self.repo}/releases")
                return False
            
            # Download
            jar_path = os.path.join(self.get_mods_path(), "oplmod-1.0.0.jar")
            print(f"📍 Downloading from: {jar_url}")
            urllib.request.urlretrieve(jar_url, jar_path)
            print(f"✅ Downloaded to: {jar_path}")
            return True
            
        except Exception as e:
            print(f"❌ Download failed: {e}")
            return False
    
    def verify_minecraft(self):
        """Check if Minecraft is installed"""
        mc_path = self.get_minecraft_path()
        if not os.path.exists(mc_path):
            print(f"❌ Minecraft not found at: {mc_path}")
            return False
        print(f"✅ Minecraft found at: {mc_path}")
        return True
    
    def verify_fabric(self):
        """Check if Fabric Loader is installed"""
        mc_path = self.get_minecraft_path()
        fabric_dir = os.path.join(mc_path, "mods")
        if not os.path.exists(fabric_dir):
            print("⚠️  Fabric Loader might not be installed")
            print("   Download from: https://fabricmc.net/")
            return False
        print("✅ Mods folder found (Fabric likely installed)")
        return True
    
    def install(self):
        """Install the mod"""
        print("="*60)
        print("OPL Automation Suite - Installation")
        print("="*60)
        print()
        
        # Check requirements
        print("🔍 Checking requirements...")
        print()
        
        if not self.verify_minecraft():
            print("\n❌ Please install Minecraft first")
            print("   Download from: https://www.minecraft.net/")
            return False
        
        if not self.verify_fabric():
            print("\n⚠️  You need Fabric Loader 0.15.11+")
            print("   Download from: https://fabricmc.net/use/installer/")
        
        print()
        print("📦 Installing OPL Automation Suite...")
        print()
        
        # Download JAR
        if not self.download_jar():
            print("\n💡 Alternative: Download manually from GitHub releases")
            print(f"   https://github.com/{self.repo}/releases")
            return False
        
        print()
        print("✅ Installation complete!")
        print()
        print("="*60)
        print("NEXT STEPS:")
        print("="*60)
        print("1. Open Minecraft Launcher")
        print("2. Select: Minecraft 1.26.2 + Fabric Loader")
        print("3. Click: PLAY")
        print("4. Join any world")
        print("5. Press: T (to open chat)")
        print("6. Type: /opl")
        print("7. Enjoy automated fishing! 🎣")
        print("="*60)
        return True

if __name__ == "__main__":
    launcher = OPLLauncher()
    success = launcher.install()
    sys.exit(0 if success else 1)
