package org.lone64.example.cmd.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> tabs = new ArrayList<>();
        if (sender instanceof Player player) {
            if (player.hasPermission("example.perms")) {
                if (args.length == 1) {
                    tabs.addAll(Arrays.asList("변경", "초기화"));
                }
            }
        } else return null;
        return tabs;
    }

}
