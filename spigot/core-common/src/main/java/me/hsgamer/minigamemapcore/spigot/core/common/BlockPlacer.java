package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;

import java.util.concurrent.CompletableFuture;

public interface BlockPlacer {
    boolean isSolid(String material);

    CompletableFuture<Void> place(World world, BlockPosition position, BlockFormatData data);
}
