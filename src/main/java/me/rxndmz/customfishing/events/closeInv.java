package me.rxndmz.customfishing.events;

import me.rxndmz.customfishing.CustomFishing;
import me.rxndmz.customfishing.data.coolerData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class closeInv implements Listener {

    CustomFishing plugin = CustomFishing.getPlugin(CustomFishing.class);

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Cooler")) {
            Inventory cooler = e.getView().getTopInventory();
            coolerData.setCooler(player,cooler);
        }
    }

}
