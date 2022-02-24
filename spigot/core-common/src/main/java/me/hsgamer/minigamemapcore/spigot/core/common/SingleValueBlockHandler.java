package me.hsgamer.minigamemapcore.spigot.core.common;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public interface SingleValueBlockHandler extends BlockHandler {
    void handle(Block block, String value);

    String getKey();

    @Override
    default void handle(Block block, BlockFormatData data) {
        Object obj = data.getProperties().get(getKey());
        if (obj == null) return;
        String value = obj.toString();
        handle(block, value);
    }
}
