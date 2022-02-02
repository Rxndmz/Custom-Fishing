package me.rxndmz.customfishing.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class invClick implements Listener {

    @EventHandler
    public void invClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Cooler")) {
            e.setCancelled(true);
        }
    }

}
