package us.danielpmc.ecotropolis.commands;

import org.bukkit.OfflinePlayer;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.CommandSender;

import us.danielpmc.ecotropolis.main;

public class Unban implements CommandExecutor

{

    final main plugin;



    public Unban(main instance)

    {

        plugin = instance;

    }



    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)

    {

        if ((sender.isOp()) || (sender.hasPermission("easybans.unban")))

        {

            if (args.length < 1)

            {

                sender.sendMessage(plugin.prefix + "§7" + "Usage: /" + label + " <player>");

            }

            else if (args.length > 0)

            {

                OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);



                if (target != null)

                {

                    if (target.isBanned())

                    {

                        plugin.banconfig.getConfig().set(target.getName().toLowerCase(), null);

                        plugin.banconfig.saveConfig();



                        target.setBanned(false);



                        plugin.getServer().broadcastMessage("§7" + target.getName().toLowerCase() + " has been unbanned");

                    }

                    else

                    {

                        sender.sendMessage(plugin.prefix + "§7" + "That player isn't banned!");

                    }

                }

                else

                {

                    sender.sendMessage(plugin.prefix + "§7" + "That player has never been online before!");

                }

            }

        }



        return true;

    }

}
