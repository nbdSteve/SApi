package gg.steve.mc.splugin.file.types;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.file.AbstractPluginFile;
import gg.steve.mc.splugin.file.PluginFileClass;
import gg.steve.mc.splugin.file.PluginFileType;

import java.io.File;

@PluginFileClass
public class ConfigurationPluginFile extends AbstractPluginFile {

    public ConfigurationPluginFile(String name, File file, SPlugin sPlugin) {
        super(name, file, PluginFileType.CONFIGURATION, sPlugin);
    }
}
