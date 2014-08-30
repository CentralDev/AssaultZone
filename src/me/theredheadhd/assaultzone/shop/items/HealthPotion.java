package me.theredheadhd.assaultzone.shop.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.theredheadhd.assaultzone.shop.Item;

public class HealthPotion extends Item {

	private static HealthPotion instance = new HealthPotion();
	
	public static HealthPotion getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.POTION,1,(short)16421);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.RED + "" + ChatColor.BOLD + "Instant Health Potion");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "25 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
