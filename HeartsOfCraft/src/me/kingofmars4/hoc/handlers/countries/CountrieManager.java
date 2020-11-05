package me.kingofmars4.hoc.handlers.countries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class CountrieManager {
	
	private static CountrieManager cm;
	public final List<Countrie> countries = new ArrayList<Countrie>();
    
    private CountrieManager() {}
    
    public static CountrieManager get() {
    	if (cm == null) {
    		cm = new CountrieManager();
    	}
    	return cm;
    }
	
    public Countrie getCountrie(String name) {
    	for (Countrie c : this.countries) {
    		if (c.getName() == name) {
    			return c;
    		}
    	}
    	return null;
    }
    
    public void addPlayer(Player p, String country) {
    	Countrie c = this.getCountrie(country);
    	
    	if (c == null) { p.sendMessage(Messages.pluginPrefix+U.color("&cInvalid countrie!")); return;}
    	if (this.hasCountrie(p)) { p.sendMessage(Messages.pluginPrefix+U.color("&cYou alredy control &e'%c'&c!".replaceAll("%c", c.getName()))); return;}
    	
    	if (!c.getPlayer().isEmpty()) { p.sendMessage(Messages.pluginPrefix+U.color("&e'%c'&cIs alredy being controlled!".replaceAll("%c", c.getName()))); return; } else {
    		c.getPlayer().add(p.getUniqueId());
    	}
    }

    public boolean hasCountrie(Player p) {
        for (Countrie c : this.countries) {
            if (c.getPlayer().contains(p.getUniqueId())) {
            	return true;
            }
        }
        return false;
    }
    
    public boolean hasPlayer(Countrie c) {
        if (c.getPlayer().isEmpty()) {
        	return true;
        }
        return false;
    }
    
    public Countrie createCountries(String name) {     
    	
        Countrie c = new Countrie(name, null);
        this.countries.add(c);

        return c;
    }
    
    public void loadCountries() {
    	this.countries.add(new Countrie("America", null));
    	this.countries.add(new Countrie("Germany", null));
    }
}
