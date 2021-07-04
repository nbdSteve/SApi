package gg.steve.mc.splugin.addon.loader;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.addon.AddonManager;
import gg.steve.mc.splugin.addon.AbstractAddon;
import gg.steve.mc.splugin.utility.FileClassUtil;
import gg.steve.mc.splugin.utility.LogUtil;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.List;

public class AddonLoader {
    private final SPlugin sPlugin;

    public AddonLoader(SPlugin sPlugin) {
        this.sPlugin = sPlugin;
        File addonsFolder = new File(this.sPlugin.getPlugin().getDataFolder(), "addons");
        if (!addonsFolder.exists()) {
            addonsFolder.mkdirs();
        }
    }

    public void registerAllAddons() {
        if (this.sPlugin.getPlugin() == null) return;
        List<Class<?>> classes = FileClassUtil.getClasses(this.sPlugin.getPlugin(), "addons", AbstractAddon.class);
        if (classes == null || classes.isEmpty()) return;
        classes.forEach(klass -> {
            AbstractAddon addon = this.createAddonInstance(klass);
            this.registerAddon(addon);
        });
    }

    public boolean registerAddon(String addonName) {
        String builder = addonName.toUpperCase().charAt(0) + addonName.substring(1).toLowerCase() + "Addon";
        List<Class<?>> subs = FileClassUtil.getClasses(this.sPlugin.getPlugin(), "addons", builder, AbstractAddon.class);
        if (subs == null || subs.isEmpty()) {
            return false;
        }
        AbstractAddon addon = createAddonInstance(subs.get(0));
        registerAddon(addon);
        return true;
    }

    public void registerAddon(AbstractAddon addon) {
        addon.register();
        AddonManager.getInstance().registerAddon(addon);
    }

    private AbstractAddon createAddonInstance(Class<?> klass) {
        if (klass == null) return null;
        AbstractAddon addon = null;
        if (!AbstractAddon.class.isAssignableFrom(klass)) return null;
        try {
            Constructor<?>[] c = klass.getConstructors();
            if (c.length == 0) {
                addon = (AbstractAddon) klass.newInstance();
            } else {
                for (Constructor<?> con : c) {
                    if (con.getParameterTypes().length == 0) {
                        addon = (AbstractAddon) klass.newInstance();
                        break;
                    }
                }
            }
        } catch (Throwable t) {
            LogUtil.warning(t.getMessage());
            LogUtil.warning("Failed to init CustomPlugin addon from class: " + klass.getName());
        }
        return addon;
    }
}
