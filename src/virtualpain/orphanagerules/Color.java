package virtualpain.orphanagerules;

import org.bukkit.ChatColor;

public class Color {
	public Color()
	{
		
	}
	public static String replaceString(String str) {
		str = str.replace("&r", ChatColor.RED.toString());
		str = str.replace("&R", ChatColor.DARK_RED.toString());        
		str = str.replace("&y", ChatColor.YELLOW.toString());
		str = str.replace("&Y", ChatColor.GOLD.toString());
		str = str.replace("&g", ChatColor.GREEN.toString());
		str = str.replace("&G", ChatColor.DARK_GREEN.toString());        
		str = str.replace("&c", ChatColor.AQUA.toString());
		str = str.replace("&C", ChatColor.DARK_AQUA.toString());        
		str = str.replace("&b", ChatColor.BLUE.toString());
		str = str.replace("&B", ChatColor.DARK_BLUE.toString());        
		str = str.replace("&p", ChatColor.LIGHT_PURPLE.toString());
		str = str.replace("&P", ChatColor.DARK_PURPLE.toString());
		str = str.replace("&0", ChatColor.BLACK.toString());
		str = str.replace("&1", ChatColor.DARK_GRAY.toString());
		str = str.replace("&2", ChatColor.GRAY.toString());
		str = str.replace("&w", ChatColor.WHITE.toString());
		return str;
	}
}
