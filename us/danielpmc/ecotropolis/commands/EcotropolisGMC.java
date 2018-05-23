package us.danielpmc.ecotropolis.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcotropolisGMC implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player) sender;
        if (!sender.hasPermission("ecotropolis.gmc")) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        if (args.length == 0) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Gamemode changed to " + ChatColor.GOLD +"Creative Mode!");
            return true;
        }else
        if (!sender.hasPermission("ecotropolis.gmc.others")) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Could not find player " + args[0] + "!");
            return true;
        }
        target.setGameMode(GameMode.CREATIVE);
        target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Gamemode changed to " + ChatColor.GOLD +"Creative Mode");
        p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Gamemode changed to " + ChatColor.GOLD +"Creative Mode" + ChatColor.DARK_AQUA + " for: " + args[0]);
        return true;
    }
}
