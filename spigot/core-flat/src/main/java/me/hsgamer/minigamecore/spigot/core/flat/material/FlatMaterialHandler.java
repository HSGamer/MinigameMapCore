package me.hsgamer.minigamecore.spigot.core.flat.material;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;

public class FlatMaterialHandler implements MaterialHandler {
    @Override
    public void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics) {
        String data = formatData.getPropertiesAsString();
        if (!data.isBlank()) {
            block.setBlockData(Bukkit.createBlockData(block.getType(), "[" + data + "]"), applyPhysics);
        }
    }
}
