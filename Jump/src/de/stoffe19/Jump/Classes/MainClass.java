package de.stoffe19.Jump.Classes;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	public ArrayList<String> inJump = new ArrayList<>();
	public HashMap<String, Location> oldLoc = new HashMap<>();
	public HashMap<String, ItemStack[]> oldItems = new HashMap<>();
	public String prefix = "§7[§bJump§7] ";
	public String noperm = "§7[§bJump§7] §4You don´t have enough permissions to do that!";
	public String help = "§7[§bJump§7] §8help: /jumper help";
	
	
	@Override
	public void onEnable() {
		
		System.out.println("[Jump] Plugin version + this.getDescription().getVersion() + was enabled");
		
		new Listeners(this);
		getCommand ("jumper").setExecutor(new Commands(this));
	}
	
	@Override
	public void onDisable() {
		
		System.out.println("[Jump] Plugin version + this.getDescription().getVersion() + was disabled");
		
	}
	
	
	
	
}
