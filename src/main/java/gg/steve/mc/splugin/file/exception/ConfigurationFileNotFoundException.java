package gg.steve.mc.splugin.file.exception;

import gg.steve.mc.splugin.exception.AbstractException;
import gg.steve.mc.splugin.exception.ExceptionClass;

@ExceptionClass
public class ConfigurationFileNotFoundException extends AbstractException {
    private final String file;

    public ConfigurationFileNotFoundException(String file) {
        this.file = file;
    }

    @Override
    public String getDebugMessage() {
        return "Unable to find the desired configuration file: " + file;
    }
}
