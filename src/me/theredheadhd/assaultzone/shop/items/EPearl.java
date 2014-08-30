package me.theredheadhd.assaultzone.shop.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.theredheadhd.assaultzone.shop.Item;

public class EPearl extends Item {

	private static EPearl instance = new EPearl();
	
	public static EPearl getInstance() {
		return instance;
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.ENDER_PEARL);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ender Pearl");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "10 Coins");
		setItemMeta(item, meta);

		return item;
	}	
}
