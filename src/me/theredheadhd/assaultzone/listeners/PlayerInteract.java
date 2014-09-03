package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.shop.ShopManager;
import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(item == null || item.getItemMeta() == null || item.getItemMeta().getDisplayName() == null) return;
			if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Shop Item")) {
				ShopManager.getInstance().openShopInventory(p);
		
			}
		}
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getClickedBlock().getState();
				
				if(s.getLine(0).equalsIgnoreCase(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "AssaultZone" + ChatColor.DARK_GRAY + "]")) {
					
					String id = s.getLine(1);
					String configID = "." + id;
					
					if(!(settings.get("Arenas" + configID) == null)) {
						World world = (World) settings.get("Arenas" + configID + ".world");
						int x = (int) settings.get("Arenas" + configID + ".xSpawn");
						int y = (int) settings.get("Arenas" + configID + ".ySpawn");
						int z = (int) settings.get("Arenas" + configID + ".zSpawn");

						p.teleport(new Location(world, x, y, z));
					} else {
						p.sendMessage(ChatColor.RED + "The specified arena does not exist. Please contact an administrator.");
					}
				}
			}
		}
	}
}
