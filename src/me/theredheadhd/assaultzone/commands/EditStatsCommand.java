package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.utilities.GameScoreboard;
import me.theredheadhd.assaultzone.utilities.MessageManager;
import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EditStatsCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("editstats")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			if(p.hasPermission("az.admin")) {
				if(args.length == 0) {
					MessageManager.getInstance().wrongFormat(p, "/editstats <stat_type> <player_name> <integer>");
					return false;
				} else if(args.length == 1) {
					MessageManager.getInstance().wrongFormat(p, "/editstats <stat_type> <player_name> <integer>");
					return false;
				} else if(args.length == 2){
					MessageManager.getInstance().wrongFormat(p, "/editstats <stat_type> <player_name> <integer>");
					return false;
				} else if(args.length == 3) {
					final Player target = Bukkit.getPlayer(args[1]);
					int amount = Integer.parseInt(args[2]);
					
					if(args[0].equalsIgnoreCase("points")) {
						if(target == null) {
							p.sendMessage(ChatColor.RED + "The specified player is not online!");
							
							return false;
						}
						
						p.sendMessage(ChatColor.GREEN + "The specified player's stats have been edited!");
						StatManager.getInstance().modifyPoints(target, amount);
						GameScoreboard.getInstance().updateGameScoreboard(target);
						return true;
					} else if(args[0].equalsIgnoreCase("coins")) {
						if(target == null) {
							p.sendMessage(ChatColor.RED + "The specified player is not online!");
							return false;
						}
						
						p.sendMessage(ChatColor.GREEN + "The specified player's stats have been edited!");
						StatManager.getInstance().modifyCoins(target, amount);
						GameScoreboard.getInstance().updateGameScoreboard(target);
						return true;
					} else if(args[0].equalsIgnoreCase("kills")) {
						if(target == null) {
							p.sendMessage(ChatColor.RED + "The specified player is not online!");
							return false;
						}
						
						p.sendMessage(ChatColor.GREEN + "The specified player's stats have been edited!");
						StatManager.getInstance().modifyKills(target, amount);
						GameScoreboard.getInstance().updateGameScoreboard(target);
						return true;
					} else if(args[0].equalsIgnoreCase("deaths")) {
						if(target == null) {
							p.sendMessage(ChatColor.RED + "The specified player is not online!");
							return false;
						}
						
						p.sendMessage(ChatColor.GREEN + "The specified player's stats have been edited!");
						StatManager.getInstance().modifyDeaths(target, amount);
						GameScoreboard.getInstance().updateGameScoreboard(target);
						return true;
					} else {
						p.sendMessage(ChatColor.RED + "The stat value you specified is not valid!");
						return false;
					}	
				} else {
					MessageManager.getInstance().wrongFormat(p, "/editstats <stat_type> <player_name> <integer>");
					return false;
				}
			} else {
				MessageManager.getInstance().noPerms(p);
				return false;
			}
		}	
		return true;
	}
}
