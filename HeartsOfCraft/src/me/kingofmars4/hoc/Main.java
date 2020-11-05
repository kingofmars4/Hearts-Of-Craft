package me.kingofmars4.hoc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingofmars4.hoc.commands.CommandPopulation;
import me.kingofmars4.hoc.commands.Turn;
import me.kingofmars4.hoc.files.Gamedata;
import me.kingofmars4.hoc.guis.SelectCountry;
import me.kingofmars4.hoc.handlers.countries.CountrieManager;
import me.kingofmars4.hoc.handlers.territories.TerritorieManager;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class Main extends JavaPlugin {
   
    public static Plugin plugin; public static Plugin getPlugin(){return plugin;}
   
    public void onEnable() {
        plugin = this;
        
        loadConfigFiles();
        loadCache();
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
    }
   
    public void loadListeners() {
       getServer().getPluginManager().registerEvents(new SelectCountry(), this);
    }
   
    public void saveCache() {
  	   
  	   TerritorieManager.get().saveTerritories();
     }
    
    public void loadCache() {
 	   
 	   CountrieManager.get().loadCountries();
 	   TerritorieManager.get().loadTerritories();
    }
    
    public void loadConfigFiles() {
    	Gamedata.setup();
    	U.loadDefaults();
		Gamedata.get().options().copyDefaults(true);
		Gamedata.save();
    }
   
    // COMMANDS
    @Override
     public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equals("hoc")) { if (args.length>0) { switch(args[0].toLowerCase()) {
               
                    case "reload":
                        if (p.hasPermission("hoc.reload")) {

                        	TerritorieManager.get().saveTerritories();
                            p.sendMessage(Messages.pluginPrefix + U.color("&9Config reloaded &asuccessfully&9!"));
                         } else {
                            p.sendMessage(Messages.noPerm);
                        }
                }
            } else {
            	
                Bukkit.broadcastMessage(""+ TerritorieManager.get().getTerritorie("Alaska").getPopulation());
            	
                if (p.hasPermission("hoc.player")) {
                	SelectCountry.updateGUI();
                    p.openInventory(SelectCountry.gui);
                   
                } else {
                    p.sendMessage(Messages.noPerm);
                }
            }
            return true;
         }
        return false;
     }
}