package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getLines().length > 0 & !e.getLine(0).equalsIgnoreCase("[AssaultZone]")) return;
		if(e.getLines().length < 2) {
			e.getBlock().breakNaturally();
			p.sendMessage(ChatColor.RED + "An AssaultZone Sign must have 2 lines.");
			return;
		}
				
		String id = e.getLine(1);
		String configID = "." + id;
		
		if((settings.get("Arenas" + configID) == null)) {
			e.getBlock().breakNaturally();
			p.sendMessage(ChatColor.RED + e.getLine(1) + " is not a valid ID.");
		} else return;
		
		e.setLine(0, ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "AssaultZone" + ChatColor.DARK_GRAY + "]");
	}
}
