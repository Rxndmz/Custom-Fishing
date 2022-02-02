package me.rxndmz.customfishing.commands;

import me.rxndmz.customfishing.data.coolerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class cooler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inv = null;
            try {
                inv = coolerData.getCooler(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.openInventory(inv);
        }
        return false;
    }
}
