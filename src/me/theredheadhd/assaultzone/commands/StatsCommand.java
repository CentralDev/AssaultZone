package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.utilities.MessageManager;
import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("stats")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players have access to this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage(ChatColor.YELLOW + "" + p.getName() + "'s Stats");
				p.sendMessage(ChatColor.DARK_AQUA + "Points: " + ChatColor.GREEN + "" + StatManager.getInstance().getPoints(p));
				p.sendMessage(ChatColor.DARK_AQUA + "Coins: " + ChatColor.GREEN + "" + StatManager.getInstance().getCoins(p));
				p.sendMessage(ChatColor.DARK_AQUA + "Kills: " + ChatColor.GREEN + "" + StatManager.getInstance().getKills(p));
				p.sendMessage(ChatColor.DARK_AQUA + "Deaths: " + ChatColor.GREEN + "" + StatManager.getInstance().getDeaths(p));
				return true;
			} else if(args.length == 1) {
				final Player target = Bukkit.getPlayer(args[0]);
				
				if(target == null) {
					p.sendMessage(ChatColor.RED + "The specified player is not online!");
					return false;
				}
				
				p.sendMessage(ChatColor.YELLOW + "" + target.getName() + "'s Stats");
				p.sendMessage(ChatColor.DARK_AQUA + "Points: " + ChatColor.GREEN + "" + StatManager.getInstance().getPoints(target));
				p.sendMessage(ChatColor.DARK_AQUA + "Coins: " + ChatColor.GREEN + "" + StatManager.getInstance().getCoins(target));
				p.sendMessage(ChatColor.DARK_AQUA + "Kills: " + ChatColor.GREEN + "" + StatManager.getInstance().getKills(target));
				p.sendMessage(ChatColor.DARK_AQUA + "Deaths: " + ChatColor.GREEN + "" + StatManager.getInstance().getDeaths(target));
				return true;
			} else {
				MessageManager.getInstance().wrongFormat(p, "/stats <player_name");
				return false;
			}
		} 		
		return false;
	}
}
