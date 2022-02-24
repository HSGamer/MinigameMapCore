package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.hscore.common.Pair;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BlockPlacer {
    boolean isSolid(String material);

    void place(World world, BlockPosition position, BlockFormatData data);

    default void place(World world, Map<BlockPosition, BlockFormatData> blockFormatDataMap) {
        List<Pair<BlockPosition, BlockFormatData>> nonSolidList = new ArrayList<>();
        blockFormatDataMap.forEach((position, formatData) -> {
            if (isSolid(formatData.getMaterial())) {
                place(world, position, formatData);
            } else {
                nonSolidList.add(Pair.of(position, formatData));
            }
        });
        nonSolidList.forEach(pair -> place(world, pair.getKey(), pair.getValue()));
    }
}
