package gg.steve.mc.frameworks.files;

import java.io.File;

public class SGuiFile extends AbstractDataFile {

    public SGuiFile(String path) {
        super(FileType.GUI.getParentFolder() + File.separator + path, FileType.GUI);
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "gui");
    }
}
