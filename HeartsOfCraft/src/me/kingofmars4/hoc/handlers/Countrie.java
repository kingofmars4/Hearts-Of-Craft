package me.kingofmars4.hoc.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Countrie {
	
	private String name;
	private final List<UUID> player = new ArrayList<UUID>();
	private final int id;
	
	public Countrie (String name, UUID player,  int id) {
		this.name = name;
		this.id = id;
	}
	
	// GETTERS
	public List<UUID> getPlayer() {
		return this.player;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}
	
}
