package me.hsgamer.minigamecore.spigot.core.block;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public interface BlockDataHandler {
    void handle(Block block, BlockFormatData data);
}
