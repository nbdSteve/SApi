package gg.steve.mc.frameworks.files;

import java.io.File;
import java.util.UUID;

public class SPlayerDataFile extends AbstractDataFile {
    private UUID playerId;

    public SPlayerDataFile(UUID playerId) {
        super(FileType.PLAYER.getParentFolder() + File.separator + String.valueOf(playerId), FileType.PLAYER);
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "player");
    }
}
