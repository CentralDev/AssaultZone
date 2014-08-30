package me.theredheadhd.assaultzone.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Soldier extends Kit {

	private static Soldier instance = new Soldier();
	
	public static Soldier getInstance() {
		return instance;
	}

	private List<ItemStack> items = new ArrayList<ItemStack>();
	private List<ItemStack> armor = new ArrayList<ItemStack>();
	private List<ItemMeta> metas = new ArrayList<ItemMeta>();

	
	@Override
	public List<ItemStack> getItems() {
		items.add(0, new ItemStack(Material.STONE_SWORD));
		items.add(1, new ItemStack(Material.COOKED_BEEF,16));
		
		return items;
	}

	@Override
	public List<ItemStack> getArmor() {
		armor.add(0, new ItemStack(Material.LEATHER_HELMET));
		armor.add(1, new ItemStack(Material.LEATHER_CHESTPLATE));
		armor.add(2, new ItemStack(Material.LEATHER_LEGGINGS));
		armor.add(3, new ItemStack(Material.LEATHER_BOOTS));
		
		return armor;
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
		
		setDisplayName(metas.get(0), ChatColor.GREEN + "" + ChatColor.BOLD + "Soldier's Sword");
		setItemMeta(items.get(0), metas.get(0));
		
		return items;
	}
	
	
}
