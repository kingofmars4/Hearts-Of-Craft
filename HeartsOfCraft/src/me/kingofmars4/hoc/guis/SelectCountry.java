package me.kingofmars4.hoc.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import me.kingofmars4.hoc.handlers.Lobby;
import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.utils.GUIs;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class SelectCountry implements Listener {

	public static Inventory gui = Bukkit.createInventory(null, 27, U.color("&0Select Your Nation!"));
	
	public static void updateGUI(Player p) {
		Lobby l = LobbyManager.get().getPlayerLobby(p);
		if (LobbyManager.get().getCountrie(l, "USA").getPlayer().isEmpty()) { GUIs.createSkull("02v", SelectCountry.gui, 0, U.color("&9[USA] &a- OPEN"), "");
		} else { GUIs.createSkull("YohanTM", SelectCountry.gui, 0, U.color("&9[USA] &c- TAKEN"), ""); }
		
		if (LobbyManager.get().getCountrie(l, "Germany").getPlayer().isEmpty()) { GUIs.createSkull("02v", SelectCountry.gui, 2, U.color("&4[Germany] &a- OPEN"), "");
		} else { GUIs.createSkull("YohanTM", SelectCountry.gui, 2, U.color("&4[Germany] &c- TAKEN"), ""); }
		
		GUIs.closeMenu(gui, 26);
		GUIs.createDisplay(new ItemStack(Material.EMERALD_BLOCK), gui, 18, U.color("&aVote to start"), "");
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem(); 
		Inventory inventory = e.getInventory(); 
		
		if (inventory.getName().equals(gui.getName())) {
			if(clicked != null && clicked.getType() != Material.AIR) {
				e.setCancelled(true); 
				
				if (clicked.getType() == Material.REDSTONE_BLOCK) { p.closeInventory();
				} else if (clicked.getItemMeta().getDisplayName().equals(U.color("&9[USA] &a- OPEN"))) { countrySelect(p, "USA", U.color("&9[USA]"));
				} else if (clicked.getItemMeta().getDisplayName().equals(U.color("&9[USA] &c- TAKEN"))) { countryUnselect(p, "USA", U.color("&9[USA]"));
				
				} else if (clicked.getItemMeta().getDisplayName().equals(U.color("&4[Germany] &a- OPEN"))) { countrySelect(p, "Germany", U.color("&4[Germany]"));
				} else if (clicked.getItemMeta().getDisplayName().equals(U.color("&4[Germany] &c- TAKEN"))) {countryUnselect(p, "Germany", U.color("&4[Germany]"));
				}
			}
		} else { return;}
	}
	
	public void countrySelect(Player p, String c, String prefix) {
		Lobby l = LobbyManager.get().getPlayerLobby(p);
		if (LobbyManager.get().hasCountrie(l, p)) { LobbyManager.get().getPlayerCountrie(p, l).getPlayer().clear(); }
		if (!LobbyManager.get().getCountrie(l, c).getPlayer().isEmpty()) { p.sendMessage(Messages.pluginPrefix+U.color("&e%c &chas alredy been selected!".replaceAll("%c", prefix))); ; return; }
		
		LobbyManager.get().getCountrie(l, c).getPlayer().add(p.getUniqueId());
		p.sendMessage(Messages.pluginPrefix + U.color("&aYou have selected &e%c".replaceAll("%c", prefix)));
		updateGUI(p);
	}
	
	public void countryUnselect(Player p, String c, String prefix) {
		Lobby l = LobbyManager.get().getPlayerLobby(p);
		if (LobbyManager.get().getCountrie(l, c).getPlayer().contains(p.getUniqueId())) {
			LobbyManager.get().getCountrie(l, c).getPlayer().clear();
			p.sendMessage(Messages.pluginPrefix + U.color("&cYou have unselected &e%c".replaceAll("%c", prefix)));
			updateGUI(p);
		} else { p.sendMessage(Messages.pluginPrefix+U.color("&e%c &chas alredy been selected!".replaceAll("%c", prefix))); }
	}
}
