package me.kingofmars4.hoc.handlers.territories;

import me.kingofmars4.hoc.handlers.countries.Countrie;

public class Territorie {
	
	private final String name;
	private Countrie owner;
	private int population;
	
	public Territorie (String name, Countrie owner, int population) {
		this.name = name;
		this.owner = owner;
		this.population = population;
	}
	
	// GETTERS
	public Countrie getOwner() {
		return this.owner;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPopulation() {
		return this.population;
	}
}
