package gg.steve.mc.splugin.gui.action.types;

import gg.steve.mc.splugin.gui.AbstractGui;
import gg.steve.mc.splugin.gui.GuiManager;
import gg.steve.mc.splugin.gui.action.AbstractInventoryClickAction;
import gg.steve.mc.splugin.gui.exception.AbstractGuiNotFoundException;
import gg.steve.mc.splugin.utility.LogUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class BackInventoryClickAction extends AbstractInventoryClickAction {

    public BackInventoryClickAction() {
        super("back", 1);
    }

    @Override
    public void onClick(AbstractGui gui, Player player, ConfigurationSection section, int slot) {
        if (!gui.isHasParentGui()) return;
        gui.close(player);
        try {
            GuiManager.getInstance().openGui(player, gui.getParentGuiUniqueName());
        } catch (AbstractGuiNotFoundException e) {
            LogUtil.warning(e.getDebugMessage());
            e.printStackTrace();
        }
    }
}