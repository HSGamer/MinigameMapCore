package me.hsgamer.minigamemapcore.api.setup;

import lombok.Getter;
import me.hsgamer.hscore.common.Pair;
import me.hsgamer.minigamemapcore.api.map.AbstractMap;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class MapSetupPool<T extends AbstractMap> implements Runnable {
    private final UUID uuid;
    private final List<T> maps = new ArrayList<>();
    private final Queue<Pair<T, Integer>> mapSetupQueue = new LinkedList<>();
    private final AtomicReference<CompletableFuture<Void>> currentSetupTask = new AtomicReference<>(CompletableFuture.completedFuture(null));
    private final AbstractMapSetup<T> setup;
    private int clonePerMap = 1;

    public MapSetupPool(UUID uuid, AbstractMapSetup<T> setup) {
        this.uuid = uuid;
        this.setup = setup;
    }

    public MapSetupPool<T> setClonePerMap(int clone) {
        this.clonePerMap = clone;
        return this;
    }

    public MapSetupPool<T> ready() {
        for (T map : maps) {
            for (int i = 0; i < clonePerMap; i++) {
                mapSetupQueue.add(Pair.of(map, i));
            }
        }
        return this;
    }

    public CompletableFuture<Void> execute() {
        return CompletableFuture.runAsync(this);
    }

    public void executeSync() {
        execute().join();
    }

    @Override
    public void run() {
        while (!mapSetupQueue.isEmpty()) {
            if (!currentSetupTask.get().isDone()) continue;
            Pair<T, Integer> pair = mapSetupQueue.poll();
            if (pair != null) {
                currentSetupTask.set(setup.createTask(uuid, pair.getKey(), pair.getValue()));
            }
        }
    }
}
