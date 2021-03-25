package gg.steve.mc.frameworks.files;

import gg.steve.mc.frameworks.SApi;

import java.io.File;
import java.util.UUID;

public class PlayerDataFile extends AbstractDataFile {
    private UUID playerId;

    public PlayerDataFile(UUID playerId) {
        super(SApi.getPlayerDataFolder() + File.separator + String.valueOf(playerId));
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "player");
    }
}
