package us.danielpmc.ecotropolis.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class  EcotropolisAbout implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Ecotropolis is a custom plugin coded by " + ChatColor.GOLD + "danielpmc" + ChatColor.DARK_AQUA + "and is running Version: 2.0");
        }
        return false;
    }
}
