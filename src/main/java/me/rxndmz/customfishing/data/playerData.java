package me.rxndmz.customfishing.data;

import me.rxndmz.customfishing.CustomFishing;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class playerData {

    CustomFishing plugin = CustomFishing.getPlugin(CustomFishing.class);

    private static File file;
    private static FileConfiguration plrData;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CustomFishing").getDataFolder(), "playerData.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        plrData = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return plrData;
    }

    public static void save() {
        try {
            plrData.save(file);
        } catch (IOException e) {
            System.out.println("[Custom Fishing] Couldn't save to file.");
        }
    }

    public static void reload() {
        plrData = YamlConfiguration.loadConfiguration(file);
    }

}