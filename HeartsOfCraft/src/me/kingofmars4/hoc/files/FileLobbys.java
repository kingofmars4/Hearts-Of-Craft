package me.kingofmars4.hoc.files;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.utils.U;

public class FileLobbys {
	private static File file;
	private static FileConfiguration lobby;
	
	public static void setup () {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("HeartsOfCraft").getDataFolder(), "lobby.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
			}
		}
		
		lobby = YamlConfiguration.loadConfiguration(file);
	}
	
	public static FileConfiguration get() {
		return lobby;
	}
	
	public static void save() {
		try {
			lobby.save(file);
		} catch (IOException e) {
			Main.getPlugin().getServer().getConsoleSender().sendMessage(U.color("&cIt was not possible to save lobby.yml"));
		}
	}
	
	public static void reload() {
		lobby = YamlConfiguration.loadConfiguration(file);
	}
}
