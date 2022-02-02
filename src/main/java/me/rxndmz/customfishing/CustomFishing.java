package me.rxndmz.customfishing;

import me.rxndmz.customfishing.commands.cooler;
import me.rxndmz.customfishing.commands.enchant;
import me.rxndmz.customfishing.commands.tokens;
import me.rxndmz.customfishing.data.playerData;
import me.rxndmz.customfishing.enchants.*;
import me.rxndmz.customfishing.events.*;
import me.rxndmz.customfishing.rewards.lootTable;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public final class CustomFishing extends JavaPlugin {

    public static me.rxndmz.customfishing.rewards.lootTable lootTable;

    private static CustomFishing plugin;

    public static ArrayList<Enchantment> custom_enchants = new ArrayList<>();
    // Enchants
    public static LuckyEnchant luckyEnchant;
    public static MagnetEnchant magnetEnchant;
    public static ExperienceEnchant experienceEnchant;
    public static CharmedEnchantment charmedEnchantment;

    public static EnchantManager enchantManager;


    public ArrayList<String> getRewards() {
        // Config
        Configuration config = getConfig();
        // Reward section
        ConfigurationSection RewardSection = config.getConfigurationSection("Rewards");
        // List of possible rewards
        ArrayList<String> Rewards = new ArrayList<String>();
        // Getting Rewards
        try {
            for (String key : RewardSection.getKeys(false)) {
                Rewards.add(key);
            }
        }
        catch (Exception e) {
            System.out.println("[Custom Fishing] Unable to get reward keys.");
        }
        return Rewards;
    }

    @Override
    public void onEnable() {
        playerData.setup();
        playerData.get().options().copyDefaults(true);
        playerData.save();
        plugin = this;

        // Enchants
        luckyEnchant = new LuckyEnchant("lucky");
        magnetEnchant = new MagnetEnchant("magnet");
        experienceEnchant = new ExperienceEnchant("experience");
        charmedEnchantment = new CharmedEnchantment("charmed");
        enchantManager = new EnchantManager();
        custom_enchants.add(luckyEnchant);
        custom_enchants.add(magnetEnchant);
        custom_enchants.add(experienceEnchant);
        custom_enchants.add(charmedEnchantment);

        // Register Enchants
        registerEnchantment(luckyEnchant);
        registerEnchantment(magnetEnchant);
        registerEnchantment(experienceEnchant);
        registerEnchantment(charmedEnchantment);

        // Sends message to console when plugin is loaded
        System.out.println("[Custom Fishing] Plugin has been loaded");

        // Getting the config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Listeners
        getServer().getPluginManager().registerEvents(new fishEvent(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        getServer().getPluginManager().registerEvents(new closeInv(), this);
        getServer().getPluginManager().registerEvents(new invClick(), this);

        // Commands
        getCommand("CustomFishing").setExecutor(new enchant());
        getCommand("FishTokens").setExecutor(new tokens());
        getCommand("Cooler").setExecutor(new cooler());

        // Checking config to see if plugin is enabled
        Boolean enabled = getConfig().getBoolean("Enabled");
        if (!enabled) {
            getServer().getPluginManager().disablePlugin(getPlugin(CustomFishing.class));
        }
        // Getting Fishing LootTable
        ArrayList<String> rewards = getRewards();

        lootTable = new lootTable.lootTableBuilder()
                .add(new ItemStack(Material.matchMaterial(getConfig().getString("Rewards." + rewards.get(0).toString() + ".Item"))), getConfig().getInt("Rewards." + rewards.get(0) + ".Chance"))
                .add(new ItemStack(Material.matchMaterial(getConfig().getString("Rewards." + rewards.get(1).toString() + ".Item"))), getConfig().getInt("Rewards." + rewards.get(1) + ".Chance"))
                .add(new ItemStack(Material.matchMaterial(getConfig().getString("Rewards." + rewards.get(2).toString() + ".Item"))), getConfig().getInt("Rewards." + rewards.get(2) + ".Chance"))
                .add(new ItemStack(Material.matchMaterial(getConfig().getString("Rewards." + rewards.get(3).toString() + ".Item"))), getConfig().getInt("Rewards." + rewards.get(3) + ".Chance"))
                .add(new ItemStack(Material.matchMaterial(getConfig().getString("Rewards." + rewards.get(4).toString() + ".Item"))), getConfig().getInt("Rewards." + rewards.get(4) + ".Chance"))
                .build();


    }

    @Override
    public void onDisable() {
        playerData.save();
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            for (Enchantment enchantment : custom_enchants) {
                if (byKey.containsKey(enchantment.getKey())) {
                    byKey.remove(enchantment.getKey());
                }
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            for (Enchantment enchantment : custom_enchants) {
                if(byName.containsKey(enchantment.getName())) {
                    byName.remove(enchantment.getName());
                }
            }
        } catch (Exception ignored) { }
        // Saving the player data file
    }

    public static CustomFishing getPlugin() {
        return plugin;
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
        }
    }

}