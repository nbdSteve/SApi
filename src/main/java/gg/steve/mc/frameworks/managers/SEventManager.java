package gg.steve.mc.frameworks.managers;

import gg.steve.mc.frameworks.SApi;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class SEventManager extends AbstractManager{
    private List<Listener> listeners;

    public SEventManager() {
        this.listeners = new ArrayList<>();
    }

    public void addEventListener(Listener listener) {
        if (this.listeners.contains(listener)) return;
        this.listeners.add(listener);
    }

    public void removeEventListener(Listener listener) {
        if (!this.listeners.contains(listener)) return;
        this.listeners.remove(listener);
    }

    public void registerEventListeners() {
        if (this.listeners == null || this.listeners.isEmpty()) return;
        for (Listener listener : this.listeners) {
            SApi.getPluginInstance().getServer().getPluginManager().registerEvents(listener, SApi.getPluginInstance());
        }
    }

    @Override
    public void onLoad() {
        registerEventListeners();
    }

    @Override
    public void onShutdown() {

    }
}
