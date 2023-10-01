package us.danielpmc.ecotropolis.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CommandHeal implements TabExecutor {
    private final Ecotropolis plugin;
    public CommandHeal(Ecotropolis plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (!sender.hasPermission("ecotropolis.heal")) {
            sender.sendMessage(Util.transform(plugin.prefix + "&4No Permission!"));
            return true;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(20);
            player.sendMessage(Util.transform(plugin.prefix + "&3You have been healed!"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}