package me.theredheadhd.assaultzone.listeners;

import me.theredheadhd.assaultzone.Core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class UtilityEvents implements Listener {

	@EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Core.saveConfigurationFile(Core.plugin);
	}
}
