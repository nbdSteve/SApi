package gg.steve.mc.splugin.economy;

public enum EconomyType {
    VAULT("Vault");

    private String pluginName;

    EconomyType(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getEconomyPlugin() {
        return this.pluginName;
    }
}