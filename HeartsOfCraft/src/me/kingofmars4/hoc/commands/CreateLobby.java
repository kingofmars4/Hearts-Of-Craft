package me.kingofmars4.hoc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kingofmars4.hoc.files.FileLobbys;
import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class CreateLobby implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("hoc.staff") || p.hasPermission("hoc.createlobby")) {
				 
				LobbyManager.LobbySize++;
				LobbyManager.get().createLobby(p.getLocation(), LobbyManager.LobbySize);
				FileLobbys.get().set("Lobbys."+LobbyManager.LobbySize, LobbyManager.get().serializeLoc(p.getLocation()));
				FileLobbys.save();
				p.sendMessage(Messages.pluginPrefix+U.color("&aYour current position has been set as &eLobby Nº%n&a!".replaceAll("%n", ""+LobbyManager.LobbySize)));
				p.sendMessage(U.color("&4WARNING: &cYou must reload the plugin in order to the new lobby load!"));
			
				return true;
			} else { p.sendMessage(Messages.noPerm); }
			
		} else { sender.sendMessage(Messages.pluginPrefix+U.color("&9You must be a player in order to use this command.")); return true;}
		
		return false;
	}

}