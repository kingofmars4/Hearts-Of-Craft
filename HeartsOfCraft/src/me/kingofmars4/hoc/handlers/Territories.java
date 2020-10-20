package me.kingofmars4.hoc.handlers;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;

public class Territories {
	public static void transferTerritory(String territory, String nation, String oldNation) {
		
	}
	
	public static void getOwner(String territory) {
		
	}
	
	public static void loadFirstTimeTerritories() {
		America.loadFirstTimeTerritories();
		Germany.loadFirstTimeTerritories();
	}
	
	public static void loadTerritories() {
		America.territories = Main.gamedata.getStringList("Countries.USA.Territories");
		Germany.territories = Main.gamedata.getStringList("Countries.GERMANY.Territories");
	}
}
