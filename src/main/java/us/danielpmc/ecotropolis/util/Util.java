package us.danielpmc.ecotropolis.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String blackAndYellowFormat(String string) {
        StringBuilder tempString = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(i % 2 == 0) {
                tempString.append(ChatColor.GOLD).append(string.charAt(i));
            } else {
                tempString.append(ChatColor.DARK_GRAY).append(string.charAt(i));
            }
        }
        return tempString.toString();
    }

    public static String transform(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> getOnlinePlayersNamesList() {
        return getOnlinePlayersNamesListWithArgument(null);
    }

    public static List<String> getOnlinePlayersNamesListWithArgument(String argument) {
        List<String> list = new ArrayList<>();
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            if(argument == null || player.getName().toLowerCase().startsWith(argument.toLowerCase())) list.add(player.getName());
        }
        return list;
    }
}
