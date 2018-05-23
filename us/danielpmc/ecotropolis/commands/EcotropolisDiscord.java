package us.danielpmc.ecotropolis.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcotropolisDiscord implements CommandExecutor {
public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (!sender.hasPermission("ecotropolis.discord")) {
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
        return true;
        }
        if (sender instanceof Player) {
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "Here is the discord link " + ChatColor.GOLD + "https://discord.gg/75BeDWP");
        }
        return false;
        }
        }
