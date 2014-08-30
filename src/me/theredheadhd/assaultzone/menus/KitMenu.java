package me.theredheadhd.assaultzone.menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitMenu extends Menu {

	private static KitMenu instance = new KitMenu();
	public static KitMenu getInstance() { return instance; }

	private static List<ItemStack> items = new ArrayList<ItemStack>();
	private static List<ItemMeta> metas = new ArrayList<ItemMeta>();
	
	@Override
	public List<ItemStack> getItems() {
		items.add(0, new ItemStack(Material.STONE_SWORD));
		items.add(1, new ItemStack(Material.BOW));
		
		return items;
	}

	@Override
	public List<ItemMeta> getMetas() {
		metas.add(0, getItems().get(0).getItemMeta());
		metas.add(1, getItems().get(1).getItemMeta());
		
		return metas;
	}

	@Override
	public List<ItemStack> getUpdatedItems(List<ItemStack> items, List<ItemMeta> metas) {
		items = getItems();
		metas = getMetas();
		
		setDisplayName(metas.get(0), ChatColor.AQUA + "" + ChatColor.BOLD + "Soldier Kit");
		setItemMeta(items.get(0), metas.get(0));
		
		setDisplayName(metas.get(1), ChatColor.AQUA + "" + ChatColor.BOLD + "Sniper Kit");
		setItemMeta(items.get(1), metas.get(1));
		
		return items;
	}
}
