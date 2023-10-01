package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandWebsite implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandWebsite(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (!sender.hasPermission("ecotropolis.website")) {
            sender.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage(Util.transform(plugin.prefix + "&3Here is the website link &6" + plugin.getConfig().getString("website")));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}

