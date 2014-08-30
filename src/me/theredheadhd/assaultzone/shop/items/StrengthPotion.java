package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StrengthPotion extends Item {

	private static StrengthPotion instance = new StrengthPotion();
	
	public static StrengthPotion getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.POTION,1,(short)16425);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.RED + "" + ChatColor.BOLD + "Strength Potion");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "25 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
