package me.theredheadhd.assaultzone.commands;

import me.theredheadhd.assaultzone.utilities.MessageManager;
import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetArenaSpawnCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setarenaspawn")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(p.hasPermission("az.admin")) {
				if(args.length == 0) {
					MessageManager.getInstance().wrongFormat(p, "/setarenaspawn <id>");
					return false;
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("1")) {
						settings.set("Arenas" + ".1" + ".world", p.getLocation().getWorld().getName());
						settings.set("Arenas" + ".1" + ".xSpawn", p.getLocation().getBlockX());
						settings.set("Arenas" + ".1" + ".ySpawn", p.getLocation().getBlockY());
						settings.set("Arenas" + ".1" + ".zSpawn", p.getLocation().getBlockZ());
						return true;
					} else if(args[0].equalsIgnoreCase("2")) {
						settings.set("Arenas" + ".1" + ".world", p.getLocation().getWorld().getName());
						settings.set("Arenas" + ".1" + ".xSpawn", p.getLocation().getBlockX());
						settings.set("Arenas" + ".1" + ".ySpawn", p.getLocation().getBlockY());
						settings.set("Arenas" + ".1" + ".zSpawn", p.getLocation().getBlockZ());
						return true;
					} else {
						p.sendMessage(ChatColor.RED + "The only valid Arena ID's are '1' and '2'.");
						return false;
					}
				} else {
					MessageManager.getInstance().wrongFormat(p, "/setarenaspawn <id>");
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
