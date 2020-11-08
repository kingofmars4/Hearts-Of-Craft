package me.kingofmars4.hoc.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

public class Lobby {
	
	private final int id;
	private final Location spawn;
	private final List<UUID> players = new ArrayList<UUID>();
	private final List<Countrie> countries = new ArrayList<Countrie>();
	private final List<Territorie> territories = new ArrayList<Territorie>();
	
	public Lobby(Location spawn, int id) {
		this.spawn = spawn;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<UUID> getPlayers() {
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

}
