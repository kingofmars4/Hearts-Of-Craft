package me.kingofmars4.hoc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.Time;
import me.kingofmars4.hoc.utils.U;

public class Turn implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("hoc.player") ) {
				Time.passTurn();
				
				Bukkit.broadcastMessage("diminiu");
				Bukkit.broadcastMessage("%d-%m-%a".replaceAll("%d", String.valueOf(Time.day)).replaceAll("%m", Time.month).replaceAll("%a", String.valueOf(Time.year)));
				
				return true;
			} else { p.sendMessage(Messages.noPerm); }
			
		} else { sender.sendMessage(Messages.pluginPrefix+U.color("&9You must be a player in order to use this command.")); return true;}
		
		return true;
	}

}