package me.theredheadhd.assaultzone.shop;

import me.theredheadhd.assaultzone.shop.items.Arrows;
import me.theredheadhd.assaultzone.shop.items.Bow;
import me.theredheadhd.assaultzone.shop.items.DiamondBoots;
import me.theredheadhd.assaultzone.shop.items.DiamondChestplate;
import me.theredheadhd.assaultzone.shop.items.DiamondHelmet;
import me.theredheadhd.assaultzone.shop.items.DiamondLeggings;
import me.theredheadhd.assaultzone.shop.items.DiamondSword;
import me.theredheadhd.assaultzone.shop.items.EPearl;
import me.theredheadhd.assaultzone.shop.items.EPearl5;
import me.theredheadhd.assaultzone.shop.items.Gapple;
import me.theredheadhd.assaultzone.shop.items.Gapple5;
import me.theredheadhd.assaultzone.shop.items.HealthPotion;
import me.theredheadhd.assaultzone.shop.items.IronBoots;
import me.theredheadhd.assaultzone.shop.items.IronChestplate;
import me.theredheadhd.assaultzone.shop.items.IronHelmet;
import me.theredheadhd.assaultzone.shop.items.IronLeggings;
import me.theredheadhd.assaultzone.shop.items.IronSword;
import me.theredheadhd.assaultzone.shop.items.RegenPotion;
import me.theredheadhd.assaultzone.shop.items.SpeedPotion;
import me.theredheadhd.assaultzone.shop.items.StrengthPotion;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopManager {
	
	private static ShopManager instance = new ShopManager();
	
	public static ShopManager getInstance() {
		return instance;
	}
	
	private Inventory shop;
	
	public void createShopInventory() {
		shop = Bukkit.getServer().createInventory(null, 36, ChatColor.LIGHT_PURPLE + "Shop");
		
		shop.setItem(0, Gapple.getInstance().getUpdatedItem(Gapple.getInstance().getItem(), 
																Gapple.getInstance().getMeta()));
		shop.setItem(2, Bow.getInstance().getUpdatedItem(Bow.getInstance().getItem(), 
															Bow.getInstance().getMeta()));
		shop.setItem(3, IronHelmet.getInstance().getUpdatedItem(IronHelmet.getInstance().getItem(), 
																IronHelmet.getInstance().getMeta()));
		shop.setItem(4, RegenPotion.getInstance().getUpdatedItem(RegenPotion.getInstance().getItem(), 
																	RegenPotion.getInstance().getMeta()));
		shop.setItem(5, DiamondHelmet.getInstance().getUpdatedItem(DiamondHelmet.getInstance().getItem(), 
																	DiamondHelmet.getInstance().getMeta()));
		shop.setItem(6, DiamondSword.getInstance().getUpdatedItem(DiamondSword.getInstance().getItem(), 
																	DiamondSword.getInstance().getMeta()));	
		shop.setItem(8, EPearl.getInstance().getUpdatedItem(EPearl.getInstance().getItem(), 
																	EPearl.getInstance().getMeta()));
		shop.setItem(9, Gapple5.getInstance().getUpdatedItem(Gapple5.getInstance().getItem(), 
																Gapple5.getInstance().getMeta()));
		shop.setItem(11, Arrows.getInstance().getUpdatedItem(Arrows.getInstance().getItem(), 
																	Arrows.getInstance().getMeta()));
		shop.setItem(12, IronChestplate.getInstance().getUpdatedItem(IronChestplate.getInstance().getItem(), 
																		IronChestplate.getInstance().getMeta()));
		shop.setItem(13, HealthPotion.getInstance().getUpdatedItem(HealthPotion.getInstance().getItem(), 
																	HealthPotion.getInstance().getMeta()));
		shop.setItem(14, DiamondChestplate.getInstance().getUpdatedItem(DiamondChestplate.getInstance().getItem(), 
																			DiamondChestplate.getInstance().getMeta()));
		shop.setItem(15, IronSword.getInstance().getUpdatedItem(IronSword.getInstance().getItem(), 
																	IronSword.getInstance().getMeta()));
		shop.setItem(17, EPearl5.getInstance().getUpdatedItem(EPearl5.getInstance().getItem(), 
																EPearl5.getInstance().getMeta()));
		shop.setItem(21, IronLeggings.getInstance().getUpdatedItem(IronLeggings.getInstance().getItem(), 
																	IronLeggings.getInstance().getMeta()));
		shop.setItem(22, SpeedPotion.getInstance().getUpdatedItem(SpeedPotion.getInstance().getItem(), 
																	SpeedPotion.getInstance().getMeta()));
		shop.setItem(23, DiamondLeggings.getInstance().getUpdatedItem(DiamondLeggings.getInstance().getItem(), 
																		DiamondLeggings.getInstance().getMeta()));
		shop.setItem(30, IronBoots.getInstance().getUpdatedItem(IronBoots.getInstance().getItem(), 
																IronBoots.getInstance().getMeta()));
		shop.setItem(31, StrengthPotion.getInstance().getUpdatedItem(StrengthPotion.getInstance().getItem(), 
																		StrengthPotion.getInstance().getMeta()));
		shop.setItem(32, DiamondBoots.getInstance().getUpdatedItem(DiamondBoots.getInstance().getItem(), 
																	DiamondBoots.getInstance().getMeta()));
	}
	
	public void openShopInventory(Player p) {
		p.openInventory(shop);
	}
}
