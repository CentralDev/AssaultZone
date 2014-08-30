package me.theredheadhd.assaultzone.shop.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.theredheadhd.assaultzone.shop.Item;

public class DiamondSword extends Item {

	private static DiamondSword instance = new DiamondSword();
	
	public static DiamondSword getInstance() {
		return instance;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.DIAMOND_SWORD);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GREEN + "" + ChatColor.BOLD + "Diamond Sword");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "20 Coins");
		setItemMeta(item, meta);
		
		return item;
	}
}
