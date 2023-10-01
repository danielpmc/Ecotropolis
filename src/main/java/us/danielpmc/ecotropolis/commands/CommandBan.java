package us.danielpmc.ecotropolis.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;

import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandBan implements TabExecutor {
    final Ecotropolis plugin;
    final String serverName;

    public CommandBan(Ecotropolis instance) {
        plugin = instance;
        serverName = plugin.config.getString("serverName");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.ban" : "ecotropolis.ban";

        if (sender.isOp() || sender.hasPermission(banPerms)) {
            if (args.length < 1) {
                sender.sendMessage(plugin.config.getString("prefix") + "Usage: /" + label + " <player> <reason>");
            }
            else if (args.length == 1) {
                Player target = plugin.getServer().getPlayer(args[0]);
                OfflinePlayer offlineTarget = plugin.getServer().getOfflinePlayer(args[0]);

                if (target != null) {
                    String reason = "Banned!";

                    target.kickPlayer(Util.transform("You were banned from the server.\nReason: &c" + reason));

                    plugin.getServer().broadcastMessage(Util.transform("&7" + target.getName() + " was banned from " + serverName + "&7 by " + sender.getName()));

                    plugin.banConfig.getConfig().set(target.getName().toLowerCase(), reason);
                    plugin.banConfig.saveConfig();

                } else {
                    String reason = "Banned!";

                    Bukkit.getBanList(BanList.Type.NAME).addBan(offlineTarget.getName(), reason, null, sender.getName());

                    plugin.getServer().broadcastMessage(Util.transform("&7" + offlineTarget.getName() + " was banned from" + serverName + "&7 by " + sender.getName()));

                    plugin.banConfig.getConfig().set(offlineTarget.getName().toLowerCase(), reason);
                    plugin.banConfig.saveConfig();

                }
            } else if (args.length > 1) {
                Player target = plugin.getServer().getPlayer(args[0]);
                OfflinePlayer offlineTarget = plugin.getServer().getOfflinePlayer(args[0]);

                if (target != null) {
                    StringBuilder reason = new StringBuilder();

                    for (int i = 1; i < args.length; i++) {
                        reason.append(args[i]).append(" ");
                    }

                    target.kickPlayer(Util.transform("You were banned from the server.\nReason: &c" + reason));

                    plugin.getServer().broadcastMessage(Util.transform("&7" + target.getName() + " was banned from " + serverName + "&7 by " + sender.getName() + " for " + reason));

                    plugin.banConfig.getConfig().set(target.getName().toLowerCase(), reason.toString());
                    plugin.banConfig.saveConfig();

                } else {
                    StringBuilder reason = new StringBuilder();

                    for (int i = 1; i < args.length; i++) {
                        reason.append(args[i]).append(" ");
                    }

                    plugin.getServer().broadcastMessage(Util.transform("&7" + offlineTarget.getName() + " was banned from " + serverName + " &7 by " + sender.getName() + " for " + reason));

                    plugin.banConfig.getConfig().set(offlineTarget.getName().toLowerCase(), reason.toString());
                    plugin.banConfig.saveConfig();
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        String banPerms = plugin.config.getBoolean("useEasyBanPermissions") ? "easybans.ban" : "ecotropolis.ban";

        if(sender.isOp() || sender.hasPermission(banPerms)) {
            if (args.length == 1) {
                return Util.getOnlinePlayersNamesListWithArgument(args[0]);
            }
        }
        return new ArrayList<>();
    }
}