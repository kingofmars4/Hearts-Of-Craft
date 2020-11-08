package me.kingofmars4.hoc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class CreateSign implements Listener {

	@EventHandler
	public void writeSign(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("hoc")) {
			Player p = e.getPlayer();
			if (e.getLine(1).equalsIgnoreCase("create")) {
				if (p.hasPermission("hoc.createsign") || p.hasPermission("hoc.staff")) {
					if (U.isInt(e.getLine(2))) {
						int lobby = Integer.parseInt(e.getLine(2));
						if (LobbyManager.get().isLobby(lobby)) {
							
							p.sendMessage(Messages.pluginPrefix + U.color("&aJoin sign succesefully created for &eLobby Nº%n&a!".replaceAll("%n", lobby+"")));
							e.setLine(0, U.color("&2[Hearts Of Craft]")); 
							e.setLine(1, U.color("&a&lOPEN"));
							e.setLine(2, "Lobby"+lobby);
							e.setLine(3, U.color("&1Right click to join"));
							
						} else { p.sendMessage(Messages.pluginPrefix + U.color("&e'%n' &cis not a valid lobby id!".replaceAll("%n", e.getLine(2)))); e.getBlock().breakNaturally();}
					} 
				}
			}
		}
	}
}
