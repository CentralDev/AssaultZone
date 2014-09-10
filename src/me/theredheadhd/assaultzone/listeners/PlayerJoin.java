package me.theredheadhd.assaultzone.listeners;
import me.theredheadhd.assaultzone.Core;
import me.theredheadhd.assaultzone.utilities.GameScoreboard;
import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(Core.config.get(p.getName() + ".Points") == null) {
			StatManager.getInstance().setPoints(p, 0);
		}
		if(Core.config.get(p.getName() + ".Coins") == null) {
			StatManager.getInstance().setCoins(p, 0);
		}
		if(Core.config.get(p.getName() + ".Kills") == null) {
			StatManager.getInstance().setKills(p, 0);
		}
		if(Core.config.get(p.getName() + ".Deaths") == null) {
			StatManager.getInstance().setDeaths(p, 0);
		}
		
		Core.setPlayerNameFormat(p);
		p.setScoreboard(GameScoreboard.getInstance().board);
		e.setJoinMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.YELLOW + "" + p.getName());
	}
}
