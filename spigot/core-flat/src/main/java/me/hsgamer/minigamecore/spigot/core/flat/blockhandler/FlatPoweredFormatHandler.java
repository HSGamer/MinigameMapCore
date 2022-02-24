package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.PoweredFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;

public class FlatPoweredFormatHandler extends PoweredFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Powerable)) return;
            boolean powered = Boolean.parseBoolean(value);
            Powerable powerable = (Powerable) blockData;
            powerable.setPowered(powered);
        });
    }
}
