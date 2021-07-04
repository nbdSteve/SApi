package gg.steve.mc.splugin.economy;

import lombok.Data;

@Data
public abstract class AbstractEconomyProvider {
    private EconomyType economyType;

    public AbstractEconomyProvider(EconomyType economyType) {
        this.economyType = economyType;
    }

    public abstract boolean isUsingEconomy();

    public abstract void hookIntoEconomyProvider();

    public abstract boolean isEconomyHooked();
}
