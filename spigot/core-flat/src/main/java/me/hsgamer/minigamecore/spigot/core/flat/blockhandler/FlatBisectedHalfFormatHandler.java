package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.BisectedHalfFormatHandler;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;

import java.util.Locale;

public class FlatBisectedHalfFormatHandler extends BisectedHalfFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Bisected)) return;
            Bisected.Half type = Bisected.Half.valueOf(value.toUpperCase(Locale.ROOT));
            ((Bisected) blockData).setHalf(type);
        });
    }
}
