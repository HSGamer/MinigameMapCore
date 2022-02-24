package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public interface BlockHandler {
    void handle(Block block, BlockFormatData data);
}
