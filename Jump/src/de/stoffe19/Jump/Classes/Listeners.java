package de.stoffe19.Jump.Classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Listeners implements Listener {

	private MainClass plugin;

	public Listeners(MainClass mainClass) {
		
		this.plugin = mainClass;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onFeed(FoodLevelChangeEvent f) {
		if(f.getEntity() instanceof Player) {
			Player p = (Player) f.getEntity();
			if(plugin.inJump.contains(p.getName())) {
				f.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent d) {
		
		if(plugin.inJump.contains(d.getPlayer())) {
			d.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent p) {
		
		if(plugin.inJump.contains(p.getPlayer())) {
			p.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onCommandsDeny(PlayerCommandPreprocessEvent pe) {
		if(plugin.inJump.contains(pe.getPlayer().getName())) {
			if(!pe.getMessage().contains("/jumper")) {
				pe.setCancelled(true);
				pe.getPlayer().sendMessage(plugin.prefix + "§8That command is not allowed in the Jump-Arena! &c[" + pe.getMessage() + "]c");
				}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent de) {
		if(de.getEntity() instanceof Player) {
			Player p = (Player) de.getEntity();
			if(plugin.inJump.contains(p.getName())) {
				de.setCancelled(true);
			}
		}
	}
	
}
