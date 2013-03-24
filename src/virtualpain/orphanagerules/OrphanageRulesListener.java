package virtualpain.orphanagerules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class OrphanageRulesListener implements Listener{
	private final OrphanageRules plugin;
	
	public OrphanageRulesListener(OrphanageRules plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event) 
	{
		event.getPlayer().sendMessage(this.plugin.getConfig().getString("motd.joinmessage"));
	}
	
	@EventHandler
	public void onPingEvent(ServerListPingEvent event)
	{
		event.setMotd(this.plugin.getConfig().getString("motd.pingmessage"));
	}
}
