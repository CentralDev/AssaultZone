
package me.theredheadhd.assaultzone.shop.items;

import me.theredheadhd.assaultzone.shop.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IronSword extends Item {

	private static IronSword instance = new IronSword();
	
	public static IronSword getInstance() {
		return instance;
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.IRON_SWORD);
	}

	@Override
	public ItemMeta getMeta() {
		return getItem().getItemMeta();
	}

	@Override
	public ItemStack getUpdatedItem(ItemStack item, ItemMeta meta) {
		item = getItem();
		meta = getMeta();
		
		setDisplayName(meta, ChatColor.GREEN + "" + ChatColor.BOLD + "Iron Sword");
		setLore(meta, ChatColor.GOLD + "Price: " + ChatColor.YELLOW + "10 Coins");
		setItemMeta(item, meta);
		
		return item;
	}	
}
