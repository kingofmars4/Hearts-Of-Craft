package me.kingofmars4.hoc.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.kingofmars4.hoc.handlers.countries.CountrieManager;
import me.kingofmars4.hoc.utils.GUIs;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class SelectCountry implements Listener {

	public static Inventory gui = Bukkit.createInventory(null, 27, U.color("&0Select Your Nation!"));
	
	public static void updateGUI() {
		if (CountrieManager.get().getCountrie("America").getPlayer().isEmpty()) {
			GUIs.createSkull("02v", SelectCountry.gui, 0, U.color("&9USA &a- OPEN"), "");
		} else {
			GUIs.createSkull("YohanTM", SelectCountry.gui, 0, U.color("&9USA &c- TAKEN"), "");
		}
		
		GUIs.closeMenu(gui, 26);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem(); 
		Inventory inventory = event.getInventory(); 
		
		
		if (inventory.getName().equals(gui.getName())) {
			if (clicked.getType() == Material.REDSTONE_BLOCK) {
				event.setCancelled(true); 
				p.closeInventory();
			}
			
			if (clicked.getItemMeta().getDisplayName().equals(U.color("&9USA &a- OPEN"))) {
				event.setCancelled(true); 
				p.closeInventory();
				p.sendMessage(Messages.pluginPrefix + U.color("&aYou have selected &9[United States Of America]"));
				CountrieManager.get().addPlayer(p, "America");
				updateGUI();
			}
			
			if (clicked.getItemMeta().getDisplayName().equals(U.color("&9USA &c- TAKEN"))) {
				event.setCancelled(true); 
				if (CountrieManager.get().getCountrie("America").getPlayer().contains(p.getUniqueId())) {
					CountrieManager.get().getCountrie("America").getPlayer().clear();
					p.closeInventory();
					p.sendMessage(Messages.pluginPrefix + U.color("&cYou have unselected &9[United States Of America]"));
					updateGUI();
				}
			}
		}
	}
}
