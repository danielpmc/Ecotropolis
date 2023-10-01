package us.danielpmc.ecotropolis.init;

import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.commands.*;

public class Commands {
    public static void init(Ecotropolis plugin) {
        plugin.getCommand("efly").setExecutor(new CommandFlyEnable(plugin));
        plugin.getCommand("dfly").setExecutor(new CommandFlyDisable(plugin));
        plugin.getCommand("heal").setExecutor(new CommandHeal(plugin));
        plugin.getCommand("feed").setExecutor(new CommandFeed(plugin));
        plugin.getCommand("gmc").setExecutor(new CommandGMC(plugin));
        plugin.getCommand("gms").setExecutor(new CommandGMS(plugin));
        plugin.getCommand("tp").setExecutor(new CommandTP(plugin));
        plugin.getCommand("discord").setExecutor(new CommandDiscord(plugin));
        plugin.getCommand("website").setExecutor(new CommandWebsite(plugin));
        plugin.getCommand("ecoabout").setExecutor(new CommandAbout(plugin));
        plugin.getCommand("etps").setExecutor(new CommandTPS(plugin));
        plugin.getCommand("eban").setExecutor(new CommandBan(plugin));
        plugin.getCommand("eunban").setExecutor(new CommandUnban(plugin));
        plugin.getCommand("ereload").setExecutor(new CommandReload(plugin));

        plugin.getCommand("efly").setTabCompleter(new CommandFlyEnable(plugin));
        plugin.getCommand("dfly").setTabCompleter(new CommandFlyDisable(plugin));
        plugin.getCommand("heal").setTabCompleter(new CommandHeal(plugin));
        plugin.getCommand("feed").setTabCompleter(new CommandFeed(plugin));
        plugin.getCommand("gmc").setTabCompleter(new CommandGMC(plugin));
        plugin.getCommand("gms").setTabCompleter(new CommandGMS(plugin));
        plugin.getCommand("tp").setTabCompleter(new CommandTP(plugin));
        plugin.getCommand("discord").setTabCompleter(new CommandDiscord(plugin));
        plugin.getCommand("website").setTabCompleter(new CommandWebsite(plugin));
        plugin.getCommand("ecoabout").setTabCompleter(new CommandAbout(plugin));
        plugin.getCommand("etps").setTabCompleter(new CommandTPS(plugin));
        plugin.getCommand("eban").setTabCompleter(new CommandBan(plugin));
        plugin.getCommand("eunban").setTabCompleter(new CommandUnban(plugin));
        plugin.getCommand("ereload").setTabCompleter(new CommandReload(plugin));
    }
}
