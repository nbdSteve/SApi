package gg.steve.mc.splugin;

import gg.steve.mc.splugin.utility.LogUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomPlugin extends JavaPlugin {
    private static CustomPlugin instance;
    private SPlugin SPlugin;

    @Override
    public void onLoad() {
        instance = this;
        LogUtil.setPluginInstance(instance);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.SPlugin = new SPlugin(instance);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (this.SPlugin != null) this.SPlugin.shutdown();
    }

    public static CustomPlugin getInstance() {
        return instance;
    }
}
