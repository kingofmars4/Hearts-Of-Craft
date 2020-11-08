package me.kingofmars4.hoc.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.kingofmars4.hoc.utils.registers.territories.NA_Territories;

public class U {
	public static String color(String s) {
		
		return s.replaceAll("&", "§");
	}
	
	public static void loadDefaults() {
		NA_Territories.loadDefaults();
	}
	
	public static boolean isInt(String s) {
	    try {
	        Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String getLastLetter (String s) {
		return s.substring(s.length() - 1);
	}
	
	public static ItemStack createItemStack(Material m, String nome) {
		ItemStack i = new ItemStack(m);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(color(nome));
		i.setItemMeta(im);
		return i;
	}
}
