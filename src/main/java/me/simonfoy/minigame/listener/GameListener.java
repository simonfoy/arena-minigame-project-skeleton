package me.simonfoy.minigame.listener;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getEntity().getPlayer());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().removeLife(e.getEntity().getPlayer());
        }
    }
}
