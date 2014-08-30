package me.theredheadhd.assaultzone.shop;

import java.util.Arrays;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Item {

	public abstract ItemStack getItem();
	public abstract ItemMeta getMeta();
	public abstract ItemStack getUpdatedItem(ItemStack item, ItemMeta meta);
	
	public void setDisplayName(ItemMeta meta, String name) {
		meta.setDisplayName(name);
	}
	
	public void setLore(ItemMeta meta, String lore) {
		meta.setLore(Arrays.asList(lore));
	}
	
	public void setItemMeta(ItemStack item, ItemMeta meta) {
		item.setItemMeta(meta);
	}
}
