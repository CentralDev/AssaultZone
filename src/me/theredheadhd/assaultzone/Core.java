package me.theredheadhd.assaultzone;

import java.io.File;
import java.io.IOException;

import me.theredheadhd.assaultzone.commands.CreateArenaCommand;
import me.theredheadhd.assaultzone.commands.DeleteArenaCommand;
import me.theredheadhd.assaultzone.commands.EditStatsCommand;
import me.theredheadhd.assaultzone.commands.KitCommand;
import me.theredheadhd.assaultzone.commands.ResetStatsCommand;
import me.theredheadhd.assaultzone.commands.SetArenaSpawnCommand;
import me.theredheadhd.assaultzone.commands.StatsCommand;
import me.theredheadhd.assaultzone.listeners.AsyncPlayerChat;
import me.theredheadhd.assaultzone.listeners.InventoryClick;
import me.theredheadhd.assaultzone.listeners.PlayerDeath;
import me.theredheadhd.assaultzone.listeners.PlayerDropItem;
import me.theredheadhd.assaultzone.listeners.PlayerInteract;
import me.theredheadhd.assaultzone.listeners.PlayerJoin;
import me.theredheadhd.assaultzone.listeners.SignChange;
import me.theredheadhd.assaultzone.listeners.UtilityEvents;
import me.theredheadhd.assaultzone.menus.MenuManager;
import me.theredheadhd.assaultzone.shop.ShopManager;
import me.theredheadhd.assaultzone.utilities.GameScoreboard;
import me.theredheadhd.assaultzone.utilities.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	public static Plugin plugin;
	public static File cfile;
	public static FileConfiguration config;
	
	@Override
	public void onEnable() {
		plugin = this;
		config = plugin.getConfig();
		
		SettingsManager.getInstance().setup(plugin);
		registerCommands();
		registerEvents();
		
		GameScoreboard.getInstance().createScoreboard();
		MenuManager.getInstance().createKitMenu();
		ShopManager.getInstance().createShopInventory();
	}
	
	@Override
	public void onDisable() {
		saveConfigurationFile(plugin);
	}
	private void registerCommands() {
		this.getCommand("createarena").setExecutor(new CreateArenaCommand());
		this.getCommand("deletearena").setExecutor(new DeleteArenaCommand());
		this.getCommand("editstats").setExecutor(new EditStatsCommand());
		this.getCommand("kit").setExecutor(new KitCommand());
		this.getCommand("resetstats").setExecutor(new ResetStatsCommand());
		this.getCommand("setarenaspawn").setExecutor(new SetArenaSpawnCommand());
		this.getCommand("stats").setExecutor(new StatsCommand());
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new AsyncPlayerChat(), plugin);
		pm.registerEvents(new InventoryClick(), plugin);
		pm.registerEvents(new PlayerDeath(), plugin);
		pm.registerEvents(new PlayerDropItem(), plugin);
		pm.registerEvents(new PlayerInteract(), plugin);
		pm.registerEvents(new PlayerJoin(), plugin);
		pm.registerEvents(new SignChange(), plugin);
		pm.registerEvents(new UtilityEvents(), plugin);
	}
	
	public static void setPlayerNameFormat(Player p) {
		if (p.hasPermission("rank.guest")) {
            p.setPlayerListName(ChatColor.YELLOW + p.getName());
        }
        if (p.hasPermission("rank.donor")) {
            p.setPlayerListName(ChatColor.AQUA + p.getName());
        }
        if (p.hasPermission("rank.vip")) {
            p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
        }
        if (p.hasPermission("rank.mod")) {
            p.setPlayerListName(ChatColor.RED + p.getName());
        }
        if (p.hasPermission("rank.srmod")) {
            p.setPlayerListName(ChatColor.RED + "" + ChatColor.BOLD + p.getName());
        }
        if (p.hasPermission("rank.admin")) {
            p.setPlayerListName(ChatColor.DARK_RED + p.getName());
        }
        if (p.hasPermission("rank.owner")) {
            p.setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.BOLD + p.getName());
        }
        if (p.hasPermission("rank.dev")) {
            p.setPlayerListName(ChatColor.DARK_AQUA + "§l" + p.getName());
        }
	}
	
	public static void saveConfigurationFile(Plugin p) {
		cfile = new File(p.getDataFolder(), "config.yml");
		
		if(!(cfile.exists())) {
			try {
				cfile.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		try {
			config.save(cfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
