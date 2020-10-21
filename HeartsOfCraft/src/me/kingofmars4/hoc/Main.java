package me.kingofmars4.hoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingofmars4.hoc.commands.CommandPopulation;
import me.kingofmars4.hoc.commands.Turn;
import me.kingofmars4.hoc.files.CommentedYamlConfiguration;
import me.kingofmars4.hoc.guis.SelectCountry;
import me.kingofmars4.hoc.handlers.Players;
import me.kingofmars4.hoc.handlers.Territories;
import me.kingofmars4.hoc.utils.GUIs;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class Main extends JavaPlugin {
	
	public static Plugin plugin; public static Plugin getPlugin(){return plugin;}
	
	public void onEnable() {
		plugin = this;
		
		loadCommands();
		loadListeners();
		loadConfigFiles();
		U.loadCache();
		
		getLogger().info(this.getDescription().getFullName() + " by KingOfMars4 has been enabled!");
	}
	
	@Override
	public void onDisable() {
		Territories.saveTerritories();
		Players.savePlayers();
		saveGamedata();
	}
	
	
	
	public void loadCommands() {
		getCommand("population").setExecutor(new CommandPopulation());
		getCommand("turn").setExecutor(new Turn());
	}
	
	public void loadListeners() {
		getServer().getPluginManager().registerEvents(new SelectCountry(), this);
	}
	
	public void loadConfigFiles() {
		if (!getDataFolder().exists()) getDataFolder().mkdirs();  
		loadGamedata();
	}
	
	
	
	// COMMANDS
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equals("hoc")) { if (args.length>0) { switch(args[0].toLowerCase()) {
				
					case "reload":
						if (p.hasPermission("hoc.reload")) {
							 
							loadGamedata();

							p.sendMessage(Messages.pluginPrefix + U.color("&9Config reloaded &asuccessfully&9!"));
						 } else {
							p.sendMessage(Messages.noPerm);
						}
						
					
				}
			} else {
				
				if (p.hasPermission("hoc.player")) {
					p.openInventory(GUIs.selectCountry);
					
				} else {
					p.sendMessage(Messages.noPerm);
				}
			}
			return true;
		 }
		return false;
	 }
	
	
	
	// GAMEDATA.YML HANDLER
	public static CommentedYamlConfiguration gamedata;
	@SuppressWarnings("unused")
	private String newline = System.getProperty("line.separator");
	 
	public static File f = new File("plugins/HeartsOfCraft", "gamedata.yml"); 
    public static void loadGamedata(){ 
        
         
        if(!f.exists()) { 
            try { 
                f.createNewFile(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
         
        gamedata = new CommentedYamlConfiguration();        

        try { 
        	gamedata.load(f); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (InvalidConfigurationException e) { 
            e.printStackTrace(); 
        } 
    	
    	//LOAD GAME DATA FOR FIRST TIME
    	U.loadFirstTimeGamedata();
			    	
    	
        try { 
        	gamedata.save(f); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        
    } 
	
    public void saveGamedata() {
    	try { 
        	gamedata.save(f); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }
    
	private static boolean gamedataPath(String path) {
		return gamedata.isSet(path);
	}
	
	
	@SuppressWarnings("unused")
	public void addGamedataComment(String path, String... comment) {
		gamedata.addComment(path, comment);		
	}
	
	public static void addGameDataDefault(String path, Object defaultValue) {
		if (path.equals("Version"))
			gamedata.set(path, plugin.getDescription().getVersion());
		if (!gamedataPath(path))
			gamedata.set(path, defaultValue);		
	}
}
