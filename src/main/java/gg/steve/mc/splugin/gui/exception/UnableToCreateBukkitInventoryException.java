package gg.steve.mc.splugin.gui.exception;

import gg.steve.mc.splugin.exception.AbstractException;
import gg.steve.mc.splugin.exception.ExceptionClass;

@ExceptionClass
public class UnableToCreateBukkitInventoryException extends AbstractException {
    private final String guiUniqueName;

    public UnableToCreateBukkitInventoryException(String guiUniqueName) {
        this.guiUniqueName = guiUniqueName;
    }

    @Override
    public String getDebugMessage() {
        return "Unable to create the bukkit gui for custom gui: " + this.guiUniqueName;
    }
}
