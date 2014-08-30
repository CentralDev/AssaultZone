package me.theredheadhd.assaultzone.shop.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.theredheadhd.assaultzone.shop.Item;

public class ShopItem extends Item {

	private static ShopItem instance = new ShopItem();
	
	public static ShopItem getInstance() {
		return instance;
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.GOLD_NUGGET);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Shop Item");
		setItemMeta(item, meta);
		
		return item;
	}
}
