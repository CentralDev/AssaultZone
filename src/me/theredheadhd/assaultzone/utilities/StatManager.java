package me.theredheadhd.assaultzone.utilities;

import me.theredheadhd.assaultzone.Core;

import org.bukkit.entity.Player;

public class StatManager {

	private static StatManager instance = new StatManager();
	public static StatManager getInstance() { return instance; }

	public int getPoints(Player p) {
		return Core.config.getInt(p.getUniqueId().toString() + ".Points");
	}
	
	public void modifyPoints(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Points", Core.config.getInt(p.getUniqueId().toString() + ".Points") + i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public void setPoints(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Points", i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public int getCoins(Player p) {
		return Core.config.getInt(p.getUniqueId().toString() + ".Coins");
	}
	
	public void modifyCoins(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Coins", Core.config.getInt(p.getUniqueId().toString() + ".Coins") + i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public void setCoins(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Coins", i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public int getKills(Player p) {
		return Core.config.getInt(p.getUniqueId().toString() + ".Kills");
	}
	
	public void modifyKills(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Kills", Core.config.getInt(p.getUniqueId().toString() + ".Kills") + i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public void setKills(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Kills", i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public int getDeaths(Player p) {
		return Core.config.getInt(p.getUniqueId().toString() + ".Deaths");
	}
	
	public void modifyDeaths(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Deaths", Core.config.getInt(p.getUniqueId().toString() + ".Deaths") + i);
		Core.saveConfigurationFile(Core.plugin);
	}
	
	public void setDeaths(Player p, int i) {
		Core.config.set(p.getUniqueId().toString() + ".Deaths", i);
		Core.saveConfigurationFile(Core.plugin);
	}
}
