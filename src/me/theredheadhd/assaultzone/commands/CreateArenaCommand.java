package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.utilities.MessageManager;
import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateArenaCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("createarena")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(p.hasPermission("az.admin")) {
				if(args.length == 0) {
					MessageManager.getInstance().wrongFormat(p, "/createarena <id>");
					return false;
				} else if(args.length == 1) {
					String id = args[0];
					
					if(settings.getArena(id) == null) {
						settings.set("Arenas" + "." + id, id);
						settings.set("Arenas" + "." + id + ".world", p.getLocation().getWorld().getName());
						settings.set("Arenas" + "." + id + ".xSpawn", p.getLocation().getBlockX());
						settings.set("Arenas" + "." + id + ".ySpawn", p.getLocation().getBlockY());
						settings.set("Arenas" + "." + id + ".zSpawn", p.getLocation().getBlockZ());
						
						p.sendMessage(ChatColor.GREEN + "Successfully created arena: " + id);
						return true;
					} else {
						p.sendMessage(ChatColor.RED + "The specified arena already exists. Please choose a different ID.");
						return false;
					}
				} else {
					MessageManager.getInstance().wrongFormat(p, "/createarena <id>");
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
