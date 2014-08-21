package de.stoffe19.DroppingItems.Events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import de.stoffe19.DroppingItems.Main.MainClass;

public class DispenserRandom implements Listener{
	
	@SuppressWarnings("unused")
	private MainClass plugin;




	public DispenserRandom(MainClass mainclass) {
		this.plugin = mainclass;
	}
	
	
	

	@EventHandler
	 public void BlockDispenseEvent (org.bukkit.event.block.BlockDispenseEvent b) {
	
	if(b.getBlock().getType() == Material.DISPENSER); {
		if(b.getBlock().getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.DRAGON_EGG);
		ItemStack random = null;
		
		Random r = new Random();
		int zufall = r.nextInt(24);
		switch(zufall) {
		
		case 0:
			random = new ItemStack(Material.DIAMOND);
			break;
			
		case 1:
			random = new ItemStack(Material.GOLD_INGOT);
			break;
			
		case 2:
			random = new ItemStack(Material.IRON_INGOT);
			break;
			
		case 3:
			random = new ItemStack(Material.COAL);
			break;
		}
		
		b.setItem(random);
	}
	
	
}
}
