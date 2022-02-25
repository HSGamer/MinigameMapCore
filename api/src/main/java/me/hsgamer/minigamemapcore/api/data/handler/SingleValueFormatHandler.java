package me.hsgamer.minigamemapcore.api.data.handler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;

import java.util.Objects;
import java.util.Optional;

public interface SingleValueFormatHandler {
    String getKey();

    default Optional<String> getValue(BlockFormatData data) {
        return Optional.ofNullable(data.getProperties().get(getKey())).map(Objects::toString);
    }
}
