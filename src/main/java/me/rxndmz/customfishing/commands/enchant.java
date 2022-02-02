package me.rxndmz.customfishing.commands;

import me.rxndmz.customfishing.CustomFishing;
import me.rxndmz.customfishing.enchants.EnchantManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class enchant implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("enchant") && args.length > 1) {
                    //
                    //  LUCKY
                    //
                    if (args[1].equalsIgnoreCase("lucky")) {
                        if (args.length > 2 && args[2].equalsIgnoreCase("1")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.luckyEnchant, item, 1, ChatColor.LIGHT_PURPLE);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("2")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.luckyEnchant, item, 2, ChatColor.LIGHT_PURPLE);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("3")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.luckyEnchant, item, 3, ChatColor.LIGHT_PURPLE);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else {
                            player.sendMessage(ChatColor.AQUA + "ERROR: Invalid Enchant Level.");
                        }
                    }
                    //
                    //  MAGNET
                    //
                    else if (args[1].equalsIgnoreCase("magnet")) {

                        if (args.length > 2 && args[2].equalsIgnoreCase("1")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.magnetEnchant, item, 1, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("2")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.magnetEnchant, item, 2, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("3")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.magnetEnchant, item, 3, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("4")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.magnetEnchant, item, 4, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("5")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.magnetEnchant, item, 5, ChatColor.AQUA);
                            } else { player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!"); }
                        }
                        else {
                            player.sendMessage(ChatColor.AQUA + "ERROR: Invalid Enchant Level.");
                        }
                    }
                    //
                    //  EXPERIENCE
                    //
                    else if (args[1].equalsIgnoreCase("experience")) {

                        if (args.length > 2 && args[2].equalsIgnoreCase("1")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.experienceEnchant, item, 1, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("2")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.experienceEnchant, item, 2, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("3")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.experienceEnchant, item, 3, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("4")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.experienceEnchant, item, 4, ChatColor.AQUA);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        }
                        else {
                            player.sendMessage(ChatColor.AQUA + "ERROR: Invalid Enchant Level.");
                        }
                    }
                    //
                    //  CHARMED
                    //
                    else if (args[1].equalsIgnoreCase("charmed")) {

                        if (args.length > 2 && args[2].equalsIgnoreCase("1")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.charmedEnchantment, item, 1, ChatColor.RED);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("2")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.charmedEnchantment, item, 2, ChatColor.RED);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else if (args.length > 2 && args[2].equalsIgnoreCase("3")) {
                            ItemStack item = player.getInventory().getItemInMainHand();
                            if (item.getType().equals(Material.FISHING_ROD)) {
                                EnchantManager.addEnchants(CustomFishing.charmedEnchantment, item, 3, ChatColor.RED);
                            } else {
                                player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                            }
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You Cannot Enchant This Item!");
                        }
                    } else {
                        player.sendMessage(ChatColor.AQUA + "ERROR: Invalid Enchant Level.");
                    }
                } else {
                    player.sendMessage(ChatColor.AQUA + "Usage:");
                    player.sendMessage(ChatColor.WHITE + "/customfishing enchant <enchant> <level>");
                }
            } else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD.toString() + "Custom Fishing" + ChatColor.GRAY + "]");
                player.sendMessage(ChatColor.AQUA + "/customfishing enchant");
                player.sendMessage(ChatColor.AQUA + "/fishtokens");
            }
        } else {
            System.out.println("Cannot execute this command in the console.");
        }
        return false;
    }
}
