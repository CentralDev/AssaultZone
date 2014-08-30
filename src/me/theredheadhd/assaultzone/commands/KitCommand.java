package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.menus.MenuManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.command.CommandExecutor;

public class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}

			Player p = (Player) sender;
			
			if(args.length == 0) {
				MenuManager.getInstance().openKitMenu(p);
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "Too many arguments! The attempted command is invalid!");
				return false;
			}
		}
		return true;
	}
}
