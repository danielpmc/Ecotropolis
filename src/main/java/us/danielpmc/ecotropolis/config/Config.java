package us.danielpmc.ecotropolis.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import us.danielpmc.ecotropolis.Ecotropolis;

import java.io.File;
import java.io.IOException;

public abstract class Config {
    private final Ecotropolis plugin;

    private FileConfiguration config = null;

    private File configFile = null;

    public abstract String getName();

    public Config(Ecotropolis instance) {
        plugin = instance;
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }



    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }

        return config;
    }



    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), this.getName() + ".yml");
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }



    public void saveConfig() {
        if ((config == null) || (configFile == null)) {
            return;
        }

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
