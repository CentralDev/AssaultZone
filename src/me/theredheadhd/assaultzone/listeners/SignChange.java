package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if(!(e.getLines().length > 0 || e.getLine(0).equals("[AssaultZone]"))) return;
		if(e.getLine(0).equalsIgnoreCase("[AssaultZone]")) {
			String id = (String) e.getLine(1);
			if(!(settings.getArena(id) == null)) {
				e.setLine(0, ChatColor.RED + "Assault" + ChatColor.BLUE + "Zone");
			} else {
				e.getBlock().breakNaturally();
				e.getPlayer().sendMessage(ChatColor.RED + "The specifed arena does not exist.");
			}
		}
	}
}
