package us.danielpmc.ecotropolis.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcotropolisFlyEnable implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player) sender;
        if (!sender.hasPermission("ecotropolis.efly")) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        if (args.length == 0) {
            p.setAllowFlight(true);
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Fly Enabled!");
            return true;
        }else
        if (!sender.hasPermission("ecotropolis.efly.others")) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Could not find player " + args[0] + "!");
            return true;
        }
        target.setAllowFlight(true);
        target.sendMessage(ChatColor.DARK_AQUA + "Flight enabled!");
        p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Fly Enabled For: " + args[0]);
        return true;
    }
}
