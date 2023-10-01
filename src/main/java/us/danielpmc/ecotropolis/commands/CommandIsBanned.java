package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;

import org.bukkit.command.TabExecutor;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandIsBanned implements TabExecutor {
    final Ecotropolis plugin;
    public CommandIsBanned(Ecotropolis instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.check" : "ecotropolis.check";

        if (sender.isOp() || sender.hasPermission(banPerms)) {
            if (args.length < 1) {
                sender.sendMessage(plugin.prefix + "Usage: /" + label + " <player>");
            } else if (args.length == 1) {
                if (plugin.banConfig.getConfig().contains(args[0].toLowerCase())) {
                    sender.sendMessage(Util.transform(plugin.prefix + args[0] + " is banned from the server for: &c" + plugin.banConfig.getConfig().getString(args[0].toLowerCase())));
                } else {
                    sender.sendMessage(Util.transform(plugin.prefix + "That player (&e" + args[0] + "&r) is not banned."));
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.check" : "ecotropolis.check";

        if((sender.isOp()) || (sender.hasPermission(banPerms))) {
            if (args.length == 1) {
                return Util.getOnlinePlayersNamesListWithArgument(args[0]);
            }
        }
        return new ArrayList<>();
    }
}
