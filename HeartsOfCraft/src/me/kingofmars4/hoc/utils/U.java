package me.kingofmars4.hoc.utils;

import me.kingofmars4.hoc.handlers.Players;
import me.kingofmars4.hoc.handlers.Population;
import me.kingofmars4.hoc.handlers.Territories;

public class U {
	public static String color(String s) {
		
		return s.replaceAll("&", "§");
	}
	
	public static void loadFirstTimeGamedata() {
		Players.loadFirstTimePlayers();
		Territories.loadFirstTimeTerritories();
		Population.loadFirstTimePopulation();
	}
	
	public static void loadCache() {
		Players.loadPlayers();
		Population.loadPopulation();
		Territories.loadTerritories();
	}
}
