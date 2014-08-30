package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DiamondLeggings extends Item {

	private static DiamondLeggings instance = new DiamondLeggings();
	
	public static DiamondLeggings getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.DIAMOND_LEGGINGS);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Leggings");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "45 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
