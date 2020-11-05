package me.kingofmars4.hoc.handlers.territories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import me.kingofmars4.hoc.files.Gamedata;
import me.kingofmars4.hoc.handlers.countries.Countrie;
import me.kingofmars4.hoc.handlers.countries.CountrieManager;

public class TerritorieManager {
	
	private static TerritorieManager tm;
	public final List<Territorie> territories = new ArrayList<Territorie>();
    
    private TerritorieManager() {}
    
    public static TerritorieManager get() {
    	if (tm == null) {
    		tm = new TerritorieManager();
    	}
    	return tm;
    }
    
    public Territorie getTerritorie(String name) {
    	for (int i = 0; i<TerritorieManager.get().territories.size(); i++) {
    		String territorio = TerritorieManager.get().territories.get(i).getName();
    		if (territorio.equalsIgnoreCase(name)) {
    			return this.territories.get(i);
    		}
    	}
		return null;
    }
    public Countrie getOwner(String name) {
    	for (int i = 0; i<TerritorieManager.get().territories.size(); i++) {
    		String territorio = TerritorieManager.get().territories.get(i).getName();
    		if (territorio.equalsIgnoreCase(name)) {
    			return getTerritorie(name).getOwner();
    		}
    	}
		return null;
    }
    
    public int getPopulation(String name) {
    	for (int i = 0; i<TerritorieManager.get().territories.size(); i++) {
    		String territorio = TerritorieManager.get().territories.get(i).getName();
    		if (territorio.equalsIgnoreCase(name)) {
    			return getTerritorie(name).getPopulation();
    		}
    	}
		return 0;
    }
    
    public void setPopulation(String name, int population) {
    	for (Territorie c : this.territories) {
    		if (c.getName() == name) {
    			c.setPopulation(population);
    		}
    	}
    }
    
    public void loadTerritories() {
    	for (String key : Gamedata.get().getConfigurationSection("Territories").getKeys(true)) {
    		if (!key.contains(".")) {
    			this.territories.add(new Territorie(key, CountrieManager.get().getCountrie(Gamedata.get().getString("Territories."+key+".Owner")), Gamedata.get().getInt("Territories."+key+".Population")));
    		}
    	}
    }
    
    public void saveTerritories() {
    	for (String key : Gamedata.get().getConfigurationSection("Territories").getKeys(true)) {
    		if (!key.contains(".")) {
    			Bukkit.broadcastMessage(key+": "+ getPopulation(key));
    			Gamedata.get().set("Territories."+key+".Owner", getOwner(key).getName()); Gamedata.get().set("Territories."+key+".Population", getTerritorie(key).getPopulation());
    			Gamedata.save();
    		}
    	}
    }

}
