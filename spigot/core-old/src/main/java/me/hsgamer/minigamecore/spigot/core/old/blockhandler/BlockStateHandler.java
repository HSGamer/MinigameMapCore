package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.BlockState;

public interface BlockStateHandler {
    void modify(BlockState blockState, BlockFormatData formatData);
}
