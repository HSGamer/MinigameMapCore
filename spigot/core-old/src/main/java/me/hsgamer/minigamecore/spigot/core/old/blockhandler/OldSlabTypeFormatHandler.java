package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.SlabTypeFormatHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Step;

public class OldSlabTypeFormatHandler extends SlabTypeFormatHandler implements BlockHandler {
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
            } else {
                BlockState blockState = block.getState();
                MaterialData materialData = blockState.getData();
                if (materialData instanceof Step) {
                    Step step = (Step) materialData;
                    step.setInverted(value.equalsIgnoreCase("top"));
                    blockState.setData(step);
                    blockState.update(false, applyPhysics);
                }
            }
        });
    }
}
