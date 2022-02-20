package me.hsgamer.minigamemapcore.api.setup;

import me.hsgamer.minigamemapcore.api.map.AbstractMap;

import java.util.UUID;

public interface AbstractMapSetup<T extends AbstractMap> {
    void setup(UUID callerId, T map, int id);
}
