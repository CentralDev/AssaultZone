package me.theredheadhd.assaultzone.kits;

import me.theredheadhd.assaultzone.shop.items.ShopItem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class KitManager {
	
	private static KitManager instance = new KitManager();
	public static KitManager getInstance() { return instance; }
	
	@SuppressWarnings("deprecation")
	public void setSoldierInventory(Player p) {
		PlayerInventory inv = p.getInventory();
		
		inv.setArmorContents(null);
		inv.clear();
		
		inv.setItem(0, Soldier.getInstance().getUpdatedItems(Soldier.getInstance().getItems(),
																Soldier.getInstance().getMetas()).get(0));
		inv.setItem(1, Soldier.getInstance().getUpdatedItems(Soldier.getInstance().getItems(),
				Soldier.getInstance().getMetas()).get(1));
		inv.setItem(8, ShopItem.getInstance().getUpdatedItem(ShopItem.getInstance().getItem(), 
																ShopItem.getInstance().getMeta()));
		
		inv.setHelmet(Soldier.getInstance().getArmor().get(0));
		inv.setChestplate(Soldier.getInstance().getArmor().get(1));
		inv.setLeggings(Soldier.getInstance().getArmor().get(2));
		inv.setBoots(Soldier.getInstance().getArmor().get(3));
		
		p.updateInventory();
	}
	
	@SuppressWarnings("deprecation")
	public void setSniperInventory(Player p) {
		PlayerInventory inv = p.getInventory();
		
		inv.setArmorContents(null);
		inv.clear();
		
		inv.setItem(0, Sniper.getInstance().getUpdatedItems(Sniper.getInstance().getItems(),
																Sniper.getInstance().getMetas()).get(0));
		inv.setItem(1, Sniper.getInstance().getUpdatedItems(Sniper.getInstance().getItems(),
				Sniper.getInstance().getMetas()).get(1));
		inv.setItem(2, Sniper.getInstance().getUpdatedItems(Sniper.getInstance().getItems(),
				Sniper.getInstance().getMetas()).get(2));
		inv.setItem(3, Sniper.getInstance().getUpdatedItems(Sniper.getInstance().getItems(),
				Sniper.getInstance().getMetas()).get(3));
		inv.setItem(8, ShopItem.getInstance().getUpdatedItem(ShopItem.getInstance().getItem(), 
				ShopItem.getInstance().getMeta()));
		
		inv.setHelmet(Sniper.getInstance().getArmor().get(0));
		inv.setChestplate(Sniper.getInstance().getArmor().get(1));
		inv.setLeggings(Sniper.getInstance().getArmor().get(2));
		inv.setBoots(Sniper.getInstance().getArmor().get(3));
		
		p.updateInventory();
	}
}
