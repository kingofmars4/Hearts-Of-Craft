package me.kingofmars4.hoc.handlers.territories;

import java.util.ArrayList;
import java.util.List;

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
    
    public Countrie getOwner(String name) {
    	for (Territorie c : this.territories) {
    		if (c.getName() == name) {
    			return c.getOwner();
    		}
    	}
    	return null;
    }
    
    public int getPopulation(String name) {
    	for (Territorie c : this.territories) {
    		if (c.getName() == name) {
    			return c.getPopulation();
    		}
    	}
    	return 0;
    }
    
    public void loadCountries() {
    	this.territories.add(new Territorie("Texas", CountrieManager.get().getCountrie("America"), 30000000));
    	this.territories.add(new Territorie("California", CountrieManager.get().getCountrie("America"), 93188731));
    }

}
