package me.kingofmars4.hoc.utils;

import me.kingofmars4.hoc.utils.registers.territories.NA_Territories;

public class U {
	public static String color(String s) {
		
		return s.replaceAll("&", "§");
	}
	
	public static void loadDefaults() {
		NA_Territories.loadDefaults();
	}
}
