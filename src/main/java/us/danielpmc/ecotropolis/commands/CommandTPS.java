package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.TPSRunnable;
import us.danielpmc.ecotropolis.util.Util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CommandTPS implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandTPS(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (!sender.hasPermission("ecotropolis.tps")) {
            sender.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }

        Player player = (Player) sender;
        double tps = TPSRunnable.getTPS();
        double percentage = TPSRunnable.getPercentage();
        DecimalFormat TpsFormat = new DecimalFormat("#.##");

        if(tps > 20){
            player.sendMessage(Util.transform("&2TPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.transform("&2Lag: " + percentage + "&2%"));
            return true;
        }
        if(tps > 19){
            player.sendMessage(Util.transform("&aTPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.transform("&aLag: " + percentage + "&a%"));
            return true;
        }
        if(tps > 14){
            player.sendMessage(Util.transform("&eTPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.transform("&eLag: " + percentage + "&e%"));
            return true;
        }
        if(tps > 9){
            player.sendMessage(Util.transform("&cTPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.transform("&cLag: " + percentage + "&c%"));
            return true;
        }
        if(tps > 5){
            player.sendMessage(Util.transform("&4TPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.transform("&4Lag: " + percentage + "&4%"));
            return true;
        }
        if(tps <= 5) {
            player.sendMessage(Util.blackAndYellowFormat("TPS: " + TpsFormat.format(tps)));
            player.sendMessage(Util.blackAndYellowFormat("Lag: " + percentage + "%"));
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}
