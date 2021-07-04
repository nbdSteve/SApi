package gg.steve.mc.splugin.addon.exception;

import gg.steve.mc.splugin.exception.AbstractException;
import gg.steve.mc.splugin.exception.ExceptionClass;

@ExceptionClass
public class AddonNotFoundException extends AbstractException {
    private final String addon;

    public AddonNotFoundException(String addon) {
        this.addon = addon;
    }

    @Override
    public String getDebugMessage() {
        return "Unable to find the addon with name: " + addon;
    }
}
