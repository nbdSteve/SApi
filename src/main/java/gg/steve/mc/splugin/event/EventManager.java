package gg.steve.mc.splugin.event;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.manager.AbstractManager;
import gg.steve.mc.splugin.manager.ManagerClass;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@ManagerClass
public class EventManager extends AbstractManager {
    private static EventManager instance;
    private SPlugin sPlugin;

    public EventManager(SPlugin sPlugin) {
        instance = this;
        this.sPlugin = sPlugin;
        AbstractManager.registerManager(instance);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onShutdown() {

    }

    @Override
    protected String getManagerName() {
        return "Event";
    }

    public void registerListener(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, this.sPlugin.getPlugin());
    }
}
