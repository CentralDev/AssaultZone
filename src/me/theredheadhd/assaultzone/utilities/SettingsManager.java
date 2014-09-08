package me.theredheadhd.assaultzone.utilities;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

	private static SettingsManager instance = new SettingsManager();
	
	public static SettingsManager getInstance() {
		return instance;
	}
	
	private static FileConfiguration arenas;
	private static File afile;
	
	public void setup(Plugin p) {
		if(!(p.getDataFolder().exists())) p.getDataFolder().mkdir();
		
		afile = new File(p.getDataFolder(), "arenas.yml");
		
		if(!(afile.exists())) {
			try {
				afile.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		arenas = YamlConfiguration.loadConfiguration(afile);
	}
	
	public FileConfiguration getArenas() {
		return arenas;
	}
	
	public Object getArena(String id) {
		return arenas.getConfigurationSection("Arenas" + "." + id);
	}
	
	public void set(String path, Object value) {
		arenas.set(path, value);
		
		try {
			arenas.save(afile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArena(String id) {
		getArenas().getConfigurationSection("Arenas").set(id, null);
		
		try {
			arenas.save(afile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(String id) {
		if(arenas.contains("Arenas" + "." + id)) {
			return true;
		}
		return false;
	}
}
