package me.rxndmz.customfishing.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import me.rxndmz.customfishing.data.playerData;

public class tokens implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            FileConfiguration data = playerData.get();
            if (args.length == 0) {
                player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Fish Tokens: " + ChatColor.RESET + ChatColor.WHITE + data.getConfigurationSection(player.getUniqueId().toString()).getString("Fish Tokens"));
            } else if (args[0].equalsIgnoreCase("send")) {
                if (args.length >= 2 && isInt(args[1])) {
                    int tokenAmount = Integer.parseInt(args[1]);
                    int sendersTokens = data.getConfigurationSection(player.getUniqueId().toString()).getInt("Fish Tokens");
                    if (tokenAmount > 0) {
                        if (args.length >= 3 && sendersTokens - tokenAmount >= 0) {
                            Player TP = player.getServer().getPlayer(args[2]);
                            if (TP != null) {
                                if (TP.isOnline()) {
                                    if (player.getName() != TP.getName()) {
                                        int TPtokens = data.getConfigurationSection(TP.getUniqueId().toString()).getInt("Fish Tokens");
                                        sendersTokens = sendersTokens - tokenAmount;
                                        TPtokens = TPtokens + tokenAmount;
                                        data.getConfigurationSection(TP.getUniqueId().toString()).set("Fish Tokens", TPtokens);
                                        data.getConfigurationSection(player.getUniqueId().toString()).set("Fish Tokens", sendersTokens);
                                        player.sendMessage(ChatColor.GREEN + args[1] + " fish tokens has been sent to " + TP.getName());
                                        TP.sendMessage(ChatColor.GREEN + args[1] + " fish tokens have been received by " + player.getName());
                                        playerData.save();
                                    } else {
                                        player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Can`t Send Yourself Tokens!");
                                    }
                                } else {
                                    player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Player Not Online!");
                                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Make sure the player is online!");
                                }
                            } else {
                                player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Player!");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "Enter a valid player name!");
                            }
                        } else if (args.length == 2) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Player!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens send <amount> <player>");
                        } else {
                            player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Amount!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "You don`t have enough tokens to send!");
                        }
                    } else {
                        player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Amount!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "Amount must be greater than 0!");
                    }
                } else {
                    player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Amount!");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens send <amount> <player>");
                }
            } /*else if (args[0].equalsIgnoreCase("give")) {
                if (args.length >= 2 && isInt(args[1])) {

                } else {
                    player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Amount!");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens give <amount> <player>");
                }
            } */else {
                player.sendMessage(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Invalid Arguments!");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens send");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens give");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "/fishtokens help");
            }
        }
        return false;
    }

    private static Boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
