package gg.steve.mc.splugin.permission.exceptions;

import gg.steve.mc.splugin.exception.AbstractException;
import gg.steve.mc.splugin.exception.ExceptionClass;

@ExceptionClass
public class PermissionNotFoundException extends AbstractException {
    private final String permission;

    public PermissionNotFoundException(String permission) {
        this.permission = permission;
    }

    @Override
    public String getDebugMessage() {
        return "Unable to locate permission with key: " + permission;
    }
}
