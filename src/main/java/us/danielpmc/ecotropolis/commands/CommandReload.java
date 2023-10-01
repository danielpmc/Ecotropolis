package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandReload implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandReload(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("ecotropolis.reload")) {
            sender.sendMessage(Util.transform(plugin.prefix + "4No Permission!"));
            return true;
        }
        plugin.reloadConfig();
        plugin.config = plugin.getConfig();
        sender.sendMessage(Util.transform(plugin.prefix + "&2Config reloaded."));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}
