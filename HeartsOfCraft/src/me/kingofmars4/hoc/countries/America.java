package me.kingofmars4.hoc.countries;

import java.util.ArrayList;
import java.util.List;
import me.kingofmars4.hoc.Main;

public class America {
	public static List<String> territories = new ArrayList<String>();
	public static String player;
	
	public static void loadFirstTimeTerritories() {
		territories.add("Alaska");
		territories.add("Arizona");
		territories.add("California");
		territories.add("Carolina");
		territories.add("Colorado");
		territories.add("Dakota");
		territories.add("Florida");
		territories.add("Illinois");
		territories.add("Indiana");
		territories.add("Louisiana");
		territories.add("Michigan");
		territories.add("Montana");
		territories.add("NewYork");
		territories.add("PacificIslands");
		territories.add("Pennsylvania");
		territories.add("Texas");
		territories.add("Virginia");
	}
	
	public static void loadFirstTimePopulation() {
		Main.addGameDataDefault("Territories.Alaska.Population", 731545);
    	Main.addGameDataDefault("Territories.Arizona.Population", 13564831);
    	Main.addGameDataDefault("Territories.California.Population", 51344853);
    	Main.addGameDataDefault("Territories.Carolina.Population", 15636798);
    	Main.addGameDataDefault("Territories.Colorado.Population", 13451880);
    	Main.addGameDataDefault("Territories.Dakota.Population", 1646721);
    	Main.addGameDataDefault("Territories.Florida.Population", 36998345);
    	Main.addGameDataDefault("Territories.Illinois.Population", 21964319);
    	Main.addGameDataDefault("Territories.Indiana.Population", 29718166);
    	Main.addGameDataDefault("Territories.Louisiana.Population", 10642747);
    	Main.addGameDataDefault("Territories.Michigan.Population", 21448923);
    	Main.addGameDataDefault("Territories.Montana.Population", 3434602);
    	Main.addGameDataDefault("Territories.NewYork.Population", 34298615);
    	Main.addGameDataDefault("Territories.PacificIslands.Population", 1870563);
    	Main.addGameDataDefault("Territories.Pennsylvania.Population", 28703623);
    	Main.addGameDataDefault("Territories.Texas.Population", 35049681);
    	Main.addGameDataDefault("Territories.Virginia.Population", 10327666);
	}
	
	public static void loadFirstTimePlayers() {
		Main.addGameDataDefault("Countries.USA.Player", "EMPTY");
	}
}
