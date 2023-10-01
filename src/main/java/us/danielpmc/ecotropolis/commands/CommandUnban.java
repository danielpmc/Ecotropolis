package us.danielpmc.ecotropolis.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandUnban implements TabExecutor {
    final Ecotropolis plugin;

    public CommandUnban(Ecotropolis instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.unban" : "ecotropolis.unban";

        if (sender.hasPermission(banPerms)) {
            if (args.length < 1) {
                sender.sendMessage(Util.transform(plugin.prefix + "&7" + "Usage: /" + label + " <player>"));
            } else {
                OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);

                if (target != null) {
                    if (plugin.banConfig.getConfig().contains(target.getName().toLowerCase())) {
                        plugin.banConfig.getConfig().set(target.getName().toLowerCase(), null);
                        plugin.banConfig.saveConfig();

                        plugin.getServer().broadcastMessage(Util.transform("&7" + target.getName() + " has been unbanned"));
                    } else {
                        sender.sendMessage(Util.transform(plugin.prefix + "&7" + "That player isn't banned!"));
                    }
                } else {
                    sender.sendMessage(Util.transform(plugin.prefix + "&7" + "That player has never been online before!"));
                }
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.unban" : "ecotropolis.unban";

        if(sender.hasPermission(banPerms)) {
            if (args.length == 1) {
                List<String> playerNames = new ArrayList<>();
                for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
                    playerNames.add(player.getName());
                }
                return playerNames;
            }
        }
        return new ArrayList<>();
    }
}
