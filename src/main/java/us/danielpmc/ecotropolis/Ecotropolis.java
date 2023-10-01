package us.danielpmc.ecotropolis;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import us.danielpmc.ecotropolis.init.Commands;
import us.danielpmc.ecotropolis.config.BanConfig;
import us.danielpmc.ecotropolis.init.Listeners;
import us.danielpmc.ecotropolis.util.TPSRunnable;

public class Ecotropolis extends JavaPlugin{
    public final Logger logger = Logger.getLogger("Minecraft");
    public static Ecotropolis plugin;
    public String version = "3.0";
    public String prefix = "&8[&6&lEcotropolis&8] ";
    public String about = prefix + "&3Ecotropolis is a custom plugin coded by &6danielpmc &3and is running Version: " + version;

    public FileConfiguration config;
    public BanConfig banConfig;

    public Ecotropolis() {
        this.banConfig = new BanConfig(this);
    }

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Has been Enabled!");

        this.config = getConfig();
        this.config.addDefault("serverName", "&6&lEcotropolis Network");
        this.config.addDefault("discord", "https://discord.gg/75BeDWP");
        this.config.addDefault("website", "https://ecotropolis.us");
        this.config.addDefault("prefix", "&eEB &7> &r ");
        this.config.addDefault("useEasyBanPermissions", false);
        getConfig().options().copyDefaults(true);
        this.saveConfig();

        Commands.init(this);
        Listeners.init(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPSRunnable(), 100L, 1L);
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this. getDescription();
        this.logger.info(pdfFile.getName() + " Has been Disabled!");
    }
}



