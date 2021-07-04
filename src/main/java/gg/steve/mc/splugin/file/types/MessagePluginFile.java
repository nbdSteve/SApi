package gg.steve.mc.splugin.file.types;

import gg.steve.mc.splugin.SPlugin;
import gg.steve.mc.splugin.file.AbstractPluginFile;
import gg.steve.mc.splugin.file.PluginFileClass;
import gg.steve.mc.splugin.file.PluginFileType;
import gg.steve.mc.splugin.message.MessageManager;

import java.io.File;

@PluginFileClass
public class MessagePluginFile extends AbstractPluginFile {

    public MessagePluginFile(String name, File file, SPlugin sPlugin) {
        super(name, file, PluginFileType.MESSAGE, sPlugin);
        // Register all messages from the file with the plugin
        MessageManager.getInstance().registerMessagesFromFile(this);
    }
}
