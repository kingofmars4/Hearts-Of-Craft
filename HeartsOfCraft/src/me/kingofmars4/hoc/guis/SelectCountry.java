package me.kingofmars4.hoc.guis;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.utils.GUIs;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class SelectCountry implements Listener {
		
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem(); 
		Inventory inventory = event.getInventory(); 
		
		
		if (inventory.getName().equals(GUIs.selectCountry.getName())) {
			if (clicked.getType() == Material.REDSTONE_BLOCK) {
				event.setCancelled(true); 
				p.closeInventory();
			}
			
			if (clicked.getItemMeta().getDisplayName().equals(U.color("&9USA &a- OPEN"))) {
				event.setCancelled(true); 
				p.closeInventory();
				p.sendMessage(Messages.pluginPrefix + U.color("&aYou have selected &9[United States Of America]"));
				America.player = p.getName();
				Main.loadGamedata();
			}
			
			if (clicked.getItemMeta().getDisplayName().equals(U.color("&9USA &c- TAKEN"))) {
				event.setCancelled(true); 
				if (America.player.equals(p.getName())) {
					America.player = "EMPTY";
					p.closeInventory();
					p.sendMessage(Messages.pluginPrefix + U.color("&cYou have unselected &9[United States Of America]"));
				}
				Main.loadGamedata();
			}
		}
	}
}
