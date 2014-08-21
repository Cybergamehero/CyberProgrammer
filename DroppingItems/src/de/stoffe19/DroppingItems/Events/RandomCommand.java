package de.stoffe19.DroppingItems.Events;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.stoffe19.DroppingItems.Main.MainClass;

public class RandomCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MainClass plugin;
	
	public RandomCommand(MainClass mainclass) {
		this.plugin = mainclass;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length == 0){
			p.sendMessage("Richtige Verwendung: §c/random");
		}
		if(p.hasPermission("droppingitems.randomcmd")){
			
			ItemStack random = null;
			
			Random r = new Random();
			int zufall = r.nextInt(3);
			switch(zufall) {
			
			case 0:
				random = new ItemStack(Material.BOW);
				break;
				
			case 1:
				random = new ItemStack(Material.STONE_SWORD);
				break;
				
			case 2:
				random = new ItemStack(Material.DIAMOND_AXE);
				break;
				
			case 3:
				random = new ItemStack(Material.GOLD_BLOCK);
				break;
			}
			
			p.getInventory().addItem(random);
			
			
		} else {
			p.sendMessage(ChatColor.RED + "Du hast keine Rechte für den Befehl");
		}
		
		
		
		return true;
	}

}
