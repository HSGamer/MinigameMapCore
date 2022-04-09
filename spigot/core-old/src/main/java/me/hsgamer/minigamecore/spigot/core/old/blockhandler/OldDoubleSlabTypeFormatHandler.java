package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.handler.SlabTypeFormatHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OldDoubleSlabTypeFormatHandler extends SlabTypeFormatHandler implements BlockHandler {
    @Override
    public void handle(Block block, BlockFormatData data, boolean applyPhysics) {
        getValue(data).ifPresent(value -> {
            if (value.equalsIgnoreCase("double")) {
                String materialType = block.getType().name();
                if (materialType.equalsIgnoreCase("STEP")) {
                    block.setType(Material.valueOf("DOUBLE_STEP"), applyPhysics);
                } else if (materialType.equalsIgnoreCase("WOOD_STEP")) {
                    block.setType(Material.valueOf("WOOD_DOUBLE_STEP"), applyPhysics);
                } else if (materialType.equalsIgnoreCase("STONE_SLAB2")) {
                    block.setType(Material.valueOf("DOUBLE_STONE_SLAB2"), applyPhysics);
                }
            }
        });
    }
}
