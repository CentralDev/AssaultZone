package me.theredheadhd.assaultzone.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuManager {
	
	private static MenuManager instance = new MenuManager();
	public static MenuManager getInstance() { return instance; }
	
	private static Inventory kitMenu;
	
	//KitMenu
	public void createKitMenu() {
		kitMenu = Bukkit.getServer().createInventory(null, 9, ChatColor.GREEN + "Select Kit");
		
		kitMenu.setItem(2, KitMenu.getInstance().getUpdatedItems(KitMenu.getInstance().getItems(), 
																	KitMenu.getInstance().getMetas()).get(0));
		
		kitMenu.setItem(6, KitMenu.getInstance().getUpdatedItems(KitMenu.getInstance().getItems(), 
				KitMenu.getInstance().getMetas()).get(1));
	}
	
	public void openKitMenu(Player p) {
		p.openInventory(kitMenu);
	}
}
