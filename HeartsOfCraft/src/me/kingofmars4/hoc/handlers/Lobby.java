package me.kingofmars4.hoc.handlers;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Lobby {
	
	private final int id;
	private final Location spawn;
	private final List<Player> players = new ArrayList<Player>();
	private final List<Countrie> countries = new ArrayList<Countrie>();
	private final List<Territorie> territories = new ArrayList<Territorie>();
	private int selectedCountries = 0;
	
	public Lobby(Location spawn, int id) {
		this.spawn = spawn;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}

	public Location getSpawn() {
		return this.spawn;
	}
	
	public List<Countrie> getCountries() {
		return this.countries;
	}
	
	public List<Territorie> getTerritories() {
		return this.territories;
	}
	
	public int getSelectedCountries() {
		return this.selectedCountries;
	}
	
	public void setSelectedCountries(int i) {
		this.selectedCountries = i;
	}


}
