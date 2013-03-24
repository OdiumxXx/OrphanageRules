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
		event.getPlayer().sendMessage(virtualpain.orphanagerules.Color.replaceString(String.format(this.plugin.getConfig().getString("motd.joinmessage"), event.getPlayer().getName())));
	}
	
	@EventHandler
	public void onPingEvent(ServerListPingEvent event)
	{
		event.setMotd(virtualpain.orphanagerules.Color.replaceString(this.plugin.getConfig().getString("motd.pingmessage")));
	}
}
