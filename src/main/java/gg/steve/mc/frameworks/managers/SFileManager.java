package gg.steve.mc.frameworks.managers;

import gg.steve.mc.frameworks.SApi;
import gg.steve.mc.frameworks.files.SConfigurationFile;
import gg.steve.mc.frameworks.files.SGuiFile;
import gg.steve.mc.frameworks.files.SMessageFile;
import gg.steve.mc.frameworks.files.SPlayerDataFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SFileManager extends AbstractManager {
    private Map<String, SConfigurationFile> configurationFiles;
    private Map<UUID, SPlayerDataFile> playerDataFiles;
    private Map<String, SGuiFile> guiFiles;
    private Map<String, SMessageFile> langFiles;

    public SFileManager() {
        this.configurationFiles = new HashMap<>();
        this.playerDataFiles = new HashMap<>();
        this.guiFiles = new HashMap<>();
        this.langFiles = new HashMap<>();
    }

    @Override
    public void onLoad() {
        if (SApi.getPluginInstance().getDataFolder().exists()) return;
        for (File file : SApi.getPluginInstance().getDataFolder().listFiles()) {
            if (file.isDirectory()) {
                for (File sub1 : file.listFiles()) {

                }
            } else {
                configurationFiles.put(file.getName().split(".yml")[0], new SConfigurationFile(file.getName()));
            }
        }
    }

    @Override
    public void onShutdown() {

    }
}
