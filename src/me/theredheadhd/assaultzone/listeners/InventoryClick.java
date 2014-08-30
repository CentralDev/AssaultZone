package me.theredheadhd.assaultzone.listeners;

import java.util.ArrayList;

import me.theredheadhd.assaultzone.kits.KitManager;
import me.theredheadhd.assaultzone.utilities.GameScoreboard;
import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

	public static ArrayList<String> selectedkit = new ArrayList<String>();

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		
		if(e.getInventory().getName().equalsIgnoreCase("kitMenu")) { e.setCancelled(true); }
		
		if(item == null || item.getItemMeta() == null || item.getItemMeta().getDisplayName() == null) return;
		if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Soldier Kit")) {
			if(selectedkit.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You have already selected your kit for this life!");
				e.setCancelled(true);
				p.closeInventory();
			} else {
				selectedkit.add(p.getName());
				e.setCancelled(true);
				p.closeInventory();
				KitManager.getInstance().setSoldierInventory(p);
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Sniper Kit")) {
			if(selectedkit.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You have already selected your kit for this life!");
				e.setCancelled(true);
				p.closeInventory();
			} else {
				selectedkit.add(p.getName());
				e.setCancelled(true);
				p.closeInventory();
				KitManager.getInstance().setSniperInventory(p);
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Helmet")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Chestplate")) {
			if(StatManager.getInstance().getCoins(p) >= 40) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
				StatManager.getInstance().modifyCoins(p, -40);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Leggings")) {
			if(StatManager.getInstance().getCoins(p) >= 35) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
				StatManager.getInstance().modifyCoins(p, -35);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Boots")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Helmet")) {
			if(StatManager.getInstance().getCoins(p) >= 35) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
				StatManager.getInstance().modifyCoins(p, -35);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Chestplate")) {
			if(StatManager.getInstance().getCoins(p) >= 50) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
				StatManager.getInstance().modifyCoins(p, -50);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Leggings")) {
			if(StatManager.getInstance().getCoins(p) >= 45) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
				StatManager.getInstance().modifyCoins(p, -45);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Boots")) {
			if(StatManager.getInstance().getCoins(p) >= 35) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
				StatManager.getInstance().modifyCoins(p, -35);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Diamond Sword")) {
			if(StatManager.getInstance().getCoins(p) >= 20) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
				StatManager.getInstance().modifyCoins(p, -20);
				GameScoreboard.getInstance().updateGameScoreboard(p);	
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Iron Sword")) {
			if(StatManager.getInstance().getCoins(p) >= 10) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
				StatManager.getInstance().modifyCoins(p, -10);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Bow")) {
			if(StatManager.getInstance().getCoins(p) >= 10) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.BOW));
				StatManager.getInstance().modifyCoins(p, -10);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "16 Arrows")) {
			if(StatManager.getInstance().getCoins(p) >= 5) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.ARROW,16));
				StatManager.getInstance().modifyCoins(p, -5);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Golden Apple")) {
			if(StatManager.getInstance().getCoins(p) >= 10) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
				StatManager.getInstance().modifyCoins(p, -10);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "5 Golden Apples")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,5));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ender Pearl")) {
			if(StatManager.getInstance().getCoins(p) >= 10) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
				StatManager.getInstance().modifyCoins(p, -10);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "5 Ender Pearls")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL,5));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Instant Health Potion")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.POTION,1,(short)16421));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Regen Potion")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.POTION,1,(short)16417));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		} else if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Speed Potion")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.POTION,1,(short)16418));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		}
		else if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Strength Potion")) {
			if(StatManager.getInstance().getCoins(p) >= 25) {
				e.setCancelled(true);
				p.closeInventory();
				
				p.getInventory().addItem(new ItemStack(Material.POTION,1,(short)16425));
				StatManager.getInstance().modifyCoins(p, -25);
				GameScoreboard.getInstance().updateGameScoreboard(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.sendMessage(ChatColor.GREEN + "Thank you for purchasing from the shop!");
			} else {
				e.setCancelled(true);
				p.closeInventory();
				
				p.sendMessage(ChatColor.RED + "You don't have the sufficient funds to purchase this item!");
			}
		}
	}
}
