package me.kingofmars4.hoc.utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class GUIs {
	
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
		createDisplay(new ItemStack(Material.ARROW), inv, slot, U.color("&cClose Menu"), "");
	}
}