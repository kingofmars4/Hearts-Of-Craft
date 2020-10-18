package me.kingofmars4.hoc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.kingofmars4.hoc.nations.America;
import me.kingofmars4.hoc.nations.Germany;
import me.kingofmars4.hoc.utils.Messages;
import me.kingofmars4.hoc.utils.U;

public class Population implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("hoc.player") ) {
				
				if (args.length==0) {
					
				} else if (args.length == 1) {
					
					if (args[0].equalsIgnoreCase("america")) { p.sendMessage("America's total population: " + String.format("%.2fM", America.population/ 1000000.0));} 
					else if (args[0].equalsIgnoreCase("germany")) {  p.sendMessage("Germany's total population: " + String.format("%.2fM", Germany.population/ 1000000.0)); }
					
					
					else { p.sendMessage(Messages.pluginPrefix + U.color("&cCountry not found!"));}
				} else { p.sendMessage(Messages.pluginPrefix + U.color("&cCorrect usage: &6/population (country)"));  }
				
				return true;
			} else { p.sendMessage(Messages.noPerm); }
		} else { sender.sendMessage(Messages.pluginPrefix+U.color("&9You must be a player in order to use this command.")); return true;}
		
		return false;
	}
}
