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
					String id = args[0];
					
					if(settings.getArena(id) == null) {
						p.sendMessage(ChatColor.RED + "The specified arena does not exist.");
						return false;
					} else {
						settings.deleteArena(id);
						p.sendMessage(ChatColor.RED + "Successfully deleted arena: " + id);
						return true;
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
