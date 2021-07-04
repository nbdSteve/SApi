package gg.steve.mc.splugin.addon;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.addon.exception.AddonNotFoundException;
import gg.steve.mc.splugin.addon.loader.AddonLoader;
import gg.steve.mc.splugin.manager.AbstractManager;
import gg.steve.mc.splugin.manager.ManagerClass;
import gg.steve.mc.splugin.utility.LogUtil;
import org.apache.commons.lang.Validate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ManagerClass
public class AddonManager extends AbstractManager {
    private static AddonManager instance;
    private SPlugin sPlugin;
    private Map<String, AbstractAddon> addons;
    private AddonLoader loader;


    public AddonManager(SPlugin sPlugin) {
        instance = this;
        this.sPlugin = sPlugin;
        this.addons = new HashMap<>();
        this.loader = new AddonLoader(this.sPlugin);
        AbstractManager.registerManager(instance);
    }

    @Override
    public void onLoad() {
        this.loader.registerAllAddons();
        LogUtil.warning("Registered addons: " + this.addons.keySet().toString());
    }

    @Override
    public void onShutdown() {
        this.unregisterAllAddons();
    }

    public boolean registerAddon(String identifier) {
        if (this.addons == null) this.addons = new HashMap<>();
        if (this.addons.containsKey(identifier.toUpperCase(Locale.ROOT))) return false;
        return this.loader.registerAddon(identifier);
    }

    public boolean registerAddon(AbstractAddon addon) {
        Validate.notNull(addon, "Trying to install addon that is null");
        Validate.notNull(addon.getIdentifier(), "Addon must have a unique identifier");
        if (addons == null) addons = new HashMap<>();
        if (addons.containsKey(addon.getIdentifier())) return false;
        return addons.put(addon.getIdentifier(), addon) != null;
    }

    public boolean isRegistered(String identifier) {
        if (this.addons == null || this.addons.isEmpty()) return false;
        return this.addons.get(identifier) != null;
    }

    public AbstractAddon getAddon(String identifier) throws AddonNotFoundException {
        if (!isRegistered(identifier)) throw new AddonNotFoundException(identifier);
        return this.addons.get(identifier);
    }

    public boolean unregisterAddon(AbstractAddon addon) {
        if (this.addons == null || this.addons.isEmpty()) return false;
        if (!this.addons.containsKey(addon.getIdentifier())) return false;
        this.addons.get(addon.getIdentifier()).unregister();
        return this.addons.remove(addon.getIdentifier()) != null;
    }

    public void unregisterAllAddons() {
        if (this.addons != null && !this.addons.isEmpty()) {
            this.addons.forEach((s, addon) -> addon.unregister());
            this.addons.clear();
        }
    }

    public Collection<AbstractAddon> getRegisteredAddons() {
        return this.addons.values();
    }

    public static AddonManager getInstance() {
        return instance;
    }

    @Override
    protected String getManagerName() {
        return "Addon";
    }
}
