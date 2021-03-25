package gg.steve.mc.frameworks.files;

import gg.steve.mc.frameworks.SApi;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractDataFile {
    private YamlConfiguration configuration;
    private File file;
    private String path;
    private FileType type;

    public AbstractDataFile(String path, FileType type) {
        this.path = path;
        this.type = type;
        this.load();
    }

    public void load() {
        JavaPlugin instance = SApi.getPluginInstance();
        this.file = new File(instance.getDataFolder(), this.path);
        if (!file.exists()) {
            instance.saveResource(this.path, false);
            instance.getLogger().info("The internal YAML file: " + this.path +
                    " was not found, actively creating / loading it now.");
            setupConfigurationDefaults();
        }
        this.configuration = new YamlConfiguration();
        try {
            this.configuration.load(file);
        } catch (InvalidConfigurationException e) {
            instance.getLogger().severe("The supplied file " + this.path +
                    " is not in the correct format, please check your YAML syntax.");
        } catch (FileNotFoundException e) {
            instance.getLogger().severe("The supplied file " + this.path +
                    " was not found, please contact the developer. Disabling the plugin.");
            instance.getServer().getPluginManager().disablePlugin(instance);
        } catch (IOException e) {
            instance.getLogger().severe("The supplied file " + this.path +
                    " could not be loaded, please contact the developer. Disabling the plugin.");
            instance.getServer().getPluginManager().disablePlugin(instance);
        }
    }

    public abstract void setupConfigurationDefaults();

    public boolean isConfigurationLoaded() {
        return this.configuration != null;
    }

    public YamlConfiguration getConfiguration() {
        if (!isConfigurationLoaded()) this.load();
        return this.configuration;
    }

    public File getFile() {
        return this.file;
    }

    public FileType getType() {
        return type;
    }
}