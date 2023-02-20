package me.simonfoy.minigame;

import me.simonfoy.minigame.command.ArenaCommand;
import me.simonfoy.minigame.instance.Arena;
import me.simonfoy.minigame.listener.ConnectListener;
import me.simonfoy.minigame.listener.GameListener;
import me.simonfoy.minigame.manager.ArenaManager;
import me.simonfoy.minigame.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Minigame extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));

    }

    public ArenaManager getArenaManager() { return arenaManager; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
