package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DiamondChestplate extends Item {

	private static DiamondChestplate instance = new DiamondChestplate();
	
	public static DiamondChestplate getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.DIAMOND_CHESTPLATE);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Chestplate");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "50 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
