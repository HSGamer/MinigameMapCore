package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WaterLevelBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;

public class FlatWaterLevelBlockHandler extends WaterLevelBlockHandler {
    @Override
    public void handle(Block block, String value) {
        int level = Integer.parseInt(value);
        if (!(block.getBlockData() instanceof Levelled)) return;
        Levelled levelled = (Levelled) block.getBlockData();
        levelled.setLevel(level);
        block.setBlockData(levelled, false);
    }
}
