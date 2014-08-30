package me.theredheadhd.assaultzone.shop.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.theredheadhd.assaultzone.shop.Item;

public class IronChestplate extends Item {

	private static IronChestplate instance = new IronChestplate();
	
	public static IronChestplate getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.IRON_CHESTPLATE);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Chestplate");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "40 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
