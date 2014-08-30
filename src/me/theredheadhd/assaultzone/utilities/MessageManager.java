package me.theredheadhd.assaultzone.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
	}
	
	public void wrongFormat(Player p, String format) {
		p.sendMessage(ChatColor.RED + "That is not the correct format! The correct format is: " 
						+ ChatColor.DARK_RED + "'" + format + "'");
	}
	
	public void noPerms(Player p) {
		p.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
	}
}
