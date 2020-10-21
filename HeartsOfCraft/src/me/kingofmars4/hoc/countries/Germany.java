package me.kingofmars4.hoc.countries;

import java.util.ArrayList;
import java.util.List;
import me.kingofmars4.hoc.Main;

public class Germany {
	public static List<String> territories = new ArrayList<String>();
	public static String player;
	
	public static void loadFirstTimeTerritories() {
		territories.add("Baden");
		territories.add("Bavaria");
		territories.add("Berlin");
		territories.add("Brandenburg");
		territories.add("Bremen");
		territories.add("Hamburg");
		territories.add("Hesse");
		territories.add("Holstein");
		territories.add("Mecklenburg");
		territories.add("Rhineland");
		territories.add("Saarland");
		territories.add("Saxony");
		territories.add("Thuringia");
		territories.add("Westphalia");
	}
	
	public static void loadFirstTimePopulation() {
		Main.addGameDataDefault("Territories.Baden.Population", 11100394);
    	Main.addGameDataDefault("Territories.Bavaria.Population", 13124737);
    	Main.addGameDataDefault("Territories.Berlin.Population", 3669491);
    	Main.addGameDataDefault("Territories.Brandenburg.Population", 2521893);
    	Main.addGameDataDefault("Territories.Bremen.Population", 681202);
    	Main.addGameDataDefault("Territories.Hamburg.Population", 1847253);
    	Main.addGameDataDefault("Territories.Hesse.Population", 6288080);
    	Main.addGameDataDefault("Territories.Holstein.Population", 2896712);
    	Main.addGameDataDefault("Territories.Mecklenburg.Population", 1609675);
    	Main.addGameDataDefault("Territories.Rhineland.Population", 4084844);
    	Main.addGameDataDefault("Territories.Saarland.Population", 990509);
    	Main.addGameDataDefault("Territories.Saxony.Population", 14279706);
    	Main.addGameDataDefault("Territories.Thuringia.Population", 2143145);
    	Main.addGameDataDefault("Territories.Westphalia.Population", 17932651);
	}
	
	public static void loadFirstTimePlayers() {
		Main.addGameDataDefault("Countries.Germany.Player", "EMPTY");
	}
}
