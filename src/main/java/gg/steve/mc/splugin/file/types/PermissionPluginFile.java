package gg.steve.mc.splugin.file.types;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.file.AbstractPluginFile;
import gg.steve.mc.splugin.file.PluginFileClass;
import gg.steve.mc.splugin.file.PluginFileType;

import java.io.File;

@PluginFileClass
public class PermissionPluginFile extends AbstractPluginFile {

    public PermissionPluginFile(String name, File file, SPlugin sPlugin) {
        super(name, file, PluginFileType.PERMISSION, sPlugin);
        // Register all of the permissions from the file with the plugin
        sPlugin.getPermissionManager().registerPermissionsFromFile(this);
    }
}
