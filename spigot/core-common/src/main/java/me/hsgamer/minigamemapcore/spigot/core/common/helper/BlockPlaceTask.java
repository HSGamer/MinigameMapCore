package me.hsgamer.minigamemapcore.spigot.core.common.helper;

import lombok.Getter;
import me.hsgamer.hscore.common.Pair;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockPlacer;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class BlockPlaceTask extends BukkitRunnable {
    private final World world;
    private final BlockPlacer blockPlacer;
    @Getter
    private final CompletableFuture<Void> completableFuture = new CompletableFuture<>();
    private final List<Pair<BlockPosition, BlockFormatData>> solidPair = new ArrayList<>();
    private final List<Pair<BlockPosition, BlockFormatData>> nonSolidPair = new ArrayList<>();
    private final Queue<Pair<BlockPosition, BlockFormatData>> queue = new LinkedList<>();
    private final AtomicReference<CompletableFuture<Void>> currentTask = new AtomicReference<>(CompletableFuture.completedFuture(null));
    private int blocksPerTick = 1;
    private long period = 0;
    private boolean async = false;

    public BlockPlaceTask(World world, BlockPlacer blockPlacer) {
        this.world = world;
        this.blockPlacer = blockPlacer;
    }

    public BlockPlaceTask addBlockMap(Map<BlockPosition, BlockFormatData> map) {
        for (Map.Entry<BlockPosition, BlockFormatData> entry : map.entrySet()) {
            if (blockPlacer.isSolid(entry.getValue().getMaterial())) {
                solidPair.add(Pair.of(entry.getKey(), entry.getValue()));
            } else {
                nonSolidPair.add(Pair.of(entry.getKey(), entry.getValue()));
            }
        }
        return this;
    }

    public BlockPlaceTask setBlocksPerTick(int blocksPerTick) {
        this.blocksPerTick = Math.max(1, blocksPerTick);
        return this;
    }

    public BlockPlaceTask setPeriod(long period) {
        this.period = period;
        return this;
    }

    public BlockPlaceTask setAsync(boolean async) {
        this.async = async;
        return this;
    }

    @Override
    public final void run() {
        if (!currentTask.get().isDone()) return;
        List<CompletableFuture<Void>> tasks = new ArrayList<>(blocksPerTick);
        for (int i = 0; i < blocksPerTick; i++) {
            Pair<BlockPosition, BlockFormatData> pair = queue.poll();
            if (pair != null) {
                tasks.add(blockPlacer.place(world, pair.getKey(), pair.getValue()));
            } else if (!tasks.isEmpty()) {
                break;
            } else {
                cancel();
                completableFuture.complete(null);
                return;
            }
        }
        currentTask.set(CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])));
    }

    public BukkitTask start(Plugin plugin) {
        queue.addAll(solidPair);
        queue.addAll(nonSolidPair);
        return async ? runTaskTimerAsynchronously(plugin, 0, period) : runTaskTimer(plugin, 0, period);
    }

    public CompletableFuture<Void> startAsFuture(Plugin plugin) {
        start(plugin);
        return completableFuture;
    }
}
