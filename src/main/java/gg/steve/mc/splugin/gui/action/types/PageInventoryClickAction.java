package gg.steve.mc.splugin.gui.action.types;

import gg.steve.mc.splugin.gui.AbstractGui;
import gg.steve.mc.splugin.gui.action.AbstractInventoryClickAction;
import gg.steve.mc.splugin.utility.LogUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Locale;

public class PageInventoryClickAction extends AbstractInventoryClickAction {

    enum Direction {
        NEXT,
        PREVIOUS;
    }

    public PageInventoryClickAction() {
        super("page", 2);
    }

    @Override
    public void onClick(AbstractGui gui, Player player, ConfigurationSection section, int slot) {
        Direction direction = getDirection(section.getString("action"));
        if (direction == null) return;
        switch (direction) {
            case NEXT:
                gui.nextPage();
                break;
            case PREVIOUS:
                gui.previousPage();
                break;
        }
    }

    public Direction getDirection(String actionFromConfig) {
        try {
            return Direction.valueOf(actionFromConfig.split(":")[1].toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            LogUtil.warning("Tried to determine page direction but the entry was invalid, defaulting to doing nothing.");
            return null;
        }
    }
}
