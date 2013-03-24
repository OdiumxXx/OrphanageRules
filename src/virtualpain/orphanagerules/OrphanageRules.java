package virtualpain.orphanagerules;

import org.bukkit.plugin.java.JavaPlugin;

public class OrphanageRules extends JavaPlugin {
	public void onEnable() {
		saveDefaultConfig();
		new OrphanageRulesListener(this);
		this.getCommand("rules").setExecutor(new OrphanageRulesExecutor(this));
	}
}
