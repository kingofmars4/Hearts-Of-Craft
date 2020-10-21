package me.kingofmars4.hoc.handlers;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;

public class Territories {
	
	public static void transferTerritory(String territory, String nation, String oldNation) {
		
	}
	
	public static void getOwner(String territory) {
		
	}
	
	public static void loadTerritories() {
		America.territories = Main.gamedata.getStringList("Countries.USA.Territories");
		Germany.territories = Main.gamedata.getStringList("Countries.Germany.Territories");
	}
	
	public static void saveTerritories() {
		Main.gamedata.set("Countries.USA.Territories", America.territories);
		Main.gamedata.set("Countries.Germany.Territories", Germany.territories);
	}
	
	public static void loadFirstTimeTerritories() {
		America.loadFirstTimeTerritories();
		Main.addGameDataDefault("Countries.USA.Territories", America.territories);
		
		Germany.loadFirstTimeTerritories();
		Main.addGameDataDefault("Countries.Germany.Territories",Germany.territories);
	}
}
