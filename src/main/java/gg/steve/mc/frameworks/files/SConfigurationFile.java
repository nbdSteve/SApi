package gg.steve.mc.frameworks.files;

public class SConfigurationFile extends AbstractDataFile {

    public SConfigurationFile(String path) {
        super(path, FileType.CONFIGURATION);
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "configuration");
    }
}