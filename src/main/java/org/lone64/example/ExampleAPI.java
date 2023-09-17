package org.lone64.example;

import org.lone64.example.cmd.MainCmd;
import org.bukkit.plugin.java.JavaPlugin;
import org.lone64.example.cmd.tab.MainTab;
import org.lone64.nametags.api.NametagsAPI;

public final class ExampleAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        NametagsAPI.getInstance().setPlugin(this);
        getCommand("닉네임").setExecutor(new MainCmd());
        getCommand("닉네임").setTabCompleter(new MainTab());
    }

    @Override
    public void onDisable() {

    }

}