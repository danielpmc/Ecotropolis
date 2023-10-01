package us.danielpmc.ecotropolis.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandGMC implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandGMC(Ecotropolis plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 1) {
            if (!sender.hasPermission("ecotropolis.gms.others")) {
                p.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(Util.transform(plugin.prefix + "&cCould not find player " + args[0] + "!"));
                return true;
            }
            target.setGameMode(GameMode.CREATIVE);
            p.sendMessage(Util.transform(plugin.prefix + "&3 " + target.getName() + "'s gamemode changed to &6Creative Mode!"));
            return true;
        }

        if (!sender.hasPermission("ecotropolis.gms")) {
            p.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }
        p.setGameMode(GameMode.CREATIVE);
        p.sendMessage(Util.transform(plugin.prefix + "&3Gamemode changed to &6Creative Mode"));
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
