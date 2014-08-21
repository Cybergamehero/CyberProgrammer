package de.stoffe19.Jump.Classes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor{

	private MainClass plugin;

	public Commands(MainClass mainClass) {
		this.plugin = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(sender instanceof Player) {
		
		Player p = (Player) sender;
		
		
	if(args.length != 1) {
		p.sendMessage(plugin.help);
		
	} else {
		if(args[0].equalsIgnoreCase("join")) {
		  joinArena(p);
		} else
		if(args[0].equalsIgnoreCase("leave")) {
		  leaveArena(p);
		} else
		if(args[0].equalsIgnoreCase("help")) {
           sendHelp(p);
		} else
		if(args[0].equalsIgnoreCase("setspawn")) {
		   setSpawn(p);
		} else {
			p.sendMessage(plugin.help);
		}
	}
	} else {
		
		sender.sendMessage("You must be a player!");
		
	}
		return true;
	}
	//METHODS
	
	public void sendHelp(Player p) {
		p.sendMessage("§8[]===============( §b§1Jumper Help)§8)==============[]");
		p.sendMessage("§1Version: §e" + plugin.getDescription().getVersion());
		p.sendMessage("§1Developer: §estoffe19 aka CyberProgrammer");
		p.sendMessage("§8<<==================================================>>");
		p.sendMessage("§1/jumper join - §eFor joining in the arena");
		p.sendMessage("§1/jumper leave - §eTo leave the joined arena");
		p.sendMessage("§1/jumper help - §eTo see this help");
		p.sendMessage("§1/jumper setspawn - §eTo set the Jump-Spawns");
		p.sendMessage("§8<<==================================================>>");
	}
	
	public void setSpawn(Player p) {
		if(p.hasPermission("Jumper.setspawn")) {
			String world = p.getWorld().getName();
			double x = p.getLocation().getX();
			double y = p.getLocation().getY();
			double z = p.getLocation().getZ();
			double Yaw = p.getLocation().getYaw();
			double Pitch = p.getLocation().getPitch();
			
			FileConfiguration cfg = plugin.getConfig();
			cfg.set("World", world);
			cfg.set("Pos.X", x);
			cfg.set("Pos.Y", y);
			cfg.set("Pos.Z", z);
			cfg.set("Pos.Yaw", Yaw);
			cfg.set("Pos.Pitch", Pitch);
			
			
			
			
			
			
			
			
		} else {
			p.sendMessage(plugin.noperm);
		}
	}
	@SuppressWarnings("deprecation")
	public void joinArena(Player p) {
		if(!plugin.inJump.contains(p.getName())) {
			
			plugin.inJump.add(p.getName());
			
			plugin.oldLoc.put(p.getName(), p.getLocation());
			plugin.oldItems.put(p.getName(), p.getInventory().getContents());
			p.getInventory().clear();
			p.updateInventory();
			
			FileConfiguration cfg = plugin.getConfig();
			
			String world = cfg.getString("World");
			double x = cfg.getDouble("Pos.X");
			double y = cfg.getDouble("Pos.Y");
			double z = cfg.getDouble("Pos.Z");
			double Yaw = cfg.getDouble("Pos.Yaw");
			double Pitch = cfg.getDouble("Pos.Pitch");
			
			Location loc = new Location(Bukkit.getWorld(world), x, y, z);
			loc.setPitch((float) Pitch);
			loc.setYaw((float) Yaw);
			
			p.teleport(loc);
			
			p.sendMessage(plugin.prefix + "§8You are now in the Jump-Arena! §aGood luck :)");
		} else {
			p.sendMessage(plugin.prefix + "§cYou are already in the Jump-Arena! '/jumper leave' - to leave the arena!");
		}
	}
	@SuppressWarnings("deprecation")
	public void leaveArena(Player p) {
		if(plugin.inJump.contains(p.getName())) {
			
			plugin.inJump.remove(p.getName());
			
			p.getInventory().clear();
			ItemStack[] old = plugin.oldItems.get(p.getName());
			p.getInventory().setContents(old);
			p.updateInventory();
			
			Location loc = plugin.oldLoc.get(p.getName());
			p.teleport(loc);
			
			p.sendMessage(plugin.prefix + "§8You left the arena! Thanks for playing c:");
			
			
		} else {
			p.sendMessage(plugin.prefix + "You are not in the Jump-Arena!");;
		}
	}
}

