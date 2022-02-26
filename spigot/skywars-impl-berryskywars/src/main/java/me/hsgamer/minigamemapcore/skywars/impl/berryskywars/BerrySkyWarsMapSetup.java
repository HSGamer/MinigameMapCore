package me.hsgamer.minigamemapcore.skywars.impl.berryskywars;

import me.hsgamer.minigamecore.spigot.core.impl.SimpleBlockPlacer;
import me.hsgamer.minigamemapcore.api.setup.StepMapSetup;
import me.hsgamer.minigamemapcore.skywars.api.SkyWarsConstants;
import me.hsgamer.minigamemapcore.skywars.api.SkyWarsMap;
import me.hsgamer.minigamemapcore.skywars.api.SkyWarsMapSetup;
import me.hsgamer.minigamemapcore.spigot.core.common.helper.BlockPlaceTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class BerrySkyWarsMapSetup extends BukkitRunnable implements SkyWarsMapSetup {
    private final Plugin plugin;
    private final StepMapSetup stepMapSetup = new StepMapSetup();
    private final AtomicReference<CompletableFuture<Void>> currentStep = new AtomicReference<>(CompletableFuture.completedFuture(null));
    private final CompletableFuture<Void> completableFuture = new CompletableFuture<>();

    public BerrySkyWarsMapSetup(Plugin plugin) {
        this.plugin = plugin;
    }

    public BerrySkyWarsMapSetup() {
        this(JavaPlugin.getProvidingPlugin(BerrySkyWarsMapSetup.class));
    }

    private void setup(UUID callerId, SkyWarsMap map, int id) {
        Player player = Bukkit.getPlayer(callerId);
        if (player == null) {
            Bukkit.getConsoleSender().sendMessage("§cThe player is not online!");
            return;
        }
        SimpleBlockPlacer placer = new SimpleBlockPlacer(plugin);
        stepMapSetup.<StepMapSetup.SimpleStep>addStep(() -> {
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
        }).addStep(() -> new BlockPlaceTask(player.getWorld(), placer)
                .setAsync(true)
                .setBlocksPerTick(30)
                .addBlockMap(map.getMapHandler().getMap())
                .startAsFuture(plugin)
        );
    }

    @Override
    public CompletableFuture<Void> createTask(UUID callerId, SkyWarsMap map, int id) {
        setup(callerId, map, id);
        runTaskTimer(plugin, 0, 0);
        return completableFuture;
    }

    @Override
    public final void run() {
        if (!currentStep.get().isDone()) return;
        if (stepMapSetup.hasNext()) {
            currentStep.set(stepMapSetup.next());
        } else {
            cancel();
            completableFuture.complete(null);
        }
    }
}
