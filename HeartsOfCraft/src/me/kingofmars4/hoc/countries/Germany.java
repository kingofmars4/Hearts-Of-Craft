package me.kingofmars4.hoc.countries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import me.kingofmars4.hoc.Main;

public class Germany {
	public static List<String> territories = new ArrayList<String>();
	public static ArrayList<Player> player = new ArrayList<Player>();
	
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
		Main.addGameDataDefault("Territories.Baden.Territories", 11100394);
    	Main.addGameDataDefault("Territories.Bavaria.Territories", 13124737);
    	Main.addGameDataDefault("Territories.Berlin.Territories", 3669491);
    	Main.addGameDataDefault("Territories.Brandenburg.Territories", 2521893);
    	Main.addGameDataDefault("Territories.Bremen.Territories", 681202);
    	Main.addGameDataDefault("Territories.Hamburg.Territories", 1847253);
    	Main.addGameDataDefault("Territories.Hesse.Territories", 6288080);
    	Main.addGameDataDefault("Territories.Holstein.Territories", 2896712);
    	Main.addGameDataDefault("Territories.Mecklenburg.Territories", 1609675);
    	Main.addGameDataDefault("Territories.Rhineland.Territories", 4084844);
    	Main.addGameDataDefault("Territories.Saarland.Territories", 990509);
    	Main.addGameDataDefault("Territories.Saxony.Territories", 14279706);
    	Main.addGameDataDefault("Territories.Thuringia.Territories", 2143145);
    	Main.addGameDataDefault("Territories.Westphalia.Territories", 17932651);
	}
}
