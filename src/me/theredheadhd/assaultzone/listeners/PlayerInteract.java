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
			if(e.getClickedBlock() instanceof Sign) {
				Sign s = (Sign) e.getClickedBlock();
								
				if(s.getLine(0).equals(ChatColor.RED + "Assault" + ChatColor.BLUE + "Zone")) {
					if(s.getLine(1).equals("1")) {
						World world = (World) settings.getArenaWorld(1);
						int x = Integer.parseInt((String) settings.get(".1" + ".xSpawn"));
						int y = Integer.parseInt((String) settings.get(".1" + ".ySpawn"));
						int z = Integer.parseInt((String) settings.get(".1" + ".zSpawn"));
						
						p.teleport(new Location(world, x, y, z));
					} else if(s.getLine(1).equals("2")) {
						World world = (World) settings.getArenaWorld(2);
						int x = Integer.parseInt((String) settings.get(".2" + ".xSpawn"));
						int y = Integer.parseInt((String) settings.get(".2" + ".ySpawn"));
						int z = Integer.parseInt((String) settings.get(".2" + ".zSpawn"));
						
						p.teleport(new Location(world, x, y, z));
					} else return;
				} else return;
			}
		}
	}
}
