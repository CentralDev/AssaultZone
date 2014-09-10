package me.theredheadhd.assaultzone.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("[AZ]")) {
			e.setLine(0, ChatColor.RED + "Assault" + ChatColor.BLUE + "Zone");
		}
	}
}
