package me.kingofmars4.hoc;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingofmars4.hoc.commands.Population;

public class Main extends JavaPlugin {
	
	public static Plugin plugin; public static Plugin getPlugin(){return plugin;}
	
	public void onEnable() {
		plugin = this;
		
		loadCommands();
		
		getLogger().info(this.getDescription().getFullName() + " by KingOfMars4 has been enabled!");
	}
	
	public void loadCommands() {
		getCommand("population").setExecutor(new Population());
	}
	
	
}
