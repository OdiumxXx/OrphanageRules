package virtualpain.orphanagerules.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import virtualpain.orphanagerules.OrphanageRules;

public class rules implements CommandExecutor {

  public OrphanageRules plugin;
  public rules(OrphanageRules plugin)  {
    this.plugin = plugin;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {    
    Player player = null;
    if (sender instanceof Player) {
      player = (Player) sender;
    } 
    List<String> rules;

    if (args.length == 0) {
      // IF PLAYER IS CONSOLE
      if (player == null) {
        rules = plugin.getConfig().getStringList("rules.default");
        for (String rule : rules) {
          sender.sendMessage(plugin.replaceColorMacros(rule));  
        }
        return true;
      }

      String World_Name = player.getWorld().getName();
      rules = plugin.getConfig().getStringList("rules."+World_Name);

      if (rules.isEmpty()) {
        rules = plugin.getConfig().getStringList("rules.default");
        plugin.log.info("rules are null");
      }

      for (String rule : rules) {
        player.sendMessage(plugin.replaceColorMacros(rule));  
      }
      return true;
    } else if(args.length == 1 & args[0].equalsIgnoreCase("reload")) {
      plugin.reloadConfig();
      sender.sendMessage(ChatColor.GREEN+"OrphanageRules Config Reloaded!");
      return true;
    }
    return true;    
  }

}