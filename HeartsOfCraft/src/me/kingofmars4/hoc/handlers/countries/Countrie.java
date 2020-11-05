package me.kingofmars4.hoc.handlers.countries;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Countrie {
	
	private final String name;
	private final List<UUID> player = new ArrayList<UUID>();
	
	public Countrie (String name, UUID player) {
		this.name = name;
	}
	
	// GETTERS
	public List<UUID> getPlayer() {
		return this.player;
	}
	
	public String getName() {
		return this.name;
	}

}
