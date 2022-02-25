package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;

import java.util.Map;

public interface BlockPlacer {
    boolean isSolid(String material);

    void place(World world, BlockPosition position, BlockFormatData data);

    default void place(World world, Map<BlockPosition, BlockFormatData> blockFormatDataMap) {
        blockFormatDataMap.forEach((position, formatData) -> place(world, position, formatData));
    }
}
