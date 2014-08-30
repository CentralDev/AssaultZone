package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Arrows extends Item {

	private static Arrows instance = new Arrows();
	
	public static Arrows getInstance() {
		return instance;
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.ARROW, 16);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GREEN + "" + ChatColor.BOLD + "16 Arrows");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.BOLD + "5 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
	
	
}
