package gg.steve.mc.frameworks.managers;

import gg.steve.mc.frameworks.files.AbstractDataFile;
import gg.steve.mc.frameworks.files.ConfigurationFile;
import gg.steve.mc.frameworks.files.PlayerDataFile;

import java.util.*;

public class FileManager extends AbstractManager {
    private Map<String, ConfigurationFile> configurationFiles;
    private Map<UUID, PlayerDataFile> playerDataFiles;

    public FileManager() {
        this.configurationFiles = new HashMap<>();
        this.playerDataFiles = new HashMap<>();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onShutdown() {

    }
}
