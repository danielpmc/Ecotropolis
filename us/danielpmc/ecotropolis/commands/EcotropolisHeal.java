package us.danielpmc.ecotropolis.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcotropolisHeal implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (!sender.hasPermission("ecotropolis.heal")) {
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        if (sender instanceof Player) {
            player.setHealth(20);
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "You have been healed!");
        }
        return false;
    }
}