package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;

public interface BlockPlacer {
    void place(World world, BlockPosition position, BlockFormatData data);
}
