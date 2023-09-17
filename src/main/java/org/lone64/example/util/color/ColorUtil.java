package org.lone64.example.util.color;

import org.bukkit.ChatColor;

public class ColorUtil {

    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}