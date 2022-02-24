package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WaterLevelBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public class OldWaterLevelBlockHandler extends WaterLevelBlockHandler {
    @Override
    public void handle(Block block, String value) {
        int level = Integer.parseInt(value);
        BlockState state = block.getState();
        MaterialData materialData = state.getData();
        materialData.setData((byte) level);
        state.update(true, false);
    }
}
