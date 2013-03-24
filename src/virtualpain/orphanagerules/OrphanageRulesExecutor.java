package virtualpain.orphanagerules;


import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OrphanageRulesExecutor implements CommandExecutor {
	private final OrphanageRules plugin;
	
	public OrphanageRulesExecutor(OrphanageRules plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String currentWorld = player.getWorld().getName();
			List<String> rulesThisWorld = plugin.getConfig().getStringList("rules."+currentWorld);
			if (rulesThisWorld.isEmpty()) {
				player.sendMessage(this.plugin.getConfig().getString("messages.norules"));
			}
			else {
				int number = 1;
				player.sendMessage(virtualpain.orphanagerules.Color.replaceString(String.format(this.plugin.getConfig().getString("messages.rulestitle"),currentWorld)));
				for (String rule : rulesThisWorld) {
					player.sendMessage(String.format("%d. %s", number, rule));
					number++;
				}
			}
			return true;
		}
		else {
			// display rules to player
			sender.sendMessage("Only player can do this!");
		}
		return false;
	}
}
