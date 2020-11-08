package me.kingofmars4.hoc.listeners;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.kingofmars4.hoc.guis.SelectCountry;
import me.kingofmars4.hoc.handlers.Lobby;
import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class JoinGame implements Listener {
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				Player p = e.getPlayer();
				if (sign.getLine(0).equalsIgnoreCase(U.color("&2[Hearts Of Craft]")) && sign.getLine(1).equalsIgnoreCase(U.color("&a&lOPEN")) && U.isInt(U.getLastLetter(sign.getLine(2)))) {
					int id = Integer.parseInt(U.getLastLetter(sign.getLine(2)));
					if (p.hasPermission("hoc.player") || p.hasPermission("hoc.usesigns")) {
						if (LobbyManager.get().isInLobby(p)) { p.sendMessage(Messages.pluginPrefix+U.color("&cYou can not join more than 1 game at once!")); return;}
						
						LobbyManager.get().addPlayer(p, id);
						Lobby l = LobbyManager.get().getLobby(id);
						p.sendMessage(Messages.pluginPrefix+U.color("&aYou have succefully joined &eLobby n%n&a!".replaceAll("%n", id+"")));
						if (l.getPlayers().size()==2) {
							SelectCountry.startCounting(l);
						}
					} else { p.sendMessage(Messages.noPerm); }
				}
			}
		}
	}
}
