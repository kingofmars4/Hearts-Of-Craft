package me.kingofmars4.hoc.handlers;

public class Territorie {
	
	private final String name;
	private final Countrie owner;
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
	
	public void setPopulation(int population) {
		this.population = population;
	}
}
