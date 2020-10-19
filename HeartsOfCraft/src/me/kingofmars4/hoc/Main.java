package me.kingofmars4.hoc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingofmars4.hoc.commands.Population;
import me.kingofmars4.hoc.commands.Turn;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;
import me.kingofmars4.hoc.files.gamedata;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class Main extends JavaPlugin {
	
	public static Plugin plugin; public static Plugin getPlugin(){return plugin;}
	private gamedata gamedata = new gamedata(this);
	
	public void onEnable() {
		plugin = this;
		
		loadCommands();
		loadFirstTimeTerritories();
		loadYamlFiles();
		
		getLogger().info(this.getDescription().getFullName() + " by KingOfMars4 has been enabled!");
	}
	
	public void loadCommands() {
		getCommand("population").setExecutor(new Population());
		getCommand("turn").setExecutor(new Turn());
	}
	
	public void loadYamlFiles() {
		if (!getDataFolder().exists()) getDataFolder().mkdirs();  gamedata.reload();
	}
	
	public void loadFirstTimeTerritories() {
		if (America.territories.isEmpty()) {
			America.loadFirstTimeTerritories();
			Germany.loadFirstTimeTerritories();
			gamedata.reload();
		}
	}
	
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equals("hoc")) { if (args.length>0) { switch(args[0].toLowerCase()) {
				
					case "reload":
						if (p.hasPermission("hoc.reload")) {
							 
							reloadConfig();
							p.sendMessage(Messages.pluginPrefix + U.color("&9Config reloaded &asuccessfully&9!"));
						 } else {
							p.sendMessage(Messages.noPerm);
						}
						
					
				}
			} else {
				// SERA O MENU DO JOGO
			}
			
			return true;
		 }
		return false;
	 }
}
