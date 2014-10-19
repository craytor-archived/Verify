package io.github.craytor.verify;


import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	public MySQLManager mysql = new MySQLManager(this);

	public void onEnable() {
		try {
			this.mysql.setupDB();
		} catch (SQLException e) {
			getLogger().info("Error with DB connection");
		}
		getLogger().info("Plugin Enabled");
		new ListenerClass(this);
	}
	
	public void onDisable() {
		try {
			this.mysql.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getLogger().info("Plugin Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("hub")) {
				
				String hub = "spawn " + player.getName();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), hub);
				player.sendMessage(ChatColor.AQUA + "Returning to hub!");
				
			}
		}
		
		return false;
	}
}
