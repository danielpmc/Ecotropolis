package us.danielpmc.ecotropolis.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandFlyEnable implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandFlyEnable(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player) sender;
        if (!sender.hasPermission("ecotropolis.efly")) {
            p.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }

        if (args.length == 0) {
            p.setAllowFlight(true);
            p.sendMessage(Util.transform(plugin.prefix + "&3Fly Enabled!"));
            return true;
        } else if (!sender.hasPermission("ecotropolis.efly.others")) {
            p.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            p.sendMessage(Util.transform(plugin.prefix + "&cCould not find player " + args[0] + "!"));
            return true;
        }

        target.setAllowFlight(true);
        target.sendMessage(Util.transform("&3Flight enabled!"));
        p.sendMessage(Util.transform(plugin.prefix + "&3Fly Enabled For: " + args[0]));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            return Util.getOnlinePlayersNamesListWithArgument(args[0]);
        }
        return new ArrayList<>();
    }
}
