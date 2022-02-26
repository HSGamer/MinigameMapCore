package me.hsgamer.minigamemapcore.api.setup;

import me.hsgamer.minigamemapcore.api.map.AbstractMap;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface AbstractMapSetup<T extends AbstractMap> {
    CompletableFuture<Void> createTask(UUID callerId, T map, int id);
}
