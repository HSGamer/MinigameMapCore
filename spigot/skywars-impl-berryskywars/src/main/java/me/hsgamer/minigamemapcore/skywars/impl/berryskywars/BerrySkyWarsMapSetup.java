package me.hsgamer.minigamemapcore.skywars.impl.berryskywars;

import me.hsgamer.minigamemapcore.skywars.api.SkyWarsConstants;
import me.hsgamer.minigamemapcore.skywars.api.SkyWarsMap;
import me.hsgamer.minigamemapcore.skywars.api.SkyWarsMapSetup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BerrySkyWarsMapSetup implements SkyWarsMapSetup {
    @Override
    public void setup(UUID callerId, SkyWarsMap map, int id) {
        Player player = Bukkit.getPlayer(callerId);
        if (player == null) {
            Bukkit.getConsoleSender().sendMessage("§cThe player is not online!");
            return;
        }
        String arenaName = map.getOptionHandler().getMap().get(SkyWarsConstants.Option.INTERNAL_NAME);
        if (id > 0) {
            arenaName += "-" + id;
        }
        int teamSize = Integer.parseInt(map.getOptionHandler().getMap().get(SkyWarsConstants.Option.TEAM_SIZE));
        int minTeam = Integer.parseInt(map.getOptionHandler().getMap().get(SkyWarsConstants.Option.MIN_TEAMS));
        int minPlayers = teamSize * minTeam;

        player.performCommand("sw arena create " + arenaName);
        player.performCommand("sw arena mode Normal");
        player.performCommand("sw arena size " + teamSize);
        player.performCommand("sw arena minimum " + minPlayers);
    }
}
