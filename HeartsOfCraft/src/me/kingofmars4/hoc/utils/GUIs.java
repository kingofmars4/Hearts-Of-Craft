package me.kingofmars4.hoc.utils;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import me.kingofmars4.hoc.countries.America;

public class GUIs {
	
	public static Inventory selectCountry = Bukkit.createInventory(null, 27, U.color("&0Select Your Nation!"));
	static {
		if (America.player.equals("EMPTY")) {
			GUIs.createSkull("02v", selectCountry, 0, U.color("&9USA &a- OPEN"), "");
		} else {
			GUIs.createSkull("0246", selectCountry, 0, U.color("&9USA &c- TAKEN"), "");
		}
		GUIs.closeMenu(selectCountry, 26);
	}
	// NAO ESTA A ATUAZLIAR, TENTAR METER NA PROPRIA CLASS "AMERICA"
	
	public static void createDisplay(ItemStack is, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = is;
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(lore);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		 
		inv.setItem(Slot, item); 
	}
	
	public static void createSkull(String owner, Inventory inv,  int slot, String name, String lore) {
		ItemStack ah = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta ahMeta = (SkullMeta) ah.getItemMeta();
        ahMeta.setOwner(owner);
        ah.setItemMeta(ahMeta);
        
        createDisplay(ah, inv, slot, name, lore);
	}
	
	public static void closeMenu(Inventory inv, int slot) {
		createDisplay(new ItemStack(Material.REDSTONE_BLOCK), inv, slot, U.color("&cClose Menu"), "");
	}
}
