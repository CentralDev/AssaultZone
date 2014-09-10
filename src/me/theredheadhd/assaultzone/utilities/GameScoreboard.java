package me.theredheadhd.assaultzone.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class GameScoreboard {
	private static GameScoreboard instance = new GameScoreboard();
	public static GameScoreboard getInstance() { return instance; }
	
	public Scoreboard board;
	private static Objective o;
	private static Score points;
	private static Score coins;
	private static Score kills;
	private static Score deaths;
	
	@SuppressWarnings("deprecation")
	public void createScoreboard() {
		board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		
		o = board.registerNewObjective("side", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Stats");
		
		points = o.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "" + ChatColor.BOLD + "Points:"));
		points.setScore(0);
		
		coins = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Coins:"));
		coins.setScore(0);
		
		kills = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "" + ChatColor.BOLD + "Kills:"));
		kills.setScore(0);
		
		deaths= o.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.BOLD + "Deaths:"));
		deaths.setScore(0);
	}
	
	@SuppressWarnings("deprecation")
	public void updateGameScoreboard(Player p) {
		int playerpoints = StatManager.getInstance().getPoints(p);
		int playercoins = StatManager.getInstance().getCoins(p);
		int playerkills = StatManager.getInstance().getKills(p);
		int playerdeaths = StatManager.getInstance().getDeaths(p);

		o.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + "'s Stats");

		points = o.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "" + ChatColor.BOLD + "Points:"));
		points.setScore(playerpoints);
		
		coins = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Coins:"));
		coins.setScore(playercoins);
		
		kills = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "" + ChatColor.BOLD + "Kills:"));
		kills.setScore(playerkills);
		
		deaths= o.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.BOLD + "Deaths:"));
		deaths.setScore(playerdeaths);
		
		p.setScoreboard(board);
	}
	
	public void setPlayerScoreboard(Player p) {
		o.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + "'s Stats");

		p.setScoreboard(board);
	}
}
