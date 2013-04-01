package virtualpain.orphanagerules;



import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OrphanageRulesListener implements Listener{
	private final OrphanageRules plugin;
	
	public OrphanageRulesListener(OrphanageRules plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
		
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event)	{
		Player player = event.getPlayer();
		String player_name = player.getName();		 
		List<String> motd = plugin.getConfig().getStringList("motd");
		
		for (String motd_line : motd) {
		  player.sendMessage(plugin.replaceColorMacros(motd_line).replace("%player", player_name));  
		}	
	
	}
	
	
// This event doesn't do what you think it does.
// this occurs when a player pings the server when viewing the server list to see if it is online (before even logging on)
// to create a ping command, one simply wants to respond to a command (/ping) with a message.
	
//	@EventHandler
//	public void onPingEvent(ServerListPingEvent event)
//	{
//		event.setMotd(virtualpain.orphanagerules.Color.replaceString(this.plugin.getConfig().getString("motd.pingmessage")));
//	}
}
