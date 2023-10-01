package us.danielpmc.ecotropolis.init;

import us.danielpmc.ecotropolis.Ecotropolis;
import us.danielpmc.ecotropolis.listeners.PlayerHandler;

public class Listeners {
    public static void init(Ecotropolis plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerHandler(plugin), plugin);
    }
}
