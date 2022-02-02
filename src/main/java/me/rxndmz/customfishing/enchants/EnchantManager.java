package me.rxndmz.customfishing.enchants;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnchantManager {

    public static void addLore(ItemStack item, Enchantment ench, ChatColor color, String level) {
        List<String> lore = new CopyOnWriteArrayList<String>();
        ItemMeta meta = item.getItemMeta();
        if (meta.hasLore()) {
            lore = (ArrayList<String>) meta.getLore();
        } else {
            lore.add(color + ench.getName() + " " + level);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        boolean worked = false;
        for (String s : lore) {
            for (int i = 1; i <= 10; i++) {
                String lvl = levelConverter(i);
                if (s.equalsIgnoreCase(color.toString() + ench.getName() + " " + lvl)) {
                    int pos = lore.indexOf(s);
                    lore.set(pos, color + ench.getName() + " " + level);
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    worked = true;
                }
            }
        }
        if (!worked) {
            lore.add(color + ench.getName() + " " + level);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    public static String levelConverter(int i) {
        String level = "";
        if (i == 1) {
            level = "I";
        } else if (i == 2) {
            level = "II";
        } else if (i == 3) {
            level = "III";
        } else if (i == 4) {
            level = "IV";
        } else if (i == 5) {
            level = "V";
        } else if (i == 6) {
            level = "VI";
        } else if (i == 7) {
            level = "VII";
        } else if (i == 8) {
            level = "VIII";
        } else if (i == 9) {
            level = "IX";
        } else if (i == 10) {
            level = "X";
        }
        return level;
    }

    public static void addEnchants(Enchantment ench, ItemStack item, int lvl, ChatColor color) {
        String level = levelConverter(lvl);
        addLore(item, ench, color, level);
        item.addUnsafeEnchantment(ench, lvl);
    }

}
