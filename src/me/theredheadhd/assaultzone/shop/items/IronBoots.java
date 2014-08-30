package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IronBoots extends Item {

	private static IronBoots instance = new IronBoots();
	
	public static IronBoots getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.IRON_BOOTS);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Boots");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "25 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
