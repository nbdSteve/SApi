package gg.steve.mc.frameworks.files;

import java.io.File;

public class SMessageFile extends AbstractDataFile {

    public SMessageFile(String path) {
        super(FileType.MESSAGE.getParentFolder() + File.separator + path, FileType.MESSAGE);
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "message");
    }
}
