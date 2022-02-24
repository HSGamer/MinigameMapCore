package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WaterLevelFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;

public class FlatWaterLevelFormatHandler extends WaterLevelFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Levelled)) return;
            int level = Integer.parseInt(value);
            Levelled levelled = (Levelled) blockData;
            levelled.setLevel(level);
        });
    }
}
