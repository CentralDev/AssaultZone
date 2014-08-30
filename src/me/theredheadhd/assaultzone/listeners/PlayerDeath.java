package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.utilities.GameScoreboard;
import me.theredheadhd.assaultzone.utilities.StatManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player victim = e.getEntity();
		
		InventoryClick.selectedkit.remove(victim.getName());
		
		StatManager.getInstance().modifyDeaths(victim, 1);
		StatManager.getInstance().modifyPoints(victim, -3);
		StatManager.getInstance().modifyKills(victim, 0);
		
		GameScoreboard.getInstance().updateGameScoreboard(victim);
		
		if(victim.getKiller() instanceof Player) {
			Player killer = victim.getKiller();
			
			StatManager.getInstance().modifyCoins(killer, 3);
			StatManager.getInstance().modifyKills(killer, 1);
			StatManager.getInstance().modifyPoints(killer, 5);
			
			GameScoreboard.getInstance().updateGameScoreboard(killer);
		}
	}
}
