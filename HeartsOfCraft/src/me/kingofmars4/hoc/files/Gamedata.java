package me.kingofmars4.hoc.files;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.utils.U;

public class Gamedata {
	private static File file;
	private static FileConfiguration gamedata;
	
	public static void setup () {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("HeartsOfCraft").getDataFolder(), "gamedata.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
			}
		}
		
		gamedata = YamlConfiguration.loadConfiguration(file);
	}
	
	public static FileConfiguration get() {
		return gamedata;
	}
	
	public static void save() {
		try {
			gamedata.save(file);
		} catch (IOException e) {
			Main.getPlugin().getServer().getConsoleSender().sendMessage(U.color("&cIt was not possible to save maps.yml"));
		}
	}
	
	public static void reload() {
		gamedata = YamlConfiguration.loadConfiguration(file);
	}
}
