package me.kingofmars4.hoc.countries;

import java.util.ArrayList;
import java.util.List;
import me.kingofmars4.hoc.Main;

public class America {
	public static List<String> territories = new ArrayList<String>();
	public static List<String> player = new ArrayList<String>();
	
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
		Main.addGameDataDefault("Territories.Alaska.Territories", 731545);
    	Main.addGameDataDefault("Territories.Arizona.Territories", 13564831);
    	Main.addGameDataDefault("Territories.California.Territories", 51344853);
    	Main.addGameDataDefault("Territories.Carolina.Territories", 15636798);
    	Main.addGameDataDefault("Territories.Colorado.Territories", 13451880);
    	Main.addGameDataDefault("Territories.Dakota.Territories", 1646721);
    	Main.addGameDataDefault("Territories.Florida.Territories", 36998345);
    	Main.addGameDataDefault("Territories.Illinois.Territories", 21964319);
    	Main.addGameDataDefault("Territories.Indiana.Territories", 29718166);
    	Main.addGameDataDefault("Territories.Louisiana.Territories", 10642747);
    	Main.addGameDataDefault("Territories.Michigan.Territories", 21448923);
    	Main.addGameDataDefault("Territories.Montana.Territories", 3434602);
    	Main.addGameDataDefault("Territories.NewYork.Territories", 34298615);
    	Main.addGameDataDefault("Territories.PacificIslands.Territories", 1870563);
    	Main.addGameDataDefault("Territories.Pennsylvania.Territories", 28703623);
    	Main.addGameDataDefault("Territories.Texas.Territories", 35049681);
    	Main.addGameDataDefault("Territories.Virginia.Territories", 10327666);
	}
	
	public static void getPlayer() {
		
	}
	
	public static void setPlayer() {
		
	}
}
