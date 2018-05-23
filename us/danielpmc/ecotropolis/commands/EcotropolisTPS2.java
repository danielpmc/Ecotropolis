package us.danielpmc.ecotropolis.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class EcotropolisTPS2 implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (!sender.hasPermission("ecotropolis.TPS")) {
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Ecotropolis" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "No Permission!");
            return true;
        }
        if (sender instanceof Player) {
            Player p = (Player) sender;
            double tps = EcotropolisTPS.getTPS();
            double percentage =  Double.valueOf(String.format("%.2f", (100 - tps * 5)));
            DecimalFormat TpsFormat = new DecimalFormat("#.##");

            if(tps > 20){
                p.sendMessage(ChatColor.DARK_GREEN + "TPS: " + TpsFormat.format(tps));
                p.sendMessage(ChatColor.DARK_GREEN + "Lag: " + percentage + ChatColor.DARK_GREEN + "%");
                return true;
            }
            if(tps > 19){
                p.sendMessage(ChatColor.GREEN + "TPS: " + TpsFormat.format(tps));
                p.sendMessage(ChatColor.GREEN + "Lag: " + percentage + ChatColor.GREEN + "%");
                return true;
            }
            if(tps > 14){
                p.sendMessage(ChatColor.YELLOW + "TPS: " + TpsFormat.format(tps));
                p.sendMessage(ChatColor.YELLOW + "Lag: " + percentage + ChatColor.YELLOW + "%");
                return true;
            }
            if(tps > 9){
                p.sendMessage(ChatColor.RED + "TPS: " + TpsFormat.format(tps));
                p.sendMessage(ChatColor.RED + "Lag: " + percentage + ChatColor.RED + "%");
                return true;
            }
            if(tps > 5){
                p.sendMessage(ChatColor.DARK_RED + "TPS: " + TpsFormat.format(tps));
                p.sendMessage(ChatColor.DARK_RED + "Lag: " + percentage + ChatColor.DARK_RED + "%");
                return true;
            }
        }
        return false;
    }
}
