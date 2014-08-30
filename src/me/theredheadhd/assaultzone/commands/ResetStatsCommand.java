package me.theredheadhd.assaultzone.commands;

import java.io.File;

import me.theredheadhd.assaultzone.Core;
import me.theredheadhd.assaultzone.utilities.MessageManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetStatsCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("resetstats")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(p.hasPermission("az.admin")) {
				if(args.length == 0) {
					File config = new File(Core.plugin.getDataFolder(), "config.yml");
					config.delete();
					
					for(Player pl : Bukkit.getOnlinePlayers()) {
						pl.kickPlayer(ChatColor.RED + "All players have been kicked for a manual stat reset!");
					}
					
					return true;
				} else {
					MessageManager.getInstance().wrongFormat(p, "/resetstats");
					return false;
				}		
			} else {
				MessageManager.getInstance().noPerms(p);
				return false;
			}
		}
		return false;
	}
}
