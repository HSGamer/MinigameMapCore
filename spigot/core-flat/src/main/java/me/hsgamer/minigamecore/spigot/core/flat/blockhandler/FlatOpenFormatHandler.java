package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.OpenFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;

public class FlatOpenFormatHandler extends OpenFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Openable)) return;
            boolean open = Boolean.parseBoolean(value);
            Openable openable = (Openable) blockData;
            openable.setOpen(open);
        });
    }
}
