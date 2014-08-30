package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		int points = StatManager.getInstance().getPoints(p);
		String pointprefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + points + ChatColor.DARK_GRAY + "] ";
		
		e.setFormat(pointprefix + 
				ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "%s" + ChatColor.GRAY + ": " + ChatColor.WHITE + "%s");
		return;
	}
}
