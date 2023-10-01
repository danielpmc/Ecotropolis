package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandAbout implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandAbout(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if(!sender.hasPermission("ecotropolis.about")) {
            sender.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }
        sender.sendMessage(Util.transform(plugin.about));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}
