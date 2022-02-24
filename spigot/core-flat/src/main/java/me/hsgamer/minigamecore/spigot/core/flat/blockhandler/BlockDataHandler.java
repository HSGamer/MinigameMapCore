package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.data.BlockData;

public interface BlockDataHandler {
    void modify(BlockData blockData, BlockFormatData formatData);
}
