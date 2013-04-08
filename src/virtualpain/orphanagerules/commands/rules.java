package virtualpain.orphanagerules.commands;

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
    String rules;
    int i = 1;

    if (args.length == 0) {
      // IF PLAYER IS CONSOLE
      if (player == null) {
        rules = plugin.getConfig().getString("rules.default");
        for (String rule : rules.split("\n")) {
          sender.sendMessage(plugin.replaceColorMacros(rule).replaceAll("[\r\n]", "").replaceAll("&#",""+i));
          if (rule.contains("&#")) {
            i++;
          }
        }

        return true;
      }

      // IF PLAYER IS IN-GAME
      String worldName = player.getWorld().getName();
      rules = plugin.getConfig().getString("rules."+worldName);

      // IF THERE ARE NO RULES SET FOR THIS WORLD
      if (rules == null) {
        rules = plugin.getConfig().getString("rules.default"); // USE DEFAULT RULES
      }

      // DISPLAY RULES
      for (String rule : rules.split("\n")) {
        player.sendMessage(plugin.replaceColorMacros(rule).replaceAll("[\r\n]", "").replaceAll("&#",""+i));
        if (rule.contains("&#")) {
          i++;
        }
      }
      i = 1;
      return true;

    } else if(args.length == 1 & args[0].equalsIgnoreCase("reload")) {
      plugin.reloadConfig();
      sender.sendMessage(ChatColor.GREEN+"OrphanageRules Config Reloaded!");
      return true;
    }
    return true;    
  }

}