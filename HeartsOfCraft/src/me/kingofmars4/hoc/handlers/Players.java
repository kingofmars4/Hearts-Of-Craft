package me.kingofmars4.hoc.handlers;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;

public class Players {
	
	public static void savePlayers() {
		Main.gamedata.set("Countries.USA.Player", America.player);
	}
	
	public static void loadPlayers() {
		America.player = Main.gamedata.getString("Countries.USA.Player");
		Germany.player = Main.gamedata.getString("Countries.Germany.Player");
	}
	
	public static void loadFirstTimePlayers() {
		America.loadFirstTimePlayers();
		Germany.loadFirstTimePlayers();
	}
}
