package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gapple extends Item {
	
	private static Gapple instance = new Gapple();
	
	public static Gapple getInstance() {
		return instance;
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.GOLDEN_APPLE);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.YELLOW + "" + ChatColor.BOLD + "Golden Apple");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "10 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
