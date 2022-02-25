package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;

import java.util.Map;
import java.util.function.BiConsumer;

public interface BlockPlacer {
    void place(World world, BlockPosition position, BlockFormatData data);

    default void place(World world, Map<BlockPosition, BlockFormatData> blockFormatDataMap, BiConsumer<BlockPosition, BlockFormatData> afterPlaceConsumer) {
        blockFormatDataMap.forEach((position, formatData) -> {
            place(world, position, formatData);
            afterPlaceConsumer.accept(position, formatData);
        });
    }

    default void place(World world, Map<BlockPosition, BlockFormatData> blockFormatDataMap) {
        place(world, blockFormatDataMap, (position, formatData) -> {
        });
    }
}
