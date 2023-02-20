package me.simonfoy.minigame.instance;

import me.simonfoy.minigame.GameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> lives;

    public Game(Arena arena) {
        this.arena = arena;
        lives = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! Your objective is this: KILL THE OTHER PLAYER 4 TIMES.");

        for (UUID uuid : arena.getPlayers()) {
            lives.put(uuid, 4);
        }
    }

    public void removeLife(Player player) {
        int playerLives = lives.get(player.getUniqueId()) - 1;
        if (playerLives == 0) {
            arena.sendMessage(ChatColor.RED + player.getName() + "has been eliminated!");
            arena.reset(true);

            return;
        }
        player.sendMessage(ChatColor.RED + "You have lost a life!");
        lives.replace(player.getUniqueId(), playerLives);
    }
}
