package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.LitFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;

public class FlatLitFormatHandler extends LitFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Lightable)) return;
            boolean lit = Boolean.parseBoolean(value);
            Lightable lightable = (Lightable) blockData;
            lightable.setLit(lit);
        });
    }
}
