package gg.steve.mc.splugin.economy;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.economy.providers.VaultEconomyProvider;
import gg.steve.mc.splugin.manager.AbstractManager;
import gg.steve.mc.splugin.manager.ManagerClass;
import gg.steve.mc.splugin.utility.ServerUtil;

import java.util.HashMap;
import java.util.Map;

@ManagerClass
public class EconomyManager extends AbstractManager {
    private static EconomyManager instance;
    private SPlugin sPlugin;
    private Map<EconomyType, AbstractEconomyProvider> economies;

    public EconomyManager(SPlugin sPlugin) {
        instance = this;
        this.sPlugin = sPlugin;
        AbstractManager.registerManager(instance);
    }

    @Override
    public void onLoad() {
        for (EconomyType type : EconomyType.values()) {
            registerEconomy(type);
        }
    }

    @Override
    public void onShutdown() {
        if (this.economies != null && !this.economies.isEmpty()) this.economies.clear();
    }

    public boolean registerEconomy(EconomyType type) {
        if (this.economies == null) this.economies = new HashMap<>();
        if (this.economies.containsKey(type)) return false;
        if (!ServerUtil.isUsingPlugin(type.getEconomyPlugin())) return false;
        AbstractEconomyProvider provider;
        switch (type) {
            case VAULT:
                provider = new VaultEconomyProvider();
                break;
            default:
                return false;
        }
        return this.economies.put(type, provider) != null;
    }

    public static EconomyManager getInstance() {
        return instance;
    }

    @Override
    protected String getManagerName() {
        return "Economy";
    }
}
