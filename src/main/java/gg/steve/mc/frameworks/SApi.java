package gg.steve.mc.frameworks;

import gg.steve.mc.frameworks.managers.AbstractManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SApi {
    // store the main java instance for the plugin
    private static JavaPlugin pluginInstance;
    // set the root folder for player data, defaults to player-data
    private static String playerDataFolder;

    public static boolean setPluginInstance(JavaPlugin instance) {
        pluginInstance = instance;
        return pluginInstance != null;
    }

    public static boolean setPlayerDataFolder(String path) {
        playerDataFolder = path;
        return playerDataFolder.equalsIgnoreCase(path);
    }

    public static List<AbstractManager> getActiveManagers() {
        return AbstractManager.getActiveManagers();
    }

    public static JavaPlugin getPluginInstance() {
        return pluginInstance;
    }

    public static String getPlayerDataFolder() {
        if (playerDataFolder == null || playerDataFolder.equalsIgnoreCase("")) return "player-data";
        return playerDataFolder;
    }
}
