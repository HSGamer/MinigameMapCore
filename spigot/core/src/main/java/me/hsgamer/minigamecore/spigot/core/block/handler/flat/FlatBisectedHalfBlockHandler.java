package me.hsgamer.minigamecore.spigot.core.block.handler.flat;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.BisectedHalfBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;

import java.util.Locale;

public class FlatBisectedHalfBlockHandler extends BisectedHalfBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Bisected) {
            Bisected.Half type = Bisected.Half.valueOf(value.toUpperCase(Locale.ROOT));
            ((Bisected) blockData).setHalf(type);
            block.setBlockData(blockData, false);
        }
    }
}
