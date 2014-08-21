package de.stoffe19.DroppingItems.Main;

import org.bukkit.plugin.java.JavaPlugin;

import de.stoffe19.DroppingItems.Events.DispenserRandom;
import de.stoffe19.DroppingItems.Events.RandomCommand;

public class MainClass extends JavaPlugin {


	
@Override
 public void onEnable(){
	
	registerCommands();
	registerEvents();
	
	
	
	System.out.println("[DroppingItems] Plugin was activated!");
	
}

public void registerCommands() {
	getCommand("random").setExecutor(new RandomCommand(this));
}

public void registerEvents() {
	new DispenserRandom(this);
}

@Override
 public void onDisable(){
	System.out.println("[DroppingItems] Plugin was disabled!");
}
}
