package me.kingofmars4.hoc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.kingofmars4.hoc.files.FileLobbys;
import me.kingofmars4.hoc.handlers.LobbyManager;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class DeleteLobby implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("hoc.staff") || p.hasPermission("hoc.deletelobby")) {
				if (args.length == 1) {
					int arg = Integer.parseInt(args[0]);
					if (U.isInt(args[0]) && arg>0 && arg<=LobbyManager.LobbySize) {
						p.sendMessage(Messages.pluginPrefix+U.color("&aLobby number &e'%n' &ahas been succefully deleted!".replaceAll("%n", arg+"")));
						FileLobbys.get().set("Lobbys."+arg, null);
						FileLobbys.save();
						LobbyManager.LobbySize -= 1;
					} else { p.sendMessage(Messages.pluginPrefix + U.color("&cNumber must be a valid lobby id!")); }
				} else { p.sendMessage(Messages.pluginPrefix + U.color("&cCorrect usage: &e/deletelobby (number)")); }
				return true;
			} else { p.sendMessage(Messages.noPerm); }
			
		} else { sender.sendMessage(Messages.pluginPrefix+U.color("&9You must be a player in order to use this command.")); return true;}
		
		return false;
	}

}