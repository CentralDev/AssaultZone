package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IronLeggings extends Item {

	private static IronLeggings instance = new IronLeggings();
		
	public static IronLeggings getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.IRON_LEGGINGS);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Leggings");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "35 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
