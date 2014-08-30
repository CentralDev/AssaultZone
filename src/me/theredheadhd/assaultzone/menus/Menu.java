package me.theredheadhd.assaultzone.menus;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Menu {

	public abstract List<ItemStack> getItems();
	public abstract List<ItemMeta> getMetas();
	public abstract List<ItemStack> getUpdatedItems(List<ItemStack> items, List<ItemMeta> metas);
	
	public void setDisplayName(ItemMeta meta, String name) {
		meta.setDisplayName(name);
	}
	
	public void setLore(ItemMeta meta, List<String> lore) {
		meta.setLore(lore);
	}
	
	public void setItemMeta(ItemStack item, ItemMeta meta) {
		item.setItemMeta(meta);
	}
}
