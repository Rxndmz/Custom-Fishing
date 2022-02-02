package me.rxndmz.customfishing.events;

import me.rxndmz.customfishing.data.coolerData;
import me.rxndmz.customfishing.data.playerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        FileConfiguration data = playerData.get();
        if (!data.contains(player.getUniqueId().toString())) {
            data.createSection(player.getUniqueId().toString());
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Fish Tokens", 0);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Cooler",null);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("CoolerSize", 9);
        }
        coolerData.setup(player);
        playerData.save();
    }

}