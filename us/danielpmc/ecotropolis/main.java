package us.danielpmc.ecotropolis;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import us.danielpmc.ecotropolis.commands.*;
import org.bukkit.Bukkit;
import us.danielpmc.ecotropolis.listeners.PlayerHandler;
import us.danielpmc.ecotropolis.commands.Ban;
import us.danielpmc.ecotropolis.config.BanConfig;

public class main extends JavaPlugin{
    public final Logger logger = Logger.getLogger("Minecraft");
    public static main plugin;
    public String prefix = "§eEB §7> §r ";

    public BanConfig banconfig;



    public main()

    {

        this.banconfig = new BanConfig(this);

    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this. getDescription();
        this.logger.info(pdfFile.getName() + " Has been Disabled!");
    }
    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Has been Enabled!");
        getConfig().options().copyDefaults(true);
        this.getCommand("efly").setExecutor((CommandExecutor)new EcotropolisFlyEnable());
        this.getCommand("dfly").setExecutor((CommandExecutor)new EcotropolisFlyDisable());
        this.getCommand("heal").setExecutor((CommandExecutor)new EcotropolisHeal());
        this.getCommand("feed").setExecutor((CommandExecutor)new EcotropolisFeed());
        this.getCommand("gmc").setExecutor((CommandExecutor)new EcotropolisGMC());
        this.getCommand("gms").setExecutor((CommandExecutor)new EcotropolisGMS());
        this.getCommand("tp").setExecutor((CommandExecutor)new EcotropolisTP());
        this.getCommand("discord").setExecutor((CommandExecutor)new EcotropolisDiscord());
        this.getCommand("website").setExecutor((CommandExecutor)new EcotropolisWebsite());
        this.getCommand("ecoabout").setExecutor((CommandExecutor)new EcotropolisAbout());
        this.getCommand("etps").setExecutor((CommandExecutor)new EcotropolisTPS2());
        this.getCommand("eban").setExecutor(new Ban(this));
        this.getCommand("eunban").setExecutor(new Unban(this));
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new EcotropolisTPS(), 100L, 1L);
    }
    void setup()

    {

        getCommand("eban").setExecutor(new Ban(this));



        getServer().getPluginManager().registerEvents(new PlayerHandler(this), this);

    }
}



