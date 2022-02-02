package me.rxndmz.customfishing.data;

import me.rxndmz.customfishing.CustomFishing;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class coolerData {

    CustomFishing plugin = CustomFishing.getPlugin(CustomFishing.class);

    public static void setup(Player player) {
        FileConfiguration data = playerData.get();
        if (data.getConfigurationSection(player.getUniqueId().toString()).get("Cooler") == null) {
            Inventory inv = Bukkit.createInventory(player,9, "Default");
            ItemStack[] items = inv.getContents();
            System.out.println(ItemSerialization.itemStackArrayToBase64(items));
            data.getConfigurationSection(player.getUniqueId().toString()).set("Cooler", ItemSerialization.itemStackArrayToBase64(items));
            playerData.save();
        }
    }

    public static Inventory getCooler(Player player) throws IOException {
        FileConfiguration data = playerData.get();
        Inventory cooler = Bukkit.createInventory(player,9,ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Cooler");
        if (!data.getConfigurationSection(player.getUniqueId().toString()).getString("Cooler").equals("null")) {
            ItemStack[] items = ItemSerialization.itemStackArrayFromBase64(data.getConfigurationSection(player.getUniqueId().toString()).getString("Cooler"));
            for (ItemStack item : items) {
                if (item != null) {
                    cooler.addItem(item);
                }
            }
        }
        return cooler;
    }

    public static void setCooler(Player player, Inventory cooler) {
        FileConfiguration data = playerData.get();
        ItemStack[] items = cooler.getContents();
        data.getConfigurationSection(player.getUniqueId().toString()).set("Cooler", ItemSerialization.itemStackArrayToBase64(items));
        playerData.save();
    }

    public static void addToCooler(Player player, ItemStack item) throws IOException {
        FileConfiguration data = playerData.get();
        ItemStack[] items = ItemSerialization.itemStackArrayFromBase64(data.getConfigurationSection(player.getUniqueId().toString()).getString("Cooler"));
        int coolerSize = data.getConfigurationSection(player.getUniqueId().toString()).getInt("CoolerSize");
        Inventory inv = Bukkit.createInventory(player,coolerSize,"Default");
        System.out.println(items[coolerSize - 1]);
        if (items[coolerSize - 1] == null) {
            for (ItemStack fish : items) {
                if (fish != null) {
                    inv.addItem(fish);
                }
            }
            inv.addItem(item);
            items = inv.getContents();
            data.getConfigurationSection(player.getUniqueId().toString()).set("Cooler", ItemSerialization.itemStackArrayToBase64(items));
        } else {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Your Cooler Is Full!");
        }
    }
}