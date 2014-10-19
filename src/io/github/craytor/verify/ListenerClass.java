package io.github.craytor.verify;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerClass implements Listener {
	public ListenerClass(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		String player = e.getPlayer().getName();
		String uuid = e.getPlayer().getUniqueId().toString();

		e.setJoinMessage(ChatColor.AQUA + "Welcome, " + player + "! Your UUID is: " + uuid);
		
	}
}
