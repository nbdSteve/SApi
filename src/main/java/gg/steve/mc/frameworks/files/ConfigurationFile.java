package gg.steve.mc.frameworks.files;

public class ConfigurationFile extends AbstractDataFile {

    public ConfigurationFile(String path) {
        super(path);
    }

    @Override
    public void setupConfigurationDefaults() {
        getConfiguration().set("file-type", "configuration");
    }
}
