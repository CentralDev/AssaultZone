package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EPearl5 extends Item {

	private static EPearl5 instance = new EPearl5();
	
	public static EPearl5 getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.ENDER_PEARL,5);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "5 Ender Pearls");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "25 Coins");
		setItemMeta(item, meta);

		return item;
	}
}
