package us.danielpmc.ecotropolis.listeners;


import org.bukkit.event.EventHandler;

import org.bukkit.event.EventPriority;

import org.bukkit.event.Listener;

import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import us.danielpmc.ecotropolis.Ecotropolis;

public class PlayerHandler implements Listener {
    final Ecotropolis plugin;

    public PlayerHandler(Ecotropolis instance) {
        plugin = instance;
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        String player = event.getName().toLowerCase();

        if (plugin.banConfig.getConfig().getString(player) != null) {
            event.disallow(
                    Result.KICK_BANNED,
                    "You are banned from this server." + "\n" + "Reason: §c" + plugin.banConfig.getConfig().getString(player)
            );
        }
    }
}