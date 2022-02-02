package me.rxndmz.customfishing.enchants;

import me.rxndmz.customfishing.CustomFishing;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class CharmedEnchantment extends Enchantment {

    public CharmedEnchantment(String namespace) { super(new NamespacedKey(CustomFishing.getPlugin(), namespace)); }

    @Override
    public String getName() { return "Charmed"; }

    @Override
    public int getMaxLevel() { return 3; }

    @Override
    public int getStartLevel() { return 1; }

    @Override
    public EnchantmentTarget getItemTarget() { return EnchantmentTarget.FISHING_ROD; }

    @Override
    public boolean isTreasure() { return false; }

    @Override
    public boolean isCursed() { return false; }

    @Override
    public boolean conflictsWith(Enchantment other) { return false; }

    @Override
    public boolean canEnchantItem(ItemStack item) { return false; }
}
