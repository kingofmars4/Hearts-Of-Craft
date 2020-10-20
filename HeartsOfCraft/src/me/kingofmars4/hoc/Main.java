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
import me.kingofmars4.hoc.commands.Population;
import me.kingofmars4.hoc.commands.Turn;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;
import me.kingofmars4.hoc.files.CommentedYamlConfiguration;
import me.kingofmars4.hoc.guis.SelectCountry;
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
		
		
		getLogger().info(this.getDescription().getFullName() + " by KingOfMars4 has been enabled!");
	}
	
	public void loadCommands() {
		getCommand("population").setExecutor(new Population());
		getCommand("turn").setExecutor(new Turn());
	}
	
	public void loadConfigFiles() {
		if (!getDataFolder().exists()) getDataFolder().mkdirs();  
		reloadGamedata();
	}
	
	public void loadListeners() {
		getServer().getPluginManager().registerEvents(new SelectCountry(), this);
	}
	
	
	// COMMANDS
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equals("hoc")) { if (args.length>0) { switch(args[0].toLowerCase()) {
				
					case "reload":
						if (p.hasPermission("hoc.reload")) {
							 
							loadConfigFiles();

							p.sendMessage(Messages.pluginPrefix + U.color("&9Config reloaded &asuccessfully&9!"));
						 } else {
							p.sendMessage(Messages.noPerm);
						}
						
					
				}
			} else {
				
				if (p.hasPermission("hoc.player")) {
					
					p.openInventory(SelectCountry.gui);
					
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
	 
	public static void reloadGamedata(){
		loadGamedata();
		Territories.loadTerritories();
	}
	
    public static void loadGamedata(){ 
        File f = new File(plugin.getDataFolder(), "gamedata.yml"); 
         
        if(!f.exists()) { 
            try { 
            	Territories.loadFirstTimeTerritories();
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
    	
    	//LOAD OWNED TERRITORIES
    		// USA
    			addGameDataDefault("Countries.USA.Territories", America.territories);
		    	
		    	
	    	// GERMANY
			    addGameDataDefault("Countries.Germany.Territories",Germany.territories);
    	
    	
    	//LOAD FIRST TIME TERRITORIES
		    	me.kingofmars4.hoc.handlers.Population.loadFirstTimePopulation(); 	
			    	
    	
        // Write back config 
        try { 
        	gamedata.save(f); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
	
	public CommentedYamlConfiguration getGamedata() {	
		return gamedata;
	}
	
	private static boolean gamedataPath(String path) {
		return gamedata.isSet(path);
	}
	
	@SuppressWarnings("unused")
	private void addGamedataComment(String path, String... comment) {
		gamedata.addComment(path, comment);		
	}
	
	public static void addGameDataDefault(String path, Object defaultValue) {
		if (path.equals("Version"))
			gamedata.set(path, plugin.getDescription().getVersion());
		if (!gamedataPath(path))
			gamedata.set(path, defaultValue);		
	}
}
