package me.kingofmars4.hoc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingofmars4.hoc.commands.CommandPopulation;
import me.kingofmars4.hoc.commands.CreateLobby;
import me.kingofmars4.hoc.commands.DeleteLobby;
import me.kingofmars4.hoc.commands.Turn;
import me.kingofmars4.hoc.files.Gamedata;
import me.kingofmars4.hoc.files.FileLobbys;
import me.kingofmars4.hoc.guis.SelectCountry;
import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.listeners.CreateSign;
import me.kingofmars4.hoc.listeners.JoinGame;
import me.kingofmars4.hoc.listeners.LobbyItems;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class Main extends JavaPlugin {
   
    public static Plugin plugin; public static Plugin getPlugin(){return plugin;}
   
    @Override
    public void onLoad() {
    	loadConfigFiles();
        loadCache();
    }
    
    public void onEnable() {
        plugin = this;
        
        loadCommands();
        loadListeners();
       
        getLogger().info(this.getDescription().getFullName() + " by KingOfMars4 has been enabled!");
    }
   
    @Override
    public void onDisable() {
    	saveCache();
    }
   
 
    public void loadCommands() {
        getCommand("population").setExecutor(new CommandPopulation());
        getCommand("turn").setExecutor(new Turn());
        getCommand("createlobby").setExecutor(new CreateLobby());
        getCommand("deletelobby").setExecutor(new DeleteLobby());
    }
   
    public void loadListeners() {
    	PluginManager pm = getServer().getPluginManager();
    	pm.registerEvents(new SelectCountry(), this);
    	pm.registerEvents(new CreateSign(), this);
    	pm.registerEvents(new JoinGame(), this);
    	pm.registerEvents(new LobbyItems(), this);
    }
   
    public void saveCache() {
  	   
     }
    
    public void loadCache() {
 	   
    	LobbyManager.get().loadLobbySize();
    	LobbyManager.get().loadLobbys();
    	
    	getLogger().info("Cache data succefully loaded.");
    }
    
    public void loadConfigFiles() {
    	Gamedata.setup();
    	U.loadDefaults();
		Gamedata.get().options().copyDefaults(true);
		Gamedata.save();
		
		FileLobbys.setup();
		FileLobbys.save();
		
		getLogger().info("Configuration files succefully loaded.");
    }
   
    // COMMANDS
    @Override
     public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equals("hoc")) { if (args.length>0) { switch(args[0].toLowerCase()) {
               
                    case "reload":
                        if (p.hasPermission("hoc.reload")) {
                        	
                        	saveCache();
                        	Bukkit.getPluginManager().disablePlugin(this);
                        	loadConfigFiles();
                            loadCache();
                        	Bukkit.getPluginManager().enablePlugin(this);
                            p.sendMessage(Messages.pluginPrefix + U.color("&9Config reloaded &asuccessfully&9!"));
                         } else {
                            p.sendMessage(Messages.noPerm);
                        }
                }
            } else {
                if (p.hasPermission("hoc.player")) {
                	if (LobbyManager.get().isInLobby(p)) {
                		SelectCountry.updateGUI(p);
                		p.openInventory(SelectCountry.gui);
                	} else { p.sendMessage(Messages.pluginPrefix+U.color("&cYou must be in a lobby to execute that command!")); }
                } else { p.sendMessage(Messages.noPerm); }
            }
            return true;
         }
        return false;
     }
}