package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.utilities.MessageManager;
import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteArenaCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("deletearena")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(p.hasPermission("az.admin")) {
				if(args.length == 0) {
					MessageManager.getInstance().wrongFormat(p, "/deletearena <id>");
					return false;
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("1")) {
						if(settings.getArenas().contains("1")) {
							settings.deleteArena("1");
							return true;
						} else {
							p.sendMessage(ChatColor.RED + "Arena 1 has not been created!");
							return false;
						}
					} else if(args[0].equalsIgnoreCase("2")) {
						if(settings.getArenas().contains("2")) {
							settings.deleteArena("2");
							return true;
						} else {
							p.sendMessage(ChatColor.RED + "Arena 2 has not been created!");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.RED + "The only valid Arena ID's are '1' and '2'.");
						return false;
					}
				} else {
					MessageManager.getInstance().wrongFormat(p, "/deletearena <id>");
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
