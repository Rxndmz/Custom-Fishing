package me.rxndmz.customfishing.events;

import me.rxndmz.customfishing.CustomFishing;
import me.rxndmz.customfishing.data.coolerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import me.rxndmz.customfishing.data.playerData;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class fishEvent implements Listener {

    CustomFishing plugin = CustomFishing.getPlugin(CustomFishing.class);

    @EventHandler
    public void onFish(PlayerFishEvent e) throws IOException {
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();
        // Getting current state of fishing
        String fishingState = e.getState().name();
        // Checking if the player successfully caught a fish
        if (fishingState == "CAUGHT_FISH") {
            // testing
            ItemStack fish = new ItemStack(Material.TROPICAL_FISH);
            coolerData.addToCooler(player,fish);

            if (Math.random() < 0.35) { // this is temp
                FileConfiguration data = playerData.get();
                int tokens = data.getConfigurationSection(uuid).getInt("Fish Tokens");
                tokens = tokens + 1;
                data.getConfigurationSection(uuid).set("Fish Tokens", tokens);
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "You Found A Fish Token!");
            } else {
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_FISHING_BOBBER_RETRIEVE, 1, 1);
            }
            // Removing vanilla
            e.getCaught().remove();
            // Removing EXP
            e.setExpToDrop(0);
        }
    }

}