package org.lone64.example.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.lone64.example.util.color.ColorUtil;
import org.lone64.nametags.api.NametagsAPI;

public class MainCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) return true;

        Player player = (Player) sender;
        if (!player.hasPermission("example.perms")) {
            return true;
        } else if (args.length == 0) {
            player.sendMessage(ColorUtil.getColor("&c올바르지 않는 명령어입니다!"));
            return true;
        }

        String name;
        switch (args[0]) {
            default:
                player.sendMessage(ColorUtil.getColor("&c올바르지 않는 명령어입니다!"));
                break;
            case "변경":
                if (args.length < 2) {
                    player.sendMessage(ColorUtil.getColor("&c변경하실 닉네임을 입력해주세요!"));
                    return true;
                } else if (NametagsAPI.getInstance().isTag(player)) {
                    player.sendMessage(ColorUtil.getColor("&c닉네임을 이미 변경하셨습니다!"));
                    return true;
                }

                name = args[1];
                if (NametagsAPI.getInstance().isTag(name)) {
                    player.sendMessage(ColorUtil.getColor("&c이미 누군가가 사용하고 있는 닉네임입니다!"));
                    return true;
                }

                NametagsAPI.getInstance().changeTag(player, name);
                player.sendMessage(ColorUtil.getColor("&a닉네임을 " + name + "으로 변경하셨습니다!"));
                break;
            case "초기화":
                if (!NametagsAPI.getInstance().isTag(player)) {
                    player.sendMessage(ColorUtil.getColor("&c닉네임을 변경하지 않으셨습니다!"));
                    return true;
                }

                NametagsAPI.getInstance().resetTag(player);
                player.sendMessage(ColorUtil.getColor("&a닉네임이 성공적으로 초기화되었습니다!"));
                break;
        }
        return false;
    }

}